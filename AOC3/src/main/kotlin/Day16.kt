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
                's' -> spinDanceMove(Integer.parseInt(order.slice(1 until order.length)))
                'x' -> {
                    val orderExchangeKey = order.split("/")
                    val firstPosition =
                        Integer.parseInt(orderExchangeKey[0].slice(1 until orderExchangeKey[0].length))
                    val secondPosition = Integer.parseInt(orderExchangeKey[1])
                    exchangeDanceMove(firstPosition, secondPosition)
                }
                'p' -> partnerDanceMove(order[1], order[3])
                else -> println("This $order is not known.")
            }
        }
        if (i == 1) {
            val stringFromPrograms = programsChar.joinToString("")
            println("First Part's result- $stringFromPrograms")
        }
        if (programsChar == copyingProgChar) {
            val iterationFactor = iterations / i
            i = i * iterationFactor
        }
        i++
    }
    val programsString = programsChar.joinToString("")
    println("Second Part's result- $programsString")
}

fun spinDanceMove(positionNumber: Int) {

    programsChar = ((programsChar.slice((programsChar.size - positionNumber) until programsChar.size))
            +
            (programsChar.slice(0 until (programsChar.size - positionNumber)))).toMutableList()
}

fun exchangeDanceMove(firstPosition: Int, secondPosition: Int) {
    val tempVariable = programsChar[firstPosition]
    programsChar[firstPosition] = programsChar[secondPosition]
    programsChar[secondPosition] = tempVariable
}

fun partnerDanceMove(firstProgChar: Char, SecondProgChar: Char) {
    val firstPosition = programsChar.indexOf(firstProgChar)
    val secondPosition = programsChar.indexOf(SecondProgChar)
    exchangeDanceMove(firstPosition, secondPosition)
}
