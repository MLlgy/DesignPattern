package mediatorPattern.base;

import java.util.Random;

/**
 * 出售类
 */
public class Sale extends AbstractColeague {

    private static int NUM = 100;
    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    //销售
    public void sellCom(int mNum){
        super.mediator.excute("sale.sell",mNum);
        System.out.println("销售电脑： "+ mNum);
    }
    //打折销售
    public void offSale(){
        super.mediator.excute("sale.offsale");
    }

    public int getSaleStatus(){
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("电脑销售情况为：" + saleStatus);
        return saleStatus;
    }
}
