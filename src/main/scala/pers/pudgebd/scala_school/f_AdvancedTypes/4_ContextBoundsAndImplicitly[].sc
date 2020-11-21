import java.util.Comparator

//Scala2.8引入了一种串联和访问隐式参数的快捷方式。

def foo[A](implicit x: Ordered[A]) {}

def foo2[A : Ordered] {}

//隐式值可能会通过 implicitly 被访问

implicitly[Ordering[Int]]

//相结合后往往会使用更少的代码，尤其是串联视图的时候。