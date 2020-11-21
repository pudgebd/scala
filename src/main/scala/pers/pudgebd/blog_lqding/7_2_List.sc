//列表合并,使用:::操作符
println(List(1, 2) ::: List(3, 4) ::: List(5, 6))
println(List(1, 2) ::: (List(3, 4) ::: List(5, 6)))
// 求列表的长度
println(List(1, 2, 3, 4, 5, 5).length)
val bigData = List("Spark", "Hadoop", "Kafka")
//求列表的最后一个元素
println(bigData.last) //Kafka
//选取除了最后一个元素的所有元素
println(bigData.init) //List(Spark, Hadoop)
//反转List中的元素位置
println(bigData.reverse) //List(Kafka, Hadoop, Spark)
//取前n个元素
bigData.take(2)
//取所有元素，除了前n个
println(bigData.drop(2))

// 在n位置处拆分List为两个List。效果等同于(c take n,c drop n) 但是splitAt更高效
println(bigData.splitAt(2)) //(List(Spark, Hadoop),List(Kafka))

//通过索引取元素的值，索引从0 开始。执行需要时间索引值成比例。
println(bigData.apply(1))
println(bigData(2)) // 其实内部会调用apply方法

val data = List("a","b","c","d","e","f","g")
//用列表的索引产生一个range
println(data.indices)

//用索引和data做zip操作，这种操作称之为拉链操作
println(data.indices zip data)

// 列表提供了一个方法实现上面的拉链操作
println(data.zipWithIndex)

//将列表转成字符串
println(data.toString())

//使用字符串将列表中的元素拼接在一起
println(data.mkString("<", ",", ">")) //"<a,b,c,d,e,f,g>"
println(data.mkString(",")) //"a,b,c,d,e,f,g"
println(data.mkString) //"abcdefg"

val buffer = new StringBuilder
//将列表的所有元素追加到StringBuilder对象中
data.addString(buffer)
// 与data.mkString("<", ",", ">")这个操作类型，只不过addString会将字符串追加
//到StringBuilder对象中
data.addString(buffer, "<", ",", ">")
println(buffer)

//数组和列表互转

val arr = data.toArray
println(arr.toList)

//获取迭代器
val iterator = data.iterator
println(iterator.next())
println(iterator.next())







