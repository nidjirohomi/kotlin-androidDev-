package practice03
// Task 1
fun task1() {
    print("Enter score: ")
    val score = readln().toInt()

    if (score >= 50) {
        println("Pass")
    } else {
        println("Fail")
    }
}

// Task 2
fun task2() {
    print("Enter temperature (°C): ")
    val temp = readln().toInt()

    if (temp < 0) {
        println("Freezing")
    } else if (temp <= 14) {
        println("Cold")
    } else if (temp <= 24) {
        println("Mild")
    } else {
        println("Warm")
    }
}

// Task 3
fun task3() {
    print("Enter age: ")
    val age = readln().toInt()
    print("Do you have a ticket? (yes/no): ")
    val hasTicket = readln().trim().lowercase() == "yes"

    if (age >= 12 && hasTicket) {
        println("Enter")
    } else if (age < 12) {
        println("Too young")
    } else {
        println("Need a ticket")
    }
}

// Task 4
fun task4() {
    print("Enter age: ")
    val age = readln().toInt()

    if (age < 13 || age > 65) {
        println("Discount")
    } else {
        println("Regular")
    }
}

// Task 5
fun task5() {
    print("Enter a: ")
    val a = readln().toInt()
    print("Enter b: ")
    val b = readln().toInt()

    val max = if (a > b) a else b

    println("max = $max")
}

// Task 6
fun task6() {
    print("Enter score: ")
    val score = readln().toInt()

    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }

    println("Grade: $grade")
}

// Task 7
fun task7() {
    print("Enter integer n: ")
    val n = readln().toInt()

    val label = when {
        n < 0 -> "negative"
        n == 0 -> "zero"
        n % 2 == 0 -> "positive even"
        else -> "positive odd"
    }

    println(label)
}

// Challenge
fun challenge() {
    print("Enter three numbers space-separated or one by one:\n")
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    val min = if (a <= b && a <= c) a else if (b <= a && b <= c) b else c
    val max = if (a >= b && a >= c) a else if (b >= a && b >= c) b else c
    val mid = (a + b + c) - min - max

    println("$min $mid $max")
}





