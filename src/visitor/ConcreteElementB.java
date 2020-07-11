package visitor;

/**
 * 具体元素
 */
public class ConcreteElementB  implements AbstractElement{
    @Override
    public void accept(AbstractVisitor abstractVisitor) {
        abstractVisitor.visit(this);
    }

    public String operationA(){
        return "具体元素 B 的操作";
    }
}
