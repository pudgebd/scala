//单例对象用于持有一个类的唯一实例。通常用于工厂模式。
object Timer {
    var count = 0

    def currCount(): Long = {
        count += 1
        count
    }
}

Timer.currCount()

//单例对象可以和类具有相同的名称，此时该对象也被称为“伴生对象”。我们通常将伴生对象作为工厂使用。
//下面是一个简单的例子，可以不需要使用’new’来创建一个实例了。

class Bar(foo: String)

object Bar {
    def apply(foo: String) = new Bar(foo)
}

Bar.apply("asd")