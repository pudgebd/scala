//在Scala中所有类型推断是 局部的 。Scala一次分析一个表达式。例如：
def id[T](x: T) = x

val i = id(123)

val str = id("asd")

val arr = id(Array(1,2,3))
