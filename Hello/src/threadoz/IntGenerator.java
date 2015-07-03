package threadoz;

public abstract class IntGenerator {
	private volatile boolean canceled = false;
	public abstract int next();
	public void cancel(){
		canceled = true;
	}
	public boolean isCanceled(){
		return canceled;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
