package javau;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class VectorTest {
	private Vector<Integer> v;
	private Hashtable<Object, Boolean> h;
	public Vector<Integer> getV() {
		return v;
	}
	
	public Hashtable<Object, Boolean> getH() {
		return h;
	}

	public void setH(Hashtable<Object, Boolean> h) {
		this.h = h;
	}

	public void setV(Vector<Integer> v) {
		this.v = v;
	}
	public void add(){
		v = new Stack<Integer>();
		for (int i = 0; i <100; i++) {
			v.add(i);
		}
		for(int j = 0;j<10;j++){
			v.remove(j);
		}
		for(Integer t : v){
			System.out.println(t);
		}
		h.put("", true);
		h.contains("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VectorTest a = new VectorTest();
		a.add();
	}

}
