package academy.learnprogramming.reified

import java.math.BigDecimal

fun main(args: Array<String>) {

    val mixedList: List<Any> = listOf(
        "string",
        1,
        BigDecimal(22.5),
        "fall",
        BigDecimal(-5938.393849)
    )
    val bigDecimalsOnly = getElementsOfType<BigDecimal>(mixedList)
    val stringsOnly = getElementsOfType<String>(mixedList)
    for (item in bigDecimalsOnly) {
        println(item)
    }
    println(bigDecimalsOnly)
    println(stringsOnly)

}

// Add "inline" and "reified" to enable type checking for generics during compile and run time
// Only use reification if there is a need to check type inside the function
//fun <T> getElementsOfType(list: List<Any>): List<T> {
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {

    var newList: MutableList<T> = mutableListOf()
    for (element in list) {
        if (element is T) {
            newList.add(element)
        }
    }

    // Creating instance with type "T" is not allowed as well:
    // val c: T = T()

    return newList

}

// Classes, properties or non-inline functions can't be marked as "reified"
// e.g.:
//class Something<reified T> {
//
//}