package academy.learnprogramming.oochallenge

fun main(args: Array<String>) {
//    val kBicycle1 = KotlinBicycle(1, 2, 3)
//    val kMountainBike1 = KotlinMountainBike(2, 3, 4, 5)
//    val kRoadBike1 = KotlinRoadBike(5, 4, 3, 2)
//
//    kBicycle1.printDescription()
//    kMountainBike1.printDescription()
//    kRoadBike1.printDescription()
//
//    val kBicycle2 = KotlinBicycle(1, 2)
//    val kMountainBike2 = KotlinMountainBike(2, 3, 4)
//    val kRoadBike2 = KotlinRoadBike(5, 4, 3)
//
//    kBicycle2.printDescription()
//    kMountainBike2.printDescription()
//    kRoadBike2.printDescription()
//
//    val kMountainBike3 = KotlinMountainBike("Blue", 2, 3, 4)
//    kMountainBike3.printDescription()

//    for (color in KotlinMountainBike.availableColors) {
//        println(color)
//    }
    KotlinMountainBike.availableColors.forEach { println(it) }
}

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed")
    }

}

class KotlinMountainBike(
    var seatHeight: Int,
    cadence: Int,
    speed: Int,
    gear: Int = 10
): KotlinBicycle(cadence, speed, gear) {

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 20):
        this(seatHeight, cadence, speed, gear) {
            println("This mountain bike has a color of $color")
        }

    // Create a companion object that has a property called availableColors: List<String>
    // Initialise the list to "blue", "red", "white", "black", "green" and "brown"
    companion object {
        val availableColors: List<String> = listOf("blue", "red", "white", "black", "green", "brown")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches")
    }

}

class KotlinRoadBike(
    val tireWidth: Int,
    cadence: Int,
    speed: Int,
    gear: Int = 10
): KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth mm")
    }

}


