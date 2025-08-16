package academy.learnprogramming.challenge7

fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    // 1. Destructure "joe" so that "fName", "lName" and "age" can be printed
    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName, age = $age")

    // 2. Create an immutable map to store the data of Persons
    // The key is "lastName" and the value is the respective Person
    val people = mapOf(
        joe.lastName to joe,
        jane.lastName to jane,
        mary.lastName to mary,
        john.lastName to john,
        jean.lastName to jean
    )

    // Instructor's solution:
//    val people = mapOf(
//        "Jones" to joe,
//        "Smith" to jane,
//        "Wilson" to mary
//        "Adams" to john
//        "Smithson" to jean
//    )

    // 3. Print the number of people in "people" map with last name beginning with "S"
    // without using explicit loop e.g. no "for" loop, forEach()
    println(people.filter { it.value.lastName.startsWith("S") }.size)

    // Instructor's solution:
//    println(people.filter { it.value.lastName.startsWith('S') }.count())

    // 3. Create a list of Pair from "people" map where
    // first item -> firstName
    // second item -> lastName
    // without using explicit loop e.g. no "for" loop, forEach()
    // Print the result out
    println(people.asSequence()
        .map { Pair(it.value.firstName, it.value.lastName) }
        .toList()
    )

    // Instructor's solution:
    // First way:
//    val namePairs = people.map { Pair(it.value.firstName, it.value.lastName) }
//    println(namePairs)

    // Second Way:
//    val firstNames = people.map { it.value.firstName }
//    val lastNames = people.map { it.value.lastName }
//    val namePairs2 = firstNames.zip(lastNames)
//    println(namePairs2)

    // 4. Using also() on a receiver object, print out the following from the "people" map:
    // Joe is 45 years old
    // Jane is 12 years old
    // etc.
    people.also {
        for (p in people) {
            println("${p.value.firstName} is ${p.value.age} years old")
        }
    }

    // Instructor's solution:
//    people.also {
//        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
//    }

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 15, 22, 101)
    // 5. Create a third list that only contains items that are in both of these lists
    // without using explicit loop e.g. no "for" loop, forEach()
    val list3 = list1.filter { list2.contains(it) }
    println("list3 = $list3")

    // Instructor's solution:
//    val list3 = list1.filter { it in list2 }        // first solution
//    val list3 = list1.filter { list2.contains(it) } // second solution
//    println("list3 = $list3")]

    var regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper
    // 6. Do the necessary to enable Line 91 to compile

    // For covariance, add "out" to type for Box i.e. Box<out T>:
    // Covariance -> can only read, cannot write
    // E.g.
//    paper.addPaper(Premium())
    // Above statement is bad!!!
    // Because "paper" might be a Box of Regular paper and we are trying to add Premium paper

    // For contravariance, add "in" to type for Box i.e. Box<in T>:
    // Contravariance -> can only write, cannot read
    // E.g.
//    regularPaper = paper
//    val sheet: Regular = regularPaper.takePaper()
    // Above statement is bad!!!
    // Because "regularPaper" might be a Box of Paper (super class)
    // and we are trying to take out a Regular paper
    // i.e. we don't know what type we are going to get back thus cannot read

}

// Can use data class to enable destructuring as well
class Person(val firstName: String, val lastName: String, val age: Int) {

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age

}

class Box<out T> {
//class Box<in T> {

//    fun takePaper(): T {
//
//    }
//
//    fun addPaper(paper: T) {
//
//    }

}

open class Paper {

}

class Regular: Paper() {

}

class Premium: Paper() {

}