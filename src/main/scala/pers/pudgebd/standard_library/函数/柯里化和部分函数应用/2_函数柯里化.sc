//可以通过调用 curried 方法得到它的柯里化版本：
val sum: (Int, Int) => Int = _ + _
val sumCurried = sum.curried
sumCurried(1)(3)

val sum2 = (a: Int, b: Int) => a + b

//使用 Funtion.uncurried 进行反向操作，可以将一个柯里化函数转换成非柯里化版本。