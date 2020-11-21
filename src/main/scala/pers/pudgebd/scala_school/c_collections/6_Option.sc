//Option 是一个表示有可能包含值的容器。

trait Option[T] {
    def isDefined: Boolean
    def get: T
    def getOrElse(t: T): T
}


val nums = Map("one" -> 1, "two" -> 2)

nums.get("one")


//现在我们的数据似乎陷在Option中了，我们怎样获取这个数据呢？
//直觉上想到的可能是在isDefined方法上使用条件判断来处理。

val res1 = nums.get("two")
val res2 = if (res1.isDefined) {
    res1.get
} else {
    0
}

//我们建议使用getOrElse或模式匹配处理这个结果。
val res3 = res1.getOrElse(0)
val res4 = res1 match {
    case Some(n) => n * 2
    case None => 0
}
