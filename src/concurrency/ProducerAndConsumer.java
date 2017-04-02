package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 使用 BlockingQueue 实现生产者-消费者模式，其中： 1. 生产者将生产的产品放置到“产品队列”里； 2. 消费者从“产品队列”里消费产品；
 * 3. 定义多个生产者与消费者同时执行；4. 虽然有多个生产者，但是必须确保生产出的产品唯一，即 product+id 唯一；
 * 
 * 设计上如有问题，欢迎拍砖~
 * 
 * @author liu yuning
 *
 */

class Product {
    private final int id;

    public Product(int id) {
	super();
	this.id = id;
    }

    @Override
    public String toString() {
	return "product" + this.id;
    }
}

class Producer implements Runnable {
    // 定义所有producer共享的计数器，保证在向“产品队列”里放置产品时，产品id唯一
    static class Counter {
	private static int count = 0;

	public static int increase() {
	    return ++count;
	}
    }

    private final int id;
    BlockingQueue<Product> producerQueue;

    public Producer(BlockingQueue<Product> producerQueue, int id) {
	super();
	this.id = id;
	this.producerQueue = producerQueue;
    }

    @Override
    public String toString() {
	return "producer" + this.id;
    }

    @Override
    public void run() {
	try {
	    while (!Thread.interrupted()) {
		TimeUnit.MILLISECONDS.sleep(500);

		// 生产产品时，对计数器加锁
		synchronized (Counter.class) {
		    Product product = new Product(Counter.increase());
		    System.out.println("生产者" + this + "生产出：" + product);
		    producerQueue.put(product);
		}
	    }

	} catch (InterruptedException e) {
	    System.out.println(this + "interrupted");
	}
    }
}

class Consumer implements Runnable {
    private final int id;
    BlockingQueue<Product> consumerQueue;

    public Consumer(BlockingQueue<Product> consumerQueue, int id) {
	super();
	this.id = id;
	this.consumerQueue = consumerQueue;
    }

    @Override
    public String toString() {
	return "consumer" + this.id;
    }

    @Override
    public void run() {
	try {
	    while (!Thread.interrupted()) {
		Product consumerProduct = consumerQueue.take();
		System.out.println("消费者" + this + "消费了：" + consumerProduct);
	    }
	} catch (InterruptedException e) {
	    System.out.println(this + "interrupted");
	}

    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
	BlockingQueue<Product> productQueue = new LinkedBlockingDeque<Product>();

	ExecutorService executorService = Executors.newCachedThreadPool();
	for (int i = 0; i < 5; i++) {
	    executorService.execute(new Producer(productQueue, i));
	    executorService.execute(new Consumer(productQueue, i));
	}

	TimeUnit.SECONDS.sleep(10);
	executorService.shutdownNow();

    }

}
