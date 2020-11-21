import scala.collection.mutable

Set(2,3,4) & Set(4,5) //交集，同 intersect
Set(2,3,4) &~ Set(4,5)  //类似java的 removeAll，同 diff
Set(2,3,4) | Set(5,6) // 并集，同 union

//获取可能存在的所有子集
//Set(2,3,4).subsets().foreach(println)

//获取可能存在的所有定长的子集
//Set(2,3,4).subsets(2).foreach(println)