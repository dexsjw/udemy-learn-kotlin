package academy.learnprogramming.lambdas

fun main(args: Array<String>) {

//    println(countTo100())

    val employees = listOf(Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002)
    )

    findByLastName(employees, "Wilson")
    findByLastName(employees, "Smithson")

    "Some String".apply somestring@ {
        "Another String".apply {
            println(lowercase())
            println(this@somestring.uppercase())
        }
    }

}

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock // This is a local return
        }
    }
    println("Nope, there's no employee with the last name $lastName")
}

//// "return" in this case returns from both the lambda (in .forEach) and findByLastName() function
//fun findByLastName(employees: List<Employee>, lastName: String) {
//    employees.forEach {
//        if (it.lastName == lastName) {
//            println("Yes, there's an employee with the last name $lastName")
//            return // This is a non-local return
//        }
//    }
//    println("Nope, there's no employee with the last name $lastName")
//}

// Original findByLastName() code
//fun findByLastName(employees: List<Employee>, lastName: String) {
//    for (employee in employees) {
//        if (employee.lastName == lastName) {
//            println("Yes, there's an employee with the last name $lastName")
//            return
//        }
//    }
//    println("Nope, there's no employee with the last name $lastName")
//}

// Using "apply()"
// The lambda always returns the instance that invoked "apply()"
//fun countTo100() = StringBuilder().apply() {      // Instructor's syntax
fun countTo100() = StringBuilder().apply {
    for (i in 1..99) {
        append(i)
        append(", ")
    }
    append(100)
}.toString()

// Using "with()"
// Further streamlining the code of countTo100() function:
//fun countTo100() = with(StringBuilder()) {
//    for (i in 1..99) {
//        append(i)
//        append(", ")
//    }
//    append(100)
//    toString()
//}

//fun countTo100(): String {
//    val numbers = StringBuilder()
//
//    // When lambda is the last argument to a function, it can be used outside the parentheses
//    return with(numbers) {
//        for (i in 1..99) {
//            append(i)
//            append(", ")
//        }
//        append(100)
//        toString()
//    }
//    // The above syntax is equivalent to the one below:
////    return with(numbers, {
////        for (i in 1..99) {
////            append(i)
////            append(", ")
////        }
////        append(100)
////        toString()
////    })
//}

//// Original countTo100() code
//fun countTo100(): String {
//    val numbers = StringBuilder()
//    for (i in 1..99) {
//        numbers.append(i)
//        numbers.append(", ")
//    }
//    numbers.append(100)
//    return numbers.toString()
//}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}