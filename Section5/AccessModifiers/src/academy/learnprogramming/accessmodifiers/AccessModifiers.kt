package academy.learnprogramming.accessmodifiers

/*                               Top Level Items                                   */
// Access Modifier      Kotlin                              Java
// private              Visible within the same file        Can't be used
// protected            Can't be used                       Can't be used
// public               Visible everywhere                  Visible everywhere
// internal             Visible within the same module      N/A

// When compiled, Kotlin's access modifiers will be compiled to access modifiers that JVM understands
// Kotlin's private is compiled to "package-private" ("default" in Java)
// Kotlin's internal is compiled to "public" (Java)

fun main(args: Array<String>) {

    val emp1 = Employee("John")
    println(emp1.firstName)
    emp1.fullTime = false
    println(emp1.fullTime)

    val emp2 = Employee("Joe")
    println(emp2.firstName)
    println(emp2.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.firstName)
    println(emp3.fullTime)

    println(Demo().dummy)

}

// Section5-37
// All classes in Kotlin are "public final" by default

// First version of a working Employee class
//class Employee(val firstName: String) {
//
//    var fullTime: Boolean = true
//
//    constructor(firstName: String, fullTime: Boolean): this(firstName) {
//        this.fullTime = fullTime
//    }
//
//}

// Final version of a working Employee class
class Employee(val firstName: String, fullTime: Boolean = true) {

    // Section5-38: Custom Getters and Setters
    // If no additional feature is needed, Kotlin auto generates default Getters and Setters
    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }

}

// It's perfectly okay to not have a primary constructor
// Just don't include parentheses after class name
class Demo {
    // default values can be used as well
    // val dummy: String = "hello"
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}

// 1. Long way of defining a class equivalent to Java
//class Employee constructor(firstName: String) {
//
//    val firstName: String
//
//    init {
//        this.firstName = firstName
//    }
//
//}

// 2. First simplification
//class Employee constructor(firstName: String) {
//
//    val firstName: String = firstName
//
//}

// 3. Second simplification
//class Employee(var firstName: String) { // "var" works too
//class Employee(val firstName: String) {
//
//}

// If primary constructor is to be protected:
//class Employee protected constructor(val firstName: String) {
//
//}

// Unlike primary constructor, secondary constructor doesn't allow declaration and assignment of property in one line
// The below will not work
//class Employee(val firstName: String) {
//
//    // If a primary constructor is present, secondary constructors needs to call the primary constructor
//    // i.e. ": this(firstName)"
//    constructor(val firstName: String, val fullTime: Boolean) {
//
//    }
//
//    // Secondary constructors do not declare a property for us,
//    // only the primary constructor does
//    // When needed, the property has to be explicitly declared
//    constructor(firstName: String, val fullTime: Boolean): this(firstName) {
//
//    }
//
//}