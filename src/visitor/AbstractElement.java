package visitor;

/**
 * 抽象元素
 */
public interface AbstractElement {
    void accept(AbstractVisitor abstractVisitor);
}
