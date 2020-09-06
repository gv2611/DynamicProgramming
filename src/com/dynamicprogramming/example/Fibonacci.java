package com.dynamicprogramming.example;

import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		HashMap <Integer, Long> hm= new HashMap <Integer,Long>();
		Fibonacci fibo = new Fibonacci();
		System.out.println(fibo.fibonacciSeries(1000,hm));
		//System.out.println(fibo.uglyNumber(149));
		

	}

	private long fibonacciSeries(int n, HashMap<Integer, Long> hm) {
		if(hm.containsKey(n))
			return hm.get(n);
		if(n<=1)
		{
			return n;
		}
		long val=fibonacciSeries(n-1,hm) + fibonacciSeries(n-2,hm);
		hm.put(n, val);
		return val;
		
	}
	
	private int uglyNumber(int n)
	{
		if(n>=1 && (n%2==0 || n%3==0 || n%5 ==0))
		{
			return n;
		}
		
		return uglyNumber(n-1);
	}

}
