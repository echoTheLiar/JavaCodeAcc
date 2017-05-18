package designpattern.template;

/**
 * 模板方法抽象类：不变的部分给出具体实现，变化的部分封装为抽象方法延迟到子类实现
 * 
 * @author liu yuning
 *
 */
public abstract class AbstractTemplate {
    public abstract void primitiveOperation1();

    public abstract void primitiveOperation2();

    public void templateMethod() {
	primitiveOperation1();
	primitiveOperation2();
	System.out.println("模板方法结束\n");
    }

}
