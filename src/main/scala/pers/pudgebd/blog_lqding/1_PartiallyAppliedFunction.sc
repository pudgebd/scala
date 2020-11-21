//偏函数，也叫部分应用函数，就是调用的时候，只传入函数的部分参数。先举个例子就很容易明白了。

object PartialAppliedFunction1 {
    def main(args: Array[String]): Unit = {
        val part_sum = sum(1,_:Int,3)
        println(part_sum(2))
    }

    def sum(a:Int,b:Int,c:Int)=a+b+c
}


//我们定义了一个函数sum，共有3个参数。 我们又定义了一个函数part_sum，它依赖于sum函数，但是只有部分的参数是用了占位符代替。那么当我们调用part_sum时，只需传入sum的未传入的参数即可。
//及 part_sum(2) == sum(1,2,3)
//这个就叫作部分应用函数。
//
//我们知道，在scala中函数是一等公民，函数可以当成变量赋值给其他的变量或者函数。
//那么我们看看如下语句


def sum(a:Int,b:Int,c:Int)=a+b+c

val sum3_1 = sum(_:Int,_:Int,_:Int)

//就是部分应用函数的特殊情况，所有的参数都应用。
val sum3_2 = sum _


object PartialAppliedFunction2 {
    def main(args: Array[String]): Unit = {
        val data = List(1, 2, 3, 4)
        data.foreach(println _)
    }
}


//也是部分应用函数，开始时怎么也想不明白。这不是参数占位的写法嘛。其实这段代码应该这样理解
//data.foreach() 应该传入一个函数作为参数 。 而 println _ 和sum _ 是类似的写法。
//参数占位应该是这样写：
//1
//data.foreach(println(_))