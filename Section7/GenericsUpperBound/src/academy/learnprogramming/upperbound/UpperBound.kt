package academy.learnprogramming.upperbound

fun main(args: Array<String>) {

    val ints = listOf(1, 2, 3, 4, 5)
    val shorts: List<Short> = listOf(10, 20, 30, 40)
    val floats: List<Float> = listOf(100.3f, -459.43f)
    val strings = listOf("1", "2", "3")

    convertToInt(shorts)
    convertToInt(floats)
//    convertToInt(strings)

    append(StringBuilder("String 1 "), StringBuilder("String 2"))

    printCollection(shorts)
    printCollection(floats)

    val nullableShorts: List<Short?> = listOf(10, 20, 30, 40)
    val nullableFloats: List<Float?> = listOf(100.3f, -459.43f)
//    convertToInt(nullableShorts)  // does not work for nullable
//    convertToInt(nullableFloats)  // does not work for nullable
    printCollection(nullableShorts)
    printCollection(nullableFloats)

    // Compiler able to tell that "strings" is "List<String>" in this case
    // because it knows that we declared "strings" as "List<String>" in Line 8
    if (strings is List<String>) {
        println("This list contains strings")
    }

    var listAny: Any = listOf("str1", "str2")
    // Cannot check for instance of erased type: List<String>
    // JVM does not recognise/understand generics
//    if (listAny is List<String>) {
    if (listAny is List<*>) {
        println("Yes, this is a list. Thank you star projection!")
    }

//    listAny = listOf(1, 2, 3)
    if (listAny is List<*>) {
        println("This list contains strings")
        // Can cast using "as" but might encounter "ClassCastException"
        // e.g. uncomment line 40 to see
        val strList = listAny as List<String>
        println(strList[1].replace("str", "string"))
    }

}

// <T> implicitly means "Any?"
// Use "<T: Any>" to indicate non-nullable types
//fun <T: Any> printCollection(collection: List<T>) {
fun <T> printCollection(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
        println("Result is ${item1.append(item2)}")
    }

fun <T: Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}