//柯里化是将原来需要多个参数的函数，转换成只需一个参数(第一个参数)，并且函数的返回值是一个函数，
// 该函数的参数是原函数的除第一个参数以外的参数。
//我们来看如下例子：

def mul(x : Int , y : Int) = x * y

//定义了一个乘法运算的函数，我们在定义一个函数
def mulOne(x : Int) = (y : Int ) => x * y


//该函数就是mul的柯里化函数
//接收一个函数，返回带一个参数的函数。
//我们调用一个mulOne函数

mulOne(2)


//mulOne(2) 返回的是一个函数。
//要求2*3则调用

val f = mulOne(2)
f(3)
//或者
mulOne(2)(3)

//柯里化函数也可用如下方法直接定义
def curring(x : Int)(y : Int) = x * y
curring(3)(4)

//看一个经典的例子
val a = Array("hello","world")
val b = Array("Hello","World")

println(a.corresponds(b)(_.equalsIgnoreCase(_)))

//corresponds 方法既用了柯里化方式定义的函数，函数声明如下
//def corresponds[B](that: GenSeq[B])(p: (A,B) => Boolean): Boolean




