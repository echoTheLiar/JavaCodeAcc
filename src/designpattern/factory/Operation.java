package designpattern.factory;

/**
 * 操作类抽象类
 * 
 * @author liu yuning
 *
 */
public abstract class Operation {
    protected double numberA;
    protected double numberB;

    public abstract double result();
}
