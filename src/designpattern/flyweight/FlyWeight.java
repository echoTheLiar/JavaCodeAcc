package designpattern.flyweight;

/**
 * 所有具体享元类的超类，接受并作用于外部状态
 * 
 * @author liu yuning
 *
 */
public abstract class FlyWeight {

    public abstract void operation(int extrinsicState);

}

class ConcreteFlyWeight extends FlyWeight {

    @Override
    public void operation(int extrinsicState) {
	System.out.println("具体FlyWeight：" + extrinsicState);
    }

}

class UnsharedConcreteFlyWeight extends FlyWeight {

    @Override
    public void operation(int extrinsicState) {
	System.out.println("不共享的具体FlyWeight：" + extrinsicState);
    }

}