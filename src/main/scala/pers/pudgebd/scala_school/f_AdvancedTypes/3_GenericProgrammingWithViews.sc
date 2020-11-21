//使用视图进行泛型编程
//在Scala标准库中，视图主要用于实现集合的通用函数。例如“min”函数（在 Seq[] 上）就使用了这种技术：

//def min[B >: A](implicit cmp: Ordering[B]): A = {
//    if (isEmpty)
//        throw new UnsupportedOperationException("empty.min")
//
//    reduceLeft((x, y) => if (cmp.lteq(x, y)) x else y)
//}


//其主要优点是：

//集合中的元素并不是必须实现 Ordered 特质，但 Ordered 的使用仍然可以执行静态类型检查。
//无需任何额外的库支持，你也可以定义自己的排序：

List(1, 2, 3, 4).min

List(1, 2, 3, 4).min(new Ordering[Int] {
    def compare(a: Int, b: Int) = b compare a
})


//作为旁注，标准库中有视图来将 Ordered 转换为 Ordering （反之亦然）。

trait lowpriorityOrderingImplicits {
    implicit def ordered[A <: Ordered[A]]: Ordering[A] = new Ordering[A] {
        def compare(x: A, y: A) = x.compare(y)
    }
}

