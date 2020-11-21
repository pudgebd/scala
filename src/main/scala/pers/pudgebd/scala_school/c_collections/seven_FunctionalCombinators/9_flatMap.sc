//flatMap是一种常用的组合子，结合映射[mapping]和扁平化[flattening]。 flatMap需要一个处理嵌套列表的函数，然后将结果串连起来。

val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(x => x.map(_ * 2))

//可以把它看做是“先映射后扁平化”的快捷操作：
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten