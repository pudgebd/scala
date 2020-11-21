package pers.pudgebd.standard_library.c

class Child(id: Long, private var name: String, protected var age: Int = 20) {
    //主构造器
    //对于主构造器中的未用var、val标注的参数，如果在类的任何一个方法用用到该参数，该参数将会转换为类的字段，否则不会
    //如 id 字段

    var height: Int = 0
    var weight: Int = 0

    //辅助构造器通过this来定义，且必须首先调用主构造器或者其他已经定义的辅助构造器。
    //辅助构造器的参数前不能添加val、var标志
    def this(height: Int, weight: Int) {
        this(0L, "k")
        this.height = height
        this.weight = weight
    }

    def getName = name

    def setName(name: String) = {
        this.name = name
    }

    def getAge = age

    def setAge(age: Int) = {
        this.age = age
    }


}

//私有构造器通过在类名后用private关键字标注主构造器参数来标明。此时，可以通过辅助构造器来创建该类的对象。
class Person private(val name: String) {

    var age: Int = 1

    def this(name: String, age: Int) {
        this(name)
        this.age = age
    }

    def getName = name

}


//嵌套类
//在Scala中，你几乎可以在任何语法结构中嵌套任何语法结构，如在函数中定义函数，在类中定义类。
class Family(val h_name: String, val w_name: String) {

    class Husband(var name: String) {
        println(" I'm a husband ")
    }

    class Wife(var name: String) {
        println(" I'm a Wife ")
    }

    var husband = new Husband(h_name)
    var wife = new Wife(w_name)

    def info() {
        println("husband: " + husband.name + ", wife:" + wife.name)
    }
}


//　　可以将在Java类中定义的静态常量、方法等放置到Scala的类的伴生对象中。
//伴生对象与类同名，且必须放置在同一源文件中。类可以访问伴生对象私有特性，但是必须通过 伴生对象.属性名 或 伴生对象.方法 调用。
//　　伴生对象是类的一个特殊实例。
//　　如在类Counter访问其伴生对象的私有方法getCount，必须通过 Counter.getCount() 的方式调用。
class Counter{
    def getTotalCounter()= Counter.getCount
}

object Counter{

    private var cnt = 0

    private def getCount()= cnt

}