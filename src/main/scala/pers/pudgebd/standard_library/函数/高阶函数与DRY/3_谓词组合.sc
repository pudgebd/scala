//        ↓-----------输入------------↓   ↓---返回---↓
def any[A](predicates: (A => Boolean)*): A => Boolean =
    {//返回体
        a => predicates.exists(pred => pred(a))
    }

val func1 = (a: Int) => a > 2
val func2 = (a: Int) => a < 5
val func3 = any(func1, func2)
func3(3)
func3(10) //func1 与 func2 是或的关系，就是any

def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)

def none[A](predicates: (A => Boolean)*) = complement(any(predicates: _*))
def every[A](predicates: (A => Boolean)*) = none(predicates.view.map(complement(_)): _*)

none(func1, func2)(1)

every(func1, func2)(1)
every(func1, func2)(3)