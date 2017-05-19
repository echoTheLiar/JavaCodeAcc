package designpattern.observer;

/**
 * 观察者模式客户端代码
 * 
 * @author liu yuning
 *
 */
public class ObserverClient {
    public static void main(String[] args) {
	ConcreteSubject concreteSubject = new ConcreteSubject();

	concreteSubject.attach(new ConcreteObserver(concreteSubject, "X"));
	concreteSubject.attach(new ConcreteObserver(concreteSubject, "Y"));
	concreteSubject.attach(new ConcreteObserver(concreteSubject, "Z"));

	concreteSubject.setSubjectState("ABC");
	concreteSubject.notifyObserver();

    }

}
