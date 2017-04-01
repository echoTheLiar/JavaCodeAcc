package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 利用迭代器实现反转操作
 * 
 * @author liu yuning
 * 
 *
 */
public class Reverse {
    @SuppressWarnings("serial")
    private static class ReverseCollection<T> extends ArrayList<T> {

	public ReverseCollection(Collection<T> collection) {
	    super(collection);
	}

	public Iterable<T> reverse() {
	    return new Iterable<T>() {

		@Override
		public Iterator<T> iterator() {
		    return new Iterator<T>() {
			int current = size() - 1;

			@Override
			public boolean hasNext() {
			    return current > -1;
			}

			@Override
			public T next() {
			    return get(current--);
			}
		    };
		}
	    };
	}

    }

    public static String reverseWords(String s) {
	ReverseCollection<String> reverseCollection = new ReverseCollection<String>(
		Arrays.asList(s.split(" ")));
	StringBuilder stringBuilder = new StringBuilder();
	for (String word : reverseCollection.reverse()) {
	    stringBuilder.append(word + " ");
	}
	return stringBuilder.toString().trim();

    }

    public static void main(String[] args) {
	String s = "This is a test for reversing words";
	System.out.println(reverseWords(s));
    }
}
