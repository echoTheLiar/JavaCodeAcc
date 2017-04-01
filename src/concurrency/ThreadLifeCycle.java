package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 线程的生命周期，演示线程的六种状态： NEW RUNNABLE TIMED_WAITING WAITING BLOCKED TERMINATED
 * 
 * @author liu yuning
 *
 */

class Block {
    public boolean waitStatus = true;

    public void waitOp() throws InterruptedException {
	synchronized (this) {
	    System.out.println(Thread.currentThread().getName() + "  进入wait");
	    wait();
	    System.out.println(Thread.currentThread().getName()
		    + "  next to Block.wait(), in the loop");
	}
    }

    public void notifyOp() {
	synchronized (this) {
	    this.waitStatus = false;
	    notifyAll();
	    System.out.println(Thread.currentThread().getName()
		    + "  向正在wait当前对象的线程发出notify");
	}
    }

}

class WaitRunnable implements Runnable {
    private Block block;

    public WaitRunnable(Block block) {
	super();
	this.block = block;
    }

    @Override
    public void run() {
	try {
	    System.out.println(Thread.currentThread().getName()
		    + "  被启动，开始执行...");

	    // 开始sleep
	    System.out.println(Thread.currentThread().getName()
		    + "  开始sleep 2s");
	    TimeUnit.SECONDS.sleep(2);
	    System.out
		    .println(Thread.currentThread().getName() + "  从sleep中醒来");

	    // 从sleep中醒来后，进入wait状态
	    while (block.waitStatus) {
		block.waitOp();
		System.out.println(Thread.currentThread().getName()
			+ "  next to WaitRunnable.waitOp(), in the loop");
	    }
	    System.out.println(Thread.currentThread().getName()
		    + "  out of wait loop");

	    System.out.println(Thread.currentThread().getName()
		    + "  任务执行结束，即将终止...");

	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}

class NotifyRunnable implements Runnable {
    private Block block;

    public NotifyRunnable(Block block) {
	super();
	this.block = block;
    }

    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + "  被启动，开始执行...");
	block.notifyOp();

	synchronized (block) {
	    try {
		System.out.println(Thread.currentThread().getName()
			+ "  开始sleep 6s，并且不会释放当前对象的锁");
		TimeUnit.SECONDS.sleep(6);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	System.out.println(Thread.currentThread().getName() + "  从sleep中醒来");

    }
}

public class ThreadLifeCycle {
    private static final String IN_THE_STATE = "当前的状态为：";
    private static final String ISALIVE_RETRUN = "isAlive()返回为：";

    /**
     * Describe the status of a thread
     * 
     * @param threadName
     * @param threadStatus
     * @param isAlive
     * @return thread status description
     */
    public static String descStatus(String threadName, String threadStatus,
	    boolean isAlive) {
	return threadName + "  " + IN_THE_STATE + threadStatus + "  "
		+ ISALIVE_RETRUN + isAlive;
    }

    /**
     * print the status of a thread
     * 
     * @param thread
     */
    public static void printStatus(Thread thread) {
	System.out.println(descStatus(thread.getName(), thread.getState()
		.toString(), thread.isAlive()));
    }

    public static void main(String[] args) throws InterruptedException {
	// 该对象将作为后面加锁的对象
	Block block = new Block();

	// NEW
	Thread thread = new Thread(new WaitRunnable(block));
	Thread notifyThread = new Thread(new NotifyRunnable(block));

	printStatus(thread);
	printStatus(notifyThread);

	// RUNNABLE
	thread.start();
	printStatus(thread);

	TimeUnit.SECONDS.sleep(1);

	// TIMED_WAITING
	printStatus(thread);

	TimeUnit.SECONDS.sleep(2);

	// WAITING
	printStatus(thread);

	TimeUnit.SECONDS.sleep(1);
	notifyThread.start();
	printStatus(notifyThread);

	TimeUnit.SECONDS.sleep(1);

	// BLOCKED or TERMINATED
	// TERMINATED：运行到此处时，如果notifyThread执行完notify操作后，调度器立马切换至thread的情况下，thread会先行终止，调度器再调度notifyThread
	printStatus(thread);

	printStatus(notifyThread);

	TimeUnit.SECONDS.sleep(6);

	// TERMINATED
	printStatus(thread);

    }
}
