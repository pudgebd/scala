//对多个partition进行操作, seqop 类似 foldLeft 的 op，combop “联合”多个par的结果
//如果只有一个 partition，结果和fold(Left)相同
// z :  Nil for list concatenation or 0 for summation
List(3, 4, 5).toIterator
        .aggregate(2)({ (a, b) => a + b*2 }, { (p1, p2) => p1 + p2 })

//----------------------------------------------

val listLR = List(3, 4, 5)
//2 + 3*2 = 8
//8 + 4*2 = 16
//16 + 5*2 = 26
listLR.iterator.foldLeft(2)((a, b) => a + b*2) //26
(2 /: listLR.iterator)((a, b) => a + b*2) //26
listLR.iterator.scanLeft(2)((a, b) => a + b*2).foreach(println) //2,8,16,26
////                                                            z:2     上面的foldRight 最终返回值是41

//5 + 2*2 = 9
//4 + 9*2 = 22
//3 + 22*2 = 47
//注意顺序 (a, b) 和 foldLeft 相反
listLR.iterator.foldRight(2)((a, b) => a + b*2)

// /: 就是 foldLeft
// \: 就是 foldRight

//----------------------------------------------
//----------------------------------------------

//从左开始对每个元素ｘｘｘｘ
//it.scanLeft(100)((b, i) => i + b)
//        .foreach(println)


//由于fold函数遍历没有特殊的次序，所以对fold的初始化参数和返回值都有限制。在这三个函数中，初始化参数和返回值的参数类型必须相同。
//第一个限制：是初始值的类型必须是list中元素类型的超类。在我们的例子中，我们的对List[Int]进行fold计算，而初始值是Int类型的，它是List[Int]的超类。
//第二个限制：是初始值必须是中立的(neutral)。也就是它不能改变结果。比如对加法来说，中立的值是0；而对于乘法来说则是1，对于list来说则是Nil。