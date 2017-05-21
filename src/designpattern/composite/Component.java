package designpattern.composite;

/**
 * Component为组合中的对象声明接口，在适当情况下，实现所有类共有接口的默认行为。
 * 
 * @author liu yuning
 *
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
	this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);

}
