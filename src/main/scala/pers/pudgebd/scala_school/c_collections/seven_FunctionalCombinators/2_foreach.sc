//foreach很像map，但没有返回值。foreach仅用于有副作用[side-effects]的函数。
val numbers = Array(1, 2, 3, 4, 5, 6)
numbers.foreach((i: Int) => i * 2)
//什么也没有返回。

//你可以尝试存储返回值，但它会是Unit类型（即void）

val doubled = numbers.foreach((i: Int) => i * 2)