//更高级多态性类型 和 特设多态性

//Scala可以对“更高阶”的类型进行抽象。例如，假设您需要用几种类型的容器处理几种类型的数据。
// 你可能定义了一个Container的接口，它可以被实现为几种类型的容器：Option、List等。
// 你要定义可以使用这些容器里的值的接口，但不想确定值的类型。

//这类似与函数柯里化。
//例如，尽管“一元类型”有类似List[A]的构造函数，这意味着我们必须满足一个“级别”的类型变量来产生一个具体的类型
// （就像一个没有柯里化的函数需要只提供一个参数列表来被调用），更高阶的类型需要更多。


trait Container[M[_]] {
    def put[A](x: A): M[A]
    def get[A](m: M[A]): A
}

val container = new Container[List] {
    def put[A](x: A) = List(x)
    def get[A](m: List[A]) = m.head
}

container.put("12")
container.get(List(10, 2, 3))


//注意：*Container*是参数化类型的多态（“容器类型”）。
//
//如果我们结合隐式转换implicits使用容器，我们会得到“特设的”多态性：即对容器写泛型函数的能力。

implicit val listContainer = new Container[List] {
    def put[A](x: A) = List(x)
    def get[A](m: List[A]) = m.head
}

implicit val optionContainer = new Container[Some] {
    def put[A](x: A) = Some(x)
    def get[A](m: Some[A]) = m.get
}

def tupleize[M[_]: Container, A, B](fst: M[A], snd: M[B]) = {
    val c = implicitly[Container[M]]
    c.put(c.get(fst), c.get(snd))
}


tupleize(Some(1), Some(2))
tupleize(List(1), List(2))









