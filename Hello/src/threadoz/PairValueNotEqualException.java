package threadoz;

class Pair{
	private int x,y;
	public Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Pair(){
		this(4,4);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void incrementX(){
		x++;
	}
	public void incrementY(){
		y++;
	}
	public String toString(){
		return "x:"+x+",y:"+y;
	}
	public class PairValueNotEqualException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public PairValueNotEqualException(){
			super("Pair values not equal:"+Pair.this);
		}
	}
	public void checkState(){
		if(x!=y){
			throw new PairValueNotEqualException();
		}
	}
}
