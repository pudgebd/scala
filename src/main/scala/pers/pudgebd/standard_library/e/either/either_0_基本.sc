import java.net.URL
import scala.io.Source

//创建 Either
def getContent(url: URL): Either[String, Source] =
    if(url.getHost.contains("google"))
        Left("Requested URL is blocked for the good of the people!")
    else
        Right(Source.fromURL(url))

//Either 用法
//Either 基本的使用方法和 Option、Try 一样： 调用 isLeft （或 isRight ）方法询问一个 Either，
// 判断它是 Left 值，还是 Right 值。 可以使用模式匹配，这是最方便也是最为熟悉的一种方法：
getContent(new URL("http://google.com")) match {
    case Left(msg) => println(msg)
    case Right(source) => source.getLines.foreach(println)
}

//fold
val content: Iterator[String] =
    getContent(new URL("http://danielwestheide.com")).fold(Iterator(_), _.getLines())


//调用 left 或 right 方法，就能得到 Either 的 LeftProjection 或 RightProjection实例，
// 这就是 Either 的 立场(Projection) ，它们是对 Either 的一个左偏向的或右偏向的封装。

val content2: Either[Iterator[String], Source] =
getContent(new URL("http://danielwestheide.com")).left.map(Iterator(_))

// content is the Right containing a Source, as already returned by getContent
val moreContent: Either[Iterator[String], Source] =
getContent(new URL("http://google.com")).left.map(Iterator(_))