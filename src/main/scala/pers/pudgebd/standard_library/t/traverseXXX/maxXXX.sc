//// 1 -1 规则和java相同
object myMaxIntOrd extends Ordering[Int] {
    override def compare(z: Int, y: Int): Int = {
        if (y > z)
            1
        else if (y == z)
            0
        else
            -1
    }
}

object myMaxStrOrd extends Ordering[String] {
    override def compare(z: String, y: String): Int = {
        val zl = z.length
        val yl = y.length
        if (yl > zl)
            1
        else if (yl == zl)
            0
        else
            -1
    }
}

List(1, 2, 3, 4, 5, 6).iterator.max(myMaxIntOrd)

List("a", "bb", "ccc", "dddd").iterator
        .maxBy(a => a + 1)(myMaxStrOrd)