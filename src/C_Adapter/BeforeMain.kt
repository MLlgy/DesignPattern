package C_Adapter


fun main() {
    var logFileReader:ILogFileReader = LogFileReader()
    logFileReader.addLog("")
    logFileReader.addLog("")
    logFileReader.addLog("")
    println("所有日志为：${logFileReader.readLogs()}")

    logFileReader.remove("")
    logFileReader.readLogs()
    println("所有日志为：${logFileReader.readLogs()}")
}