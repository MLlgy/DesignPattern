package visitor;

/**
 * 抽象访问者
 */
public interface AbstractVisitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);

}
