//List的Map函数的作用：
//map的参数是一个函数，List中的每个元素都应用于这个函数，并且返回一个新的集合。
//例如我们有一个List(1，2，3，4) ，我们需要构建List(2,4,6,8)
//那么我们就可以使用Map函数，传入一个*2的函数

val list = List(1, 2, 3, 4)
list.map(x => x * 2)

//x => x*2 是一个匿名函数。 List中的每个元素都应用于这个函数。
//这种只有一个参数的匿名函数、可以使用_占位符简化写法。

list.map(_ * 2)

val bigData =List("spark","hadoop","hbase")
bigData.map(_.length)

bigData.map(_.toList)


