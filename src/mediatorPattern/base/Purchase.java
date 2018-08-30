package mediatorPattern.base;

/**
 * 购买类
 */
public class Purchase extends AbstractColeague {
    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }
    //采购电脑
    public void buyComputer(int mNum){
        super.mediator.excute("purchase.buy",mNum);
    }

    //不采购电脑
    public void refuseBuyComputer(){
        System.out.println("不再采购电脑");
    }
}
