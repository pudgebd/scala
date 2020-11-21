//异步计算的一个常见模式是把消费者和生产者分开，让他们只能通过 队列（Queue） 沟通。
// 让我们看看如何将这个模式应用在我们的搜索引擎索引中。

//import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
//
//// Concrete producer
//class Producer[T](path: String, queue: BlockingQueue[T]) extends Runnable {
//    def run() {
//        Source.fromFile(path, "utf-8").getLines.foreach { line =>
//            queue.put(line)
//        }
//    }
//}
//
//// Abstract consumer
//abstract class Consumer[T](queue: BlockingQueue[T]) extends Runnable {
//    def run() {
//        while (true) {
//            val item = queue.take()
//            consume(item)
//        }
//    }
//
//    def consume(x: T)
//}
//
//val queue = new LinkedBlockingQueue[String]()
//
//// One thread for the producer
//val producer = new Producer[String]("users.txt", q)
//new Thread(producer).start()
//
//trait UserMaker {
//    def makeUser(line: String) = line.split(",") match {
//        case Array(name, userid) => User(name, userid.trim().toInt)
//    }
//}
//
//class IndexerConsumer(index: InvertedIndex, queue: BlockingQueue[String]) extends Consumer[String](queue) with UserMaker {
//    def consume(t: String) = index.add(makeUser(t))
//}
//
//// Let's pretend we have 8 cores on this machine.
//val cores = 8
//val pool = Executors.newFixedThreadPool(cores)
//
//// Submit one consumer per core.
//for (i <- i to cores) {
//    pool.submit(new IndexerConsumer[String](index, q))
//}