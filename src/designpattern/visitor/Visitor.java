package designpattern.visitor;

/**
 * 为该对象结构中ConcreteElement的每一个类声明一个Visit操作
 * 
 * @author liu yuning
 *
 */
public abstract class Visitor {

    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);

}

class ConcreteVisitor1 extends Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
	System.out.println(concreteElementA.getClass().getSimpleName() + "被"
		+ this.getClass().getSimpleName() + "访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
	System.out.println(concreteElementB.getClass().getSimpleName() + "被"
		+ this.getClass().getSimpleName() + "访问");
    }

}

class ConcreteVisitor2 extends Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
	System.out.println(concreteElementA.getClass().getSimpleName() + "被"
		+ this.getClass().getSimpleName() + "访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
	System.out.println(concreteElementB.getClass().getSimpleName() + "被"
		+ this.getClass().getSimpleName() + "访问");
    }

}