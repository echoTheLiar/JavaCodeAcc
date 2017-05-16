package designpattern.factory;

/**
 * 操作类工厂类
 * 
 * @Todo 改造生成对象实例的方式
 * @author liu yuning
 *
 */
public class OperationFactory {
    public static Operation createOperation(char operator) {
	Operation operation = null;

	switch (operator) {
	case '+':
	    operation = new OperationAdd();
	    break;
	case '-':
	    operation = new OperationSub();
	    break;
	case '*':
	    operation = new OperationMul();
	    break;
	case '/':
	    operation = new OperationDiv();
	    break;
	default:
	    throw new RuntimeException("unsupported operation");
	}

	return operation;
    }
}

class OperationAdd extends Operation {

    @Override
    public double result() {
	return numberA + numberB;
    }

}

class OperationSub extends Operation {

    @Override
    public double result() {
	return numberA - numberB;
    }

}

class OperationMul extends Operation {

    @Override
    public double result() {
	return numberA * numberB;
    }

}

class OperationDiv extends Operation {

    @Override
    public double result() {
	if (numberB == 0) {
	    throw new RuntimeException("divided by 0");
	}
	return numberA / numberB;
    }

}
