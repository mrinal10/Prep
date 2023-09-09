package designpattern.facade;

public class Rectangle implements Facade{

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
    
}
