//assertion

val arr = Array(1, 2, 3)
val ret0 = arr.ensuring(1 != 2, "b-god")
val ret1 = arr.ensuring(Array(3, 4).length > 5, "pigKing")