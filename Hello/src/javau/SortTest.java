package javau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.stream.FileImageInputStream;

public class SortTest implements Comparable<SortTest>{
	private int sort ;
	public SortTest(int a){
		this.sort = a;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		SortTest[] y = new SortTest[12];
//		for(int i=0;i<12;i++){
//			y[i] = new SortTest((int) (12*Math.random()));
//			System.out.println(y[i].sort);
//		}
//		Arrays.sort(y);
//		for(int i=0;i<12;i++){
//			System.out.println(y[i].sort);
//		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.addLast(4);
		list.addFirst(6);
		list.addFirst(9);
		Iterator<Integer> it = list.iterator();
		Collections.sort(list);
		while(it.hasNext()){
			Integer a = it.next();
			System.out.println(a);
		}
		int index = Collections.binarySearch(list, 6);
		System.out.println(index);
		File file = new File("D:/a1.txt");
		//×Ö½Ú¶ÁÈ¡
		InputStream in = null;
		in = new FileInputStream(file);
		int temp;
		while((temp=in.read())!=-1){
			System.out.println(temp);
		}
		in.close();
		
		Reader reader = null;
		reader = new InputStreamReader(new FileInputStream(file));
		int temp2;
		while((temp2 = reader.read())!=-1){
			if(((char)temp2)!='\r'){
				System.out.println((char)temp2);
			}
		}
		reader.close();
		
		BufferedReader readers = null;
		readers = new BufferedReader(new FileReader(file));
		String tempString  = null;
		int line = 1;
		while((tempString = readers.readLine())!=null){
			System.out.println(tempString);
			line++;
		}
		readers.close();
		
	}
	
	@Override
	public int compareTo(SortTest o) {
		// TODO Auto-generated method stub
		if(o==null)return -1;
		if(o.sort==sort){
			return 0;
		}else{
			return this.sort - o.sort;
		}
	}
}
