import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer

var sb = new StringBuilder()
sb.append("adfg34sdf3w5w3g43")

var arr2 = ArrayBuffer.empty[Int]
arr2 += 0
//arr2.order
//Array(2, 3).order

val hs = HashSet("a", "b")
val s = Set(1,2,3,"c")

var arr = ArrayBuffer.empty[Int]
arr += 1
arr += 2

arr ++= arr2
val new1 = arr ++ hs


println(arr)

val a = new Array[Int](10)
val b = Array.empty[Int]
b(1) = 1










