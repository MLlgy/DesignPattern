package mediatorPattern.model;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        BussinessObjectOne bussinessObjectOne = new BussinessObjectOne(mediator);
        BussinessObjectTwo bussinessObjectTwo = new BussinessObjectTwo(mediator);
        bussinessObjectOne.depMethod1();
        bussinessObjectTwo.depMethod2();
    }
}
