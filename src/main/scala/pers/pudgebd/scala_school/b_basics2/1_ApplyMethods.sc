class Foo {}

object FooMaker {
    def apply() = new Foo
}

val newFoo = FooMaker()

//-------------------------------------------------------------
//-------------------------------------------------------------

class Bar {

    def apply() = 0

}

val bar = new Bar
bar()

//在这里，我们实例化对象看起来像是在调用一个方法。

//可参考 http://cuipengfei.me/blog/2013/12/29/desugar-scala-7/