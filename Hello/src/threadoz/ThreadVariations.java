package threadoz;

import java.util.concurrent.TimeUnit;

class InnerThread1{
	private int count = 5;
	private Inner inner;
	private class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		public void run(){
			try{
				while(true){
					System.out.println(this);
					if(--count==0){
						return;
					}
					sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
		public String toString(){
			return getName()+" "+count;
		}
	}
	public InnerThread1(String name){
		inner = new Inner(name);
	}
}
class InnerThread2{
	private int count = 5;
	private Thread t;
	public InnerThread2(String name){
		t = new Thread(name){
			public void run(){
				try{
					while(true){
						System.out.println(this);
						if(--count==0){
							return;
						}
						sleep(10);
					}
				}catch(InterruptedException e){
					System.out.println("sleep() interrupted");
				}
			}
		};
		t.start();
	}
}
class InnerRunnable1{
	private int count = 5;
	private Inner inner;
	private class Inner implements Runnable{
		Thread t;
		Inner(String name){
			t = new Thread(this,name);
			t.start();
		}
		public void run(){
			try{
				while(true){
					System.out.println(this);
					if(--count==0){
						return;
					}
					TimeUnit.MILLISECONDS.sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println("sleep() interrupted");
			}
		}
		public String toString(){
			return t.getName()+" "+count;
		}
	}
	public InnerRunnable1(String name){
		inner = new Inner(name);
	}
}
class InnerRunnable2{
	private int count = 5;
	private Thread t;
	public InnerRunnable2(String name){
		t = new Thread(new Runnable(){
			public void run(){
				try{
					while(true){
						System.out.println(this);
						if(--count==0){
							return;
						}
						TimeUnit.MILLISECONDS.sleep(10);
					}
				}catch(InterruptedException e){
					System.out.println("sleep() interrupted");
				}
			}
			public String toString(){
				return Thread.currentThread().getName()+":"+count;
			}
		},name);
		t.start();
	}
}
//方法内部创建线程，线程准备好后可以执行，然后该方法将返回。该线程可以只执行辅助操作，而非类内部重要操作
class ThreadMethod{
	private int count = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name){
		this.name = name;
	}
	public void runTask(){
		if(t==null){
			t = new Thread(name){
				public void run(){
					try{
						while(true){
							System.out.println(this);
							if(--count ==0){
								return;
							}
							sleep(10);
						}
					}catch(InterruptedException e){
						System.out.println("sleep() interrupted");
					}
				}
				public String toString(){
					return getName()+":"+count;
				}
			};
			t.start();
		}
	}
}
public class ThreadVariations {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		new InnerThread2("InnerThread2");
		new InnerThread1("InnerThread1");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		 */
		new ThreadMethod("ThreadMethod").runTask();
	}

}
