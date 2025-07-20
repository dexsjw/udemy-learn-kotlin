package academy.learnprogramming.nullreferences

fun main(args: Array<String>) {

    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts) {
        println(i)
    }
    println(nullableInts[3].toString())

//    Section4-32
//    val str: String? = "This isn't null"
//    str?.let { printText(it) } // ".let" wants a lambda expression
//
//    val str4: String? = null
//    val anotherStr = "This isn't nullable"
//    println(str4 == anotherStr)
//
//    val str2 = str!!
//    val str3 = str2.uppercase()

//    Section4-31
//    val str4 = str!!.uppercase()
//    // str?.uppercase() is similar to this in Java:
//    /*
//    if (str == null) {
//        throw exception
//    } else {
//        str.uppercase()
//    }
//    */
//
//    println("What happens when we do this: ${str?.uppercase()}")
//    // str?.uppercase() is similar to this in Java:
//    /*
//    if (str == null) {
//        null
//    } else {
//        str.uppercase()
//    }
//    */
//
//    val str2 = str ?: "This is the default value"
//    println(str2)
//
//    // Elvis operator - "?:"
//    // val str2 = str ?: "This is the default value"
//    // is shorthand for:
//    /*
//    if (str == null) {
//        str2 = "This is the default value"
//    } else {
//        str2 = str
//    }
//    */
//
//    val something: Any = arrayOf(1, 2, 3, 4)
//    val str3 = something as? String
//    println(str3)
//    println(str3?.uppercase())

}

fun printText(text: String) {
    println(text)
}