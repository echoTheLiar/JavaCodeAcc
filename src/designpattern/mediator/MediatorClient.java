package designpattern.mediator;

/**
 * 客户端
 * 
 * @author liu yuning
 *
 */
public class MediatorClient {
    public static void main(String[] args) {
	ConcreteMediator concreteMediator = new ConcreteMediator();

	// 让两个具体同事类认识中介者对象
	ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(
		concreteMediator);
	ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(
		concreteMediator);

	// 让中介者认识各个具体同事类对象
	concreteMediator.setC1(concreteColleague1);
	concreteMediator.setC2(concreteColleague2);

	// 具体同事类对象的消息发送都是通过中介者对象转发
	concreteColleague1.sendMsg("吃过饭了没有？");
	concreteColleague2.sendMsg("没有呢，你打算请客？");

    }

}
