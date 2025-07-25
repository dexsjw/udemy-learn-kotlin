package academy.learnprogramming.accessmodifiers

fun main(args: Array<String>) {

    val emp = Employee()
    println(emp)

}

private class Employee {

}

/*                               Top Level Items                                   */
// Access Modifier      Kotlin                              Java
// private              Visible within the same file        Can't be used
// protected            Can't be used                       Can't be used
// public               Visible everywhere                  Visible everywhere
// internal             Visible within the same module      N/A

// When compiled, Kotlin's access modifiers will be compiled to access modifiers that JVM understands
// Kotlin's