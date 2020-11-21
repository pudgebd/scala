abstract class Shape {
    def getArea: Double
}


class Circle(r: Double) extends Shape {
    override def getArea(): Double = r * r * 3.14
}