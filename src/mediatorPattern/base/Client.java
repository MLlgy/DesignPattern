package mediatorPattern.base;

public class Client {
    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        //采购人员采购电脑
        System.out.println("----采购人员采购电脑------");
        Purchase purchase = new Purchase(mediator);
        purchase.buyComputer(100);
        //销售人员销售电脑
        System.out.println("----销售人员销售电脑------");
        Sale sale = new Sale(mediator);
        sale.sellCom(50);
        //清空仓库
        System.out.println("----清空仓库------");
        Socket socket = new Socket(mediator);
        socket.clearStock();

    }
}
