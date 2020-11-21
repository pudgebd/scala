//Case class是一种特殊的类，它们经过优化以用来模式匹配。
//我们看如下例子

abstract class Person
case class Student(age: Int) extends Person
case class Worker(age: Int,salary:Double) extends Person
case object Shared extends Person

object caseClassObject {
    def main(args: Array[String]): Unit = {
        def caseOps(p : Person)= p match {
            case Student(age) => println("the student age is :"+age)
            case Worker(_,sal) => println("the Worker's salary is :"+sal)
            case Shared => println("No perporty!!")
        }

        caseOps(Student(10))
        caseOps(Worker(25,8000))
        caseOps(Shared)

    }
}


//可见使用模式匹配，可以获取创建对象时传入的参数
//如果类不是case类，那么上述功能将无法完成。
//
//case class提供了copy方法，可以创建一个与现有对象同值或者不同值的对象
val worker =  Worker(36,20000)
val worker1 = worker.copy()
val worker2 = worker.copy(salary=10000)
//caseOps(worker2)

//worker2的年纪是36，而薪水是10000
//
//这种case class 和case object 特别适用于消息传递系统。


//如果一个case class 其构造函数的参数又是另一个case class，那么我们如果使用模式匹配呢？

abstract class Item
case class Book(Description: String,Price: Double) extends Item
case class Bundle(Description: String,Price: Double,item: Item*) extends Item

object CaseClassNested {
    def main(args: Array[String]): Unit = {
        def caseClaseNestedMatch(item: Item) = item match {
            case Bundle(x,y,Book(desc,price)) => {
                println("Bundle's description:"+x)
                println("Bundle's price:"+y)
                println("Bundle's Book description:"+desc)
            }
            case Bundle(x,y,first @Book(_,_),rest @ _*) => {
                println("Bundle's description:"+x)
                println("Bundle's price:"+y)
                println("Bundle's first Book description:"+first.Description)
            }
        }
        caseClaseNestedMatch(Bundle("one book",49,Book("Spark in action",49)))
        caseClaseNestedMatch(Bundle("two book",100,Book("Hadoop in action",50),Book("Spark",50)))
    }
}

//Book是一个case class 而Bundle的参数也可以有多个Book类 。
//如果想匹配Book内的参数，可以使用类似Book(x,y)来进行模式匹配。
// 如果想匹配整个Book类，那么使用first @ Book(_,_) 来匹配。first是常量名称，可以随意定义。@ 后面是类的名称。