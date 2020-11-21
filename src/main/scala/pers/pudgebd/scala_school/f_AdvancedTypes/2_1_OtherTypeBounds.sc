//方法可以通过隐含参数执行更复杂的类型限制。例如，List支持对数字内容执行sum，但对其他内容却不行。
// 可是Scala的数字类型并不都共享一个超类，所以我们不能使用T <: Number。
// 相反，要使之能工作，Scala的math库对适当的类型T 定义了一个隐含的Numeric[T]。
// 然后在List定义中使用它：

//sum[B >: A](implicit num: Numeric[B]): B

//如果你调用List(1,2).sum()，你并不需要传入一个 num 参数；它是隐式设置的。但如果你调用List("whoop").sum()，它会抱怨无法设置num。
//
//在没有设定陌生的对象为Numeric的时候，方法可能会要求某种特定类型的“证据”。这时可以使用以下类型-关系运算符：
//
//A =:= B	A 必须和 B相等
//A <:< B	A 必须是 B的子类
//A <%< B	A 必须可以被看做是 B

class Container[A] (value: A) {
    def addInt(implicit evidence: A =:= Int) = 1 + value
}
val c = new Container(2)
c.addInt

//类似地，根据之前的隐式转换，我们可以放松约束为可视性：  <%< 不能编译通过？
//class Container2[B] (value: B) {
//    def addInt(implicit evidence: B <%< Int): Int = {1 + value}
//}

//使用视图进行泛型编程
//在Scala标准库中，视图主要用于实现集合的通用函数。例如“min”函数（在 Seq[] 上）就使用了这种技术：

def min[B >: Int] (i: Int) (implicit cmp: Ordering[B]): Int = {
    i + 1
}

min(2)

//其主要优点是：
//集合中的元素并不是必须实现 Ordered 特质，但 Ordered 的使用仍然可以执行静态类型检查。
//无需任何额外的库支持，你也可以定义自己的排序：

//作为旁注，标准库中有视图来将 Ordered 转换为 Ordering （反之亦然）。

trait LowPriorityOrderingImplicits {
    implicit def ordered[A <: Ordered[A]]: Ordering[A] = new Ordering[A] {
        def compare(x: A, y: A) = x.compare(y)
    }
}






