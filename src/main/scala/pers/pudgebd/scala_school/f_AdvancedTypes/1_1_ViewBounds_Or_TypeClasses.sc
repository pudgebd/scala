import scala.swing.Container

//有时候，你并不需要指定一个类型是等/子/超于另一个类，你可以通过转换这个类来伪装这种关联关系。
// 一个视界指定一个类型可以被“看作是”另一个类型。这对对象的只读操作是很有用的。
//隐函数允许类型自动转换。更确切地说，在隐式函数可以帮助满足类型推断时，它们允许按需的函数应用。例如：

implicit def strToInt(x: String) = x.toInt

math.max("123", 111)


//视界，就像类型边界，要求对给定的类型存在这样一个函数。您可以使用<%指定类型限制，例如：

class Container[A <: Long] {
    def addIt(x: A) = 1 + x
}

//这是说 A 必须“可被视”为 Int 。让我们试试。
var c = new Container[Long];
c.addIt(123)

//error
//(new Container[Float]).addIt(12F)

