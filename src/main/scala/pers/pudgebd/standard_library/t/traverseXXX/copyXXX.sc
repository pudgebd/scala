import scala.collection.mutable

val list = List(3,4,5)

val arr = new Array[Int](3)
list.copyToArray(arr)
list.copyToArray(arr, 1) //复制从 arr 的 index:1 开始
list.copyToArray(arr, 1, 1)
arr.foreach(println)


val buf = mutable.Buffer[Int]()
list.copyToBuffer(buf)
buf.foreach(println)
