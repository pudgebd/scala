case class Email(subject: String, text: String,
                 sender: String, recipient: String)
type EmailFilter = Email => Boolean

//柯里化和部分函数应用是函数式编程里依赖注入的几种方式之一。
//下面这个简化的例子说明了这项技术：
case class User(name: String)
trait EmailRepository {
    def getMails(user: User, unread: Boolean): Seq[Email]
}
trait FilterRepository {
    def getEmailFilter(user: User): EmailFilter
}
trait MailboxService {
    def getNewMails(emailRepo: EmailRepository)(filterRepo: FilterRepository)(user: User) =
        emailRepo.getMails(user, true).filter(filterRepo.getEmailFilter(user))
    val newMails: User => Seq[Email]
}


object MockEmailRepository extends EmailRepository {
    def getMails(user: User, unread: Boolean): Seq[Email] = Nil
}
object MockFilterRepository extends FilterRepository {
    def getEmailFilter(user: User): EmailFilter = _ => true
}
object MailboxServiceWithMockDeps extends MailboxService {
    val newMails: (User) => Seq[Email] =
        getNewMails(MockEmailRepository)(MockFilterRepository) _
}

//一下调用 无需指定要使用的存储库。 在实际的应用程序中，这个服务也可能是以依赖的方式被使用，而不是直接引用。
MailboxServiceWithMockDeps.newMails(User("daniel"))

