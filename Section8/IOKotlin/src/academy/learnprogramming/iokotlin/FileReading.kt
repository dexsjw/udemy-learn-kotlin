package academy.learnprogramming.iokotlin

import java.io.File

fun main(args: Array<String>) {

//    val lines = File("testfile.txt").reader().readLines()
//    lines.forEach { println(it) }
    // In Java, equivalent to:
    // new InputStreamReader(new FileInputStreamReader(new File("testfile.txt")), "UTF-8")

//    val reader = File("testfile.txt").reader()    // Caller need to close this reader
//    val lines = reader.readText()
//    println(lines)
//    reader.close()

    // One general rule of thumb:
    // Functions with "use" in the name will generally close the resource for you
//    val lines = File("testfile.txt").bufferedReader().use { it.readText() }
//    println(lines)

    // File.readText() has a limit of 2GB file size
    // but it closes the resource for you
//    val lines = File("testfile.txt").readText()
//    println(lines)

    // Closes reader/resource for you
    // Under the hood (in the declaration), it uses "useLines()" seen below
    File("testfile.txt").reader().forEachLine { println(it) }

    // useLines() is more verbose, forEachLine() is preferred
//    File("testfile.txt").reader().useLines { println(it) } // returns a Sequence
    File("testfile.txt").reader().useLines { it.forEach { println(it) } }

}