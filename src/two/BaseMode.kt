package two

interface Maker {
    fun make(): String
}

class WheelMaker : Maker {
    override fun make(): String = "1. 制造车轮"
}

class CarriageMaker : Maker {
    override fun make() = "2. 制造车架"
}

class GlassesMaker : Maker {
    override fun make() = "3. 制造车玻璃"
}

class CarMaker : Maker {
    override fun make() = "4. 组装车"
}