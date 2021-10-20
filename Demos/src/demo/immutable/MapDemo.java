package demo.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Employee
{
	private int id;
	private String name;
	
	public Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	}
public class MapDemo {
	
	Map<Integer,Integer> map=new HashMap<>();
	
	public void addSalary(Employee emp, Integer sal)
	{
		map.put(emp.getId(), sal);
	}
	public void findSal(Employee emp)
	{
		for(Map.Entry<Integer,Integer> mapEntry:map.entrySet())
		{
			if(mapEntry.getKey().equals(emp.getId()))
					System.out.println("Salary:"+mapEntry.getValue());
			
		}
	
	}
	public void findSal2(Employee emp)
	{
		Iterator<Entry<Integer, Integer>> it=map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Integer, Integer> entry=it.next();
			
			if(entry.getKey().equals(emp.getId()))
				System.out.println("Emp Name:"+emp.getName()+" Emp Id:"+emp.getId()+" Salary:"+entry.getValue());
		
		}
		
	}


	public static void main(String[] args) {
		
		MapDemo obj=new MapDemo();
		
		Employee e1=new Employee(1,"Chetan");
		Employee e2=new Employee(2,"Ashwini");
		Employee e3=new Employee(3,"Maya");
		Employee e4=new Employee(4,"Sachin");
		Employee e5=new Employee(5,"Rahul");
		
		obj.addSalary(e1, 200000);
		obj.addSalary(e2, 400000);
		obj.addSalary(e3, 800000);
		obj.addSalary(e4, 600000);
		obj.addSalary(e5, 500000);
		
		
		obj.findSal2(e5);
		 List<Integer> li = new ArrayList<>();
	        int i = 10;
	        li.add(10);
	        int j = li.get(0);
	        System.out.println(j);
		
		

	}

}
