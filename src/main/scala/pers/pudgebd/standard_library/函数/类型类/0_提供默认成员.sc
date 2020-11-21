//伴生对象里提供一些默认的类型类特质实现，之后你会知道为什么要这么做
//你也许会发现，类型类的成员通常是单例对象，而且会有一个 implicit 关键字位于前面，
// 这是类型类在 Scala 中成为可能的几个重要因素之一，在某些条件下，它让类型类成员隐式可用。
object Math {
    trait NumberLike[T] {
        def plus(x: T, y: T): T
        def divide(x: T, y: Int): T
        def minus(x: T, y: T): T
    }
    object NumberLike {
        implicit object NumberLikeDouble extends NumberLike[Double] {
            def plus(x: Double, y: Double): Double = x + y
            def divide(x: Double, y: Int): Double = x / y
            def minus(x: Double, y: Double): Double = x - y
        }
        implicit object NumberLikeInt extends NumberLike[Int] {
            def plus(x: Int, y: Int): Int = x + y
            def divide(x: Int, y: Int): Int = x / y
            def minus(x: Int, y: Int): Int = x - y
        }
    }
}


object Statistics {
    import Math.NumberLike
    def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
        ev.divide(xs.reduce(ev.plus(_, _)), xs.size)
}
