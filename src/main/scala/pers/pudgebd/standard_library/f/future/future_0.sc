import scala.util.{Success, Failure}
import scala.concurrent.future
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.Random

case class GrindingException(msg: String) extends Exception(msg)

def grind(beans: String): Future[String] = Future {
    println("start grinding...")
    Thread.sleep(Random.nextInt(2000))
    if (beans == "baked beans") throw GrindingException("are you joking?")
    println("finished grinding...")
    s"ground coffee of $beans"
}

//首先是 Future 伴生对象里的 apply 方法需要两个参数：+
//
//object Future {
//    def apply[T](body: => T)(implicit execctx: ExecutionContext): Future[T]
//}

//要异步执行的计算通过传名参数 body 传入。 第二个参数是一个隐式参数，隐式参数是说，函数调用时，
// 如果作用域中存在一个匹配的隐式值，就无需显示指定这个参数。 ExecutionContext 可以执行一个 Future，
// 可以把它看作是一个线程池，是绝大部分 Future API 的隐式参数。

//import scala.concurrent.ExecutionContext.Implicits.global 语句引入了一个全局的执行上下文，
// 确保了隐式值的存在。 这时候，只需要一个单元素列表,可以用大括号来代替小括号。 调用 future 方法时，
// 经常使用这种形式，使得它看起来像是一种语言特性，而不是一个普通方法的调用。

grind("baked beans").onComplete {
    case Success(ground) => println(s"got my $ground")
    case Failure(ex) => println("This grinder needs a replacement, seriously!")
}


//Map 操作
//如果 Future[Water 失败，传递给 map 的函数中的事情永远不会发生，调用 map 的结果将是一个失败的 Future[Boolean]
//
//val tempreatureOkay: Future[Boolean] = heatWater(Water(25)) map { water =>
//    println("we're in the future!")
//    (80 to 85) contains (water.temperature)
//}


//FlatMap 操作
//val flatFuture: Future[Boolean] = heatWater(Water(25)) flatMap {
//    water => temperatureOkay(water)
//}


//for 语句
//因此，要确保在 for 语句之前实例化所有相互独立的 Futures：
//def prepareCappuccino(): Future[Cappuccino] = {
//    val groundCoffee = grind("arabica beans")
//    val heatedWater = heatWater(Water(20))
//    val frothedMilk = frothMilk("milk")
//    for {
//        ground <- groundCoffee
//        water <- heatedWater
//        foam <- frothedMilk
//        espresso <- brew(ground, water)
//    } yield combine(espresso, foam)
//}