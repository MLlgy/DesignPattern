package b_facade

// 使用简单工厂模式
class MakerFactory {
    companion object {
        fun make(type: Int): Maker = when (type) {
            1 -> WheelMaker()
            2 -> CarriageMaker()
            3 -> GlassesMaker()
            else -> CarMaker()
        }
    }
}

class Facade {
    fun makeCar() {
        println(MakerFactory.make(1).make())
        println(MakerFactory.make(2).make())
        println(MakerFactory.make(3).make())
        println(MakerFactory.make(4).make())
    }
}

fun main(args: Array<String>) {
    val facade = Facade()
    facade.makeCar()
}