class PreferredPrompt(val preference: String)

class PreferredDrink(val preference: String)

object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
        println("Welcome, " + name + ". The System is ready.")
        print("But while you work,")
        println("why not enjoy a cup of " + drink.preference + "?")
        println(prompt.preference)
    }
}

object JamesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
    implicit val drink = new PreferredDrink("coffee")
}

import JamesPrefs._

Greeter.greet("James")


//这里有一点要注意的是，这里 implicit 参数的类型我们没有直接使用 String 类型，事实我们可以使用 String 类型：

object Greeter2{
    def greet(name:String)(implicit prompt2: String) {
        println("Welcome, " + name + ". The System is ready.")
        println(prompt2)
    }
}
implicit val prompt2="Yes, master> "
Greeter2.greet("James")

//当问题是如果有多个参数都使用 implicit 类型，而类型相同，你就无法提供多个参数，
// 因此 implicit 类型的参数一般都是定义特殊的类型。