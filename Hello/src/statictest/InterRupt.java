package statictest;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InterRupt {
	class Too extends Thread{
		private volatile boolean isStop = false;
		public void setStop(boolean stop){
			this.isStop = stop;
		}
		public void run(){
			int i=0;
			while(!isStop&&i<Integer.MAX_VALUE){
				System.out.println(i);
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterRupt t = new InterRupt();
		Too o =t.new Too();
		o.start();
		try {
			Thread.currentThread().sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//o.interrupt();
		o.setStop(true);
		Hashtable h = new Hashtable();
		ConcurrentHashMap<String, String> r = new ConcurrentHashMap<String, String>();
		ReentrantLock sa = new ReentrantLock();
		ReentrantReadWriteLock sr = new ReentrantReadWriteLock();
	}
}
