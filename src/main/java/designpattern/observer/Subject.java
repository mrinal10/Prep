package designpattern.observer;

public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);

    public Object getUpdate(Observer obj);
}
