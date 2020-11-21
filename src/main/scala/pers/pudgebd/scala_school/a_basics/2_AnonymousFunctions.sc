object HelloWorld {
    def main(args: Array[String]): Unit = {
        println("Hello, world!")
    }
}
val two = 1 + 1
var name = "pudgebd"

def addOne(m: Int): Int = m + 1
val three = addOne(2)

val addOne2 = (x: Int) => x + 1
addOne2(1)

def timesTwo(i: Int): Int = {
    println("hello world!")
    i * 2
}

{
    i: Int =>
        println("hello world!")
        i * 2
}


