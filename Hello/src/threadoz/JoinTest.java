package threadoz;

public class JoinTest {
	public static int t=0;
	public static void inc(){
		synchronized (JoinTest.class) {
			t++;
			System.out.println(Thread.currentThread());
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("@@"+i);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				for(int j=0;j<1000;j++){
					System.out.println("%%"+j);
				}
			}
		};
		Thread t3 = new Thread(){
			public void run(){
				for(int j=0;j<1000;j++){
					System.out.println("&&"+j);
				}
			}
		};
		t2.start();
		t1.start();
		t2.join();
		t1.join();
		t3.start();
	}

}
