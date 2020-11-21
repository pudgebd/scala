import java.net.URL
import scala.io.Source

def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
        Left("Requested URL is blocked for the good of the people!")
    else
        Right(Source.fromURL(url))



//def averageLineCountWontCompile(url1: URL, url2: URL): Either[String, Int] =
//    for {
//        source1 <- getContent(url1).right
//        source2 <- getContent(url2).right
//        lines1 = source1.getLines().size
//        lines2 = source2.getLines().size
//    } yield (lines1 + lines2) / 2

//试着去编译它，然后你会发现无法编译！如果我们把 for 语法糖去掉，原因可能会清晰些。 展开上面的代码得到：

//def averageLineCountDesugaredWontCompile(url1: URL, url2: URL): Either[String, Int] =
//    getContent(url1).right.flatMap { source1 =>
//        getContent(url2).right.map { source2 =>
//            val lines1 = source1.getLines().size
//            val lines2 = source2.getLines().size
//            (lines1, lines2)
//        }.map { case (x, y) => x + y / 2 }
//    }

//问题在于，在 for 语句中追加新的值定义会在前一个 map 调用上自动引入另一个 map 调用， 前一个 map 调用返回的是 Either 类型，
// 不是 RightProjection 类型， 而 Scala 并没有在 Either 上定义 map 函数，因此编译时会出错。
//
//这就是 Either 丑陋的一面。要解决这个例子中的问题，可以不添加新的值定义。 但有些情况，就必须得添加，
// 这时候可以将值封装成 Either 来解决这个问题：

def averageLineCount(url1: URL, url2: URL): Either[String, Int] =
    for {
        source1 <- getContent(url1).right
        source2 <- getContent(url2).right
        lines1 <- Right(source1.getLines().size).right
        lines2 <- Right(source2.getLines().size).right
    } yield (lines1 + lines2) / 2


//认识到这些设计缺陷是非常重要的，这不会影响 Either 的可用性，但如果不知道发生了什么，它会让你感到非常头痛。