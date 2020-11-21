import scala.annotation.implicitNotFound

@implicitNotFound("No member of type class NumberLike in scope for ${T}")
trait Increasable[T] {
    def inc(t: T): T
}

object IncreaseObj {

    implicit object IncreasableInt extends Increasable[Int] {
        def inc(t: Int) = t + 1
    }

    implicit object IncreasableString extends Increasable[String] {
        def inc(t: String) = t + t
    }

}

//T: Increasable 表示存在一个 Increasable[T]类型的隐式值。
def outterInc[T: Increasable](list: List[T]) = {
    val ev = implicitly[Increasable[T]]
    list.map(ev.inc)
}


import IncreaseObj._
outterInc(List(1, 2, 3))
outterInc(List("z", "a", "b"))