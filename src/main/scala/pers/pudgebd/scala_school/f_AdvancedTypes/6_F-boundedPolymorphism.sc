//F-界多态性
//通常有必要来访问一个（泛型）特质的具体子类。例如，想象你有一些泛型特质，但需要可以与它的某一子类进行比较。

trait Container1 extends Ordered[Container1]

//然而，现在比较方法是必须的了

def compare(that: Container1): Int

//因此，我们不能访问具体子类型，例如：

//class MyContainer1 extends Container1 {
//    def compare(that: MyContainer): Int
//}
//编译失败，因为我们对 Container 指定了Ordered特质，而不是对特定子类型指定的。

//为了调和这一点，我们改用F-界的多态性。

trait Container[A <: Container[A]] extends Ordered[A]

//奇怪的类型！但可以看到怎样对 A 实现了Ordered参数化，它本身就是 Container[A]
//
//所以，现在

class MyContainer extends Container[MyContainer] {
    def compare(that: MyContainer) = 0
}

//他们是有序的了：
List(new MyContainer, new MyContainer, new MyContainer)

//List(new MyContainer, new MyContainer, new MyContainer).min


//鉴于他们都是 Container[_] 的子类型，我们可以定义另一个子类并创建 Container[_] 的一个混合列表：
class YourContainer extends Container[YourContainer] {
    def compare(that: YourContainer) = 0
}

List(new MyContainer, new MyContainer, new MyContainer, new YourContainer)


//注意结果类型是怎样成为 YourContainer 和 MyContainer 类型确定的下界。
// 这是类型推断的工作。有趣的是，这种类型甚至不需要是有意义的，它只是提供了一个合乎逻辑的最大下界为列表的统一类型。
// 如果现在我们尝试使用 Ordered 会发生什么？

//(new MyContainer, new MyContainer, new MyContainer, new YourContainer).min
//<console>:9: error: could not find implicit value for parameter cmp:
//    Ordering[Container[_ >: YourContainer with MyContainer <: Container[_ >: YourContainer with MyContainer <: ScalaObject]]]
//
//    对统一的类型 Ordered[]不存在了。太糟糕了。