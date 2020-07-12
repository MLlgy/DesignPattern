package three


fun main() {
    var logFileReader:ILogFileReader = LogFileReader()
    logFileReader.addLog("one")
    logFileReader.addLog("two")
    logFileReader.addLog("three")
    println("所有日志为：${logFileReader.readLogs()}")

    logFileReader.remove("one")
    logFileReader.readLogs()
    println("所有日志为：${logFileReader.readLogs()}")
}