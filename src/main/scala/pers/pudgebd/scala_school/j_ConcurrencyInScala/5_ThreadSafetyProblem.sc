//三种工具
//同步
//互斥锁（Mutex）提供所有权语义。当你进入一个互斥体，你拥有它。同步是JVM中使用互斥锁最常见的方式。在这个例子中，我们会同步Person。
//
//在JVM中，你可以同步任何不为null的实例。

class Person(var name: String) {
    def set(changedName: String) {
        this.synchronized {
            name = changedName
        }
    }
}


//volatile
//随着Java 5内存模型的变化，volatile和synchronized基本上是相同的，除了volatile允许空值。
//synchronized 允许更细粒度的锁。 而 volatile 则对每次访问同步。

class Person2(@volatile var name: String) {
    def set(changedName: String) {
        name = changedName
    }
}


//AtomicReference
//此外，在Java 5中还添加了一系列低级别的并发原语。 AtomicReference 类是其中之一

import java.util.concurrent.atomic.AtomicReference

class Person3(val name: AtomicReference[String]) {
    def set(changedName: String) {
        name.set(changedName)
    }
}


