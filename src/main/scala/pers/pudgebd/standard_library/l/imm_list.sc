import scala.collection.mutable.BitSet
import scala.collection.mutable.MutableList

//-----------------------------------
//--不变 list 的以下操作都产生新的 list
//-----------------------------------

1 :: List(2,3,4) //将 1 加到 list 的头部
List(1,2) ::: List(3,4) //将前一个list加到后一个的头部
List(1,2) :+ 3 // 把 3 加到 list 尾部
1 +: List(2,3,4) //将 1 加到 list 的头部

//List(1,2).reduceLeftOption()

val x = List(1)
val y = MutableList("2")

val z1 = x ++ y
val z2 = x ++: y
//z1 这个集合的类型是 List，由 x 和 y 的共同父类型决定
//z2 这个集合的类型是 MutableList，由 y 决定


val z3 = x :+ 2 + 34 + 45 + 15 + 46+ 26+ 62 //2 在后
val z4 = 2 +: x //2 在前

//z3.reduce(_ - _)
//println(z3)


val a = Seq(2,3,4,5)
//val b = a.reduceLeftOption(_ + _)
//val b = a.repr
//val b = a.reverse_:::(List(1, 11))
//val b = a.runWith(i => i + 1)
val b = a.slice(0, 2)
//val b = a.sliding(2, 3).foreach(println)
//val b = a.map(_ + 1)