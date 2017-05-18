package designpattern.facade;

/**
 * 外观类，它需要了解所有的子系统的方法或属性，进行组合，以备外界调用
 * 
 * @author liu yuning
 *
 */
public class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    SubSystemFour subSystemFour;

    public Facade() {
	subSystemOne = new SubSystemOne();
	subSystemTwo = new SubSystemTwo();
	subSystemThree = new SubSystemThree();
	subSystemFour = new SubSystemFour();
    }

    public void methodA() {
	System.out.println("方法组A:");

	subSystemOne.methodOne();
	subSystemTwo.methodTwo();
	subSystemFour.methodFour();
    }

    public void methodB() {
	System.out.println("方法组B:");

	subSystemThree.methodThree();
	subSystemFour.methodFour();
    }
}
