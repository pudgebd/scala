import scala.collection.parallel.mutable
import scala.collection.parallel.mutable.ParArray

val pa = new ParArray[Int](10)

for (i <- 0 to 9) {
    pa(i) = i
}

//pa.lastIndexWhere(_ > 7)
//pa.lastOption
//pa.maxBy(_ > 4)
//pa.minBy(_ > 4)

val pa2 = pa.padTo(7, 10)









