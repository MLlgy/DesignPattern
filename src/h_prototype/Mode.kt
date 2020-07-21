package h_prototype

/**
 * 原型模式的结构化示例
 */

interface Prototype{
    fun clone():Prototype
}

/**
 * 方便展示，两个具体类都没有声明属性
 */
class ConcretePrototype:Prototype{
    override fun clone(): Prototype  = ConcretePrototype()
}

class ConcretePrototype2:Prototype{
    override fun clone(): Prototype  = ConcretePrototype2()
}

class Client(val prototype: Prototype){


    fun operation(){
        val concretePrototype = prototype.clone()
    }

}

fun main() {

}