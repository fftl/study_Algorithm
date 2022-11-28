package com.bj.silver;

import java.util.*;

public class Main_BJ_01463_S3_1로만들기 {
    
    static int go(int num){
        
		int[] dp = new int[num+1];
		
		for(int i=2; i<num+1; i++) {
			dp[i] = dp[i-1]+1; // -1 
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		return dp[num];
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(go(n));
    }
}