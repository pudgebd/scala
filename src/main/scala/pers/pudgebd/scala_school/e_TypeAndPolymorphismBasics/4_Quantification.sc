//有时候，你并不关心是否能够命名一个类型变量，例如：
def count[A] (l: List[A]) = l.size

//这时你可以使用“通配符”取而代之：
def count2(l: List[_]) = l.size

//这相当于是下面代码的简写：
def count3(l: List[T forSome { type T }]): Int = l.size

//注意量化会的结果会变得非常难以理解：
def drop1(l: List[_]) = l.tail

def drop2(l: List[T forSome { type T }]) = l.tail