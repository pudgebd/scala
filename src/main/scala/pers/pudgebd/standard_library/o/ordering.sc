import scala.util.Sorting

case class Person(name:String, age:Int)
val people = Array(Person("bob", 30), Person("ann", 32), Person("carl", 19))

object ageCompare extends Ordering[Person] {
    override def compare(x: Person, y: Person): Int = {
        if (y.age > x.age) {
            1
        } else if (y.age > x.age) {
            0
        } else {
            -1
        }
    }
}

people.sortBy(x => (x.name, x.age))
//people.sorted(ageCompare)
//Sorting.quickSort(people)(ageCompare)
//people.withFilter(_.age > 20).map(p => p.age) //这个和排序无关，为什么放这里？


//val xs1 = Traversable(
//    (1, "one"),
//    (2, "two"),
//    (3, "three")).unzip
//
//val xs2 = Traversable(
//    (1, "one", '1'),
//    (2, "two", '2'),
//    (3, "three", '3')).unzip3