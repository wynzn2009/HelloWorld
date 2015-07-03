package threadoz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		for(int i=0;i<5;i++){
			new Thread(new Lift()).start();
		}
		*/
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new Lift());
		}
		exec.shutdown();
		
		//ExecutorService exec = Executors.newFixedThreadPool(1);
		/*
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			exec.execute(new Lift());
		}
		exec.shutdown();
		*/
	}
}
