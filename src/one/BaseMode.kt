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
