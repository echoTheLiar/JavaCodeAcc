package designpattern.factory.simple;

/**
 * 乘法类
 * 
 * @author liu yuning
 *
 */
public class OperationMul extends Operation {

    @Override
    public double result() {
	return numberA * numberB;
    }

}