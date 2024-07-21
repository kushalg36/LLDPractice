package singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class InnerClass {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return InnerClass.instance;
    }
}
