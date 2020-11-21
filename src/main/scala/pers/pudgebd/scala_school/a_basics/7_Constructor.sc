

class Calculator(brand: String) {
    /**
      * A constructor.
      */
    val color: String = {
        if (brand == "TI") {
            "blue"
        } else if (brand == "HP") {
            "black"
        } else {
            "white"
        }
    }

    def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator("HP")
calc.add(1, 2)
calc.color
