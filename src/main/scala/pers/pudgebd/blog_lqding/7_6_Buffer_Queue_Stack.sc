// List 是不可变的,一旦声明，并不能修改变量引用的List的内容
//scala 提供了ListBuffer 可变列表

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

val lb = new ListBuffer[Int]()
lb += 1
lb += 2
// 请注意，我们将lb定义成常量，lb +=1 并不是改变lb的值，而是改变lb指向的列表的值
println(lb) //ListBuffer(1, 2)


// Array 同样也是不可变数组，ArrayBuffer是可变数组
import scala.collection.mutable.ArrayBuffer
val ab = new ArrayBuffer[Int]()
ab.+=(1)
ab += 2
println(ab) //ArrayBuffer(1, 2)


//Queue 是一个对象
val queue = mutable.Queue[Int]()






