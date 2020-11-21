val list = List(1, 2, 3, 4, 5, 6)
val it = list.iterator

val myPa: PartialFunction[Int, Int] = {
    case i: Int => if (i > 1) i else 0
}
it collectFirst myPa //只判断第一个元素
it collect myPa foreach println