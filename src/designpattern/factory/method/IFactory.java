package designpattern.factory.method;

import designpattern.factory.simple.Operation;
import designpattern.factory.simple.OperationAdd;
import designpattern.factory.simple.OperationDiv;
import designpattern.factory.simple.OperationMul;
import designpattern.factory.simple.OperationSub;

/**
 * 工厂接口
 * 
 * @author liu yuning
 *
 */
public interface IFactory {
    public Operation createOperation();
}

class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationAdd();
    }

}

class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationSub();
    }

}

class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationMul();
    }

}

class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationDiv();
    }

}