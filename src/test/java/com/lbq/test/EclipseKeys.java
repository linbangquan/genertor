package com.lbq.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class EclipseKeys {

	public final double PI = 3.14;
	public static void main(String[] args) {
		String s = new String();
		String string = new String();
		Date date = new Date();
		HashMap map = new HashMap();
		int num = 1;
		ArrayList testList11 = new ArrayList();

		testList11.add(123);
		testList11.add(123);
		testList11.add(123);
		testList11.add(123);
		testList11.add(123);
		testList11.add(123);
		testList11.add(123);
		testList11.add(456);
		testList11.add(456);
		testList11.add(123);
		
		String string2 = new String();
	}

}

class Keys{
	public int id;
	public String name;
	
	public Keys() {
		super();
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
	@Override
	public String toString() {
		return "Keys [id=" + id + ", name=" + name + "]";
	}
	
	
}
