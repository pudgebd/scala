//方法

//Traversable
//下面所有方法在子类中都是可用的。参数和返回值的类型可能会因为子类的覆盖而看起来不同。


//def head : A
//def tail : Traversable[A]
//这里是函数组合子定义的地方。
//
//def map [B] (f: (A) => B) : CC[B]
//
//返回每个元素都被 f 转化的集合
//
//def foreach[U](f: Elem => U): Unit
//
//在集合中的每个元素上执行 f 。
//
//def find (p: (A) => Boolean) : Option[A]
//
//返回匹配谓词函数的第一个元素
//
//def filter (p: (A) => Boolean) : Traversable[A]
//
//返回所有匹配谓词函数的元素集合
//
//划分：
//
//def partition (p: (A) ⇒ Boolean) : (Traversable[A], Traversable[A])
//
//按照谓词函数把一个集合分割成两部分
//
//def groupBy [K] (f: (A) => K) : Map[K, Traversable[A]]
//
//转换：
//
//有趣的是，你可以转换集合类型。
//
//def toArray : Array[A]
//def toArray [B >: A] (implicit arg0: ClassManifest[B]) : Array[B]
//def toBuffer [B >: A] : Buffer[B]
//def toIndexedSeq [B >: A] : IndexedSeq[B]
//def toIterable : Iterable[A]
//def toIterator : Iterator[A]
//def toList : List[A]
//def toMap [T, U] (implicit ev: <:<[A, (T, U)]) : Map[T, U]
//def toSeq : Seq[A]
//def toSet [B >: A] : Set[B]
//def toStream : Stream[A]
//def toString () : String
//def toTraversable : Traversable[A]
//把映射转换为一个数组，您会得到一个键值对的数组。
//
//scala> Map(1 -> 2).toArray
//res41: Array[(Int, Int)] = Array((1,2))


//Iterable
//添加一个迭代器的访问。
//
//def iterator: Iterator[A]
//一个迭代器能给你提供什么？
//
//def hasNext(): Boolean
//def next(): A
//这是非常Java式的。你通常不会看到在Scala中使用迭代器，通常更容易出现的是函数组合器或for循环的使用。




//Set
//def contains(key: A): Boolean
//def +(elem: A): Set[A]
//def -(elem: A): Set[A]

//Map
//通过键查找的键值对的序列。

//可以像这样将一个键值对列表传入apply()
Map("a" -> 1, "b" -> 2)

//或者像这样：
Map(("a", 2), ("b", 2))






