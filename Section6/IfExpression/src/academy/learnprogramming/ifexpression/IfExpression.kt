package academy.learnprogramming.ifexpression

fun main(args: Array<String>) {

    val someCondition = 69 < 22

    // There is no ternary operator in Kotlin
    // Equivalent to Java's ternary operator:
    // num = someCondition ? 50 : 592;
    val num1 = if (someCondition) 50 else 592

    val num2 = if (someCondition) {
        println("something")
        50
    } else {
        println("something else")
        592
    }
    println(num2)

    println("The result of the if expression is ${
        if (someCondition) {
            println("something")
            50
        } else {
            println("something else")
            592
        }
    }")

    val x = if (someCondition) {
        println("something")
    } else {
        println("something else")
    }
    println(x.javaClass)

}