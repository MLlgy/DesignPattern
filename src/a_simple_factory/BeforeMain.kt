package a_simple_factory


fun main(args: Array<String>) {
    val dog = Dog()
    val bird = Bird()
    println("dog.eat() = ${dog.eat()}")
    println("bird.eat() = ${bird.eat()}")
}

