package mediatorPattern.model;

public class BussinessObjectOne extends BussinessObject {

    public BussinessObjectOne(Mediator mediator) {
        super(mediator);
    }

    /**
     * 自发行为方法
     */
    public void selfMethod1() {
    }

    /**
     * 依赖方法（必须依赖中介者才可以实现）
     */
    public void depMethod1() {
        super.mediator.metod1();
    }
}
