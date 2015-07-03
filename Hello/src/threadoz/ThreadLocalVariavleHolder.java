package threadoz;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable{
	private final int id;
	public Accessor(int idn){
		id = idn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariavleHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	public String toString(){
		return "#"+id + ": "+ThreadLocalVariavleHolder.get();
	}
}
public class ThreadLocalVariavleHolder {
	public static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
		private Random rand = new Random(47);
		protected synchronized Integer initialValue(){
			return rand.nextInt(10000);
		}
	};
	public static void increment(){
		value.set(value.get()+1);
	}
	public static int get(){
		return value.get();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
