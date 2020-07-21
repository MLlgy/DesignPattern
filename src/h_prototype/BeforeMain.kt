package h_prototype


interface BeforeOrderApi {
    fun getOrderProductNum(): Int
    fun setOrderProductNum(num: Int)
}

class BeforePersonalOrder : BeforeOrderApi {

    private var customerName: String? = null
    private var productId: String? = null
    private var orderProduceNum = 0

    override fun getOrderProductNum(): Int = orderProduceNum

    override fun setOrderProductNum(num: Int) {
        orderProduceNum = num
    }

    override fun toString(): String {
        return "BeforePersonalOrder(customerName=$customerName, productId=$productId, orderProduceNum=$orderProduceNum)"
    }
}


class BeforeEnterpriseOrder : BeforeOrderApi {

    private var customerName: String? = null
    private var productId: String? = null
    private var orderProduceNum = 0

    override fun getOrderProductNum(): Int = orderProduceNum

    override fun setOrderProductNum(num: Int) {
        orderProduceNum = num
    }

    override fun toString(): String {
        return "BeforeEnterpriseOrder(customerName=$customerName, productId=$productId, orderProduceNum=$orderProduceNum)"
    }
}

fun dealOrder(orderApi: BeforeOrderApi){
    while (orderApi.getOrderProductNum() > 1000){
        var newOrder:BeforeOrderApi? = null
        if (orderApi is BeforeEnterpriseOrder ){
            newOrder = BeforeEnterpriseOrder()
        }else if(orderApi is BeforeOrderApi){
            newOrder = BeforePersonalOrder()
        }
        newOrder?.setOrderProductNum(1000)
        orderApi.setOrderProductNum(orderApi.getOrderProductNum() - 1000)
        println("new Order: ${newOrder.toString()}" )
    }
    println(" Orign Order: ${orderApi}" )

}

fun main() {
    val orderApi = BeforePersonalOrder()
    orderApi.setOrderProductNum(2007)
    dealOrder(orderApi)
}