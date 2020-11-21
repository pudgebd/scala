//线程
//Scala并发是建立在Java并发模型基础上的。
//在Sun JVM上，对IO密集的任务，我们可以在一台机器运行成千上万个线程。
//一个线程需要一个Runnable。你必须调用线程的 start 方法来运行Runnable。

val hello = new Thread(new Runnable {
    def run() {
        println("hello world")
    }
})