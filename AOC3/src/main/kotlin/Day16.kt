private var programsChar = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p')

fun main() {

    print("Enter input: ")
    val stringInput = readLine() ?: ""

    val orders = stringInput.split(",")
    var i = 1

    val iterations = 1_000_000_000

    val copyingProgChar = programsChar.toList()

    while (i <= iterations) {
        orders.forEach { order ->
            when (order[0]) {
                's' -> spinDanceMove(order.drop(1).toInt())
                'x' -> {
                    val (firstPosition, secondPosition) = order.drop(1).split("/").map { it.toInt() }
                    exchangeDanceMove(firstPosition, secondPosition)
                }
                'p' -> partnerDanceMove(order[1], order[3])
                else -> println("This $order is not known.")
            }
        }
        // iterating one time and making the final string for the part 1
        if (i == 1) { 
            val stringFromPrograms = programsChar.joinToString("")
            println("First Part's result- $stringFromPrograms")
        }

        // checking the orignal programs with the current programs
        if (programsChar == copyingProgChar) {
            val iterationFactor = iterations / i
            i = i.times(iterationFactor)
        }
        i++
    }
    
    // iterated the program for one billion times to get solution for the part 2
    val programsString = programsChar.joinToString("")
    println("Second Part's result- $programsString")
}

// moving programs from end to front
fun spinDanceMove(positionNumber: Int) {

    val finalSlicedPart = programsChar.takeLast(positionNumber)
    val startingSlicedPart = programsChar.take(programsChar.size - positionNumber)
    programsChar = (finalSlicedPart + startingSlicedPart).toMutableList()
}

// swaping two programs at positions 
fun exchangeDanceMove(firstPosition: Int, secondPosition: Int) {
    val tempVariable = programsChar[firstPosition]
    programsChar[firstPosition] = programsChar[secondPosition]
    programsChar[secondPosition] = tempVariable
}

// swaping two programs as characters
fun partnerDanceMove(firstProgChar: Char, SecondProgChar: Char) {
    val firstPosition = programsChar.indexOf(firstProgChar)
    val secondPosition = programsChar.indexOf(SecondProgChar)
    exchangeDanceMove(firstPosition, secondPosition)
}
