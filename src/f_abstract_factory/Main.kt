package f_abstract_factory

abstract class AbstractCpu {
    abstract fun doCpuWork()
}

abstract class AbstractBrand {
    abstract fun brandAction()
}

class CPUWith12Pin : AbstractCpu() {
    override fun doCpuWork() {
        println("CPU：我的插针数为：12")
    }
}

class CPUWith24Pin : AbstractCpu() {
    override fun doCpuWork() {
        println("CPU：我的插针数为：24")
    }
}

class BrandWith12Pin : AbstractBrand() {
    override fun brandAction() {
        println("Brand：我的插针数为：12")
    }
}

class BrandWith24Pin : AbstractBrand() {
    override fun brandAction() {
        println("Brand：我的插针数为：24")
    }
}

interface AbstractProductFactory {
    fun createCpu(): AbstractCpu
    fun createBrand(): AbstractBrand
}


class ProductWith12PinFactory:AbstractProductFactory{
    override fun createCpu(): AbstractCpu  = CPUWith12Pin()

    override fun createBrand(): AbstractBrand = BrandWith12Pin()
}

class ProductWith24PinFactory:AbstractProductFactory{
    override fun createCpu(): AbstractCpu  = CPUWith24Pin()

    override fun createBrand(): AbstractBrand = BrandWith24Pin()
}


fun main() {
    val factoryWith12Pin = ProductWith12PinFactory()
    println("---开始生产 12 个引脚的电脑---")
    factoryWith12Pin.createCpu().doCpuWork()
    factoryWith12Pin.createBrand().brandAction()

    val factoryWith24Pin = ProductWith24PinFactory()
    println("---开始生产 24 个引脚的电脑---")
    factoryWith24Pin.createCpu().doCpuWork()
    factoryWith24Pin.createBrand().brandAction()
}

