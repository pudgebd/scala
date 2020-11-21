import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

case class TaxCut(reduction: Int)

object Government {
    def redeemCampaignPledge(): Future[TaxCut] = {
        val p = Promise[TaxCut]()
        Future {
            println("Starting the new legislative period.")
            Thread.sleep(2000)
            p.success(TaxCut(20))
            println("We reduced the taxes! You must reelect us!!!!1111")
        }
        p.future
    }
}

val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
println("Now that they're elected, let's see if they remember their promises...")

//现在我们来兑现当初的竞选宣言，在 Future 上添加一个 onComplete 回调：
taxCutF.onComplete {
    case Success(TaxCut(reduction)) =>
        println(s"A miracle! They really cut our taxes by $reduction percentage points!")
    case Failure(ex) =>
        println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
}


//阻塞 IO
//Future {
//    queryDB(query)
//}

//长时间运行的计算
//取决于应用的本质特点，一个应用偶尔还会调用一些长时间运行的任务，它们完全不涉及 IO（CPU 密集的任务）。 这些任务也不应该在服务器线程中执行，因此需要将它们变成 Future：
//Future {
//    longRunningComputation(data, moreData)
//}

