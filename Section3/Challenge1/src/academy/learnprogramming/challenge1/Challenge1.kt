package academy.learnprogramming.challenge1

fun main(args: Array<String>) {

    // Declare two immutable String variables called hello1 and hello2.
    // Assign "Hello" to both variables.
    val hello1 = "Hello"
    val hello2 = "Hello"

    // Using one line of code, test whether hello1 and hello2 are referentially equal
    // and print the result
    println("hello1 is referentially equal to hello2: ${hello1 === hello2}") // true
    // In Java, there is only one instance of a specific String literal
    // If the String literal is used more than once in the code, the same String instance is being used
    // JVM optimises String in this way
    // In JVM, it looks into a "String pool" to see if the String literal already exists
    // Strings are immutable, so it's safe for JVM to do this
    // Thus, hello1 and hello2 contains the same instance of "Hello"

    // Do the same thing as above, but test for structural equality
    println("hello1 is structurally equal to hello2: ${hello1 == hello2}") // true

    // Declare a mutable variable of type Int and assign it the value of 2988
    var num = 2988

    // Declare an immutable variable of type Any
    // and assign it the string "The Any type is the root of the Kotlin class hierarchy".
    // Then using a smart cast, print out the uppercased string
    val text: Any = "The Any type is the root of the Kotlin class hierarchy"
    if (text is String) {
        println(text.uppercase())
    }

    // Using one line of code, print out the following.
    // Make sure your code is nicely indented.
    //    1
    //   11
    //  111
    // 1111
    println("""   1
        |  11
        | 111
        |1111
    """.trimMargin())

    // Achieve the same as above but using "1" as the marginPrefix
    println("""1   1
        1  11
        1 111
        11111
    """.trimMargin("1"))

}