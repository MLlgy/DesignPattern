package a_simple_factory

class Factory {
    companion object {
        fun createAnimal(type: Int): Animal? = when (type) {
            1 -> Dog()
            2 -> Bird()
            else -> null
        }
    }
}

fun main(args: Array<String>) {
    val dog by lazy {
        Factory.createAnimal(1)
    }
    val bird: Animal? = Factory.createAnimal(2)
    println("dog eat: ${dog?.eat()}")
    println("bird eat: ${bird?.eat()}")
}