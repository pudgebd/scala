import scala.collection.JavaConverters._
import scala.collection.{JavaConversions, mutable}

val strFromG4 = "SHOW | TABLES | COLUMNS | COLUMN | PARTITIONS | FUNCTIONS | DATABASES\n    | ADD\n    | OVER | PARTITION | RANGE | ROWS | PRECEDING | FOLLOWING | CURRENT | ROW | LAST | FIRST | AFTER\n    | MAP | ARRAY | STRUCT\n    | PIVOT | LATERAL | WINDOW | REDUCE | TRANSFORM | SERDE | SERDEPROPERTIES | RECORDREADER\n    | DELIMITED | FIELDS | TERMINATED | COLLECTION | ITEMS | KEYS | ESCAPED | LINES | SEPARATED\n    | EXTENDED | REFRESH | CLEAR | CACHE | UNCACHE | LAZY | GLOBAL | TEMPORARY | OPTIONS\n    | GROUPING | CUBE | ROLLUP\n    | EXPLAIN | FORMAT | LOGICAL | FORMATTED | CODEGEN | COST\n    | TABLESAMPLE | USE | TO | BUCKET | PERCENTLIT | OUT | OF\n    | SET | RESET\n    | VIEW | REPLACE\n    | IF\n    | POSITION\n    | EXTRACT\n    | NO | DATA\n    | START | TRANSACTION | COMMIT | ROLLBACK | IGNORE\n    | SORT | CLUSTER | DISTRIBUTE | UNSET | TBLPROPERTIES | SKEWED | STORED | DIRECTORIES | LOCATION\n    | EXCHANGE | ARCHIVE | UNARCHIVE | FILEFORMAT | TOUCH | COMPACT | CONCATENATE | CHANGE\n    | CASCADE | RESTRICT | BUCKETS | CLUSTERED | SORTED | PURGE | INPUTFORMAT | OUTPUTFORMAT\n    | DBPROPERTIES | DFS | TRUNCATE | COMPUTE | LIST\n    | STATISTICS | ANALYZE | PARTITIONED | EXTERNAL | DEFINED | RECORDWRITER\n    | REVOKE | GRANT | LOCK | UNLOCK | MSCK | REPAIR | RECOVER | EXPORT | IMPORT | LOAD | VALUES | COMMENT | ROLE\n    | ROLES | COMPACTIONS | PRINCIPALS | TRANSACTIONS | INDEX | INDEXES | LOCKS | OPTION | LOCAL | INPATH\n    | ASC | DESC | LIMIT | RENAME | SETS\n    | AT | NULLS | OVERWRITE | ALL | ANY | ALTER | AS | BETWEEN | BY | CREATE | DELETE\n    | DESCRIBE | DROP | EXISTS | FALSE | FOR | GROUP | IN | INSERT | INTO | IS |LIKE\n    | NULL | ORDER | OUTER | TABLE | TRUE | WITH | RLIKE\n    | AND | CASE | CAST | DISTINCT | DIV | ELSE | END | FUNCTION | INTERVAL | MACRO | OR | STRATIFY | THEN\n    | UNBOUNDED | WHEN\n    | DATABASE | SELECT | FROM | WHERE | HAVING | TO | TABLE | WITH | NOT\n    | DIRECTORY\n    | BOTH | LEADING | TRAILING | ANTI | FULL | INNER | LEFT | SEMI | RIGHT | NATURAL | JOIN | CROSS | ON\n    | UNION | INTERSECT | EXCEPT | SETMINUS"

val set1 = strFromG4.split("[|]").map(_.trim)

val strFromErrMsg = "'SELECT', 'FROM', 'ADD', 'AS', 'ALL', 'ANY', 'DISTINCT', 'WHERE', 'GROUP', 'BY', 'GROUPING', 'SETS', 'CUBE', 'ROLLUP', 'ORDER', 'HAVING', 'LIMIT', 'AT', 'OR', 'AND', 'IN', NOT, 'NO', 'EXISTS', 'BETWEEN', 'LIKE', RLIKE, 'IS', 'NULL', 'TRUE', 'FALSE', 'NULLS', 'ASC', 'DESC', 'FOR', 'INTERVAL', 'CASE', 'WHEN', 'THEN', 'ELSE', 'END', 'JOIN', 'CROSS', 'OUTER', 'INNER', 'LEFT', 'SEMI', 'RIGHT', 'FULL', 'NATURAL', 'ON', 'PIVOT', 'LATERAL', 'WINDOW', 'OVER', 'PARTITION', 'RANGE', 'ROWS', 'UNBOUNDED', 'PRECEDING', 'FOLLOWING', 'CURRENT', 'FIRST', 'AFTER', 'LAST', 'ROW', 'WITH', 'VALUES', 'CREATE', 'TABLE', 'DIRECTORY', 'VIEW', 'REPLACE', 'INSERT', 'DELETE', 'INTO', 'DESCRIBE', 'EXPLAIN', 'FORMAT', 'LOGICAL', 'CODEGEN', 'COST', 'CAST', 'SHOW', 'TABLES', 'COLUMNS', 'COLUMN', 'USE', 'PARTITIONS', 'FUNCTIONS', 'DROP', 'UNION', 'EXCEPT', 'MINUS', 'INTERSECT', 'TO', 'TABLESAMPLE', 'STRATIFY', 'ALTER', 'RENAME', 'ARRAY', 'MAP', 'STRUCT', 'COMMENT', 'SET', 'RESET', 'DATA', 'START', 'TRANSACTION', 'COMMIT', 'ROLLBACK', 'MACRO', 'IGNORE', 'BOTH', 'LEADING', 'TRAILING', 'IF', 'POSITION', 'EXTRACT', 'DIV', 'PERCENT', 'BUCKET', 'OUT', 'OF', 'SORT', 'CLUSTER', 'DISTRIBUTE', 'OVERWRITE', 'TRANSFORM', 'REDUCE', 'SERDE', 'SERDEPROPERTIES', 'RECORDREADER', 'RECORDWRITER', 'DELIMITED', 'FIELDS', 'TERMINATED', 'COLLECTION', 'ITEMS', 'KEYS', 'ESCAPED', 'LINES', 'SEPARATED', 'FUNCTION', 'EXTENDED', 'REFRESH', 'CLEAR', 'CACHE', 'UNCACHE', 'LAZY', 'FORMATTED', 'GLOBAL', TEMPORARY, 'OPTIONS', 'UNSET', 'TBLPROPERTIES', 'DBPROPERTIES', 'BUCKETS', 'SKEWED', 'STORED', 'DIRECTORIES', 'LOCATION', 'EXCHANGE', 'ARCHIVE', 'UNARCHIVE', 'FILEFORMAT', 'TOUCH', 'COMPACT', 'CONCATENATE', 'CHANGE', 'CASCADE', 'RESTRICT', 'CLUSTERED', 'SORTED', 'PURGE', 'INPUTFORMAT', 'OUTPUTFORMAT', DATABASE, DATABASES, 'DFS', 'TRUNCATE', 'ANALYZE', 'COMPUTE', 'LIST', 'STATISTICS', 'PARTITIONED', 'EXTERNAL', 'DEFINED', 'REVOKE', 'GRANT', 'LOCK', 'UNLOCK', 'MSCK', 'REPAIR', 'RECOVER', 'EXPORT', 'IMPORT', 'LOAD', 'ROLE', 'ROLES', 'COMPACTIONS', 'PRINCIPALS', 'TRANSACTIONS', 'INDEX', 'INDEXES', 'LOCKS', 'OPTION', 'ANTI', 'LOCAL', 'INPATH'"

val set2 = strFromErrMsg.split("[,]").map(str => {
  val newStr = str.trim
  newStr.substring(1, newStr.length - 1)
})

val mset1 = mutable.HashSet.empty[String] ++= set1
set2.foreach(mset1.remove(_))
println(mset1.mkString(", "))

//println(set1.forall(_ == set2.head))  // true  if empty or all the same
//println(set1.exists(_ != set2.head))  // false if empty or all the same

//以下 createHiveCreate sql 的 PARTITIONED BY (`dt` String, `hour` string, `minute` string)
//里的字段名如果不加 ` 会解析出错

//CREATE TABLE `myhive`.`default`.FlinkWriteHiveTable (
//  order_type bigint COMMENT '订单类型, 0:订单；1：撤单',
//acct_id string COMMENT '投资者账户代码',
//order_no bigint COMMENT '原始订单参考编号',
//sec_code string comment '产品代码',
//trade_dir string COMMENT '交易方向,B 或者 S',
//order_price bigint comment '交易价格，单位为分',
//order_vol bigint comment '含3位小数，比如数量为100股，则交易数量为二进制100000',
//act_no bigint COMMENT '订单确认顺序号',
//withdraw_order_no bigint COMMENT '撤单订单编号',
//pbu double COMMENT '发出此订单的报盘机编号',
//order_status string COMMENT '订单状态,0=New,1=Cancelled,2=Reject',
//ts bigint COMMENT '订单接收时间，微妙级时间戳',
//score double
//) PARTITIONED BY (`dt` String, `hour` string, `minute` string) STORED AS parquet TBLPROPERTIES (
//  'connector'='filesystem',
//'path'='hdfs://cdh601:8020/user/hive/warehouse/flinkwritehivetable',
//'format'='parquet',
//'partition.time-extractor.timestamp-pattern'='$dt $hour:$minute:00',
//'sink.partition-commit.trigger'='partition-time',
//'sink.partition-commit.delay'='1 minute',
//'sink.partition-commit.policy.kind'='metastore,success-file'
//)