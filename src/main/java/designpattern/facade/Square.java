package designpattern.facade;

public class Square implements Facade{

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
    
}
