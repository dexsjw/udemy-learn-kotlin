package academy.learnprogramming.inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()

    SomethingElse("whatever")
}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

// Subclass constructor signatures do not have to match super class
open class LaserPrinter(modelName: String, pagePerMinute: Int): Printer(modelName) {

    // Using secondary constructor as the constructor for subclass
    // constructor(): super()

    // "override" key word implicitly includes "open"
    final override fun printModel() = println("The model name of this laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}

class SpecialLaserPrinter(modelName: String, pagePerMinute: Int): LaserPrinter(modelName, pagePerMinute) {

}

// Demo for class without primary constructor and only have secondary constructor
open class Something {

    val someProperty: String

    constructor(someParameter: String) {
        someProperty = someParameter
        println("I'm in the parent's constructor")
    }

}

class SomethingElse: Something {

    constructor(someOtherParameter: String): super(someOtherParameter) {
        println("I'm in the child's constructor")
    }

}

// data classes are "closed" type, they can't be extended
// data classes can't be abstract or inner classes - don't make sense
// data classes are meant to just store state so why make it extendable?
// data classes can extend other classes but doesn't allow inheritance from data class
//open data class DataClass(val number: Int) {
data class DataClass(val number: Int) {

}