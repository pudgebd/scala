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

class Child(name: String, age: Int, height: Int) {

    var grade: Int = 0

    def study(implicit forWhat: String): Unit ={
        println(s"$name whose grade: $grade is studying $forWhat ...")
    }

}

///////////////////////////////////////////////////////////

object myImplict {
    implicit def personToChild(a: Adult): Child = {
        new Child(a.name, a.age, a.height)
    }
    implicit val forWhatImplicit = "scala"
}


def studyAfterPlay(a: Adult): Unit = {
    import myImplict._
    a.study
}

val a1 = new Adult("k", 21)
studyAfterPlay(a1)

///////////////////////////////////////////////////////////

def func01[A](v: A)(implicit c: Child): Unit = {

    import myImplict._
    c.study("spark" + "_" + v.toString)
}

func01(1)(new Child("jenny", 21, 180))

///////////////////////////////////////////////////////////

def func02[A](v: A)(implicit course: String = "java", part: String = "class"): Unit = {

    val c = new Child("puge", 123, 181)
    c.study(course + "_" + v.toString + "_" + part)
}

func02(2)


