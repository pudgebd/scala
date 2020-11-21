class Container01[A](value: A) {
    def addIt(implicit evidence: A =:= Int) = 123 + value
}

class Container02[A](value: A) {
    def addIt(implicit evidence: A <:< Int) = 123 + value
}

//class Container03[A](value: A) {  // 不能用 <%< ？
//    def addIt(implicit evidence: A <%< Int) = 123 + value
//}

//class Container04[A](value: A) {
//    def addIt(implicit evidence: A =: Int) = 123 + value
//}

//class Container05[A](value: A) {
//    def addIt(implicit evidence: A <: Int) = 123 + value
//}

//class Container06[A](value: A) {
//    def addIt(implicit evidence: A <% Int) = 123 + value
//}