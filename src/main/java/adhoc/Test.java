package adhoc;


import java.time.Instant;

class Employee{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + "-" + name;
    }
}

public class Test {

    public static void main(String[] args) {
      /*  Employee e1 = new Employee(1,"A");
        Employee e2 = new Employee(1,"A");

        System.out.println(e1);
        System.out.println(e2);

        Set<Employee> treeSet = new TreeSet<Employee>();
        treeSet.add(e1);
        treeSet.add(e2);

        //System.out.println(treeSet);


        try{
            return;
        } catch (Exception e) {
            return;
        } finally {
            System.out.println("finally executed");
        }

        String s = "test";
        String s2 = new String("test").intern();
        String s3 = new String("test");

        Boolean value;

        System.out.println(value);

        Thread t = new Thread() {
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        };

        t.run();
        System.out.println(Thread.currentThread().getName());

        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("A");
            }
        };

        Thread t = new Thread(task) {
            @Override
            public void run() {
                System.out.println("A");
            }

            public synchronized void start() {
                System.out.println("C");
                super.start();
            }
        };

        t.start();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            it.remove();
            System.out.println(list.size());
        }*/


        System.out.println("Current epoch timestamp in millis: " + Instant.now().toEpochMilli());

    }
}
