val greeting: Option[String] = Some("Hello world")
greeting.productElement(0)

//-----------------------------------------------

//-------------------
//----模式匹配--------
//-------------------

case class User(id: Int, firstName: String, lastName: String,
                age: Int, gender: Option[String])

object UserRepository {
    private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
        2 -> User(2, "Johanna", "Doe", 30, None))
    def findById(id: Int): Option[User] = users.get(id)
    def findAll = users.values
}

val user = User(2, "Johanna", "Doe", 30, Option("Student"))
println("Gender: " + user.gender.getOrElse("not specified")) // will print "not specified"

//你可能已经发现用模式匹配处理 Option 实例是非常啰嗦的，这也是它非惯用法的原因。
// 所以，即使你很喜欢模式匹配，也尽量用其他方法吧。
val gender = user.gender match {
    case Some(gender) => s"hello, $gender"
    case None => "nothing"
    case _ => "_"
}

//-------------------
//----作为集合的 Option-------
//-------------------
//前文我提到过， Option 是类型 A 的容器，更确切地说，你可以把它看作是某种集合，
// 这个特殊的集合要么只包含一个元素，要么就什么元素都没有。+
//
// 虽然在类型层次上， Option 并不是 Scala 的集合类型，
// 但，凡是你觉得 Scala 集合好用的方法， Option 也有，
// 你甚至可以将其转换成一个集合，比如说 List

//val gender = for {
//
//}

//执行一个副作用
UserRepository.findById(2).foreach(user => println(user.firstName))
//执行映射
val age = UserRepository.findById(1).map(_.age)
//Option 与 flatMap
val gender1 = UserRepository.findById(1).flatMap(_.gender)


//for 语句
for {
    user <- UserRepository.findById(1)
    gender <- user.gender
} yield gender

//如果我们想返回所有用户的性别（当然，如果用户设置了性别），可以遍历用户，yield 其性别：
for {
    user <- UserRepository.findAll
    gender <- user.gender
} yield gender

println("----:" + gender)

//也许你还记得，前一章曾经提到过， for 语句中生成器的左侧也是一个模式。
// 这意味着也可以在 for 语句中使用包含选项的模式。
//在生成器左侧使用 Some 模式就可以在结果集中排除掉值为 None 的元素。
for {
    User(_, _, _, _, Some(gender)) <- UserRepository.findAll
} yield gender



//链接 Option
//一个很好的使用案例是资源查找：对多个不同的地方按优先级进行搜索。
// 下面的例子中，我们首先搜索 config 文件夹，并调用 orElse 方法，以传递备用目录：
case class Resource(content: String)
val resourceFromConfigDir: Option[Resource] = None
val resourceFromClasspath: Option[Resource] = Some(Resource("I was found on the classpath"))
val resource = resourceFromConfigDir orElse resourceFromClasspath