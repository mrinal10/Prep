package multithreading;

public class MySingleton {
    private static MySingleton obj = null;

    private MySingleton() {

    }

    static synchronized MySingleton getObject() {

        if(obj == null) {
            obj = new MySingleton();
        }

        return obj;
    }
}
