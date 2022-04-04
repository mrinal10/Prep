
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

class Test {

    public static void main(String[] args) {
        for (int i = 0; i<100; i++) {
            MySingleton newSingleton = MySingleton.getObject();
            System.out.println(newSingleton.hashCode());
        }
    }
}
