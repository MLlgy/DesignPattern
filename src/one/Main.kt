package one

interface Animal{
    fun eat():String
}

class Dog:Animal{
    override fun eat() = "I eat bone"
}

class Bird : Animal{
    override fun eat()= "I eat flower"
}


fun main(args: Array<String>) {
    val dog = Dog()
    val bird = Bird()
    println("dog.eat() = ${dog.eat()}")
    println("bird.eat() = ${bird.eat()}")
}

