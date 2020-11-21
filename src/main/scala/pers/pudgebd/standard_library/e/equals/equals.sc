case class Asd(id: Int, name: String)

val a = Asd(1, "a")
val b = Asd(1, "a")

a == b
a.equals(b)