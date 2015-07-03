package statictest;

public class Test extends Base{
	static{
		System.out.println("Test static");
	}
	public Test(){
		System.out.println("Test constructor");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}
	
}
class Base{
	static{
		System.out.println("Base static");
	}
	public Base(){
		System.out.println("Base constructor");
	}
}
