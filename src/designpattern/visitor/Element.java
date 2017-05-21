package designpattern.visitor;

/**
 * 定义一个accept操作，它以一个访问者为参数
 * 
 * @author liu yuning
 *
 */
public abstract class Element {
    public abstract void accept(Visitor visitor);
}

class ConcreteElementA extends Element {

    @Override
    public void accept(Visitor visitor) {
	visitor.visitConcreteElementA(this);
    }

}

class ConcreteElementB extends Element {

    @Override
    public void accept(Visitor visitor) {
	visitor.visitConcreteElementB(this);
    }

}