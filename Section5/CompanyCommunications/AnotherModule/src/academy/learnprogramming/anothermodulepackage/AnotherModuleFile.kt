package academy.learnprogramming.anothermodulepackage

import academy.learnprogramming.communications.topLevel
import academy.learnprogramming.communications.upperFirstAndLast

fun main(args: Array<String>) {
    topLevel("Hello from another module")
    println("a string to work with".upperFirstAndLast())

    // Cannot use "getCopyrightLine()" because it has been declared "internal"
    // "internal" access modifier restricts access to within the module which it has been declared
    //println(CompanyCommunications.getCopyrightLine())
}