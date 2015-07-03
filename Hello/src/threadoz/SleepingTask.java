package threadoz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends Lift {
	public void run(){
		try{
			while(count-->0){
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("interrupted");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
