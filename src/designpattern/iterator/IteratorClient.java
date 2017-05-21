package designpattern.iterator;

/**
 * 迭代器客户端
 * 
 * @author liu yuning
 *
 */
public class IteratorClient {
    public static void main(String[] args) {
	ConcreteAggregate<String> bus = new ConcreteAggregate<String>();

	bus.setItems("大鸟");
	bus.setItems("小菜");
	bus.setItems("行李");
	bus.setItems("老外");
	bus.setItems("公交内部员工");
	bus.setItems("小偷");

	Iterator<String> iterator = new ConcreteIterator<String>(bus);

	while (!iterator.isDone()) {
	    System.out.println(iterator.currentItem() + "请买票！");
	    iterator.next();
	}
    }

}
