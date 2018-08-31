package mediatorPattern.model;

public class BussinessObjectTwo extends BussinessObject {
    public BussinessObjectTwo(Mediator mediator) {
        super(mediator);
    }

    /**
     * 自发行为方法
     */
    public void selfMethod2() {
    }

    /**
     * 依赖方法（必须依赖中介者才可以实现）
     */
    public void depMethod2() {
        super.mediator.metod2();
    }
}
