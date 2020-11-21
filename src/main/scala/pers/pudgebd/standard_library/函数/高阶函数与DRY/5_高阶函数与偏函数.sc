val pf: PartialFunction[(String, Int), String] = {
    case (word, freq) if freq > 3 && freq < 25 => word
}

//匿名函数那一章提到过，偏函数可以被用来创建责任链：
// PartialFunction 上的 orElse 方法允许链接任意个偏函数，从而组合出一个新的偏函数。
// 不过，只有在一个偏函数没有为给定输入定义的时候，才会把责任传递给下一个偏函数。 从而可以做下面这样的事情：
//val handler = fooHandler orElse barHandler orElse bazHandler
//再看偏函数
//
//有时候，偏函数并不合适。 仔细想想，一个函数没有为所有的输入值定义操作，这样的事实还可以用一个返回 Option[A] 的标准函数代替：
// 如果函数为一个输入定义了操作，那就返回 Some[A] ，否则返回 None 。
//要这么做的话，可以在给定的偏函数 pf 上调用 lift 方法得到一个普通的函数，这个函数返回 Option 。
// 反过来，如果有一个返回 Option 的普通函数 f ，也可以调用 Function.unlift(f) 来得到一个偏函数。