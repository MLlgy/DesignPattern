package k_observer

import java.util.*
import java.util.Observer


/**
 * 目标对象
 */
class NewsPaper : Observable() {
    var content: String? = null
        set(value) {
            field = value
            // Java API 实现观察者模式，需要做如下调用
            setChanged()
            // 主动通知，推模型
            notifyObservers(this.content)
            // 拉的方式，采用这种调用方式
//            notifyObservers()
        }
}

/**
 * 观察者对象
 */
class Reader(private val name:String) : Observer {

    override fun update(o: Observable?, arg: Any?) {
        // 使用推模型 notifyObservers(this.content)
        println("$name 收到报纸了，目标推过来的内容是 == ：$arg")
        // 使用拉模型，对应更新调用方式：notifyObservers()
//        println("$name  收到报纸了，主动拉取目标对象的内容，具体的内容为 == ${(o as NewsPaper).content}")
    }
}


fun main() {
    // 目标对象
    val newsPaper = NewsPaper()

    // 观察者对象
    val reader = Reader("小李")
    val reader2 = Reader("小赵")
    val reader3 = Reader("小王")

    // 产生订阅关系
    newsPaper.addObserver(reader)
    newsPaper.addObserver(reader2)
    newsPaper.addObserver(reader3)

    // 更新内容
    newsPaper.content = "本期报纸的内容为：中美贸易战，中国大获全胜！！！"

}