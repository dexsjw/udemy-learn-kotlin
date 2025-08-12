package academy.learnprogramming.section6challenge

fun main(args: Array<String>) {

    // 1. print 5, 10, 15, 20, 25... 5000
//    for (i in 5..5000 step 5) {
//        println(i)
//    }

    // 2. print -500 to 0
//    for (j in -500..0) {
//        println(j)
//    }

    // 3. print first 15 numbers in Fibonacci sequence
    // i.e. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377
//    var num1 = 0
//    var num2 = 1
//    println(num1)
//    println(num2)
//    for (i in 1..13) {
//        val sum = num1 + num2
//        println(sum)
//        num1 = num2
//        num2 = sum
//    }
//
//    // Instructor's solution:
//    var total: Int
//    var secondToLast = 0
//    var last = 1
//
//    println(secondToLast)
//    println(last)
//    for (i in 1..13) {
//        total = secondToLast + last
//        println(total)
//        secondToLast = last
//        last = total
//    }

    // 4. print "1, 11, 100, 99, 98, 2" from the code below by modifying / adding keywords to it
//    for (i in 1..5) {
//        println(i)
//        for (j in 11..20) {
//            println(j)
//            for (k in 100 downTo 90) {
//                println(k)
//            }
//        }
//    }
//    for (i in 1..5) {
//        println(i)
//        if (i == 2) {
//            break
//        }
//        jloop@ for (j in 11..20) {
//            println(j)
//            for (k in 100 downTo 90) {
//                println(k)
//                if (k == 98) {
//                    break@jloop
//                }
//            }
//        }
//    }
//
//    // Instructor's solution:
//    iloop@ for (i in 1..5) {
//        println(i)
//        if (i == 2) {
//            break
//        }
//        for (j in 11..20) {
//            println(j)
//            for (k in 100 downTo 90) {
//                println(k)
//                if (k == 98) {
//                    continue@iloop
//                }
//            }
//        }
//    }

    // 5.
    // Declare a variable called num (int) and assign it whatever you want

    // Declare a variable called dnum (double) and assign it as follows:
    // if num > 100, assign dnum -234.567
    // if num < 100, assign dnum 4444.555
    // if num == 100, assign dnum 0.0
    // Do all of the above in one statement / expression

    // Then print the value of dnum - separate statement
    val num = 150
    val dnum = when {
        num > 100 -> -234.567
        num < 100 -> 4444.555
        else -> 0.0
    }
    println("Value of dnum = $dnum")

    // Instructor's solution:
    println(
        if (num < 100) {
            -234.567
        } else if (num > 100) {
            4444.555
        } else {
            0.0
        }
    )

    val dnum1 = when {
        num < 100 -> -234.567
        num > 100 -> 4444.555
        else -> 0.0
    }
    println(dnum1)

}