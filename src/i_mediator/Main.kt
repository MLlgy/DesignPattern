package i_mediator

abstract class ColleagueAbstract(mediatorBrand: MediatorBrand) {
}


class CDDrive(private val mediatorBrand: MediatorBrand) : ColleagueAbstract(mediatorBrand) {

    var cdData: String = ""

    /**
     * 业务方法，也是和中介者对象交互的方法
     */
    fun readCD() {
        cdData = "视频数据,声音数据"
        // 通知主板，自己的状态方法改变
        mediatorBrand.changed(this)
    }
}

class CPU(private val mediatorBrand: MediatorBrand) : ColleagueAbstract(mediatorBrand) {

    // 视频数据
     var videoData: String = ""
    // 声音数据
     var soundData: String = ""

    /**
     * 业务方法，也是和中介者对象交互的方法
     * 处理数据，将数据分为音频和视频数据
     */
    fun execteData(data: String) {
        var array: List<String> = data.split(",")
        this.videoData = array[0]
        this.soundData = array[1]
        // 通知主板， CPU 的工作完成
        this.mediatorBrand.changed(this)
    }
}

/**
 * 显卡类，同事类
 */
class VideoCard(private val mediatorBrand: MediatorBrand) : ColleagueAbstract(mediatorBrand) {

    fun showData(data: String) {
        println("您现在观看的是：$data")
    }

}

/**
 * 显卡类，同事类
 */
class SoundCard(mediatorBrand: MediatorBrand) : ColleagueAbstract(mediatorBrand) {

    fun soundData(data: String) {
        println("同步音频：$data")
    }

}

interface MediatorBrand {
    /**
     * 同事对象在自身改变时通知中介者的方法，让中介者负责与其他同事类的交互
     */
    fun changed(colleagueAbstract: ColleagueAbstract)
}

class MotherBrand : MediatorBrand {
    var cdDrive: CDDrive? = null
    var cpu: CPU? = null
    var videoCard: VideoCard? = null
    var soundCard: SoundCard? = null

    override fun changed(colleagueAbstract: ColleagueAbstract) {
        when(colleagueAbstract){
            is CDDrive -> openCDDriveReadData(colleagueAbstract)
            is CPU -> openCPU(colleagueAbstract)
        }
    }

    /**
     * 处理 光驱读取数据以后与其他对象的交互
     */
    private fun openCDDriveReadData(cdDrive: CDDrive) {
        // 1. 获取光驱读取的数据
        val data = cdDrive.cdData
        // 2. 把这些数据传送给 CPU 处理
        this.cpu!!.execteData(data)
    }
    // CPU 处理完数据后与其他对象的交互
    private fun openCPU(cpu:CPU){
        // 从 CPU 获取数据
        val videoData = cpu.videoData
        val soundData = cpu.soundData

        this.videoCard!!.showData(videoData)
        this.soundCard!!.soundData(soundData)
    }
}

fun main() {
    // 1. 创建中介者 -- 主板对象
    val mediator = MotherBrand()
    // 2. 创建同事类
    val cdDrive = CDDrive(mediator)
    val cpu = CPU(mediator)
    val soundCard = SoundCard(mediator)
    val videoCard = VideoCard(mediator)

    // 3. 让中介者知道所有的同事类
    mediator.cpu = cpu
    mediator.soundCard = soundCard
    mediator.videoCard = videoCard
    mediator.cdDrive = cdDrive

    // 4. 开始看电影，放入光盘，开始读盘
    cdDrive.readCD()




}