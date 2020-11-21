//0为初始值（记住numbers是List[Int]类型），m作为一个累加器。

val numbers = List(1, 2, 3, 4, 5, 6)
numbers.foldLeft(0)((m: Int, n: Int) => m + n)

numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

//foldRight
//和foldLeft一样，只是运行过程相反。

numbers.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }