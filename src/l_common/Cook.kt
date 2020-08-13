package l_common

// 一个点菜的过程

/**
 * 厨师接口
 */
interface CookApi {
    fun cooke(name: String)
}

// 具体接收者
class HotCooke : CookApi {
    override fun cooke(name: String) {
        println("我是热菜师傅，正在做的菜为：$name")
    }
}

class CoolCooke : CookApi {
    override fun cooke(name: String) {
        println("我是凉菜师傅，正在做的菜为：$name")
    }
}

/**
 * 声明命令接口，声明执行的操作
 */
interface CookCommand {
    fun execute()
}

/**
 * 命令对象
 */
class ChopCommand : CookCommand {
    var cookApi: CookApi? = null
    override fun execute() {
        cookApi?.cooke("绿豆排骨")
    }
}

class CowCommand() : CookCommand {
    var cookApi: CookApi? = null
    override fun execute() {
        cookApi?.cooke("西红柿牛腩")
    }
}

class GuaCommand() : CookCommand {
    var cookApi: CookApi? = null
    override fun execute() {
        cookApi?.cooke("拍黄瓜")
    }
}

class MenuCommand : CookCommand {
    private val commandList = ArrayList<CookCommand>()

    fun addCommand(command: CookCommand) {
        commandList.add(command)
    }

    override fun execute() {
        commandList.forEach { it.execute() }
    }
}


/**
 * 服务员，相当于 Invoke 角色，负责组装每个菜和具体的实现者，
 * 同时还负责调度，相当于标准 Command 模式的 Client + Invoker
 */
class Waiter{
    private val menuCommand = MenuCommand()
    fun orderDish(command: CookCommand){
        val hotCooke = HotCooke()
        val coolCooke = CoolCooke()
        when(command){
            is ChopCommand -> command.cookApi = hotCooke
            is GuaCommand -> command.cookApi = coolCooke
            is CowCommand -> command.cookApi = hotCooke
        }
        menuCommand.addCommand(command)
    }

    fun  orderOver(){
        menuCommand.execute()
    }
}

fun main() {

    val waiter = Waiter()

    val chop = ChopCommand()
    val cow = CowCommand()
    val gua = GuaCommand()

    waiter.orderDish(chop)
    waiter.orderDish(cow)
    waiter.orderDish(gua)

    waiter.orderOver()

}