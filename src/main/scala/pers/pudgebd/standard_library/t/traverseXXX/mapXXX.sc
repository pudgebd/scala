import scala.collection.mutable.ArrayBuffer

val ab = ArrayBuffer(1, 2, 3, 4)
val builder = ab.mapResult(ele => ele.toArray)

for (ele <- builder.result()) {
    println(ele)
}