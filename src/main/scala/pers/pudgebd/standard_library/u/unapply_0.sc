trait User {
    def name: String
}
class FreeUser(val name: String) extends User
class PremiumUser(val name: String) extends User


//我们想在各自的伴生对象中为 FreeUser 和 PremiumUser 类实现提取器， 就像 Scala 为样例类所做的一样。
// 如果想让样例类只支持从给定对象中提取单个参数，那 unapply 方法的签名看起来应该是这个样子：
object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
}
object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
}


//如果调用返回的结果是 Some[T] ，说明提取模式匹配成功，如果是 None ，说明模式不匹配。
//一般不会直接调用它，因为用于提取器模式时，Scala 会隐式的调用提取器的 unapply 方法。
//你会发现，两个提取器绝不会都返回 None 。 这个例子展示的提取器要比之前所见的更有意义。
// 如果你有一个类型不确定的对象，你可以同时检查其类型并解构。
val user: User = new PremiumUser("Daniel")
user match {
    case FreeUser(name) => "Hello" + name
    case PremiumUser(name) => "Welcome back, dear" + name
}

