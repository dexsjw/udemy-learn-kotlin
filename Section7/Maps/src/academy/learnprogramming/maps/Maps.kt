package academy.learnprogramming.maps

fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013)
    )
    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = mutableMapOf<String, Car>(
        "John's car" to Car("red", "Range Rover", 2010),
        "Jane's car" to Car("blue", "Hyundai", 2012)
    )
    println(mutableMap.javaClass)
    println(mutableMap)

    val mutableHashMap = hashMapOf<String, Car>(
        "John's car" to Car("red", "Range Rover", 2010),
        "Jane's car" to Car("blue", "Hyundai", 2012)
    )
    println(mutableHashMap.javaClass)
    println(mutableHashMap)
    mutableHashMap.put("Mary's car", Car("red", "Corvette", 1965))

    for ((key, value) in mutableMap) {
        println(key)
        println(value)
    }
//    for (entry in mutableMap) {
//        println(entry.key)
//        println(entry.value)
//    }

    val pair = Pair(10, "ten")
    //val firstValue = pair.first
    //val secondValue = pair.second
    val (firstValue, secondValue) = pair
    println(firstValue)
    println(secondValue)

    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    println("color = $color, model = $model, and year = $year")

}

data class Car(val color: String, val model: String, val year: Int) {

    // "data class" comes with destructuring functions by default
    // Hence, the below is not needed anymore
//    operator fun component1() = color
//    operator fun component2() = model
//    operator fun component3() = year

}

//class Car(val color: String, val model: String, val year: Int) {
//
//    operator fun component1() = color
//    operator fun component2() = model
//    operator fun component3() = year
//
//}