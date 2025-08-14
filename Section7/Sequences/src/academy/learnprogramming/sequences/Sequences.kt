package academy.learnprogramming.sequences

fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        17 to Car("red", "BMW", 2015),
        8 to Car("green", "Ford", 2010),
    )
    println(immutableMap.asSequence()
        .filter { it.value.model == "Ford" }
        .map { it.value.color })

    println(
        listOf("Joe", "Mary", "Jane").asSequence()
            // semicolon required for single line with more than one statement
            .filter { println("filtering $it"); it[0] == 'J' }
//            .filter {
//                println("filtering $it")
//                it[0] == 'J'
//            }
            .map { println("mapping $it"); it.uppercase() }
//            .toList()
            .find { it.endsWith('E') }
            // not all elements in the sequence needs to be evaluated
            // .find() is a terminal function that ends the sequence when first value is found
    )
    
    // When working with collections instead of sequences,
    // the order in which functions are called makes a difference
    println(
        listOf("Joe", "Mary", "Jane")
            .filter { println("filtering $it"); it[0] == 'J' }
            .map { println("mapping $it"); it.uppercase() }
            .find { it.endsWith('E') }
    )
    println(
        listOf("Joe", "Mary", "Jane")
            .map { println("mapping $it"); it.uppercase() }
            .filter { println("filtering $it"); it[0] == 'J' }
            .find { it.endsWith('E') }
    )

}

data class Car(val color: String, val model: String, val year: Int) {

}