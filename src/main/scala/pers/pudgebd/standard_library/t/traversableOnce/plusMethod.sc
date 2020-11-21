import scala.collection.mutable

val list1 = List(1, 2)
val list2 = mutable.LinkedList(3, 4)

//list1 ++ list2 //返回一个新的 traversableOnece，其类型由左边决定
//list1 ++: list2 //返回一个新的，其类型由右边决定

//1 +: list1 //必须这样写，返回一个新的，1 加在 list 头部
//list1 :+ 1 //必须这样写，返回一个新的，1 加在 list 尾部

