package threadoz;

public class Lift implements Runnable{
	protected int count = 10;
	private static int task = 0;
	private final int id = task++;
	public Lift(){
		
	}
	public Lift(int countDown){
		this.count = countDown;
	}
	public String status(){
		return "$$"+id+"##"+(count>0?count:"Lift over!")+",";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(count-->0){
			System.out.println(status());
			Thread.yield();
		}
	}
}
