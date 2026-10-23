class Player(var name: String, var score: Int, var health: Int) {
    fun rename(name: String) {
        this.name = name

    }
    fun rescore(score: Int){
        this.score = score
    }
    fun takeDamage(damage: Int) {
        this.health -= damage
    }
    fun healHealth(plus: Int) {
        this.health += plus
    }
    fun armour(armours: Int) {
        takeDamage(armours)
        if (health < 0){
            health = 0
        }
    }
    fun chakra(chakraScore: Int){
        if (chakraScore < 0) {
            return
        }



    }


    fun main(){
        val player1 = Player("Alex",  100, 200, 50)

        println("Имя: ${player1.name}, Очки: ${player1.score}, HP: ${player1.health}}")
        player1.takeDamage(100)
        player1.rename("Bob")
        player1.rescore(300)
        player1.takeDamage(50)
        player1.healHealth(100)
        player1.armour(300)
        player1.chakra(300)

        println("Новое имя: ${player1.name}, Новое очко: ${player1.score}, hp: ${player1.health}")
    }


    class Anim(
        val kg: Int,
        val age: Int,
        val name: String,
    ) {


    fun main() {

        val myPet = Anim(
            name = "mol",
            age = 8,
            kg = 10,
        )
        myPet.myanim()
        }