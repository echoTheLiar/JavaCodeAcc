package designpattern.iterator;

/**
 * 具体迭代器类，给出一种具体迭代的实现方式。思考：迭代器表示的是一种迭代的行为，而聚集则是真正要被迭代的数据集合。
 * 之所以要将迭代器和聚集分开，就是为了将行为与数据分开。 可类比Java中Iterator与Iterable的关系进行理解
 * 
 * @author liu yuning
 *
 * @param <T>
 */
public class ConcreteIterator<T> implements Iterator<T> {

    private ConcreteAggregate<T> concreteAggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate<T> concreteAggregate) {
	this.setConcreteAggregate(concreteAggregate);
    }

    @Override
    public T first() {
	return concreteAggregate.getItems(0);
    }

    @Override
    public T next() {
	current++;

	if (current < concreteAggregate.count()) {
	    return concreteAggregate.getItems(current);
	}

	return null;
    }

    @Override
    public boolean isDone() {
	return current >= concreteAggregate.count() ? true : false;
    }

    @Override
    public T currentItem() {
	return concreteAggregate.getItems(current);
    }

    public ConcreteAggregate<T> getConcreteAggregate() {
	return concreteAggregate;
    }

    public void setConcreteAggregate(ConcreteAggregate<T> concreteAggregate) {
	this.concreteAggregate = concreteAggregate;
    }

    public int getCurrent() {
	return current;
    }

    public void setCurrent(int current) {
	this.current = current;
    }

}
