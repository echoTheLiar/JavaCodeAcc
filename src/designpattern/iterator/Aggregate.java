package designpattern.iterator;

/**
 * 聚集接口
 * 
 * @author liu yuning
 *
 * @param <T>
 */
public interface Aggregate<T> {

    public Iterator<T> createIterator();
}
