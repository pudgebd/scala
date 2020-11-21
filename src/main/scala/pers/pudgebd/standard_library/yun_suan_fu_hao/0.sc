class Adult(var name: String, var age: Int) {

    var height: Int = 0

    def this(name: String, age: Int, height: Int) {
        this(name, age)
        this.height = height
    }

    def playGame: Unit = {
        println(s"$name is playing vedio game...")
    }

}

class Child(name: String, age: Int) extends Adult(name, age) {

    var grade: Int = 0

    def study(implicit forWhat: String): Unit ={
        println(s"$name whose grade: $grade is studying $forWhat ...")
    }
}

//def eat(sb: +Adult) {
//
//}
