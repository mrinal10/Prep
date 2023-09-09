package designpattern.facade;

public class FacadeMaker {
    
    private Facade circle;
    private Facade rectangle;
    private Facade square;


    public FacadeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
    
}
