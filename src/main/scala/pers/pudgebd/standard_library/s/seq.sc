import scala.collection.mutable

Seq(71D, "a", 1, 5L).collectFirst({
    case x: Int => x * 10
    case x: String => x + "_"
    case _ => "sth else"
})


//mutable 和 immutable 的 以下方法结果相同
var seq1 = mutable.Seq.empty[Int]
seq1 = seq1 :+ 1

var seq2 = mutable.Seq.empty[Int]
seq2 = seq2 :+ 2

seq1 ++ seq2
seq1
seq2


