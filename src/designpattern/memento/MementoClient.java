package designpattern.memento;

/**
 * 客户端
 * 
 * @author liu yuning
 *
 */
public class MementoClient {

    public static void main(String[] args) {
	// 设置初始状态
	Originator originator = new Originator();
	originator.setState("On");
	originator.show();

	// 管理者通过备忘录保存状态，由于有了很好地封装，可以隐藏Originator的实现细节
	CareTaker careTaker = new CareTaker();
	careTaker.setMemento(originator.createMemento());

	// 改变状态
	originator.setState("Off");
	originator.show();

	// 通过管理者从备忘录中恢复状态
	originator.recoverMemento(careTaker.getMemento());
	originator.show();
    }

}
