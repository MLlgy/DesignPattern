package mediatorPattern.base;

/**
 * 仓库类
 */
public class Socket extends AbstractColeague {
    private static int NUM = 100;

    public Socket(AbstractMediator mediator) {
        super(mediator);
    }

    //库存增加
    public void increase(int mNum) {
        NUM = NUM + mNum;
        System.out.println("库存数量为" + NUM);
    }

    //降低库存
    public void decrease(int mNum) {
        NUM = NUM - mNum;
        System.out.println("库存数量为" + NUM);
    }

    public  int getNUM() {
        return NUM;
    }

    //库存较大，通知采购不要购买，同事销售人员要尽快销售
    public void clearStock() {
        System.out.println("清空存货数量" + NUM);
        super.mediator.excute("stock.clear");
    }
}
