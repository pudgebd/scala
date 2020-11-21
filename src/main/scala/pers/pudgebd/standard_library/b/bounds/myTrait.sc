trait Vehicle {

    var wheel: Int
    var carriage: String
    var controller: String

    def run: Unit = {
        println(s"use $controller to run $carriage with $wheel wheels")
    }

    def brake

}

trait Streamline {

    var streamLevel: Int

    def speedUp
}

trait Dudu {
    def createDudu: Unit = {
        println("du du...")
    }
}

trait Noice extends Dudu {

    var noiceLike: String

    def createNoice

}

class Car extends Vehicle with Streamline with Noice {

    override var wheel: Int = _

    override def brake: Unit = ???

    override var controller: String = _
    override var carriage: String = _

    override def speedUp: Unit = ???

    override var streamLevel: Int = _

    override def createNoice: Unit = ???

    override var noiceLike: String = _

}


