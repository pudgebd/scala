def addNaturals(nats: List[Int]): Int = {
    require(nats.forall(_ >= 0), "List contains negative numbers")
    nats.foldLeft(0)(_ + _)
} ensuring(_ >= 0)

import java.lang.String

val str = new String("asd")
println(str)