package pandc;

import java.util.PriorityQueue;

public class WaitAndNotify {
	private int size = 50000;
	private PriorityQueue<Integer> q = new PriorityQueue<Integer>(size);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitAndNotify w = new WaitAndNotify();
		Producer p = w.new Producer();
		Costomer c = w.new Costomer();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}

	class Producer implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (q) {
					while(q.size()==size){
						try {
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							q.notify();
						}
					}
					q.offer((int) (10*Math.random()));
					q.notify();
				}
			}
		}
		
	}
	
	class Costomer implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (q) {
					while(q.size()==0){
						try {
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							q.notify();
						}
					}
					System.out.println(q.poll()+" "+q.size());
					q.notify();
				}
			}
		}
		
	}
}