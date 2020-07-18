package B_Facade



fun main() {
    val wheelMaker = WheelMaker()
    val carriageMaker = CarriageMaker()
    val glassesMaker = GlassesMaker()
    val carMaker = CarMaker()
    println(wheelMaker.make())
    println(carriageMaker.make())
    println(glassesMaker.make())
    println(carMaker.make())
}