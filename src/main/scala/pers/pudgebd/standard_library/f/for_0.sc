//---------------------
//-----for 语句中的模式------
//---------------------

for (e <- 1 to 5 if e > 2) yield e

// for 后的圆括号中还可以许更多的事情:
//def scalaFiles =
//    for {
//        file <- filesHere
//        if file.isFile
//        if file.getName.endsWith(".scala")
//    } yield file

//yield 关键字的简短总结:

//1.针对每一次 for 循环的迭代, yield 会产生一个值，被循环记录下来 (内部实现上，像是一个缓冲区).
//2.当循环结束后, 会返回所有 yield 的值组成的集合.
//3.返回集合的类型与被遍历的集合类型是一致的.


def gameResults(): Seq[(String, Int)] =
    ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil //Nill is List[Nothing]

def hallOfFame = for {
    (name, score) <- gameResults()
    if (score > 5000)
} yield name



val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil
for {
    list @ head :: _ <- lists //@ 是绑定？
} yield list.size

// --------------------------------------------------------------

//def getURLContent(url: String): Try[Iterator[String]] =
//    for {
//        url <- parseURL(url)
//        source = Source.fromURL(url)
//    } yield source.getLines()