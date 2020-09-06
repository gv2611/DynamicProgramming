package com.dynamicprogramming.example;

public class NumberOfWaysToDecode {
	
	
	private int numOfWays(String s) {
		int n = s.length();
		System.out.println("length= "+n);
        if(n==0) return 0;
        int ways[] = new int[n+1];
        System.out.println("length of ways = "+ways.length);
         
        ways[0]=1;
        ways[1] = s.charAt(0) !='0' ? 1:0;
        for(int i=2; i<=n; i++){
            if(s.charAt(i-1) !='0'){
                ways[i] = ways[i-1];
            }
            int val = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            System.out.println("val="+val);
            if(val<=26 && val>=10){
                ways[i] += ways[i-2];
            }
        }
        for(int i =0 ; i<ways.length;i++)
        {
        	System.out.println("val of ways at i="+i+" is "+ways[i]);
        }
        return ways[n];	
	}

	public static void main(String[] args) {
		NumberOfWaysToDecode decode = new NumberOfWaysToDecode();
		String str = "123";
		System.out.println(decode.numOfWays(str));
		
	}

	

}
