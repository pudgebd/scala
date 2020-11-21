//val strs = List("a s d", "dr as", "a agd")
//val flatMap = strs.flatMap(_.split(" "))
val strs = Map("a" -> List(1, 2), "b" -> List(3, 4))
val flatMap = strs.flatMap(_._1)

val groupBy = flatMap.groupBy(i => i)

val mapValues = groupBy.mapValues(_.size)

val values = mapValues.values
val sum = values.sum