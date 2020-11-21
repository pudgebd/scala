import scala.collection.mutable

var data: Int = 1

data match {
    case 1 => {
        println("one")
        println(data + 1)
    }
    case 2 => println("two")
    case _ => println("others")
}

//我们看看如下的另一种写法

val resutl = data match {
    case i if i ==1 => "one"
    case number if number ==2 => "two"
    case _ => "others"
}

//case 后面定义了一个常量 i 和 number 该常量在进行匹配的时候赋值。
// 并且该常量可以再次引用。
//例如

"Spark !".foreach(
    c => println(
        c match {
            case ' ' => "space"
            case ch => "char:" + ch
        }
    )
)



def math_type(x: Any) = x match {
    case i: Int => i + 1
    case d: Double => d + 0.1
    case s: String => println(s)
    case _ => println("sth else")
}

math_type(1)
math_type(0.1)
math_type("pudgebd")
math_type(2L)


//列表匹配：
def match_list(lst : Any) = lst match {
    case 0 :: Nil => println("List:"+0) //Nil表示空列表
    case List(x) => println("List:"+x)
    case x :: y :: Nil => println("List:"+x)
    case x :: tail => println("List:"+"多元素List") //tail表示List的剩下所有元素
}

match_list(List(0))
match_list(List("spark"))
match_list(List("spark","hadoop"))
match_list(List("spark",1,2,4,5))


//元组匹配
def match_tuple(t : Any) = t match {
    case (0,_) => println("二元元组，第一个值为0")
    case (x,y) => println("二元元组，值为:"+x+","+y)
    case _ => println("something else")
}

match_tuple((0,'x'))
match_tuple(('y','x'))
match_tuple((0,1,2,3))


//还有一个使用正则表达式提取数据的提取器
val pattern = "([0-9]+) ([a-z]+)".r
"2016 spark" match {
    case pattern(num,item) => println(num+" "+item)
}

val map = Map(1 -> "a", 2 -> "b")
map.getOrElse(3, "null2")

//通过模式匹配分离可选值，如果匹配的值是Some的话，将Some里的值抽出赋给s变量
object OptionOps {
    def main(args: Array[String]): Unit = {
        val capitals = Map("France"->"Paris", "Japan"->"Tokyo", "China"->"Beijing")

        capitals.get("China") match {
            case Some(c) => println(c)
            case None => println("captitals miss")
        }

        def showCapital(x: Option[String]) = x match {
            case Some(s) => s
            case None => "?"
        }
        println(showCapital(capitals.get("Japan")))
    }
}