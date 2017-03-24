package datastructure;

interface Generator<T> {
	T next();
}

public class Fibonacci implements Generator<Integer> {

	private int count = 0;

	@Override
	public Integer next() {
		return fibonacci(count++);
	}

	public int fibonacci(int n) {
		if (n < 2) {
			return 1;
		}
		return fibonacci(n - 2) + fibonacci(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int size = 18;
		for (int i = 0; i < size; i++) {
			System.out.print(fibonacci.next() + " ");
		}
	}
}
