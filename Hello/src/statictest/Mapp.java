package statictest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class Tll{
	public void set(Mapp m){
		m.set(this);
	}
}
public class Mapp {
	private Map<Tll, Integer> map;
	public void set(Tll t){
		map.put(t, 1);
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Thread t = new Thread(){
			public void run(){
				
				int t = 0;
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("得到了异常");
					t = 8;
				}
				System.out.println(t==0?true:false);
			}
		};
		t.start();
	}

}
