package academy.learnprogramming.inheritance

import java.time.Year

// Three use cases for "object" keyword:
// 1. Singletons
// 2. Companion Objects
// 3. Object Expressions

fun main(args: Array<String>) {
    println(Department.HR.getDeptInfo())
    println(Department.IT.getDeptInfo())
    println(Department.ACCOUNTING.getDeptInfo())
    println(Department.SALES.getDeptInfo())

    // 1. Singleton
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())

    // 2. Companion Objects
    // Using companion object to access private static property
    println(SomeClass.Companion.accessPrivateVar()) // "Companion" keyword is optional
    println(SomeClass.accessPrivateVar())

    // Using companion object with private primary constructor
    // to prevent instances being created via constructors.
    // Factory methods in the companion object have to be used to create instances instead.
    val someClass1 = SomeClass.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this isn't the string as is", false)
    println(someClass1.someString)
    println(someClass2.someString)
//    val someClass3 = SomeClass("") // does not work

    // 3. Object Expressions
    var thisIsMutableInt = 45

    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutableInt++
            return "This is from mustImplement: ${num * 100}"
        }
    })
    println(thisIsMutableInt)
}

// Section5-49
// Enum
enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5), IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3), SALES("Sales", 20);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

// Section5-46
// Singleton
// No constructors - no other instance of this class can be created
// The one single instance is created when it is first used i.e. line 6
// "object" declarations can extend classes and implement interfaces
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

}

// Section5-47
// Companion object
class SomeClass private constructor(val someString: String) {

    // Similar to using static in Java
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            if (lowerCase) {
                return SomeClass(str.lowercase())
            } else {
                return SomeClass(str.uppercase())
            }
        }
    }

}

// Section5-48
// Object Expression
interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}