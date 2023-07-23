package design.observer.impl;

import design.observer.Observer;
import design.observer.Subject;

public class MyTopicSubscriber implements Observer {

    private final String name;
    private Subject topic;

    public MyTopicSubscriber(String nm){
        this.name = nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
}
