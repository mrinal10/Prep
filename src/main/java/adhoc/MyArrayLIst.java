package adhoc;

public class MyArrayLIst {

    private Object[] arrayOfObjects;
    private final double loadFactor;
    private int elementCount;

    MyArrayLIst() {
        arrayOfObjects = new Object[16];
        loadFactor = 0.75;
        elementCount = 0;
    }

    MyArrayLIst(int size) {
        arrayOfObjects = new Object[size];
        loadFactor = 0.75;
        elementCount = 0;
    }

    public void add(Object o) {
        int currentSize = arrayOfObjects.length;
        if(elementCount >= currentSize * loadFactor) {
            refactor();
        }

        arrayOfObjects[elementCount] = o;
        elementCount++;
    }

    public Object get(int index) {

        if(index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }

        return arrayOfObjects[index];
    }

    private void refactor() {
        Object[] newArrayOfObjects = new Object[arrayOfObjects.length * 2];
        for(int i = 0; i < arrayOfObjects.length; i++) {
            newArrayOfObjects[i] = arrayOfObjects[i];
        }

        arrayOfObjects = newArrayOfObjects;
    }

}


class Myclass {

    public static void main(String[] args) {
        MyArrayLIst mAlist = new MyArrayLIst();
        TestAlti t1 = new TestAlti(1 );
        TestAlti t2 = new TestAlti(2 );

        mAlist.add(t1);
        mAlist.add(t2);

        TestAlti getValue = (TestAlti) mAlist.get(1);

        System.out.println(getValue.getVal());
    }
}