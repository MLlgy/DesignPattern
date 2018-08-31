package mediatorPattern.model;

public class ConcreteMediator extends Mediator {
    @Override
    public void metod1() {
        super.bussinessObjectOne.selfMethod1();
    }

    @Override
    public void metod2() {
        super.bussinessObjectTwo.selfMethod2();
    }
}
