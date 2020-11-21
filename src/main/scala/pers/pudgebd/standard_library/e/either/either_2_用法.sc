import scala.io.Source
import java.net.URL
import scala.util.control.Exception.catching
import java.net.MalformedURLException


def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
        Left("Requested URL is blocked for the good of the people!")
    else
        Right(Source.fromURL(url))

getContent(new URL("http://google.com")) match {
    case Left(msg) => println(msg)
    case Right(source) => source.getLines.foreach(println)
}


//错误处理
//
//可以用 Either 来处理异常，就像 Try 一样。 不过 Either 有一个优势：可以使用更为具体的错误类型，而 Try 只能用 Throwable 。
// （这表明 Either 在处理自定义的错误时是个不错的选择） 不过，需要实现一个方法，将这个功能委托给 scala.util.control 包中的
// Exception 对象：

def handling[Ex <: Throwable, T](exType: Class[Ex])(block: => T): Either[Ex, T] =
    catching(exType).either(block).asInstanceOf[Either[Ex, T]]

//这么做的原因是，虽然 scala.util.Exception 提供的方法允许你捕获某些类型的异常， 但编译期产生的类型总是 Throwable ，
// 因此需要使用 asInstanceOf 方法强制转换。
//有了这个方法，就可以把期望要处理的异常类型，放在 Either 里了：

def parseURL(url: String): Either[MalformedURLException, URL] =
    handling(classOf[MalformedURLException])(new URL(url))

//handling 的第二个参数 block 中可能还会有其他产生错误的情形， 而且并不是所有情形都会抛出异常。
// 这种情况下，没必要为了捕获异常而人为抛出异常，相反，只需定义你自己的错误类型，最好是样例类，
// 并在错误情况发生时返回一个封装了这个类型实例的 Left。
//下面是一个例子：

case class Customer(age: Int)

class Cigarettes

case class UnderAgeFailure(age: Int, required: Int)

def buyCigarettes(customer: Customer): Either[UnderAgeFailure, Cigarettes] =
    if (customer.age < 16) Left(UnderAgeFailure(customer.age, 16))
    else Right(new Cigarettes)

//应该避免使用 Either 来封装意料之外的异常， 使用 Try 来做这种事情会更好，至少它没有 Either 这样那样的缺陷。
//处理集合
//
//有些时候，当按顺序依次处理一个集合时，里面的某个元素产生了意料之外的结果， 但是这时程序不应该直接引发异常，
// 因为这样会使得剩下的元素无法处理。 Either 也非常适用于这种情况。
//假设，在我们 “行业标准般的” Web 审查系统里，使用了某种黑名单：

type Citizen = String

case class BlackListedResource(url: URL, visitors: Set[Citizen])

val blacklist = List(
    BlackListedResource(new URL("https://google.com"), Set("John Doe", "Johanna Doe")),
    BlackListedResource(new URL("http://yahoo.com"), Set.empty),
    BlackListedResource(new URL("https://maps.google.com"), Set("John Doe")),
    BlackListedResource(new URL("http://plus.google.com"), Set.empty)
)

//BlackListedResource 表示黑名单里的网站 URL，外加试图访问这个网址的公民集合。
//现在我们想处理这个黑名单，为了标识 “有问题” 的公民，比如说那些试图访问被屏蔽网站的人。 同时，我们想确定可疑的 Web 网站：
// 如果没有一个公民试图去访问黑名单里的某一个网站， 那么就必须假定目标对象因为一些我们不知道的原因绕过了筛选器，需要对此进行调查。
//下面的代码展示了该如何处理黑名单的：

val checkedBlacklist: List[Either[URL, Set[Citizen]]] =
    blacklist.map(resource =>
        if (resource.visitors.isEmpty) Left(resource.url)
        else Right(resource.visitors))

//我们创建了一个 Either 序列，其中 Left 实例代表可疑的 URL， Right 是问题市民的集合。 识别问题公民和可疑网站变得非常简单。
val suspiciousResources = checkedBlacklist.flatMap(_.left.toOption)
val problemCitizens = checkedBlacklist.flatMap(_.right.toOption).flatten.toSet

//Either 非常适用于这种比异常处理更为普通的使用场景。