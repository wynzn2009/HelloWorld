package javau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lift {
	private Player[] p= new Player[100];
	public void Lift1(){
		for(int i=0;i<100;i++){
			p[i] = new Player();
		}
		Arrays.sort(p);
	}
	public void printP(){
		for(Player t:p){
			System.out.println(t.getHeight()+"  "+t.getWeight());
		}
	}
	public void resort(){
		ArrayList<Con> list = new ArrayList<Con>();
		for(int i=0;i<p.length;i++){
			int Min = 0;
			int Max = p[i].getWeight();
			int id = -1;
			for(int j=0;j<i;j++){
				if(list.get(j).Compare(Max, Min)){
					Min = list.get(j).getLength();
					id = j;
				}
			}
			if(id==-1){
				list.add(new Con(i, Max));
			}else{
				list.add(new Con(i, Max, list.get(id)));
			}
		}
		Collections.sort(list);
		Con c = list.get(list.size()-1);
		System.out.println(c.getLength());
		List<Integer> l = c.getList();
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i)+"--"+p[l.get(i)].getHeight()+"&&"+p[l.get(i)].getWeight());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lift l = new Lift();
		l.Lift1();
		l.printP();
		l.resort();
	}
	class Con implements Comparable<Con>{
		private int MaxNum = 0;
		private int id = 0;
		private ArrayList<Integer> list = new ArrayList<Integer>();
		private int length = 0;
		
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public int getMaxNum() {
			return MaxNum;
		}
		public void setMaxNum(int maxNum) {
			MaxNum = maxNum;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public ArrayList<Integer> getList() {
			return list;
		}
		public void setList(ArrayList<Integer> list) {
			this.list = list;
		}
		public Con(int id,int MaxNum){
			this.id = id;
			this.MaxNum = MaxNum;
			list.add(id);
			this.length = 1;
		}
		public Con(int id,int MaxNum,Con con){
			this.id = id;
			this.MaxNum = MaxNum;
			list.addAll(con.getList());
			list.add(id);
			this.length = con.getLength()+1;
		}
		public boolean Compare(int Max,int Min){
			if(this.MaxNum<Max&&this.length>Min){
				return true;
			}else{
				return false;
			}
		}
		@Override
		public int compareTo(Con o) {
			// TODO Auto-generated method stub
			return this.length-o.getLength();
		}
	}
}