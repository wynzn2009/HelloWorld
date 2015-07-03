package statictest;

public class NULL {
	public int i = 0;
	public static transient int t=0;
	public static void a(){
		System.out.println("SB");
	}
	public void b(NULL n) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		n.i = 6;
		n = new NULL();
		n.i = 3;
		NULL a = (NULL) Class.forName("NULL").newInstance();
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		((NULL)null).a();
		String a = "1234";
		String b = "12" + "34";
		System.out.println(a==b);
		String c = "123456";
		String d = a.concat("56");
		d = d.intern();
		System.out.println(c==d);
		String e = "124356";
		String f = c.replace("34", "43");
		f = f.intern();
		System.out.println(e==f);
		String g = a.substring(0, 1);
		String h = "1";
		g = h.intern();
		System.out.println(g==h);
		NULL n = new NULL();
		NULL nu = new NULL();
		nu.b(n);
		System.out.println(n.i);
	}

}
