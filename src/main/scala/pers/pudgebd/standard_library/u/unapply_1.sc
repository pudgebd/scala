//--------------------
//-----提取多个值------
//--------------------
trait User {
    def name: String

    def score: Int
}

class FreeUser(
                      val name: String,
                      val score: Int,
                      val upgradeProbability: Double
              ) extends User

class PremiumUser(
                         val name: String,
                         val score: Int
                 ) extends User

object FreeUser {
    def unapply(user: FreeUser): Option[(String, Int, Double)] =
        Some((user.name, user.score, user.upgradeProbability))
}

object PremiumUser {
    def unapply(user: PremiumUser): Option[(String, Int)] =
        Some((user.name, user.score))
}


val user: User = new FreeUser("Daniel", 3000, 0.7d)
user match {
    case FreeUser(name, _, p) =>
        if (p > 0.75) "$name, what can we do for you today?"
        else "Hello $name"
    case PremiumUser(name, _) =>
        "Welcome back, dear $name"
}


//--------------------------------------------------------------------------------------------------------

//--------------------
//-----布尔提取器------
//--------------------

object premiumCandidate {
    def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}
def initiateSpamProgram(freeUser: FreeUser) = ???
def sendRegularNewsletter(user: User) = ???

//你会发现，提取器不一定非要在这个类的伴生对象中定义。 正如其定义一样，这个提取器的使用方法也很简单：
val user2: User = new FreeUser("Daniel", 2500, 0.8d)
user2 match {
    case freeUser @ premiumCandidate() => initiateSpamProgram(freeUser)
    case _ => sendRegularNewsletter(user)
}

//使用的时候，只需要把一个空的参数列表传递给提取器，因为它并不真的需要提取数据，自然也没必要绑定变量。
//这个例子有一个看起来比较奇怪的地方： 我假设存在一个空想的 initiateSpamProgram 函数，其接受一个 FreeUser 对象作为参数。
// 模式可以与任何一种 User 类型的实例进行匹配，但 initiateSpamProgram 不行， 只有将实例强制转换为 FreeUser 类型， initiateSpamProgram 才能接受。
//因为如此，Scala 的模式匹配也允许将提取器匹配成功的实例绑定到一个变量上， 这个变量有着与提取器所接受的对象相同的类型。
// 这通过 @ 操作符实现。 premiumCandidate 接受 FreeUser 对象，因此，变量 freeUser 的类型也就是 FreeUser 。


