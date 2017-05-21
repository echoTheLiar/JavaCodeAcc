package designpattern.bridge;

/**
 * 客户端
 * 
 * @author liu yuning
 *
 */
public class BridgeClient {
    public static void main(String[] args) {

	Abstraction a = new AbstractionA("A");
	a.setImplementor(new ConcreteImplemtorA());
	a.operation();
	a.setImplementor(new ConcreteImplemtorB());
	a.operation();

	Abstraction b = new AbstractionB("B");
	b.setImplementor(new ConcreteImplemtorA());
	b.operation();
	b.setImplementor(new ConcreteImplemtorB());
	b.operation();

	// 这样通过使用“组合/聚合复用原则”
	// 如果继续有AbstractionC ... 或者ConcreteImplemtorC ...
	// 只需要扩展类即可，不需要修改现有类，符合“开放-封闭”原则
    }

}
