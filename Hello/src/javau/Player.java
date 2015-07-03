package javau;

public class Player implements Comparable<Player>{
	private int height;
	private int weight;
	public Player(){
		height = (int) (200*Math.random());
		weight = (int) (100*Math.random());
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		
		return this.getHeight() - o.getHeight();
	}

}
