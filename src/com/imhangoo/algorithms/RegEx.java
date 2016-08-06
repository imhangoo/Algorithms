package com.imhangoo.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx{
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("a.+?d");
		Matcher matcher = pattern.matcher("a4d");
		if(matcher.find())
		  System.out.println(matcher.group(0));
		}
	}
	


