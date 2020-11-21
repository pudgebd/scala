case class Email(subject: String, text: String,
                 sender: String, recipient: String)

type EmailFilter = Email => Boolean

type SizeChecker = Int => Boolean

val sizeConstraint: SizeChecker => EmailFilter =
    f => email => f(email.text.size)


val minimumSize: Int => EmailFilter =
    n => sizeConstraint(_ >= n)

val maximumSize: Int => EmailFilter =
    n => sizeConstraint(_ <= n)


val mails = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you?",
    sender = "johndoe@example.com",
    recipient = "me@example.com") :: Nil

def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

val notSentByAnyOf: Set[String] => EmailFilter =
    senders => email => !senders.contains(email.sender)

val emails1 = newMailsForUser(mails, minimumSize(2))
val emails2 = newMailsForUser(mails, maximumSize(2))


