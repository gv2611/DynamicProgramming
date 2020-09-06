package com.dynamicprogramming.example;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance edit = new EditDistance();
		String source="insertion";
		String target ="execution";
		int source_length=source.length(), target_length=target.length();
		int output=edit.editDistDP(source, target, source.length(), target.length());
		System.out.println(output);
		//System.out.println(edit.findEditDistance(source,target,source_length,target_length));
 	}

	private int findEditDistance(String source, String target, int source_length, int target_length) {
		
		if(source_length==0)
			return target_length;
		if(target_length==0)
			return source_length;
		if(source.charAt(source_length-1) == target.charAt(target_length-1))
			return findEditDistance(source, target, source_length-1, target_length-1);
		
		return 1+ min(findEditDistance(source,target,source_length, target_length-1),
				findEditDistance(source, target, source_length-1, target_length),
				findEditDistance(source, target, source_length-1, target_length-1));
		
		
		
	}
	
	static int editDistDP(String str1, String str2, int m, int n) 
    { 
        // Create a table to store results of subproblems 
        int dp[][] = new int[m + 1][n + 1]; 
  
        // Fill d[][] in bottom up manner 
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                // If first string is empty, only option is to 
                // insert all characters of second string 
                if (i == 0) 
                    dp[i][j] = j; // Min. operations = j 
  
                // If second string is empty, only option is to 
                // remove all characters of second string 
                else if (j == 0) 
                    dp[i][j] = i; // Min. operations = i 
  
                // If last characters are same, ignore last char 
                // and recur for remaining string 
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1]; 
  
                // If the last character is different, consider all 
                // possibilities and find the minimum 
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert 
                                       dp[i - 1][j], // Remove 
                                       dp[i - 1][j - 1]); // Replace 
            } 
        }
		print2DArray(dp);
  
        return dp[m][n]; 
    } 

	private static int min(int x, int y, int z) {
		if(x<y && x<z)
			return x;
		if(y<x && y<z)
			return y;
		else
			return z;
		//return z;
	}
	
	public static void print2DArray(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
	}

}
