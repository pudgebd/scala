
object addOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
}


class addOne2 extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1

}

val plusOne = new addOne2()
plusOne(1)



class addOne3 extends (Int => Int) {
    def apply(m: Int): Int = m + 1

}