package threadoz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {
	private int count = 5;
	private volatile double d;
	private int priority;
	
	public SimplePriorities(int priority) {
		this.priority = priority;
	}
	public String toString(){
		return Thread.currentThread() + ":" + count;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(priority);
		while(true){
			for(int i=0;i<100000;i++){
				d += (Math.PI+Math.E)/(double)i;
				if(i%1000==0){
					Thread.yield();
				}
			}
			System.out.println(this);
			if(--count==0){
				return;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
