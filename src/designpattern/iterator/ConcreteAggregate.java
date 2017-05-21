package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚集类
 * 
 * @author liu yuning
 *
 * @param <T>
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

    private List<T> items = new ArrayList<T>();

    @Override
    public Iterator<T> createIterator() {
	// TODO Auto-generated method stub
	return new ConcreteIterator<T>(this);
    }

    public int count() {
	return items.size();
    }

    public T getItems(int index) {
	return items.get(index);
    }

    public void setItems(T item) {
	items.add(item);
    }

}
