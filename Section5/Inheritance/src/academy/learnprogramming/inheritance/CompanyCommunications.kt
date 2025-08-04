package academy.learnprogramming.inheritance

import java.time.Year

fun main(args: Array<String>) {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())
}

// Singleton
// No constructors - no other instance of this class can be created
// The one single instance is created when it is first used i.e. line 6
// "object" declarations can extend classes and implement interfaces
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

}