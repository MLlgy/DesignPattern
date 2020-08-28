package m_iterator

/**
 * 迭代器接口
 *
 * 定义访问和遍历元素的操作
 */
interface Iterator{
    fun first()
    fun next()
    fun isDone():Boolean
    fun currentItem():Any
}

/**
 * 聚合对象接口
 *
 * 定义创建相应迭代器的方法
 */
abstract class Aggregate{
    abstract fun createIterator():Iterator
}


/**
 * 具体的聚合对象
 *
 * 针对不同数据类型实现相应迭代器的功能，此处以数组示意
 */
class ConcreteAggregate(var array: Array<String>?): Aggregate(){




    override fun createIterator(): Iterator = ConcreteIterator(this)

}


/**
 * 具体的迭代器对象
 *
 * 不同聚合对象相应的迭代器实现是不一样的
 *
 * 每一个具体的迭代器对象对应一个具体的聚合对象
 *
 * ConcreteIterator 对应 ConcreteAggregate，所以传入的为 ConcreteAggregate
 */
class ConcreteIterator(val aggregate: ConcreteAggregate) : Iterator{
    private var index = -1
    override fun first() {
        index = 0
    }

    override fun next() {
        /*if(index <= this.aggregate.){

        }
*/

    }

    override fun isDone(): Boolean {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun currentItem(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

