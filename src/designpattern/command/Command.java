package designpattern.command;

import java.util.List;

/**
 * 用来声明执行操作的接口
 * 
 * @author liu yuning
 *
 */
public abstract class Command {

    protected List<Reciever> recievers;

    public Command(List<Reciever> recievers) {
	this.recievers = recievers;
    }

    public void addRecievers(Reciever reciever) {
	this.recievers.add(reciever);
    }

    public abstract void execute();

}

// 将一个接收者对象绑定于一个动作，调用接收者相应的操作，以实现execute
class ConcreteCommand extends Command {

    public ConcreteCommand(List<Reciever> recievers) {
	super(recievers);
    }

    @Override
    public void execute() {
	for (Reciever reciever : recievers) {
	    reciever.action();
	}
    }

}
