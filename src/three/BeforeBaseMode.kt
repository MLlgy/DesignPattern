package three

interface ILogFileReader {
    fun readLogs(): List<String>
    fun remove(log: String)
    fun addLog(log: String)
}

open class LogFileReader : ILogFileReader {
    private  var logList: ArrayList<String> = ArrayList()

    override fun readLogs(): ArrayList<String> = logList

    override fun remove(log: String) {
        val iterator = logList.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == log) {
                iterator.remove()
            }
        }
    }

    override fun addLog(log: String) {
        logList.add(log)
    }

}