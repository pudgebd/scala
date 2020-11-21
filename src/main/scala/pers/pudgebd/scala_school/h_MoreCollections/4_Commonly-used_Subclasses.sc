//常用的子类
//HashSet和HashMap 的快速查找，这些集合的最常用的形式。
//
//TreeMap 是SortedMap的一个子类，它可以让你进行有序访问。
//
//Vector 快速随机选择和快速更新。

val vec = IndexedSeq(1, 2, 3)

val i: Int = 1
vec.find(i => true)


//Range 等间隔的Int有序序列。你经常会在for循环看到。
for (i <- 1 to 3) {
    println(i)
}

//Ranges支持标准的函数组合子。
(1 to 3).map { j => j}