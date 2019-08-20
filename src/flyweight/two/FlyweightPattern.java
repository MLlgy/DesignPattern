package flyweight.two;

public class FlyweightPattern {
    public static void main(String[] args) {
        ShareFactory shareFactory = new ShareFactory();

        Shape shape01 = shareFactory.getShape("red");
        Shape shape02 = shareFactory.getShape("blue");
        Shape shape03 = shareFactory.getShape("black");
        Shape shape04 = shareFactory.getShape("white");

        UnshareInfo unshareInfo01 = new UnshareInfo();
        unshareInfo01.setRadius(10);
        unshareInfo01.setX(2);
        unshareInfo01.setY(1);

        UnshareInfo unshareInfo02 = new UnshareInfo();
        unshareInfo02.setRadius(100);
        unshareInfo02.setX(21);
        unshareInfo02.setY(12);

        UnshareInfo unshareInfo03 = new UnshareInfo();
        unshareInfo03.setRadius(110);
        unshareInfo03.setX(211);
        unshareInfo03.setY(121);

        shape01.work(unshareInfo01);
        shape01.work(unshareInfo03);
        shape01.work(unshareInfo02);

        shape02.work(unshareInfo01);
        shape02.work(unshareInfo03);
        shape02.work(unshareInfo02);

        shape03.work(unshareInfo01);
        shape03.work(unshareInfo03);
        shape03.work(unshareInfo02);

        shape04.work(unshareInfo01);
        shape04.work(unshareInfo03);
        shape04.work(unshareInfo02);


        System.out.println("享元元素个数："  + shareFactory.getNum());
    }
}
