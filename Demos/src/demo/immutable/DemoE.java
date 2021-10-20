package demo.immutable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;


public class DemoE {

	
	String col;
	
	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="ChetanBagale1";
		
		String s="";
		System.out.println(s!=null);
		System.out.println(str.substring(1));
		
		DemoE obj1=new DemoE();
		obj1.setCol("Chetan Bagale");
		
		DemoE obj2=obj1;
		obj2.setCol("Chetan");
		System.out.println(obj1.getCol()+"  "+obj2.getCol());
		int i=0;
		i=i+++i;
		System.out.println("I="+i);
		bar();
		
		int count=1;
		
		while(count<=15)
		{
			System.out.println(count%2==1?"*":"?");
			count++;
		}

	}
	
	public static int foo(int a,String s)
	{
		s="Yello";
		a=a+2;
		return a;
	}
	public static void bar()
	{
		int a=3;
		String s="bluw";
		a=foo(a, s);
		System.out.println(a+" "+s);
		Integer.parseInt("11");
				
		
	
		
		
	}


}
