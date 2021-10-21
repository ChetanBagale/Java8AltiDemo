package demo.immutable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Emp {
	private String name;
	private int empId;

	public Emp(String name, int empId) {

		this.name = name;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", empId=" + empId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("Hash Code is:" + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class HashCodeEqualsDemo {

	public static void main(String[] args) {

		Map<Emp, String> map = new HashMap<>();
		map.put(new Emp("Chetan", 101), "Chetan");
		map.put(new Emp("Chetn", 101), "Chetan");
		map.put(new Emp("Chetan", 101), "Chetan");
		map.put(new Emp("Chetan", 101), "Chetan");

		Iterator<Entry<Emp, String>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Emp, String> entry = iterator.next();
			System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());

		}

	}

}
