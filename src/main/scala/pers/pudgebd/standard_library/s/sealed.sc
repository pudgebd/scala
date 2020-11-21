//sealed 关键字表示，其修饰的trait只能在当前文件里头被继承

sealed trait Answer
case object Yes extends Answer
case object No extends Answer


//sealed abstract 表示，其修饰的class，只能在当前文件里头被继承

//def process(request:Trade){
//    request match{
//        case Buy(name) => println("buy:"+name)
//        case Sale(name) => println("sale:"+name)
//    }
//}
//
//val op = Buy("IBM")
//process(op)


//通常用在case class，case class 有两个特点：1、不用new，用括号即可产生实例 2、构造器参数默认是val
//
//用sealed修饰这样做的目的是告诉scala编译器在检查模式匹配的时候，让scala知道这些case的所有情况，scala就能够在编译的时候进行检查，看你写的代码是否有没有漏掉什么没case到，减少编程的错误。



//如上例子，如果没有case sale的话，会警告，match may not be exhaustive. It would failed on the following input:Sale(_)sealed 关键字表示，其修饰的trait只能在当前文件里头被继承

//sealed trait Answer
//case object Yes extends Answer
//case object No extends Answer


//sealed abstract 表示，其修饰的class，只能在当前文件里头被继承

//def process(request:Trade){
//    request match{
//        case Buy(name) => println("buy:"+name)
//        case Sale(name) => println("sale:"+name)
//    }
//}
//
//val op = Buy("IBM")
//process(op)


//通常用在case class，case class 有两个特点：1、不用new，用括号即可产生实例 2、构造器参数默认是val
//
//用sealed修饰这样做的目的是告诉scala编译器在检查模式匹配的时候，让scala知道这些case的所有情况，scala就能够在编译的时候进行检查，看你写的代码是否有没有漏掉什么没case到，减少编程的错误。
//
//
//
//如上例子，如果没有case sale的话，会警告，match may not be exhaustive. It would failed on the following input:Sale(_)