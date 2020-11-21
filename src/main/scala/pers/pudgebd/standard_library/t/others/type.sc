//scala里的类型，除了在定义class,trait,object时会产生类型，还可以通过type关键字来声明类型。

//type相当于声明一个类型别名：
type S = String


//上面把String类型用S代替，通常type用于声明某种复杂类型，或用于定义一个抽象类型。

//场景1 用于声明一些复杂类型，比如下面声明一个结构类型

type T = Serializable {
    type X
    def foo(): Unit
}


//这个结构类型内部也允许通过type来定义类型，这里对X没有赋值表示X是一个抽象类型，
// 需要子类型在实现时提供X具体的类型。下面是一个T类型的具体实例：

object A extends Serializable{ type X=String; def foo(){} }
//typeOf[A.type] <:< typeOf[T]



//场景2 用于抽象类型
trait A { type T ; def foo(i:T) = print(i) }
class B extends A { type T = Int }
val b = new B
b.foo(200)


class C extends A { type T = String }
val c = new C
c.foo("hello")


//获取变量的类型
//用变量名.type可以获得变量的类型，特别的，用this.type可以获得本对象的类型。这种方法得到的类型可以用于定义其他变量或者函数参数或者返回值：

//val a1: Int = 1
//val b1: a1.type = a1
//val c1: this.type = this

//val a2: Int = 1
//val b2: a2.type = a2
//val c2: this.type = this
//注意区别.getClass和.type，前者是一个方法，可以获得类型对应的对象，后者是语法结构，用来表示某个变量的类型。

//单例对象的类型也可以用这种方式获得：
object AObject
val o: AObject.type = AObject

object AObject2
val o2: AObject2.type = AObject2