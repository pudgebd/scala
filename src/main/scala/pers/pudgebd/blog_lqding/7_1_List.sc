val bigData = List("Spark", "Hadoop")
val data = List(1, 2, 3)

//使用::定义列表
val bigDataCore = "Spark" :: "Hadoop" :: Nil
//:: Nil不能省略，"Spark"::"Hadoop" 这个语法是错误的
//Nil是空列表，并且::是右元素的方法，例如"Hadoop"::Nil  :: 是Nil的方法
//等同于
val bigDataCore2 = Nil.::("Hadoop")


val data_Int = 1 :: 2 :: 3 :: Nil

// 两个列表合并,使用:::方法
val data_union = data ::: data_Int

//判断列表是否为空
data.isEmpty
//取列表的头部
data.head
//对于List来说，第一个元素称之为head，其余的所有元素成为tail
data.tail.head

//提取List中的元素
val List(a, b) = bigData //a="Spark" , b="Hadoop"
println("a = " + a + " b = " + b)

// 如果List中有多个元素，可以使用如下方式提取
val first :: second :: rest = data //rest代表剩余的List，返回的类型是List
println("first:" + first + " ==== " + "second:" + second + " ==== " + "rest:" + rest)
//first:1 ==== second:2 ==== rest:List(3)


//使用模式匹配对List进行排序操作
val shuffleData = List(9, 3, 2, 10, 3, 34, 1)
def compute(data: Int, dataSet: List[Int]): List[Int] = dataSet match {
    case List() => List(data)   //如果dataSet为空，那么返回List(data)
    case head :: tail => {  //如果dataSet不为空
        if (data <= head) { // data和第一个元素比较如果<=head则放到List的头部
            data :: dataSet
        } else {
            head :: compute(data, tail) //否则嵌套调用compute
        }
    }
}

println(compute(10, shuffleData))

def sortList(data : List[Int]) : List[Int] = data match {
    case List() => List()
    case head :: tail => compute(head,sortList(tail))
}

println(sortList(shuffleData))











