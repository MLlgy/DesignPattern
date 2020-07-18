package A_Simple_Factory

interface Animal{
    fun eat():String
}

class Dog:Animal{
    override fun eat() = "I eat bone"
}

class Bird : Animal{
    override fun eat()= "I eat flower"
}
