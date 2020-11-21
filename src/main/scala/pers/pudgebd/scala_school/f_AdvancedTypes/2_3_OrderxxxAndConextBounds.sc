//在第十七节中的类型参数（一）中，我们提到视图界定可以跨越类继承层次结构，其后面的原理是隐式转换。
// 本节要介绍的上下文界定采用隐式值来实现，上下文界定的类型参数形式为T：M的形式，其中M是一个泛型，
// 这种形式要求存在一个M[T]类型的隐式值：

//PersonOrdering混入了Ordering，它与实现了Comparator接口的类的功能一致
class PersonOrdering extends Ordering[Person] {
    override def compare(x: Person, y: Person): Int = {
        if (x.name > y.name)
            1
        else
            -1
    }
}

case class Person(val name: String) {
    println("正在构造对象:" + name)
}

//下面的代码定义了一个上下文界定
//它的意思是在对应作用域中，存在一个类型为Ordering[T]的隐式值，该隐式值可以作用于内部的方法
class Pair[T: Ordering](val first: T, val second: T) {
    //smaller方法中有一个隐式参数，该隐式参数类型为Ordering[T]
    def smaller(implicit ord: Ordering[T]) = {
        if (ord.compare(first, second) > 0)
            first
        else
            second
    }
}

object ConextBound extends App {
    //定义一个隐式值，它的类型为Ordering[Person]
    implicit val p1 = new PersonOrdering
    val p = new Pair(Person("123"), Person("456"))
    //不给函数指定参数，此时会查找一个隐式值，该隐式值类型为Ordering[Person],根据上下文界定的要求，该类型正好满足要求
    //因此它会作为smaller的隐式参数传入，从而调用ord.compare(first, second)方法进行比较
    println(p.smaller)
}

//http://blog.csdn.net/lovehuangjiaju/article/details/47342301
Map(1 -> "as")