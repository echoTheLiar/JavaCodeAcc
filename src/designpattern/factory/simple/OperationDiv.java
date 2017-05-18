package designpattern.factory.simple;

/**
 * 除法类
 * 
 * @author liu yuning
 *
 */
public class OperationDiv extends Operation {

    @Override
    public double result() {
	if (numberB == 0) {
	    throw new RuntimeException("divided by 0");
	}
	return numberA / numberB;
    }

}