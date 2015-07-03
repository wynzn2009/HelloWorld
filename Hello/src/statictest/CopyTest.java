package statictest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class CopyTest implements Cloneable{
	class Foo{
		public int t = 0;
	}
	private int i = 0;
	private Date f = new Date();
	public Object clone(){
		try {
			CopyTest a = (CopyTest) super.clone();
			a.f = (Date) f.clone();
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyTest f = new CopyTest();
		CopyTest b = (CopyTest) f.clone();
		f.f = new Date(123);
		System.out.println(b.f+"   "+f.f);
		Foo ed = f.new Foo();
	}

}
