package k_observer

/**
 * 目标对象
 */
open class Subject {
    private val observers: ArrayList<Observer> = ArrayList()

    /**
     * 注册观察者对象
     */
    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

    /**
     * 通知所有注册的观察者对象
     */
    protected fun notifyObservers() {
        observers.forEach { it.update(this) }
    }
}

/**
 * 具体的目标对象
 *
 * 负责把有关的状态存入到相应的观察者对象，并在自己状态改变时，通知各个观察者
 */
class ConcreteSubject : Subject() {

    /**
     * 目标对象的状态,此处具体为  subjectState 字段，在实际开发中会有各种相应的状态
     */
     var subjectState: String? = null
        set(value) {
            field = value
            // 状态发生改变，通知各个观察者
            notifyObservers()
        }
}


/**
 * 观察者接口，定义一个更新接口，在目标发生改变时通知所有的观察者
 */
interface Observer {
    /**
     * 更新的接口
     *
     * 传入目标对象，方便获取相应的目标对象的状态，同时可以定义 Observer 收到新状态后的逻辑
     */
    fun update(subject: Subject)
}

class ConcreteObserver : Observer {

    private var observerState: String? = null

    override fun update(subject: Subject) {
        observerState = (subject as ConcreteSubject).subjectState
        println(observerState)
    }
}

fun main() {
    //创建一系列观察者
    val observer = ConcreteObserver()
    val observer2 = ConcreteObserver()
    val observer3 = ConcreteObserver()
    val observer4 = ConcreteObserver()

    // 创建一个目标对象
    val subject = ConcreteSubject()

    // 目标对象注册观察者
    subject.attach(observer)
    subject.attach(observer2)
    subject.attach(observer3)
    subject.attach(observer4)

    subject.subjectState = "before"

    println("---更新目标对象状态---")

    subject.subjectState = "after"
}