class Animal {
    def runNow: Unit = {
        println("animal run")
    }
}

class Bird extends Animal {
    override def runNow: Unit = {
        println("bird run")
    }
}

//协变
class Covariant[+T](t: T) {}

val cov = new Covariant[Bird](new Bird)
val cov2: Covariant[Animal] = cov

def run(a: Animal) = {
    a.runNow
}
run(new Bird)

//逆变
class Contravariant[-T](t: T) {
}
val c: Contravariant[Animal] = new Contravariant[Animal](new Animal)
val c2: Contravariant[Bird] = c


class Consumer[-S, +T]() {
    def m1[U >: T](u: U): String = {u.toString}//协变，下界
    def m2[U <: S](s: S): String = {s.toString}//逆变，上界
}


val c3: Consumer[Animal, Bird] = new Consumer[Animal, Bird]()
val c4: Consumer[Bird, Animal] = c3
c4.m1(new Animal)
c4.m2(new Bird)


