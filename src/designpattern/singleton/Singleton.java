package designpattern.singleton;

/**
 * 单例类，使用饿汉式，线程安全（不存在同步问题，但是类被加载即被初始化，特定条件下耗费内存）；注释为饱汉式，存在线程不安全的问题
 * 
 * @author liu yuning
 *
 */
public class Singleton {

    // 饱汉式
    // private static Singleton instance;

    // 饿汉式
    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
	// 饱汉式
	// if (instance == null) {
	// instance = new Singleton();
	// }

	return instance;
    }

}
