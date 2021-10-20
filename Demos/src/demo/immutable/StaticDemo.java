package demo.immutable;

class Base {
	
	public static void m1()
	{
		System.out.println("Static Method in Base Class");
	}
	
	public  void m2()
	{
		System.out.println("m2() Method in Base Class");
	}
}

class Derrived extends Base {
	
	public static void m1()
	{
		System.out.println("Static Method in Derrived Class");
	}
	public  void m2()
	{
		System.out.println("m2() Method in Derrived Class");
	}
}

public class StaticDemo {
	public static void main(String[] args) {
		
		Base base=new Derrived();
		Base.m1();
		Derrived derrived=new Derrived();
		Derrived.m1();
		
		Base base1=new Base(); 
		
		base.m2();
		base1.m2();
		
	}

}
