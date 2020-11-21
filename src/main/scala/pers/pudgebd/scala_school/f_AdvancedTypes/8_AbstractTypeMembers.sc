//抽象类型成员

//在特质中，你可以让类型成员保持抽象。

trait Foo {
    type A
    val x: A
    def getX: A = x
}

(new Foo {type A = Int; val x = 123}).getX

(new Foo { type A = String; val x = "hey" }).getX


//在做依赖注入等情况下，这往往是一个有用的技巧。
//您可以使用hash操作符来引用一个抽象类型的变量：

trait Foo2[M[_]] { type t[A] = M[A] }

val x: Foo2[List]#t[Int] = List(1)