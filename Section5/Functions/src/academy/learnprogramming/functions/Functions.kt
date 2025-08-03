package academy.learnprogramming.functions

fun main(args: Array<String>) {
    println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))

    val emp1 = Employee("Jane")
    println(emp1.upperCaseFirstName())

    val car1 = Car("Blue", "Toyota", 2015)
    val car2 = Car("Red", "Ford", 2016)
    val car3 = Car("Grey", "Ford", 2017)

//    printCarColors(car1, car2, car3, str = "Color: ")
    printCarColors(car1, car2, car3)

    val manyCars = arrayOf(car1, car2, car3)
    printCarColors(*manyCars)

    val moreCars = arrayOf(car3, car2)
    val car4 = car1.copy()
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
    for (car in lotsOfCars) {
        println(car)
    }

    val str = "this is all in lowercase"
    println(Utils().upperFirstAndLast(str))
    println(str.upperFirstAndLast())

}

fun String.upperFirstAndLast(): String {
//    val upperFirst = this.substring(0, 1).uppercase() + this.substring(1)
    val upperFirst = substring(0, 1).uppercase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}

//fun printCarColors(vararg cars: Car, str: String) {
fun printCarColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

fun labelMultiply(operand1: Int, operand2: Int,
                  label: String = "The answer is:") =
    "$label ${operand1 * operand2}"

class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.uppercase()

}

data class Car(val color: String, val model: String, val year: Int) {

}