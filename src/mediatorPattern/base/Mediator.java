package mediatorPattern.base;

/**
 * 具体中介者
 */
public class Mediator extends AbstractMediator {
    @Override
    public void excute(String srt, Object... objects) {
        if ("purchase.buy".equals(srt)) {
            this.buyCom((Integer) objects[0]);
        } else if ("sale.sell".equals(srt)) {
            this.sellCom((Integer) objects[0]);
        } else if ("sale.offsale".equals(srt)) {
            this.offsale();
        } else if ("stock.clear".equals(srt)) {
            this.clearStock();
        }
    }

    //采购电脑
    private void buyCom(int mNum) {
        int status = super.sale.getSaleStatus();
        if (status > 80) {
            System.out.println("采购电脑 " + mNum + " 台");
            super.socket.increase(mNum);
        } else {
            System.out.println("采购电脑 " + mNum / 2 + "台");
        }
    }

    //销售电脑
    private void sellCom(int mNum) {
        if (super.socket.getNUM() < mNum) {
            super.purchase.buyComputer(mNum);
        }
        super.socket.decrease(mNum);
    }

    //折价销售电脑
    private void offsale() {
        System.out.println("折价销售电脑：" + socket.getNUM() + " 台");
    }

    //清仓处理
    private void clearStock() {
        super.sale.offSale();
        super.purchase.refuseBuyComputer();
    }
}
