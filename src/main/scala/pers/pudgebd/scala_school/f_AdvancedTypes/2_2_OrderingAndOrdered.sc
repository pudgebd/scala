//http://img.blog.csdn.net/20150808134338867
//http://img.blog.csdn.net/20150808134527087
//通过上面两个图可以看到,Ordering混入了java中的Comparator接口，而Ordered混入了java的Comparable接口，
// 我们知道java中的Comparator是一个外部比较器，而Comparable则是一个内部比较器

//它们之间的区别和Comparable与Comparator间的区别是相同的。这里先给出一个Ordered在scala中的用法

case class Student(val name: String) extends Ordered[Student] {
    override def compare(that: Student): Int = {
        if (this.name == that.name) {
            1
        } else {
            -1
        }
    }
}

//将类型参数定义为T<:Ordered[T]
class Pairl[T <: Ordered[T]](val first: T, val second: T) {
    //比较的时候直接使用<符号进行对象间的比较
    def smaller1()={
        if(first < second)
            first
        else
            second
    }
    def smaller2: Int = {
        if (first > second) {
            1
        } else {
            -1
        }
    }
}

val p = new Pairl[Student](new Student("tom"), new Student("bob"))
println(p.smaller1)
println(p.smaller2)


















