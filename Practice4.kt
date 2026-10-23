package Practice04

// Task 1

fun task1() {
    val nums = listOf(4, 8, 15, 16, 23)

    println("first = ${nums[0]}")
    println("last = ${nums[nums.size - 1]}")
    println("size = ${nums.size}")
}

// Task 2
fun task2() {
    val items = mutableListOf("milk", "bread")

    print("Enter one more item: ")
    val newItem = readln()
    items.add(newItem)

    // Изменяем элемент с индексом 0
    items[0] = "oat milk"

    println("List: $items")
    println("Size: ${items.size}")
}

// Task 3
fun task3() {
    print("Enter n: ")
    val n = readln().toInt()

    repeat(n) {
        print("*")
    }
    println() // Новая строка после окончания цикла
}

// Task 4
fun task4() {
    print("Enter n: ")
    var n = readln().toInt()

    while (n > 0) {
        println(n)
        n--
    }
    println("Go!")
}

// Task 5
fun task5() {
    val xs = listOf(2, 1, 7, 4)

    // Version A: Итерация по элементам
    var sumA = 0
    for (x in xs) {
        sumA += x
    }

    // Version B: Итерация по индексам
    var sumB = 0
    for (i in 0 until xs.size) {
        sumB += xs[i]
    }

    println("Sum A = $sumA")
    println("Sum B = $sumB")
}

// Task 6
fun task6() {
    // 1. Диапазон 1..5
    for (i in 1..5) {
        print("$i ")
    }
    println()

    // 2. Обратный отсчет с downTo
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()

    // 3. Диапазон до (не включая) с until
    for (i in 0 until 3) {
        print("$i ")
    }
    println()

    // 4. Итерация с шагом step
    for (i in 1..9 step 2) {
        print("$i ")
    }
    println()
}

// Task 7
fun task7() {
    print("Enter age: ")
    val age = readln().toInt()

    if (age in 13..19) {
        println("Teen")
    } else {
        println("Not a teen")
    }
}

// Task 8
fun task8() {
    var choice: String
    do {
        println("1) Hello  2) Quit")
        print("Choice: ")
        choice = readln()

        when (choice) {
            "1" -> println("Hello!")
            "2" -> {} // Ничего не делаем, цикл завершится
            else -> println("Unknown")
        }
    } while (choice != "2")
}

// Task 9
fun task9() {
    print("Enter numbers: ")
    val input = readln()

    // Разбиваем строку по пробелу, фильтруем пустые части (если было несколько пробелов подряд)
    val parts = input.split(" ").filter { it.isNotBlank() }

    var sum = 0
    for (part in parts) {
        sum += part.toInt()
    }

    println("Sum = $sum")
}

// Challenge (optional)
fun challenge() {
    print("Enter comma-separated names: ")
    val input = readln()

    val names = input.split(",")

    for (i in names.indices) {
        // trim() убирает лишние пробелы по краям каждого имени
        println("$i: ${names[i].trim()}")
    }
}