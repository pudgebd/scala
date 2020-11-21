def msort[A](list: List[A])(less: (A, A) => Boolean) = {
    list.sortWith(less)
}

val abcde = "abcde".toList
//msort((a: Char, b: Char) => a > b)(abcde)
//abcde sortWith (_ > _)

//对于一个柯里化的函数，如果它有函数参数，则编译器只会通过其第一组参数的类型来判断其函数参数的类型。
//连个参数位置换一下，则下面报错
msort(abcde)(_ > _)

