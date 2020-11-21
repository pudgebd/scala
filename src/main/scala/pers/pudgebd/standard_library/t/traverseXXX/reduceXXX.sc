//reduceXX 与 foldXX 的区别：r 只对自己的元素做些什么；而 f 有个初始值 z，op 会使用 z 产生新的数据。

//2 - 1 = 1
//3 - 1 = 2
//4 - 2 = 2
List(1,2,3,4).toIterator.reduceLeft((a, b) => b - a)

