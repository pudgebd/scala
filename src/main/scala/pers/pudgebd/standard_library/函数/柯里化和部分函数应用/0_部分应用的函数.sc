case class Email(subject: String, text: String,
                 sender: String, recipient: String)
type EmailFilter = Email => Boolean

type IntPairPred = (Int, Int) => Boolean
def sizeConstraint(pred: IntPairPred, n: Int, email: Email) =
    pred(email.text.size, n)

val gt: IntPairPred = _ > _
val ge: IntPairPred = _ >= _
val lt: IntPairPred = _ < _
val le: IntPairPred = _ <= _
val eq: IntPairPred = _ == _


//调用 sizeConstraint 函数，用上面的 IntPairPred 传入第一个参数：
val minimumSize: (Int, Email) => Boolean = sizeConstraint(ge, _: Int, _: Email)
val maximumSize: (Int, Email) => Boolean = sizeConstraint(le, _: Int, _: Email)

//我们可以漏掉第一个值，只传递约束值 n ：
val constr20: (IntPairPred, Email) => Boolean =
    sizeConstraint(_: IntPairPred, 20, _: Email)

val constr30: (IntPairPred, Email) => Boolean =
    sizeConstraint(_: IntPairPred, 30, _: Email)

//从方法到函数对象
//在一个方法上做部分应用时，可以不绑定任何的参数，这样做的效果是产生一个函数对象，并且其参数列表和原方法一模一样。
// 通过这种方式可以将方法变成一个可赋值、可传递的函数！
val sizeConstraintFn: (IntPairPred, Int, Email) => Boolean = sizeConstraint _
