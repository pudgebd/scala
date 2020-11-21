import scala.collection.mutable

val list = List(1, 2, 3, 4, 5, 6)
val it = list.iterator


//it.product
//it.reduce()
//----------------------------------------------

//it.++((7 to 8).toIterator).foreach(println)

//----------------------------------------------

//withPartial：若最后一组元素长度小于“size”，是否返回
//(1 to 5).iterator.sliding(4, 3).withPartial(false).toList

//----------------------------------------------

//val list3 = List(3, 1, 2, 4, 5)
//val pair = list3.iterator.span(a => a > 2)
//println("----_1:")
//pair._1.foreach(println) //满足条件的靠前元素放入 "_1"，直到遇到不符合的
//println("----_2:")
//pair._2.foreach(println) //其余放入 "_2"

//----------------------------------------------

//val newIt = it ++ (6 to 10)
//newIt.foreach(println)

//----------------------------------------------

//val list2 = List(2,3,4,5,6)
//it.corresponds(list2)((a, b) => {a < b})

//----------------------------------------------

//val it2 = it.drop(2)
//it2.foreach(println)

//----------------------------------------------

//原来的　it 和 dup 出来的两个 it 会互相影响
//val dup = it.duplicate
//it.foreach(println)
//dup._1.foreach(println)

//----------------------------------------------

//(1 to 7).iterator.grouped(3).withPartial(false).toList

//----------------------------------------------

//it.isTraversableAgain

//----------------------------------------------

//在末尾追加 8
//it.padTo(7, "8").foreach(println)

//----------------------------------------------

//it.map(_ + 1).foreach(println)

//----------------------------------------------

//it.find(_ > 3)

//----------------------------------------------

//it.flatMap(i => List(i + 1)).foreach(println)

//----------------------------------------------

//val its = it.partition(_ > 3)
//its._1.foreach(println)
//its._2.foreach(println)

//----------------------------------------------

//    it patch (i, jt, r)
// 由it返回一个新迭代器，其中自第i个元素开始的r个元素被迭代器jt所指元素替换。
//val itB = scala.collection.Iterator(98,99,100)
//it.patch(1, itB, 3).toList.foreach(println)
//println("---- itB:")
//itB.foreach(println)
//println("---- it:")
//it.foreach(println)

//----------------------------------------------

//it.zipWithIndex.foreach(println)


