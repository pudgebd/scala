//对给定的输入参数类型，函数可接受该类型的任何值。换句话说，一个(Int) => String 的函数可以接收任意Int值，并返回一个字符串。
//对给定的输入参数类型，偏函数只能接受该类型的某些特定的值。一个定义为(Int) => String 的偏函数可能不能接受所有Int值为输入。
//isDefinedAt 是PartialFunction的一个方法，用来确定PartialFunction是否能接受一个给定的参数。
//注意 偏函数PartialFunction 和我们前面提到的部分应用函数是无关的。

val sample = 1 to 10
val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x+" is even"
}

// the method collect can use isDefinedAt to select which members to collect
val evenNumbers = sample collect isEven

val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x+" is odd"
}

// the method orElse allows chaining another partial function to handle
// input outside the declared domain
val numbers = sample map (isEven orElse isOdd)

//see scala_school.d_xxx.1_xxx for more