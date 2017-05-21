package designpattern.responsibilitychain;

/**
 * 处理请求的接口
 * 
 * @author liu yuning
 *
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
	this.successor = successor;
    }

    public abstract void handleRequest(int request);
}

// 具体处理者类，处理它所负责的请求，可访问它的后继者，如果可处理该请求，则处理，否则转给它的后继者处理
class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(int request) {
	if (request >= 0 && request <= 10) {
	    System.out.println(this.getClass().getName() + "处理了请求" + request);
	} else if (successor != null) {
	    successor.handleRequest(request);
	}
    }

}

class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(int request) {
	if (request > 10 && request <= 20) {
	    System.out.println(this.getClass().getName() + "处理了请求" + request);
	} else if (successor != null) {
	    successor.handleRequest(request);
	}
    }

}

class ConcreteHandlerC extends Handler {

    @Override
    public void handleRequest(int request) {
	if (request > 20 && request <= 30) {
	    System.out.println(this.getClass().getName() + "处理了请求" + request);
	} else if (successor != null) {
	    successor.handleRequest(request);
	}
    }

}
