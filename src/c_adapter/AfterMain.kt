package c_adapter

fun main() {
    val logDBReader = LogDBReader()

    logDBReader.createLog("dbOne")
    logDBReader.createLog("dbTwo")
    logDBReader.createLog("dbThree")
    println("db 所有日志：${logDBReader.getAllLog()}")

    logDBReader.removeLog("dbOne")
    println("删除后：db 所有日志：${logDBReader.getAllLog()}")

    logDBReader.updateLog(1, "dbNew")
    println("更新后： db 所有日志：${logDBReader.getAllLog()}")


    println("----使用适配器支持文件存储----")

    // 被适配的对象
    val logFileReader = LogFileReader()
    val adapter = Adapter()
    adapter.setFileLogReader(logFileReader)

    adapter.createLog("dbOne")
    adapter.createLog("dbTwo")
    adapter.createLog("dbThree")
    println("db 所有日志：${logDBReader.getAllLog()}")

    adapter.removeLog("dbOne")
    println("删除后：db 所有日志：${logDBReader.getAllLog()}")

    adapter.updateLog(1, "dbNew")
    println("更新后： db 所有日志：${logDBReader.getAllLog()}")
}