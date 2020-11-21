//---------------------
//----- 序列提取 ------
//---------------------

//可以匹配只有两个、或者只有三个元素的列表：

val list = List(1, 2, 3, 4, 5)
val ret = list match {
    case List(a, b) => "ab"
    case List(a, b, c) => "abcd"
    case List(a, b, c, _*) => "abc*"
    case _ => "*"
}

//下面的代码是一个用 unapplySeq 方法实现的提取器：
object givenNames {
    def unapplySeq(name: String): Option[Seq[String]] = {
        val names = name.trim.split(" ")
        if (names.forall(_.isEmpty)) None
        else Some(names)
    }
}

//给定一个含有一个或多个名字的字符串，这个提取器会将其解构成一个列表。
// 如果字符串不包含有任何名字，提取器会返回 None ，提取器所在的那个模式就匹配失败。
def greetWithFirstName(name: String) = name match {
    case givenNames(firstName, _*) => s"Good morning, $firstName !"
    case _ => "Welcome! Please make sure to fill in your name!"
}

greetWithFirstName("Daniel")
greetWithFirstName("Catherina Johanna")

//---------------------------------------------------------------

object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
        val names = name.trim.split(" ")
        if (names.size < 2) None
        else Some((names.last, names.head, names.drop(1).dropRight(1).toSeq))
    }
}

def greet(fullName: String) = fullName match {
    case Names(lastName, firstName, _*) =>
        s"Good morning, $firstName $lastName!"
    case _ =>
        "Welcome! Please make sure to fill in your name!"
}

greet("asd hqw qwfg")


//小结
//这一章里，我们学会了怎样去实现和使用返回不定长度值序列的提取器。
// 提取器是一个相当强大的工具，你可以灵活的重用它们，从而提供一种有效的方法来扩展要匹配的模式。