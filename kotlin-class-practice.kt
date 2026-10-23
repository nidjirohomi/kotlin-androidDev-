// -----------------------------------------------------------------------------
// Task 1 — Sensor with primary constructor
// -----------------------------------------------------------------------------
class Sensor(val id: String, var reading: Double) {
    init {
        require(id.isNotBlank()) { "Sensor ID cannot be blank." }
        require(reading.isFinite()) { "Reading must be a finite number." }
    }

    fun update(reading: Double) {
        require(reading.isFinite()) { "Updated reading must be a finite number." }
        this.reading = reading
    }

    override fun toString(): String = "Sensor(id=$id, reading=$reading)"
}

fun task1() {
    val s1 = Sensor("S-101", 23.5)
    val s2 = Sensor("S-102", 18.0)

    s1.update(25.1)

    println(s1)
    println(s2)

    // Edge case check (uncomment to test validation):
    // val invalid = Sensor("", 10.0) // Throws IllegalArgumentException
}

// -----------------------------------------------------------------------------
// Task 2 — Encapsulated counter
// -----------------------------------------------------------------------------
class Counter(start: Int = 0) {
    private var value: Int = start

    fun value(): Int = value

    fun inc(step: Int = 1) {
        require(step > 0) { "Step must be strictly positive (> 0)." }
        value += step
    }

    fun reset() {
        value = 0
    }
}

fun task2() {
    val defaultCounter = Counter()
    val customCounter = Counter(10)

    customCounter.inc(2)
    println("Default counter value: ${defaultCounter.value()}")
    println("Custom counter value after inc(2): ${customCounter.value()}")
}

// -----------------------------------------------------------------------------
// Task 3 — Vehicle hierarchy (open / override)
// -----------------------------------------------------------------------------
open class Vehicle(val brand: String) {
    init {
        require(brand.isNotBlank()) { "Brand cannot be blank." }
    }

    open fun info(): String = "Vehicle brand: $brand"
    open fun maxSpeedKmh(): Int = 120
}

class Car(brand: String, val doors: Int) : Vehicle(brand) {
    init {
        require(doors >= 2) { "Car must have at least 2 doors." }
    }

    override fun info(): String = "Car $brand, doors=$doors"
    override fun maxSpeedKmh(): Int = 200
}

class Bike(brand: String, val gears: Int) : Vehicle(brand) {
    init {
        require(gears >= 1) { "Bike must have at least 1 gear." }
    }

    override fun info(): String = "Bike $brand, gears=$gears"
    override fun maxSpeedKmh(): Int = 45
}

fun task3() {
    val car = Car("Volvo", 4)
    val bike = Bike("Trek", 18)

    println("${car.info()} \vert{} Max Speed:${car.maxSpeedKmh()} km/h")
    println("${bike.info()} \vert{} Max Speed:${bike.maxSpeedKmh()} km/h")
}

// -----------------------------------------------------------------------------
// Task 4 — Payroll with super (employee family)
// -----------------------------------------------------------------------------
open class Employee(val name: String, val baseSalary: Int) {
    init {
        require(name.isNotBlank()) { "Employee name cannot be blank." }
        require(baseSalary >= 0) { "Base salary cannot be negative." }
    }

    open fun pay(): Int = baseSalary
    open fun describe(): String = "$name:${pay()}"
}

class Accountant(name: String, baseSalary: Int, val bonusPercent: Int) : Employee(name, baseSalary) {
    init {
        require(bonusPercent in 0..100) { "Bonus percent must be in 0..100." }
    }

    override fun pay(): Int = super.pay() + (super.pay() * bonusPercent / 100)
    override fun describe(): String = "Accountant ${super.describe()}"
}

class Intern(name: String, baseSalary: Int, val mentor: String) : Employee(name, baseSalary) {
    init {
        require(mentor.isNotBlank()) { "Mentor name cannot be blank." }
    }

    override fun pay(): Int = super.pay() / 2
    override fun describe(): String = "Intern ${super.describe()} (Mentor:$mentor)"
}

fun task4() {
    val staff: List<Employee> = listOf(
        Employee("Alice", 3000),
        Accountant("Bob", 4000, 15),
        Intern("Charlie", 2000, "Alice")
    )

    var totalPay = 0
    for (e in staff) {
        println(e.describe())
        totalPay += e.pay()
    }
    println("Total payroll: $totalPay")
}

// -----------------------------------------------------------------------------
// Task 5 — Polymorphic shipping costs
// -----------------------------------------------------------------------------
open class Parcel(val id: String, val weightKg: Double) {
    init {
        require(id.isNotBlank()) { "Parcel ID cannot be blank." }
        require(weightKg > 0.0) { "Weight must be positive." }
    }

    open fun shippingCost(): Double = weightKg * 2.0
}

class ExpressParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double = super.shippingCost() + 15.0
}

class EconomyParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double = super.shippingCost() * 0.8
}

fun totalShipping(parcels: List<Parcel>): Double {
    var total = 0.0
    for (p in parcels) {
        total += p.shippingCost()
    }
    return total
}

fun task5() {
    val parcels: List<Parcel> = listOf(
        Parcel("P1", 5.0),         // 10.0
        ExpressParcel("P2", 5.0),  // 10.0 + 15.0 = 25.0
        EconomyParcel("P3", 5.0)   // 10.0 * 0.8 = 8.0
    )

    val total = totalShipping(parcels)
    println("Total shipping cost: $total") // 43.0
}

// -----------------------------------------------------------------------------
// Task 6 — Upcast catalogue
// -----------------------------------------------------------------------------
fun printFleet(fleet: List<Vehicle>) {
    for (v in fleet) {
        println(v.info())
    }
}

fun task6() {
    // 1 & 2. Explicit upcast to base type Vehicle
    val v: Vehicle = Car("Volvo", 4)
    println("Calling v.info() on upcasted reference: ${v.info()}")

    // 3. Print fleet
    val fleet: List<Vehicle> = listOf(
        Car("Volvo", 4),
        Bike("Trek", 18)
    )

    println("\nFleet list:")
    printFleet(fleet)
}

// -----------------------------------------------------------------------------
// Task 7 — Smart cast and safe downcast
// -----------------------------------------------------------------------------
fun doorsOrZero(v: Vehicle): Int {
    // Smart cast: Kotlin automatically casts `v` to Car inside the `if` block
    return if (v is Car) {
        v.doors
    } else {
        0
    }
}

fun task7() {
    val car: Vehicle = Car("Audi", 4)
    val bike: Vehicle = Bike("Giant", 21)

    println("Car doors: ${doorsOrZero(car)}")
    println("Bike doors: ${doorsOrZero(bike)}")

    // Safe downcast demo: returns null if cast fails
    val c = (bike as? Car)
    println("Safe cast (Bike as? Car): $c") // prints null

    // Explicit unsafe cast (would throw ClassCastException):
    // val unsafeCar = bike as Car // Commented out to prevent crash
}

// -----------------------------------------------------------------------------
// Task 8 — Graded assessment hierarchy
// -----------------------------------------------------------------------------
open class Assessment(val title: String, val maxPoints: Int) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank." }
        require(maxPoints > 0) { "maxPoints must be > 0." }
    }

    open fun scoreTowardGrade(raw: Int): Double {
        val clamped = raw.coerceIn(0, maxPoints)
        return clamped.toDouble() / maxPoints
    }
}

class Quiz(title: String, maxPoints: Int, val penaltyIfLate: Double) : Assessment(title, maxPoints) {
    init {
        require(penaltyIfLate in 0.0..0.5) { "Penalty must be between 0.0 and 0.5." }
    }

    override fun scoreTowardGrade(raw: Int): Double {
        // Reuse base ratio, then apply late penalty factor
        return super.scoreTowardGrade(raw) * (1.0 - penaltyIfLate)
    }
}

class Project(title: String, maxPoints: Int, val bonusCap: Double) : Assessment(title, maxPoints) {
    init {
        require(bonusCap >= 0.0) { "Bonus cap must be non-negative." }
    }

    override fun scoreTowardGrade(raw: Int): Double {
        // Calls super.scoreTowardGrade for the base portion up to maxPoints,
        // then adds extra ratio if raw points exceeded maxPoints.
        val baseScore = super.scoreTowardGrade(raw)
        val extraPoints = (raw - maxPoints).coerceIn(0, (maxPoints * bonusCap).roundToInt())
        val bonusRatio = extraPoints.toDouble() / maxPoints

        return baseScore + bonusRatio
    }
}

fun task8() {
    val assessments: List<Assessment> = listOf(
        Quiz("Kotlin Quiz 1", 20, 0.1),       // raw 18 -> ratio 0.9 * 0.9 = 0.81
        Project("Coursework", 100, 0.2)       // raw 115 -> base 1.0 + bonus 0.15 = 1.15
    )

    for (a in assessments) {
        val rawScore = if (a is Quiz) 18 else 115
        println("${a.title}: raw $rawScore -> score =${a.scoreTowardGrade(rawScore)}")
    }
}

// -----------------------------------------------------------------------------
// Task 9 — Notification channels (polymorphism + visibility)
// -----------------------------------------------------------------------------
open class Notification(private val payload: String) {
    init {
        require(payload.isNotBlank()) { "Payload cannot be blank." }
    }

    // Accessible to subclasses, but invisible to outsiders
    protected fun body(): String = payload

    open fun render(): String = body()
}

class EmailNotification(payload: String, val to: String) : Notification(payload) {
    override fun render(): String = "Email to [$to]:${body()}"
}

class SmsNotification(payload: String, val phone: String) : Notification(payload) {
    override fun render(): String = "SMS to [$phone]:${body()}"
}

fun sendAll(items: List<Notification>) {
    for (item in items) {
        println(item.render())
    }
}

fun task9() {
    val notifications: List<Notification> = listOf(
        EmailNotification("Your invoice is ready", "user@example.com"),
        SmsNotification("Your OTP is 4821", "+123456789")
    )

    sendAll(notifications)
    // val p = notifications[0].payload // Error: payload is private
}

// -----------------------------------------------------------------------------
// Task 10 — Zoo ticketing (combine hierarchy + casts)
// -----------------------------------------------------------------------------
open class Ticket(val code: String, val basePrice: Int) {
    init {
        require(code.isNotBlank()) { "Code cannot be blank." }
        require(basePrice >= 0) { "Price cannot be negative." }
    }

    open fun price(): Int = basePrice
}

class AdultTicket(code: String, basePrice: Int) : Ticket(code, basePrice)

class ChildTicket(code: String, basePrice: Int, val guardianCode: String) : Ticket(code, basePrice) {
    init {
        require(guardianCode.isNotBlank()) { "Guardian code required." }
    }

    override fun price(): Int = super.price() / 2
}

class VipTicket(code: String, basePrice: Int, val loungeAccess: Boolean) : Ticket(code, basePrice) {
    override fun price(): Int = super.price() + if (loungeAccess) 50 else 20
}

fun checkout(tickets: List<Ticket>): Int {
    var total = 0
    for (t in tickets) {
        total += t.price()
    }
    return total
}

fun childGuardianCodes(tickets: List<Ticket>): List<String> {
    val result = mutableListOf<String>()
    for (t in tickets) {
        // Explicit `is` check + Smart Cast
        if (t is ChildTicket) {
            result.add(t.guardianCode)
        }
    }
    return result
}

fun task10() {
    val tickets: List<Ticket> = listOf(
        AdultTicket("A-1", 100),               // price: 100
        ChildTicket("C-1", 100, "G-1"),         // price: 50
        ChildTicket("C-2", 100, "G-9"),         // price: 50
        VipTicket("V-1", 100, loungeAccess = true) // price: 150
    )

    println("total = ${checkout(tickets)}")
    println("guardians = ${childGuardianCodes(tickets).joinToString(", ")}")
}