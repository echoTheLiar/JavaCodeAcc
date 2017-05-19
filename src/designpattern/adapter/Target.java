package designpattern.adapter;

/**
 * 客户所期待的接口
 * 
 * @author liu yuning
 *
 */
public abstract class Target {
    public void request() {
	System.out.println("普通请求！");
    }
}
