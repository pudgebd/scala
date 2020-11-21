//Future 代表异步计算。你可以把你的计算包装在Future中，当你需要计算结果的时候，
// 你只需调用一个阻塞的 get() 方法就可以了。一个 Executor 返回一个 Future 。
// 如果使用Finagle RPC系统，你可以使用 Future 实例持有可能尚未到达的结果。
//
//一个 FutureTask 是一个Runnable实现，就是被设计为由 Executor 运行的


//val future = new FutureTask[String](new Callable[String]() {
//    def call(): String = {
//        searcher.search(target);
//    }})
//executor.execute(future)