package j_proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


interface SubjectApi{
    fun request()
}


class DynamicProxy:InvocationHandler{

    private var subject:SubjectApi?= null

    fun getProxyInstance(subjectApi: SubjectApi):SubjectApi{
        this.subject = subjectApi
        return Proxy.newProxyInstance(subjectApi::class.java.classLoader,subjectApi::class.java.interfaces,this) as SubjectApi
    }


    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        return method!!.invoke(proxy,args)
    }
}