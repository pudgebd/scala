val numbers = List(1, 2, 3, 4, 5, 6)
def timesTwo(i: Int): Int = i * 2
val timesTwo2 = (i: Int) => i * 2

def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
        fn(x) :: xs
    }
}

ourMap(numbers, timesTwo2(_))