//与Java生活

//您可以通过JavaConverters package轻松地在Java和Scala的集合类型之间转换。
// 它用asScala 装饰常用的Java集合以和用asJava 方法装饰Scala集合。

import scala.collection.JavaConverters._

val sl = new scala.collection.mutable.ListBuffer[Int]
val jl : java.util.List[Int] = sl.asJava
val sl2 : scala.collection.mutable.Buffer[Int] = jl.asScala
assert(sl eq sl2)

//双向转换：
//
//scala.collection.Iterable <=> java.lang.Iterable
//scala.collection.Iterable <=> java.util.Collection
//scala.collection.Iterator <=> java.util.{ Iterator, Enumeration }
//scala.collection.mutable.Buffer <=> java.util.List
//scala.collection.mutable.Set <=> java.util.Set
//scala.collection.mutable.Map <=> java.util.{ Map, Dictionary }
//scala.collection.mutable.ConcurrentMap <=> java.util.concurrent.ConcurrentMap
//此外，也提供了以下单向转换
//
//scala.collection.Seq => java.util.List
//scala.collection.mutable.Seq => java.util.List
//scala.collection.Set => java.util.Set
//scala.collection.Map => java.util.Map