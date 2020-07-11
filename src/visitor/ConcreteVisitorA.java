package visitor;

/**
 * 具体访问者
 */
public class ConcreteVisitorA implements AbstractVisitor{

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者 A ---》" + elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者 A ---》" + elementB.operationA());
    }
}
