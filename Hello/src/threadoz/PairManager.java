package threadoz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {
	AtomicInteger checkCount = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
	public synchronized Pair getPair(){
		return new Pair(p.getX(),p.getY());
	}
	protected void store(Pair p){
		storage.add(p);
		try{
			TimeUnit.MILLISECONDS.sleep(50);
		}catch(InterruptedException ignore){
		}
	}
	public abstract void increment();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
class PairManager1 extends PairManager{
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}
class PairManager2 extends PairManager{
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		Pair temp;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}
class PairManipulator implements Runnable{
	private PairManager pm;
	public PairManipulator(PairManager pm){
		this.pm = pm;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			pm.increment();
		}
	}
	public String toString(){
		return "Pair:"+pm.getPair()+" checkCounter="+pm.checkCount.get();
	}
}
class PairChecker implements Runnable{
	private PairManager pm;
	public PairChecker(PairManager pm){
		this.pm = pm;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			pm.checkCount.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}












