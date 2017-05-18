package designpattern.facade;

/**
 * “系统”接口，只是标记接口，暂无任何意义
 * 
 * @author liu yuning
 *
 */
public interface SystemInterface {

}

class SubSystemOne implements SystemInterface {
    public void methodOne() {
	System.out.println("子系统方法一");
    }
}

class SubSystemTwo implements SystemInterface {
    public void methodTwo() {
	System.out.println("子系统方法二");
    }
}

class SubSystemThree implements SystemInterface {
    public void methodThree() {
	System.out.println("子系统方法三");
    }
}

class SubSystemFour implements SystemInterface {
    public void methodFour() {
	System.out.println("子系统方法四");
    }
}
