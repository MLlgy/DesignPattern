package e_factory_method

// 工厂方法所创建的对象的接口
interface Product{
    fun doSomething()
}

class ConcreteProduct:Product{
    override fun doSomething() {
        println("具体实现类 -- ConcreteProduct")
    }
}

class ConcreteProduct2:Product{
    override fun doSomething() {
        println("具体实现类 -- ConcreteProduct2")
    }
}


abstract class Creator{
    // 创建 Product 的工厂方法
    abstract fun factoryMethod(): Product

    fun  operation(){
        val product = factoryMethod()
        product.doSomething()
    }
}

class ConcreteCreator:Creator(){
    override fun factoryMethod() = ConcreteProduct()
}

class ConcreteCreator2:Creator(){
    override fun factoryMethod() = ConcreteProduct2()
}

fun main() {
    val concreteProduct = ConcreteCreator().factoryMethod()
    concreteProduct.doSomething()

    val concreteProduct2 = ConcreteCreator2().factoryMethod()
    concreteProduct2.doSomething()
}