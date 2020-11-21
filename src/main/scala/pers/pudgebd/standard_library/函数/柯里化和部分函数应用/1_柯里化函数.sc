case class Email(subject: String, text: String,
                 sender: String, recipient: String)
type EmailFilter = Email => Boolean

type IntPairPred = (Int, Int) => Boolean

val gt: IntPairPred = _ > _
val ge: IntPairPred = _ >= _
val lt: IntPairPred = _ < _
val le: IntPairPred = _ <= _
val eq: IntPairPred = _ == _

//也许你已经知道 Scala 里的方法可以有多个参数列表。 下面的代码用多个参数列表重新定义了sizeConstraint ：
def sizeConstraint(pred: IntPairPred)(n: Int)(email: Email): Boolean =
    pred(email.text.size, n)

//如果把它变成一个可赋值、可传递的函数对象，它的签名看起来会像是这样：
//这种单参数的链式函数称做 柯里化函数
val sizeConstraintFn: IntPairPred => Int => Email => Boolean = sizeConstraint _

//可以把要传入的 IntPairPred 传递给 sizeConstraint 得到：
//          ↓输入↓    ↓------返回----↓    ↓-此处传入ge后得到和前面对应的输入返回类型
val minSize: Int => Email => Boolean  =  sizeConstraint(ge)
val maxSize: Int => Email => Boolean  =  sizeConstraint(le)

val min20 = minSize(20)

val email = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you?",
    sender = "johndoe@example.com",
    recipient = "me@example.com")

min20(email)

