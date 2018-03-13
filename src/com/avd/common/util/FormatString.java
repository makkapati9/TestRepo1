package com.avd.common.util;

public class FormatString {
	
	public String formatString(String oldString){
		
		StringBuilder str = new StringBuilder(oldString);
		int idx = str.length() - 4;

		while (idx > 0)
		{
		    str.insert(idx, " ");
		    idx = idx - 4;
		}
		System.out.println("hello world");
		return str.toString();
	}

}
