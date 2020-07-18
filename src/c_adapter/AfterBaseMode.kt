package c_adapter

interface ILogDBReader {
    fun createLog(dbLog: String)
    fun updateLog(index: Int, newLog: String)
    fun removeLog(dbLog: String)
    fun getAllLog(): List<String>
}

class LogDBReader : ILogDBReader {
    private var logDBList: ArrayList<String> = ArrayList()
    override fun createLog(dbLog: String) {
        logDBList.add(dbLog)
    }

    override fun updateLog(index: Int, newLog: String) {
        logDBList.add(index, newLog)
    }

    override fun removeLog(dbLog: String) {
        val iterator = logDBList.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == dbLog) {
                iterator.remove()
            }
        }
    }

    override fun getAllLog(): List<String> = logDBList

}

class Adapter : ILogDBReader {

    private var logFileReader: LogFileReader? = null
    fun setFileLogReader(logFileReader: LogFileReader?) {
        this.logFileReader = logFileReader
    }

    override fun createLog(dbLog: String) {
        logFileReader?.readLogs()?.add(dbLog)
    }

    override fun updateLog(index: Int, newLog: String) {
        val logFileList = logFileReader?.readLogs()
        logFileList?.add(index, newLog)
    }

    override fun removeLog(dbLog: String) {
        logFileReader?.remove(dbLog)
    }

    override fun getAllLog(): List<String> {
        return logFileReader!!.readLogs()
    }
}

/**
 * 除了通过上面关联的关系与原角色产生联系，也可以使用继承来实现
 */
class NewAdapter : ILogDBReader, LogFileReader() {
    override fun createLog(dbLog: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLog(index: Int, newLog: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeLog(dbLog: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllLog(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}