package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectStructure {
    private List<AbstractElement> list = new ArrayList<>();

    public void accept(AbstractVisitor visitor) {
        Iterator<AbstractElement> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(AbstractElement element) {
        list.add(element);
    }

    public void remove(AbstractElement element) {
        list.remove(element);
    }
}
