package i_mediator

/**
 * 中介者模式的标准实现
 */

interface Mediator{
    // 持有同事类，中介者对象可以凭此获取同事类的状态
    fun notifyColleague(colleague: Colleague)
}

/**
 * 同事类的抽象类
 */
abstract class Colleague(val mediator: Mediator){
//    private var mediatorObject:Mediator? = null
//    init {
//        mediatorObject = mediator
//    }

//    fun getMediator():Mediator = mediator

}

class ConcreteColleagueA(mediator: Mediator) :Colleague(mediator){

    fun someOperation(){
        // 需要跟其他同事通信时，通知中介者对象
        mediator.notifyColleague(this)
    }
}

class ConcreteColleagueB(mediator: Mediator) :Colleague(mediator){

    fun someOperation(){
        // 需要跟其他同事通信时，通知中介者对象
        mediator.notifyColleague(this)
    }
}

/**
 * 具体的中介者实现
 */
class ConcreteMediator:Mediator{
    private lateinit var colleagueA:ConcreteColleagueA
    private lateinit var colleagueB:ConcreteColleagueB

    override fun notifyColleague(colleague: Colleague) {
        // 当某个同事类发生变化，通常需要与其他同事交互，具体协调相应的同事类来实现协作行为
    }
}