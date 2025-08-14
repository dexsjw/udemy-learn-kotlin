package academy.learnprogramming.generics

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list = mutableListOf("Hello")
    list.add("another string")
//    printCollection(list)
    list.printCollection()


    val bdList = mutableListOf(BigDecimal(-33.45), BigDecimal(3503.99), BigDecimal(0.329))
//    printCollection(bdList)
    bdList.printCollection()

}

// Have to put <T> after "fun" to indicate that function is using generics
// This is called the Typed Parameter Declaration
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}

//fun <T> printCollection(collection: List<T>) {
//    for (item in collection) {
//        println(item)
//    }
//}