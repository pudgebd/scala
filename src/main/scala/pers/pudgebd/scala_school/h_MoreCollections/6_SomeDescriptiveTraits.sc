//一些描述性的特质
//IndexedSeq 快速随机访问元素和一个快速的长度操作。"API 文档":http://www.scala-lang.org/api/current/scala/collection/IndexedSeq.html
//
//LinearSeq 通过head快速访问第一个元素，也有一个快速的tail操作。 API文档
//
//可变 vs 不可变
//不可变
//
//优点
//
//在多线程中不会改变
//缺点
//
//一点也不能改变
//Scala允许我们是务实的，它鼓励不变性，但不惩罚我们需要的可变性。这和var vs. val非常相似。我们总是先从val开始并在必要时回退为var。
//
//我们赞成使用不可改变的版本的集合，但如果性能使然，也可以切换到可变的。使用不可变集合意味着你在多线程不会意外地改变事物。