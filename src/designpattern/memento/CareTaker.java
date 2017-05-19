package designpattern.memento;

/**
 * 管理者（CareTaker）类：管理备忘录
 * 
 * @author liu yuning
 *
 */
public class CareTaker {

    private Memento memento;

    public Memento getMemento() {
	return memento;
    }

    public void setMemento(Memento memento) {
	this.memento = memento;
    }

}
