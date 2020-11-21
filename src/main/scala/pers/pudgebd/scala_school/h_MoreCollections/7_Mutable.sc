//可变集合
//前面讨论的所有类都是不可变的。让我们来讨论常用的可变集合。
//
//HashMap 定义了 getOrElseUpdate, +=

val nums = collection.mutable.Map(1 -> 2)

nums.get(1)

nums.getOrElseUpdate(2, 3)

nums += 3 -> 4

//ListBuffer和ArrayBuffer 定义 += ListBuffer API, ArrayBuffer API
//
//LinkedList and DoubleLinkedList LinkedList API, DoubleLinkedList API
//        LinkedList和DoubleLinkedList LinkedList API, DoubleLinkedList API
//
//PriorityQueue API 文档
//
//Stack 和 ArrayStack Stack API, ArrayStack API
//
//StringBuilder 有趣的是，StringBuilder的是一个集合。 API文档