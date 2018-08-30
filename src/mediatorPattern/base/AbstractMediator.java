package mediatorPattern.base;

/**
 * 抽象中介者
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Socket socket;

    public AbstractMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        socket = new Socket(this);
    }

    /**
     * 中介者模式中最重要的方法 -- 事件方法，
     * 处理各个对象间的关系
     * @param srt
     * @param objects
     */
    public abstract void excute(String srt,Object...objects);
}
