package demo.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MyImmutable {

	private final String str;
	private final int id;
	private final List<String> list;

	public MyImmutable(String str, int id,List<String> list) {

		this.str = str;
		this.id = id;
		this.list=list;
		
	}

	public List<String> getList() {
		return list;
	}

	public String getStr() {
		return str;
	}

	public int getId() {
		return id;
	}

	public MyImmutable modifyStr(String str) {
		if (this.str.equals(str))
			return this;
		else
			return new MyImmutable(str, 100,new ArrayList<>());

	}

	public static void main(String args[])

	{
		Map<String, Integer> map = new HashMap();
		map.put("hello", 1);
		map.put("hell2o", 2);
		map.get("hello");

		System.out.println("Map is:" + map);
		MyImmutable obj = new MyImmutable("Chetan", 1,new ArrayList<>());
		
          
		obj.getList().add("Chetan");

		System.out.println("Str is:" + obj.getStr() + " Id is:" + obj.getId() + " HashCode:" + obj.hashCode()+"List is:"+obj.getList());

		MyImmutable obj2 = obj.modifyStr("Chetan");

		System.out.println("Str is:" + obj2.getStr() + " Id is:" + obj2.getId() + " HashCode:" + obj2.hashCode()+"List is:"+obj2.getList());

		MyImmutable obj3 = obj.modifyStr(obj.getStr() + " bagale");

		System.out.println("Str is:" + obj3.getStr() + " Id is:" + obj3.getId() + " HashCode:" + obj3.hashCode()+"List is:"+obj3.getList());

	}

}
