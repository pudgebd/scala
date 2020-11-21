//---------------------
//-----中缀表达方式------
//---------------------

//解构列表、流的方法与创建它们的方法类似，都是使用 cons 操作符： :: 、 #:: ，比如：
val xs = 58 #:: 43 #:: 93 #:: Stream.empty
xs match {
    case first #:: second #:: _ => first - second
    case _ => -1
}


//尽管 #:: 提取器在模式匹配中的使用并没有什么特殊的， 但是，为了更好的理解上面的代码，
// 还是进一步来分析一下。 而且，这是一个很好的例子，根据要匹配的数据结构的状态，提取器很可能返回 None
//看 #:: 的源码



//如果给定的流是空的，提取器就直接返回 None 。 因此， case head #:: tail 就不会匹配任何空的流。 否则，就会返回一个 Tuple2 ，其第一个元素是流的头，第二个元素是流的尾，尾本身又是一个流。 这样， case head #:: tail 就会匹配有一个或多个元素的流。 如果只有一个元素， tail 就会被绑定成空流。
//为了理解流提取器是怎么在模式匹配中工作的，重写上面的例子，把它从中缀写法转成普通的提取器模式写法：
val xs2 = 58 #:: 43 #:: 93 #:: Stream.empty
xs2 match {
    case #::(first, #::(second, _)) => first - second
    case _ => -1
}

//首先为传递给模式匹配的初始流 xs 调用提取器。 由于提取器返回 Some(xs.head, xs.tail) ，
// 从而 first 会绑定成 58， xs 的尾会继续传递给提取器，提取器再一次被调用，
// 返回首和尾， second 就被绑定成 43 ， 而尾就绑定到通配符 _ ，被直接扔掉了。


//---------------------
//-----使用提取器------
//---------------------
//那到底该在什么时候使用、怎么使用自定义的提取器呢？尤其考虑到，使用样例类就能自动获得可用的提取器。
//一些人指出，使用样例类、对样例类进行模式匹配打破了封装， 耦合了匹配数据和其具体实现的方式，这种批评通常是从面向对象的角度出发的。 如果想用 Scala 进行函数式编程，将样例类当作只包含纯数据（不包含行为）的 代数数据类型 ，那它非常适合。
//通常，只有当从无法掌控的类型中提取数据，或者是需要其他进行模式匹配的方法时，才需要实现自己的提取器。
//提取器的一种常见用法是从字符串中提取出有意义的值， 作为练习，想一想如何实现 URLExtractor 以匹配代表 URL 的字符串。


//小结
//
//在这本书的第一章中，我们学习了 Scala 模式匹配背后的提取器， 学会了如何实现自己的提取器，
//及其在模式中的使用是如何和实现联系在一起的。 但是这并不是提取器的全部，下一章，将会学习如何实现可提取可变个数参数的提取器。