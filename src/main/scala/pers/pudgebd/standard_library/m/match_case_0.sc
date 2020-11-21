//---------------------
//-----模式匹配表达式------
//---------------------

//允许你解耦两个并不真正属于彼此的东西，也使得你的代码更易于测试
case class Player(name: String, score: Int)

def message(player: Player) = player match {
    case Player(_, score) if score > 100000 =>   //注意 if score > 100000
        "Get a job, dude!"
    case Player(name, _) =>
        s"Hey, $name, nice to see you again!"
}

def printMessage(player: Player) = println(message(player))
printMessage(new Player("k", 27))


//---------------------
//-----值定义中的模式------
//---------------------


def currentPlayer(): Player = Player("Daniel", 3500)
val player = currentPlayer()

def doSomethingWithName(name: String) = println(name)
doSomethingWithName(player.name)

//如果你知道 Python，你可能会了解一个称为 序列解包(sequence unpacking) 的功能，
// 它允许在值定义（或者变量定义）的左侧使用模式。
// 你可以用类似的风格编写你的 Scala 代码：改变我们的代码，在将球员赋值给左侧变量的同时去解构它：
val Player(name, _) = currentPlayer()
doSomethingWithName(name)


//你可以用任何模式来做这件事情，但得确保模式总能够匹配，否则，代码会在运行时出错。
// 下面的代码就是有问题的： scores 方法返回球员得分的列表。
//为了说明问题，代码中只是返回一个空的列表。
//def scores: List[Int] = List()
//val best :: rest = scores
//println("The score of our champion is " + best)

def gameResult(): (String, Int) = ("Daniel", 3500)
//访问元组字段的代码给人感觉总是很怪异：
val result = gameResult()
println(result._1 + ": " + result._2)
//这样，在赋值的同时去解构它是非常安全的，因为我们知道它类型是 Tuple2 ：
val (name2, score) = gameResult()
println(name2 + ": " + score)
//这就好看多了，不是吗？

