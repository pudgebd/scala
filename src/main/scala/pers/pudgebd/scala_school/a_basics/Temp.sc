def methodMulti4(x:Int) = 4*x
val f3: (Int) => Int = methodMulti4

f3(2)


/////////////////////////////////////////////////////////////////////


//定义一个方法
def m(x: Int): Int = 2 * x
def mul(x : Int , y : Int) = x * y
def mulOne(x : Int) = (y : Int ) => x * y
//mulOne是mul的柯里化函数

//定义一个函数
val f = (x: Int) => 2 * x


/////////////////////////////////////////////////////////////////////


class Animal {
    val sound = "rustle"
}
class Bird extends Animal {
    override val sound = "call"
}
//假设你需要一个以Bird为参数的函数：
val getTweet: (Bird => String) = _.sound;


/////////////////////////////////////////////////////////////////////


import java.util
import java.util.ArrayList

val list = new util.ArrayList[Int]()
list.add(1)
list.add(2)

println(list)


/////////////////////////////////////////////////////////////////////


//什么是->？这不是特殊的语法，这是一个返回元组的方法。

"a" -> 2

//res0: (java.lang.String, Int) = (a,2)
//请记住，这仅仅是下面代码的语法糖

"a".->(2)

