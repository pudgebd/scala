//Fold是折叠的意思，foldLeft就是从左折叠，foldRight就是从右折叠
val list = List.range(1, 5) // 1 .. 100

//foldLeft有两个参数：z 初始值，f 叠加函数
//初始值于第一个元素做加法运算，等到的结果和第二个再做加法，以此类推下去
var result = list.foldLeft(0)(_ + _)

//还有一个简化的写法，如下
result = (0 /: list) (_ + _)

println(List.range(1, 5).foldLeft(100)(_ - _)) // 100-1-2-3-4 = 90

//方法与foldLeft 相同 。
//foldRight 于foldLeft类似，只不过是从列表的尾部叠加函数
println(List.range(1, 5).foldRight(0)(_ + _)) // 1-(2-(3-(4-100))) = 98

val list2 = List(3, 9, 1, 4, 8, 7)
//Sorted Will sort the list using the natural ordering
//升序排列列表
println(list2.sorted)

//降序
println(list2.sorted(Ordering.Int.reverse))

// 使用特殊的算法排序
val list3 = List("Spark","Hadoop","Zookeeper","Scala Language")

//按照元素长度排序
println(list3.sortWith(_.length > _.length))
//按照首字母排序
println(list3.sortWith(_.head < _.head))
// 按照符合条件排序
println(list3.sortBy(x =>(x.head,x.length())))













