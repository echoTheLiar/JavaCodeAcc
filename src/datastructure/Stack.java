package datastructure;

/**
 * 使用Java泛型实现栈
 * 
 * @author liu yuning
 *
 * @param <T>
 */
public class Stack<T> {

    private static class Node<U> {
	private U value;
	private Node<U> next;

	public Node() {
	    value = null;
	    next = null;
	}

	public Node(U value, Node<U> next) {
	    this.value = value;
	    this.next = next;
	}

	/**
	 * 判断栈是否为空
	 * 
	 * @return true 如果为空；否则，false
	 */
	public boolean empty() {
	    return value == null && next == null;
	}
    }

    /**
     * 定义栈顶元素
     */
    private Node<T> top = new Node<T>();

    /**
     * 入栈操作
     * 
     * @param value
     *            入栈元素的值
     */
    public void push(T value) {
	top = new Node<T>(value, top);
    }

    /**
     * 出栈操作
     * 
     * @return 栈顶元素的值
     */
    public T pop() {
	T value = top.value;
	if (!top.empty()) {
	    top = top.next;
	}
	return value;
    }

    public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();
	String string = "This is a test for stack";

	System.out.println("入栈元素(String)依次为：");
	for (String nodeIn : string.split(" ")) {
	    stack.push(nodeIn);
	    System.out.println(nodeIn);
	}

	System.out.println("出栈元素(String)依次为：");
	String nodeOut;
	while ((nodeOut = stack.pop()) != null) {
	    System.out.println(nodeOut);
	}
    }
}
