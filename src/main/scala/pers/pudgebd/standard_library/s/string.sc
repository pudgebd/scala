val str = """create temporary table t_employee
            |using org.elasticsearch.spark.sql
            """.stripMargin

println(str)