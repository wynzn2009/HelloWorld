package pandc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ty {
	private static int i = 1;
	private static String s = "123";
	private String b = "r";
	public Ty(){
		i=2;
		s = "a";
		System.out.println(i);
		System.out.println(s);
	}
	{
		System.out.println(b);
		i = 3;
		System.out.println(i);
	}
	static{
		System.out.println(s);
		i = 4;
		System.out.println(i);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ty a = new Ty();
		
	}

}
