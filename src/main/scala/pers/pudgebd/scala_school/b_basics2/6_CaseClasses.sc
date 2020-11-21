//使用样本类可以方便得存储和匹配类的内容。你不用new关键字就可以创建它们。
case class Calculator(brand: String, model: String)
val hp20b = Calculator("HP", "20b")


//样本类基于构造函数的参数，自动地实现了相等性和易读的toString方法。
val hp20B = Calculator("HP", "20b")
hp20b == hp20B


val hp30b = Calculator("HP", "30B")

def calcType(calc: Calculator) = calc match {
    case Calculator("HP", "20B") => "financial"
    case Calculator("HP", "48G") => "scientific"
    case Calculator("HP", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
}


//最后一句也可以这样写
//case Calculator(_, _) => "Calculator of unknown type"

//或者我们完全可以不将匹配对象指定为Calculator类型
//case _ => "Calculator of unknown type"

//或者我们也可以将匹配的值重新命名。
//case c@Calculator(_, _) => "Calculator: %s of unknown type".format(c)