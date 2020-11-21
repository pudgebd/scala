//partition函数：
//对列表进行分组，参数传入一个布尔表达式，返回true的一组，返回false的一组。
//只能分成两组

val list = List(1, 2, 3, 4)
list.partition(_ % 2 == 0)

val bigData = List("spark", "hadoop", "hbase")
bigData.partition(_.startsWith("h"))


//find函数：
//找到满足条件的第一个元素
list.find(_ - 1 > 1)


//takeWhile函数：
//找到满足条件的最长前缀元素，也就是说，一旦有一个元素不满足条件，后续的元素就不用判断了。
List(1, 2, 3, 2, 5, 3, 6).takeWhile(_ < 3)


//span函数：
//将List拆分成两个List。于partition不同，它等同于
//(c takeWhile p, c dropWhile p) 但是效率更高
List(1,2,3,2,5,3,6).span(_<3)


//exists函数：
//判断是否存在满足条件的元素
//scala> list.exists(_==1)
//res17: Boolean = true
//forall函数：
//判断是否List中的所有元素都满足条件
//scala>  println(list.forall { x => x>0})
//true
//判断是否有全部元素都是0 的List
//        1
//def hasTotalZeroList(m : List[List[Int]]) = {
//    m.exists { row => row.forall { _ == 0} }
//}
//val ListAll = List(List(1,0,0),List(0,1,0),List(0,0,0))
//println(hasTotalZeroList(ListAll))

