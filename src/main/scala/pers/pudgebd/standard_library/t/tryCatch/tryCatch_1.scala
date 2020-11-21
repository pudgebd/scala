package pers.pudgebd.standard_library.t.tryCatch

import java.io.{FileOutputStream, InputStream}

import scala.util.Try
import java.net.URL
import scala.util.Success
import scala.util.Failure
import scala.io.Source
import java.net.MalformedURLException
import java.io.FileNotFoundException

//---------------------
//-----Try 的语义-------
//---------------------

//Try 有两个子类型：+
//
//   1、Success[A]：代表成功的计算。
//   2、封装了 Throwable 的 Failure[A]：代表出了错的计算。
object tryCatch_1 {

    val urlStr = "http://7xnmmr.com1.z0.glb.clouddn.com/0006016da781b4460b9f6fb56c536e3f4f60b438"

    def parseURL(url: String): Try[URL] = Try(new URL(url))

    def getTestedInput01(): InputStream = {
        def inputStreamForURL(urlStr: String): Try[InputStream] = {
            parseURL(urlStr).flatMap(url => Try(url.openStream()))
        }

        val input = inputStreamForURL(urlStr).get  //OrElse(Try(None))
        input
    }

    def getURLContent(url: String): Try[Iterator[String]] = {
        for {
            url <- parseURL(url)
            source = Source.fromURL(url)
        } yield source.getLines()
    }

    //模式匹配
    def matchs() = {
        getURLContent("http://danielwestheide.com/foobar") match {
            case Success(lines) => lines.foreach(println)
            case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
        }
    }

    //从故障中恢复
    val content = getURLContent("garbage") recover {
        case e: FileNotFoundException => Iterator("Requested page does not exist")
        case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
        case _ => Iterator("An unexpected error has occurred. We are so sorry!")
    }

    def main(args: Array[String]) {
        val input = getTestedInput01()
        println(input.isInstanceOf[InputStream])
        val output = new FileOutputStream("/home/pudgebd/10105scala")

        val buff = new Array[Byte](1024)
        var read = input.read(buff)
        while (read > 0) {
            output.write(buff)
            read = input.read(buff)
        }

        output.flush()
        input.close()
        output.close()
    }

}
