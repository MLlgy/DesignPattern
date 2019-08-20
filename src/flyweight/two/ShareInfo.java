package flyweight.two;

/**
 * 共享部分
 */
public class ShareInfo implements Shape {
    private String color;

    public ShareInfo(String color) {
        this.color = color;
        System.out.println("具体的享元 " + color + " 被创建");
    }


    @Override
    public void work(UnshareInfo unshareInfo) {
        System.out.println("具体的享元 " + color + " 被调用");
        System.out.println("非共享部分：" + unshareInfo.toString());
    }
}
