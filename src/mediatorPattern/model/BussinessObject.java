package mediatorPattern.model;

public abstract class BussinessObject {
    protected Mediator mediator;

    public BussinessObject(Mediator mediator) {
        this.mediator = mediator;
    }
}
