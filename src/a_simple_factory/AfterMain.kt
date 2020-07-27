package a_simple_factory

class Factory {
    companion object {
        // 这样的话，客户端不需要知道具体的实现是什么，也不知道如何实现的
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