import java.io.FileNotFoundException
import java.net.{MalformedURLException, URL}

import scala.io.Source
import scala.util.{Failure, Success, Try}

//-- ----------------------------------------------------
//-- 1.
//-- ----------------------------------------------------
def getTradeNameBy(trade: Long): String = {
    trade match {
        case 1L => "政府"
        case 2L => "学校"
        case _ => "其他"
    }
}

//-- ----------------------------------------------------
//-- 2.
//-- ----------------------------------------------------
def getScaleName(userCount: Int): String = {
    userCount match {
        case a if (0 <= a && a < 10) => "微型企业"
        case b if (10 <= b && b < 100) => "小型企业"
        case g if (10000 <= g ) => "超大型企业"
    }
}

//-- ----------------------------------------------------
//-- 3.
//-- ----------------------------------------------------
def parseURL(url: String): Try[URL] = Try(new URL(url))
def getURLContent(url: String): Try[Iterator[String]] = {
    for {
        url <- parseURL(url)
        source = Source.fromURL(url)
    } yield source.getLines()
}
//从故障中恢复
val content = getURLContent("garbage") recover {
    case e: FileNotFoundException => Iterator("Requested page does not exist")
    case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
    case _ => Iterator("An unexpected error has occurred. We are so sorry!")
}