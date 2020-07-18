package g_builder

class NetRequest(private val builder: RequestBuilder) {
    private var url: String? = null
    private var method: String? = null
    private var body: String? = null
    private var header: String? = null

    init {
        this.url = builder.getUrl()
        this.method = builder.getMethod()
        this.header = builder.getHeader()
        this.body = builder.getBody()
    }

    fun makeRequest() {
        print("有了充足的信息，我现在可以发起网络请求了")
    }
}

class RequestBuilder {

    private var url: String? = null
    private var method: String? = null
    private var body: String? = null
    private var header: String? = null

    fun setUrl(url: String): RequestBuilder {
        this.url = url
        return this
    }

    fun setMethod(url: String): RequestBuilder {
        this.method = url
        return this
    }

    fun setBody(body: String): RequestBuilder {
        this.body = body
        return this
    }

    fun setHeader(header: String): RequestBuilder {
        this.url = header
        return this
    }

    fun getUrl() = url
    fun getMethod() = method
    fun getBody() = body
    fun getHeader() = header

    fun build(): NetRequest = NetRequest(this)
}


fun main() {
//    buildObject()
    buildObjectInnerBuilder()

}

fun buildObjectInnerBuilder() {
    val builder: InnerBuilderNetRequest.Builder = InnerBuilderNetRequest.Builder().setUrl("https://www.baidu.com")
            .setMethod("GET")
            .setHeader("Cookie:xxjfjiddjls")
            .setBody("query=android")
    val request: InnerBuilderNetRequest = builder.build()
    request.makeCall()
}

private fun buildObject() {
    val builder: RequestBuilder = RequestBuilder()
    val request: NetRequest = builder.setBody("method")
            .setUrl("https://www.baidu.com")
            .setHeader("connection:keep-alive")
            .setBody("?query=android")
            .build()
    request.makeRequest()
}