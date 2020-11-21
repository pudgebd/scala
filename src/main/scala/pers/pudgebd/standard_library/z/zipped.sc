val newChildren = Seq(1, 2, 3, 4)
val children = Seq(3, 4, 5, 6)

val zipped = (newChildren, children).zipped

zipped.foreach((i1, i2) => println(i1 + "_" + i2))

val anyChildChanged = (newChildren, children).zipped map { _ == _ } contains false