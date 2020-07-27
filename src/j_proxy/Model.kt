package j_proxy

interface Subject{
    fun request()
}

class RealSubject:Subject{
    override fun request() {
        // 执行具体对象真正的操作
    }
}

class Proxy(private val realSubject: RealSubject):Subject{
    override fun request() {
        // 调用具体目标对象前，可以执行一系列操作
        realSubject.request()
        // 调用具体目标对象后，可以执行一系列操作
    }

}