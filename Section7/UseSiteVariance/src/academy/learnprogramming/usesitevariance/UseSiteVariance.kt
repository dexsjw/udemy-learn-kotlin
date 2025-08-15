package academy.learnprogramming.usesitevariance

fun main(args: Array<String>) {

    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    firstCopyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    firstCopyCars(fords1, fords2)

    // If we can do this:
    val cars3: MutableList<Car> = mutableListOf(Ford(), Ford())
    // We should be able to do this (with reference to firstCopyCars()):
//    firstCopyCars(fords1, cars2) // error
    // but we can't

    // Use site variance:
    secondCopyCars(fords1, cars2)

}

// First iteration of copyCars()
fun <T: Car> firstCopyCars(source: MutableList<T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

// Use Site Variance (Type Projection):
// Used when implementation of a function meets the requirements of covariance and/or contravariance
// i.e. making a parameter type covariant
// Example of Use Site Variance:
// Working with third party class that is invariant
// -> write functions using instances of the class in a covariant way

// Second iteration of copyCars()
// source list      -> only read from  (covariance)
// destination list -> only written to (contravariance)
fun <T> secondCopyCars(source: MutableList<out T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

// No Declaration Site Variance below
// i.e. no covariance and contravariance below
open class Car {

}

class Toyota: Car() {

}

class Ford: Car() {

}

// Java does not have Declaration Site Variance
// Use Site Variance is equivalent to wild cards in Java
// Java equivalent code
// List<? extends Car> -> Covariance
// List<? super Car>   -> Contravariance