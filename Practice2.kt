fun main(){
    print("Enter n:")
    val n = readln().toInt()
    val triple = n * 3
    val square = n * n

    println("triple = $triple")
    println("square = $square")

    print("Enter a: ")
    val a = readln().toInt()
    print("Enter b: ")
    val b = readln().toInt()

    val quotient = a / b
    val remainder = a % b
    val exact = a.toDouble() / b

    println("quotient = $quotient")
    println("remainder = $remainder")
    println("exact = $exact")

    print("Enter seconds: ")
    val totalSeconds = readln().toInt()
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60

    println("H:M:S -> $hours: $minutes:$seconds")





    



    var score = 0
    print("Enter score: ")
    score += readln().toInt()
    print("Enter score: ")
    score += readln().toInt()
    
    print("Enter score: ")
    score += readln().toInt()

    println("final result: $score")





    print("Enter celsius: ")

    
    val c = readln().toDouble()
    val f = c * 9.0 / 5.0 + 32.0
    
    println("C = $c")
    println("F = $f")
    println("Below freezing: ${f < 32.0}")




    val basePopulation: Long = 8_100_000_000L

    print("Enter extra population: ")
    val extra = readln().toInt()

    val total = basePopulation + extra.toLong()

    println("base population: $basePopulation")
    println("extra population: $extra")
    println("total population: $total")





    val small: Byte = 100
    val medium: Short = 20_000

    val sum = small + medium
    println("Sum: $sum (Type: Int)")
}
