package D_Singleton

// 通过枚举获得单例
fun main() {
    val enumSingleton = EnumSingleton.singletonInstance
    val enumSingleton_ = EnumSingleton.singletonInstance
    val enumSingleton__ = EnumSingleton.singletonInstance

    println("${enumSingleton.time}")
    println("${enumSingleton_.hashCode()}")
    println("${enumSingleton__.hashCode()}")

}