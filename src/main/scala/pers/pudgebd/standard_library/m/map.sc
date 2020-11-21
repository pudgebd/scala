import scala.collection.mutable

//val map = mutable.Map(1 -> "a", 2 -> "b", 3 -> "c")
//map.transform((k, v) => k+v) //改变所有 key 对应的值

val map = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5)
val newMap = map.map(tp2 => (tp2._1, tp2._2.toLong))

//    val map = mutable.Map("a" -> 1, "b" -> 2)
//println(map)