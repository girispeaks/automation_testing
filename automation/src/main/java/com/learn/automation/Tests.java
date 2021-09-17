package com.learn.automation;

import java.util.HashSet;
import java.util.Set;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> str = new HashSet<String>();
		str.add("Apple");
		str.add("Grapes");
		str.add("Mango");
		for(String fruits : str)
			System.out.println(fruits);
		

	}

}
