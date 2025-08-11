package academy.learnprogramming.whenpkg

import java.math.BigDecimal

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

fun main(args: Array<String>) {

    // Switch statement doesn't exist in Kotlin

    var counter = 100

    val timeOfYear = Season.SPRING
    val str = when (timeOfYear) {
        Season.SPRING -> {
            counter += 5
            "Flowers are blooming"
        }
        Season.SUMMER -> "It's hot!"
        Season.FALL -> "It's getting cooler"
        Season.WINTER -> {
            counter = 22 - 55
            "I need a coat"
        }
    }
    println(str)

    val checkerNum = -50
    if (counter < checkerNum) {
        println("counter is less than checkerNum")
    } else if (counter > checkerNum) {
        println("counter is greater than checkerNum")
    } else {
        println("counter = checkerNum")
    }

    when {
        counter < checkerNum -> println("counter is less than checkerNum")
        counter > checkerNum -> println("counter is greater than checkerNum")
        else -> println("counter = checkerNum")
    }

    val num = 100
    when(num) {
        100, 600 -> println("600")
        in 101..199 -> println("in range 101..199")
        200 -> println("200")
        300 -> println("300")
        else -> println("Doesn't match anything")
    }

    val y = 10

    when(num) {
        y + 80 -> println("90")
        y + 90 -> println("100")
        300 -> println("300")
        else -> println("Doesn't match anything")
    }

    val obj1: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val something: Any = obj2
//    if (something is String) {
//        println(something.uppercase())
//    } else if (something is BigDecimal) {
//        println(something.remainder(BigDecimal(10.5)))
//    } else if (something is Int) {
//        println("${something - 22}")
//    }
    when (something) {
        is String -> println(something.uppercase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
    }

//    val z = when (something) {
//        is String -> println(something.uppercase())
//        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
//        is Int -> println("${something - 22}")
//        else -> println("I have no idea what type this is")
//    }
    val z = when (something) {
        is String -> {
            println(something.uppercase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
        else -> {
            println("I have no idea what type this is")
            -1
        }
    }
    println(z)

}