package g_builder

import java.lang.StringBuilder

interface Builder {
    fun buildHeader(header: String)
    fun buildContent(content: String)
    fun buildFooter(footer: String)
}

class PdfBuilder : Builder {
    private val result: StringBuilder by lazy {
        StringBuilder()
    }
    override fun buildHeader(header: String) {
        result.append("Pdf header:title is $header\n")
    }

    override fun buildContent(content: String) {
        result.append("$content \n")
    }

    override fun buildFooter(footer: String) {
        result.append("pdf footer: $footer")
    }
    fun geFileResult() = result
}

class HtmlBuilder : Builder {
    private val result: StringBuilder by lazy { StringBuilder() }

    override fun buildHeader(header: String) {
        result.append("<html>\n")
        result.append("<head>\n")
        result.append("<title> $header </title>\n")
        result.append("</head>\n")
    }

    override fun buildContent(content: String) {
        result.append("<body>\n")
        result.append("<p> $content </p>\n")
        result.append("</body>\n")
    }

    override fun buildFooter(footer: String) {
        result.append("<!-- 注释：$footer -->\n")
    }
    fun getFileResult() = result
}


class Director(private val builder: Builder) {

    fun makeFile(header: String, content: String, footer: String) {
        builder.buildHeader(header)
        builder.buildContent(content)
        builder.buildFooter(footer)
    }
}

fun main() {
    val builder = PdfBuilder()
    val director = Director(builder)
    director.makeFile("你好中国","我爱你中国","祝福你，中国")
    println(builder.geFileResult())

}