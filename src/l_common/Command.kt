package l_common


/**
 * 主板接口：接收者接口,
 *
 * 定义接收者需要完成的动作
 *
 */
interface MainBoardApi {
    fun open()
    fun reset()
}

class GigaMainBoard : MainBoardApi {
    override fun open() {
        println("技嘉主板现在正在开机，请稍后")
        println("接通电源。。。")
        println("设备检查。。。")
        println("装载系统。。。")
        println("机器正常运转。。。")
        println("机器已经打开，请操作。。。")
    }

    override fun reset() {
        println("技嘉主板正在重启，请稍等。。。")
        println("机器重启成功，请操作。。。")
    }
}

class SansungMainBoard : MainBoardApi {
    override fun open() {
        println("三星主板现在正在开机，请稍后")
        println("接通电源。。。")
        println("设备检查。。。")
        println("装载系统。。。")
        println("机器正常运转。。。")
        println("机器已经打开，请操作。。。")
    }

    override fun reset() {
        println("三星主板正在重启，请稍等。。。")
        println("机器重启成功，请操作。。。")
    }
}

/**
 * 命令接口，声明执行的动作
 */
interface ComCommand {
    fun execute()
}

/**
 * 开机命令的实现，持有开机命令的真正实现，通过调用接收者的方法来实现命令
 */
class OpenCommon(private val mainBoardApi: MainBoardApi) : ComCommand {
    override fun execute() {
        mainBoardApi.open()
    }

}

/**
 * 重启命令的实现
 *
 * 最终调用接收者的方法来实现
 */
class ResetComCommand(private val mainBoardApi: MainBoardApi):ComCommand{
    override fun execute() {
        mainBoardApi.reset()
    }
}

/**
 * 这样调用完全是没问题的，但是不符合命令模式的预期
 *
 * 命令模式，很明显关注的是命令，用户只需要发出相应的命令，而不关心命令执行的情况，即客户端不需要知道具体的主板是什么，
 * 那么基于此就需要在主板和客户端建立一个中间对象，客户端发出的命令交给这个中间对象（OpenCommon），由这个中间对象去找真正的执行者--主板，完成具体的工作。
 */
/*fun main() {
    val gigaMainBoard = GigaMainBoard()
    val openCommon = OpenCommon(gigaMainBoard)
    openCommon.execute()
}*/

/**
 * 机箱对象，本身有按钮，持有按钮对应的命令对象
 *
 * 命令对象的集成者
 */
class Box {
    var openCommon: ComCommand? = null
    var resetCommand: ComCommand? = null
    fun openButtonPressed() {
        openCommon?.execute()
    }

    fun resetButtonPress(){
        resetCommand?.execute()
    }
}

/**
 * 抽象了主板和机箱，命令对象也准备好了，想要完成开机动作，则需要将按钮和主板组装起来，形成一个完成的机器
 */
fun main() {
    // 1. 初始化接收者和命令对象
    val mainBoard = GigaMainBoard()

    val openCommon = OpenCommon(mainBoard)
    val resetCommand = ResetComCommand(mainBoard)

    val box = Box()
    // 2. 为机箱上设置对应的按钮，让按钮知道该干什么
    box.openCommon = openCommon
    box.resetCommand = resetCommand
    // 3. 模拟按下机箱按钮
    box.openButtonPressed()
    println("-----")
    box.resetButtonPress()

}