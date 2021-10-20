package demo.immutable;


class Animal
{
	private static Animal animal=new Animal();
	private Animal()
	{}
	
	public static Animal getInstance()
	{
		return animal;
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		
		
		Animal animal=Animal.getInstance();
		
		System.out.println("Animal Object is:"+animal);
		System.out.println("Animal Object is:"+Animal.getInstance());
		
		// TODO Auto-generated method stub

	}

}
