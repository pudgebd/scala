class Calculator(b: Int) {
    val brand: String = "HP"

    def add(m: Int, n: Int): Int = m + n

    def printParam = println(b)
}

class ScientificCalculator(brand: Int) extends Calculator(brand) {
    def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

class EvenMoreScientificCalculator(brand: Int) extends ScientificCalculator(brand) {
    def log(m: Int) = println(m)
}

