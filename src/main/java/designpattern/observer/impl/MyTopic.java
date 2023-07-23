package designpattern.observer.impl;

import designpattern.observer.Observer;
import designpattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    private final List<Observer> observerList;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic(){
        this.observerList = new ArrayList<>();
    }
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");

        synchronized (MUTEX) {
            if(!observerList.contains(obj)) {
                observerList.add(obj);
            }
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observerList.remove(obj);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }

    private void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observerList);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }
}
