package designpattern.observer;

public interface Observer {

    //to be used by subject
    public void update();
    public void setSubject(Subject sub);

}
