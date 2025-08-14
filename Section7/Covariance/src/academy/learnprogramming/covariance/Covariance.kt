package academy.learnprogramming.covariance

fun main(args: Array<String>) {

    // Immutable list is covariant
    // Mutable list is not covariant i.e. invariant

    // Covariant -> read only, changes can't be made to instance
    // Invariant -> changes can be made to instance

    // Covariant -> subtype is preserved
    // Invariant -> subtype is not preserved i.e. needs to be more specific

    // Subtype != Subclass
    // List<Short> is a subtype of List<Number>
    // Subclass refers to inheritance e.g. Dog is subclass of Animal

    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    val mutableShortList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)
//    convertToInt(shortList)
//    convertToInt(mutableShortList)

}

/*
*   Note:
*   Constructor parameters don't have "in" and "out" positions
*   Covariant class can be accepted as a constructor parameter
*   This is because constructors are called when an instance is created
*   -> no danger of using constructor to do something that will lead to type mismatch
*/

//fun convertToInt(collection: List<Number>) {
//    for (num in collection) {
//        println("${num.toInt()}")
//    }
//}

fun convertToInt(collection: MutableList<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
    collection.add(25.3)    // This causes problem:
    // This will cause problem if we allow MutableList<Short> to be passed in
    // because "double" type will be added into a list of "short"
    // Hence, error for "convertToInt(mutableShortList)"
}

fun waterGarden(garden: Garden<Flower>) {

}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

open class Flower {

}

class Rose: Flower() {

}

// Adding the "out" keyword makes Garden covariant
// This comes at a price
// -> more restrictions e.g. only can read, can't add
// "out" position -> can only be used as return type
// "in"  position -> to be taken as input e.g. function parameter

// "var" constructor variables cannot be used with generics i.e. "T":
//class Garden<out T: Flower>(var something: T) {

// Adding "private" keyword to "var" will work
// because the property will then only be used internally
// and it can't be changed by external factors:
//class Garden<out T: Flower>(private var something: T) {

class Garden<out T: Flower>(val something: T) {

    val flowers: List<T> = listOf()

    // pickFlower() function is allowed because "T" will be in an "out" position
    fun pickFlower(i: Int): T = flowers[i]

    // plantFlower() function is not allowed because "T" will be in an "in" position
    // when it has been declared as "out"
//    fun plantFlower(flower: T) {
//
//    }

}

// This class is invariant
// i.e. "stubborn"
//class Garden<T: Flower> {
//
//}