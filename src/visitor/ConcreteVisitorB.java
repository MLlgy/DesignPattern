package visitor;

/**
 * 具体访问者
 */
public class ConcreteVisitorB implements AbstractVisitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者 B ---》" + elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者 B ---》" + elementB.operationA());
    }
}
