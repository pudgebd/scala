case class Email(subject: String, text: String,
                 sender: String, recipient: String)

type EmailFilter = Email => Boolean
def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

//为了使用户能够配置邮件过滤器，实现了一些可以产生 EmailFilter 的工厂方法：
//                 输入类型        返回类型
val sentByOneOf: Set[String] => EmailFilter =
    //变量名
    senders =>
        //返回函数
        { email => senders.contains(email.sender) }


val notSentByAnyOf: Set[String] => EmailFilter =
    senders =>
        email => !senders.contains(email.sender)
val minimumSize: Int => EmailFilter =
    n =>
        email => email.text.size >= n
val maximumSize: Int => EmailFilter =
    n =>
        email => email.text.size <= n


val emailFilter: EmailFilter = notSentByAnyOf(Set("johndoe@example.com"))
val mails = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you?",
    sender = "johndoe@example.com",
    recipient = "me@example.com") :: Nil

newMailsForUser(mails, emailFilter) // returns an empty list


//--------------------------------------
//---------------函数组合----------------
//--------------------------------------
def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)
val notSentByAnyOf2 = sentByOneOf andThen complement(_)