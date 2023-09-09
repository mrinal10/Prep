package designpattern.facade;

public class Circle implements Facade{

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
    
}
