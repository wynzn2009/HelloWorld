package statictest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javau.Files;
class B{
	public int i=9;
}
public class FINAL {
	private final int a;
	private int b;
	private final B bb;
	public FINAL(){
		a = 0;
		b = a;
		b = 6;
		Integer c = a;
		bb = new B();
		B cc = bb;
		cc = new B();
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		try {
			Files f = (Files) Class.forName("javau.Files").newInstance();
			Files ff = (Files) Class.forName("javau.Files").newInstance();
			Class c = Class.forName("javau.Files");
			Constructor con = c.getDeclaredConstructor();
			con.setAccessible(true);
			Files fff = (Files) con.newInstance();
			System.out.println(f==ff);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
