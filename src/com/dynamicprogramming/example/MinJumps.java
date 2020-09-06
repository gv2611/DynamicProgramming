package com.dynamicprogramming.example;

public class MinJumps {

	public static void main(String[] args) {
		MinJumps min = new MinJumps();
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int arr2[] = { 1, 3, 6, 1, 0, 9 };
		int steps = min.minJumpsDP2(arr2);
		System.out.println();
		System.out.println(steps);
	}

	private int minJumps(int[] arr, int i) {
		int min = Integer.MAX_VALUE;
		if (i == arr.length - 1) {
			return 0;
		}
		for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
			min = findMin(min, minJumps(arr, j));
		}
		return min + 1;
	}

	private int findMin(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	private void printArray(int arr[]) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.print("]");
	}

	private int minJumpsDP2(int[] arr) {
		int n = arr.length;
		
		int dp[] = new int[arr.length];
		dp[n - 1] = 0;
		
		for (int i = n - 2; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			
			if (arr[i] > n - i - 1) {
				dp[i] = 1;
			} else {
				for (int j = i + 1; j < n && j <= i + arr[i]; j++) {
					dp[i] = Math.min(dp[i], dp[j]);
				}

				if (dp[i] != Integer.MAX_VALUE) {
					dp[i]++;
				}
			}
		}
		
		if (dp[0] == Integer.MAX_VALUE)
			return -1;
		else
			return dp[0];
	}
	
	private int minJumpsDP(int[] arr) {
		int min;
		int n = arr.length;
		int dp[] = new int[arr.length];
		dp[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] == 0)
				dp[i] = Integer.MAX_VALUE;
			else if (arr[i] > n - i - 1) {
				dp[i] = 1;
			} else {
				min = Integer.MAX_VALUE;
				for (int j = i + 1; j < n && j <= i + arr[i]; j++) {
					if (min > dp[j])
						min = dp[j];
				}

				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				} else
					dp[i] = min;
			}
		}
		printArray(dp);
		if (dp[0] == Integer.MAX_VALUE)
			return -1;
		else
			return dp[0];
	}
}
