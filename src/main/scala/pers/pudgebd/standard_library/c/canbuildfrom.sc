import scala.collection.generic.CanBuildFrom
import scala.collection.immutable.{BitSet, SortedSet}
import scala.collection.mutable
import scala.collection.mutable.Builder

val bits = BitSet(42, 84, 126)
val aintBits1 = bits.map(_ + 2)
val aintBits2 = bits.map(_ + 2)(toBitSetBf)

def toBitSetBf = new CanBuildFrom[Set[Int], Int, BitSet] {

    override def apply(from: Set[Int]): mutable.Builder[Int, BitSet] = {
        builder
    }

    override def apply(): mutable.Builder[Int, BitSet] = {
        builder
    }

    val builder = new Builder[Int, BitSet] {
        private[this] val b = new mutable.BitSet

        override def +=(elem: Int): this.type = {
            b += elem.toInt
            this
        }

        override def clear(): Unit = {
            b.clear()
        }

        override def result(): BitSet = {
            b.toImmutable
        }
    }

}










