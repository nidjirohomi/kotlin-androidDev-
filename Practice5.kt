package Practice05
// Task 1

fun task1lab5() {
    val letter: Char = 'K'
    val word: String = "K"

    println("letter: $letter")
    println("word: $word")

    // Char представляет одиночный символ в одинарных кавычках ('K'),
    // а String — это последовательность символов в двойных кавычках ("K").

    println("word[0]: ${word[0]}")
    println("Same character: ${word[0] == letter}")
}

// Task 2
fun task2lab5() {
    print("Enter a line: ")
    val line = readln()

    if (line.isEmpty()) {
        println("Empty input")
    } else {
        println("first = ${line[0]}")
        println("last = ${line[line.length - 1]}")
    }
}

// Task 3
fun task3ab5() {
    print("Enter char: ")
    val line = readln()
    val ch = line[0]

    val classification = when (ch) {
        in '0'..'9' -> "Digit"
        in 'A'..'Z' -> "Uppercase"
        in 'a'..'z' -> "Lowercase"
        else -> "Other"
    }

    println(classification)
}

// Task 4
fun task4lab5() {
    print("Enter digit: ")
    val line = readln()
    val ch = line[0]

    // Вычитаем код символа '0', чтобы получить числовое значение
    val value = ch - '0'

    println("value = $value")
    println("value * 2 = ${value * 2}")
}

// Task 5
fun task5lab5() {
    print("Enter text: ")
    val line = readln()

    var count = 0
    for (ch in line) {
        if (ch.isLetter()) {
            count++
        }
    }

    println("Letters: $count")
}

// Task 6
fun task6lab5() {
    print("Enter text: ")
    val line = readln()

    var result = ""
    for (ch in line) {
        if (ch.isLetter()) {
            result += ch
        }
    }

    println("Result: $result")
}

// Task 7
fun task7lab5() {
    print("Enter char: ")
    val line = readln()
    val ch = line[0]

    println("isDigit: ${ch.isDigit()}")
    println("isLetter: ${ch.isLetter()}")
    println("isWhitespace: ${ch.isWhitespace()}")
    println("lowercaseChar: ${ch.lowercaseChar()}")
    println("uppercaseChar: ${ch.uppercaseChar()}")
}

// Challenge
fun challenge() {
    print("Enter a lowercase letter: ")
    val line = readln()
    val ch = line[0]

    if (ch in 'a'..'z') {
        val shifted = 'a' + (ch - 'a' + 1) % 26
        println("Shifted: $shifted")
    } else {
        println("Unchanged: $ch")
    }    }