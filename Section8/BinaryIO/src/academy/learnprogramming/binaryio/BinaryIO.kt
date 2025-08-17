package academy.learnprogramming.binaryio

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

fun main(args: Array<String>) {

    val di = DataInputStream(FileInputStream("testfile.bin"))
    var si: String

    try {
        while (true) {
            si = di.readUTF()
            println(si)
        }
    } catch (e: EOFException) {

    }

    // There is no try with resources in Kotlin
    // The way to do it is to use functions that contains "use*()"
//    try (fr: FileReader = )

}