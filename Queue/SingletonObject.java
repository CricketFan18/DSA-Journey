public class SingletonObject {
    private static SingletonObject ob;

    public static SingletonObject getInstance() {
        if (ob == null)
            ob = new SingletonObject();
        return ob;
    }
}
