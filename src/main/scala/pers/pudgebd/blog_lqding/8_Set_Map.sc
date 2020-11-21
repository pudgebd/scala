// Set 集合，集合中的数据是不可重复的。但是数据是无序的。
val dataSet = Set(1,2,5,4,1,3,2)
println(dataSet)

val dataSet2 = dataSet.+(1) //向集合中添加元素，生成另一个集合
val dataSet3 = dataSet.++(dataSet2) // 两个集合合并，返回新的集合

import scala.collection.mutable
// 定义可变集合
val data = mutable.Set.empty[Int]
data += 1 //向集合中添加元素

data ++=List(3,4) // 将列表中的元素添加到集合中

println(data)
// 有序集合TreeSet
import scala.collection.immutable
val ts = immutable.TreeSet(1,3,2,5,2,3,9,7)
println(ts) //TreeSet(1, 2, 3, 5, 7, 9)

//可变TreeSet
val mts = mutable.TreeSet[Int]()
mts.add(1)
//添加一个列表到treeSet中
mts.++=(List(1,2,3,9,7,5))
println(mts)


//TreeMap 映射,默认对值排序
val tmap = immutable.TreeMap("Spark"->10,"Hadoop"->5,"Yarn"->8)

println(tmap)