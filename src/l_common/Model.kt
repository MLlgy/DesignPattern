package l_common

/**
 * 定义命令的接口，声明执行的方法
 */
interface Command{
    fun execute()
}

/**
 * 具体的命令实现者
 */
class ConcreteCommand(private val receiver: Receiver):Command{
    override fun execute() {
        receiver.action()
    }
}

/**
 * 接收者对象
 */
class Receiver{
    fun action(){
        print("接收者对象执行动作。。。")
    }
}

/**
 * 调用者
 */
class Invoker{
    var command:Command? = null

    fun runCommand(){
        command?.execute()
    }
}

/**
 * 装配过程：负责创建命令对象，并设定它的接收者
 */
fun assemble(){
    val receiver = Receiver()
    val command = ConcreteCommand(receiver)
    val invoker = Invoker()
    // 把命令对象放入 Invoker 中
    invoker.command = command
    invoker.runCommand()
}


fun main() {
    assemble()

}





