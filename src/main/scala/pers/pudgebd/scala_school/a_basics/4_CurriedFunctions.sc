def multiply(m: Int)(n: Int): Int = m * n

multiply(2)(4)

val timesTwo = multiply(2) _
timesTwo(3)