package academy.learnprogramming.trycatch

fun main(args: Array<String>) {

    // Kotlin does not distinguish between checked and unchecked exception
    // Thus, do not have to declare exception that a function throws in Kotlin
    // Try-Catch can be used as an expression in Kotlin

//    println(getNumber("22.5") ?: throw IllegalArgumentException("Number isn't an Int"))
    println(getNumber("22.5") ?: "I can't print the result")

    notImplementedYet("string")

}

// Another use case for "Nothing" type
// This function will never return a value
fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("Implement me!")
}

fun getNumber(str: String): Int? {
    // Values can only be returned from the "try" or "catch" block
    // No value will ever be returned from a "finally" block
    return try {
        Integer.parseInt(str)
    } catch(e: NumberFormatException) {
        null
    } finally {
        println("I'm in the finally block")
        1 // This return value is ignored
    }
}