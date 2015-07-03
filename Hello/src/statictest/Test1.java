package statictest;

public class Test1 {
    Person person = new Person("Test");
    static{
        System.out.println("1");
    }
     
    public Test1() {
        System.out.println("2");
    }
     
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person{
    static{
        System.out.println("3");
    }
    public Person(String str) {
        System.out.println("4 "+str);
    }
}
 
 
class MyClass extends Test1 {
    Person person = new Person("MyClass");
    static{
        System.out.println("5");
    }
     
    public MyClass() {
        System.out.println("6");
    }
}
