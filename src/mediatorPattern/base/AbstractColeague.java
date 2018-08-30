package mediatorPattern.base;

/**
 * 抽象同事类
 */
public abstract class AbstractColeague {
    protected AbstractMediator mediator;

    public AbstractColeague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}

