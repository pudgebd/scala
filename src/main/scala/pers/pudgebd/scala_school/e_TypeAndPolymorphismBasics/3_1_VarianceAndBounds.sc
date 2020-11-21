class Covariant[+A]

val cv: Covariant[AnyRef] = new Covariant[String]

//error:
//val cv: Covariant[String] = new Covariant[AnyRef]


class Contravariant[-A]

val cv2: Contravariant[String] = new Contravariant[AnyRef]

//error:
//val fail: Contravariant[AnyRef] = new Contravariant[String]


class Animal {
    val sound = "rustle"
}
class Bird extends Animal {
    override val sound = "call"
}
class Chicken extends Bird {
    override val sound = "cluck"
}
class Duck extends Bird {
    override val sound = "gagaga"
}

trait playWith[Bird <: Ordered[Bird]] {

}

//假设你需要一个以Bird为参数的函数：
//a 不能是　Bird　的子类
//val getTweet: (Bird => String) = ((a: Animal) => a.sound )

//函数的返回值类型是协变的。如果你需要一个返回Bird的函数，但指向的函数返回类型是Chicken，这当然是可以的。
//val hatch: (() => Bird) = (() => new Chicken )


//Scala允许你通过 边界 来限制多态变量。这些边界表达了子类型关系。

//error
//def cacophony[T](things: Seq[T]) = things map (_.sound)

//def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)

//biophony(Seq(new Chicken, new Bird))

//类型下界也是支持的，这让逆变和巧妙协变的引入得心应手。List[+T]是协变的；一个Bird的列表也是Animal的列表。List定义一个操作::(elem T)返回一个加入了elem的新的List。新的List和原来的列表具有相同的类型：
//val flock = List(new Bird, new Bird)
//new Chicken :: flock

//List 同样 定义了::[B >: T](x: B) 来返回一个List[B]。请注意B >: T，这指明了类型B为类型T的超类。这个方法让我们能够做正确地处理在一个List[Bird]前面加一个Animal的操作：
//new Animal :: flock

//注意返回类型是Animal。
