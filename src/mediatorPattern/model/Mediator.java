package mediatorPattern.model;

public abstract class Mediator {
    protected BussinessObjectOne bussinessObjectOne;
    protected BussinessObjectTwo bussinessObjectTwo;

    public void setBussinessObjectOne(BussinessObjectOne bussinessObjectOne) {
        this.bussinessObjectOne = bussinessObjectOne;
    }

    public void setBussinessObjectTwo(BussinessObjectTwo bussinessObjectTwo) {
        this.bussinessObjectTwo = bussinessObjectTwo;
    }

    public abstract void metod1();

    public abstract void metod2();
}
