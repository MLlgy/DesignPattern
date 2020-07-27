package e_factory_method

interface ExportFile {
    fun export(data: String)
}

class MdExportFile : ExportFile {
    override fun export(data: String) {
        println("我将 $data 导出为 markdown 格式")
    }
}

class PdfExportFile : ExportFile {
    override fun export(data: String) {
        println("我将 $data 导出为 pdf 格式")
    }
}

/**
 * 简单工厂模式的使用方法
 */
class SimpleFactory {
    companion object {
        fun createExport(type: Int): ExportFile? = when (type) {
            1 -> MdExportFile()
            2 -> PdfExportFile()
            else -> null
        }
    }
}

fun simpleFactory() {
    val mdExportFile = SimpleFactory.createExport(1);
    val pdfExportFile = SimpleFactory.createExport(2);
    mdExportFile?.export("markdown")
    pdfExportFile?.export("pdf")
}


abstract class FileExportActionFactory {
    /**
     * 工厂方法
     */
    abstract fun exporterMaker(): ExportFile

    fun exportAction(data: String) {
        val exportFile = exporterMaker()
        exportFile.export(data);
    }

    fun exportAction(type: Int, data: String) {
        val exportFile: ExportFile? = when (type) {
            1 -> MdExportFile()
            2 -> PdfExportFile()
            else -> null
        }
        exportFile?.export(data);
    }
}

fun factoryMethod() {
    val mdFileExportAction = MdFileExportAction()
    val pdfFileExportAction = PdfFileExportAction()
    mdFileExportAction.exportAction("markdown")
    pdfFileExportAction.exportAction("pdf")
}

class FileExportActionFactoryWithType {
    /**
     * 参数化工厂方法
     */
    fun exportAction(type: Int, data: String) {
        val exportFile = exportActionWithType(type)
        exportFile?.export(data);
    }

    private fun exportActionWithType(type: Int): ExportFile? = when (type) {
        1 -> MdExportFile()
        2 -> PdfExportFile()
        else -> null
    }
}

class MdFileExportAction : FileExportActionFactory() {
    override fun exporterMaker(): ExportFile = MdExportFile()
}


class PdfFileExportAction : FileExportActionFactory() {
    override fun exporterMaker(): ExportFile = PdfExportFile()
}

fun factoryMethodWithType() {
    val actionFactory = FileExportActionFactoryWithType()
    actionFactory.exportAction(1, "md")
    actionFactory.exportAction(2, "pdf")
}

fun main() {
    simpleFactory()
    factoryMethod()
    factoryMethodWithType()

}

