package academy.learnprogramming.nullreferences

fun main(args: Array<String>) {

    val str: String? = null
    println("What happens when we do this: ${str?.uppercase()}")
    // str?.uppercase() is similar to this in Java:
    /*
    if (str == null) {
        null
    } else {
        str.uppercase()
    }
    */

    val str2 = str ?: "This is the default value"
    println(str2)

    // Elvis operator - "?:"
    // val str2 = str ?: "This is the default value"
    // is shorthand for:
    /*
    if (str == null) {
        str2 = "This is the default value"
    } else {
        str2 = str
    }
    */

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String
    println(str3)
    println(str3?.uppercase())
}