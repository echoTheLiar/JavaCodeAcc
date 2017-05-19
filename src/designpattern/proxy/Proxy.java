package designpattern.proxy;

/**
 * 代理类
 * 
 * @author liu yuning
 *
 */
public class Proxy implements Subject {

    // 保存一个引用，使得代理可以访问真实实体
    Subject subject;

    public Proxy() {
	subject = new RealSubject();
    }

    @Override
    public void request() {
	subject.request();
    }

}
