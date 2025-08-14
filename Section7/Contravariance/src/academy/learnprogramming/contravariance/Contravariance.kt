package academy.learnprogramming.contravariance

fun main(args: Array<String>) {

    // Covariance and Contravariance are called
    // Declarations Site Variance

    // Contravariance is the opposite of Covariance
    // Covariance     -> preserve subtyping
    // Contravariance -> preserve "supertyping"

    // Covariance     -> looking down the inheritance tree
    // Contravariance -> looking up the inheritance tree

    // e.g.
    // Covariance     -> I want to accept Flower and all its subclasses
    // Contravariance -> I want to accept Rose and all its superclasses

    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a ${flower.name}!")
    }

//    val roseTender = object: FlowerCare<Rose> {
//        override fun prune(flower: Rose) = println("I'm pruning a rose!")
//    }
    val roseGarden = Garden<Rose>(
        listOf(Rose(), Rose()),
        flowerTender
    )
    roseGarden.tendFlower(0)

//    val daffodilTender = object: FlowerCare<Daffodil> {
//        override fun prune(flower: Daffodil) = println("I'm pruning a daffodil!")
//    }
    val daffodilGarden = Garden<Daffodil>(
        listOf(Daffodil(), Daffodil(), Daffodil()),
        flowerTender
    )
    daffodilGarden.tendFlower(2)

    // Example of why contravariance cannot use "T" in out position i.e. return type
    val flowerTender2 = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a flower")
        fun pick(): Flower = Flower("Random Flower")
    }
    val roseGarden2 = Garden<Rose>(listOf(Rose()), flowerTender2)

    // Assuming Garden has a pickFlower2() function
    // that uses FlowerCare's impossible pick() function
    // This will return "Random Flower" instead of the expected "Rose"
    // i.e. Flower class was returned instead of Rose Class
    // We are not guaranteed to get the type that we want
    // Mismatch of type -> expected Rose but got Flower
//    val rose: Rose = roseGarden2.pickFlower2(0)
    
    // Hence, "T" cannot be used in out position for contravariance

}

class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    // For illustration purpose:
    // fun pickFlower2(i: Int) = flowerCare.pick(i)

    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower(val name: String) {

}

class Rose(): Flower("Rose") {

}

class Daffodil(): Flower("Daffodil") {

}

// Adding "in" keyword makes FlowerCare contravariant
// This comes at a price
// -> can only write, cannot read
// Can only use contravariant classes as parameters
// Cannot be used as return types of functions
// because return type is in the "out" position
interface FlowerCare<in T> {

    // prune() function is allowed because "T" will be in an "in" position
    fun prune(flower: T)

    // pick() function is not allowed because "T" will be in an "out" position
//    fun pick(i: Int): T
}