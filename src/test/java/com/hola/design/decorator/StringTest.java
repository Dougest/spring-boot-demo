package com.hola.design.decorator;

public class StringTest {
	 public static void main(String[] args)  {
		char[] c1 = new char[]{'1','2'}; 
		Strings str1 =  new Strings(c1);
		char[] c2 = new char[]{'1','2'}; 
		String str2 = new String(c2);
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(System.lineSeparator());
	}
	 
}
