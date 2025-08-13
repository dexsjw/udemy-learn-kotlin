package academy.learnprogramming.collections

fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "fall", "winter")
    println(strings.javaClass) // Immutable list

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

     if (!emptyList.isEmpty()) {
         println(emptyList[0])
     }

    val notNullList = listOfNotNull("hello", null, "goodbye")
    println(notNullList)

    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass) // Mutable list

    val mutableList = mutableListOf<Int>(1, 2, 3)
    println(mutableList.javaClass) // Mutable list

    println(mutableList[2])
    mutableList[1] = 20
    println(mutableList)

    val array = arrayOf("black", "white", "green")
//    val colorList = listOf(*array) // * -> spread operator
    val colorList = array.toList()
    println(colorList)

    val ints = intArrayOf(1, 2, 3)
    println(ints.toList())

}