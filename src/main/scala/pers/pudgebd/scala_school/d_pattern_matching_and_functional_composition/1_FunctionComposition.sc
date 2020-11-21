//val f = (s: String) => "f(" + s + ")"
//val g = (s: String) => "g(" + s + ")"
def f(s: String) = "f(" + s + ")"
def g(s: String) = "g(" + s + ")"

//compose 组合成一个新的函数 f(g(x))

val fCombG = f _ compose g _
fCombG("ha")

//andThen 和 compose很像，但是调用顺序是先调用第一个函数，然后调用第二个，即g(f(x))

val fAndThenG = f _ andThen g _
fAndThenG("yay")

