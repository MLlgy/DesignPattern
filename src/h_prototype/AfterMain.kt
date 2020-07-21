package h_prototype


interface OrderApi {
    fun getOrderProductNum(): Int
    fun setOrderProductNum(num: Int)

    // 定义克隆方法
    fun cloneOrder(): OrderApi
}

class PersonalOrder : OrderApi {

    private var customerName: String? = null
    private var productId: String? = null
    private var orderProduceNum = 0

    override fun getOrderProductNum(): Int = orderProduceNum

    override fun setOrderProductNum(num: Int) {
        orderProduceNum = num
    }

    override fun cloneOrder(): OrderApi {
        val order = PersonalOrder()
        order.customerName = this.customerName
        order.productId = this.productId
        order.orderProduceNum = this.orderProduceNum
        return order
    }

    override fun toString(): String {
        return "PersonalOrder(customerName=$customerName, productId=$productId, orderProduceNum=$orderProduceNum)"
    }
}


class EnterpriseOrder : OrderApi {

    private var customerName: String? = null
    private var productId: String? = null
    private var orderProduceNum = 0

    override fun getOrderProductNum(): Int = orderProduceNum

    override fun setOrderProductNum(num: Int) {
        orderProduceNum = num
    }

    override fun cloneOrder(): OrderApi {
        val order = EnterpriseOrder()
        order.customerName = this.customerName
        order.productId = this.productId
        order.orderProduceNum = this.orderProduceNum
        return order
    }

    override fun toString(): String {
        return "EnterpriseOrder(customerName=$customerName, productId=$productId, orderProduceNum=$orderProduceNum)"
    }
}

fun dealOrder(orderApi: OrderApi){
    while (orderApi.getOrderProductNum() > 1000){
        val newOrder = orderApi.cloneOrder()
        newOrder.setOrderProductNum(1000)
        orderApi.setOrderProductNum(orderApi.getOrderProductNum() - 1000)
        println("new Order: ${newOrder.toString()}" )

    }
    println(" Orign Order: ${orderApi}" )

}

fun main() {
    val orderApi = PersonalOrder()
    orderApi.setOrderProductNum(2007)
    dealOrder(orderApi)
}