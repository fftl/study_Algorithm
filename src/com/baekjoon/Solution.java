package com.baekjoon;

import java.util.Arrays;

class Solution {
    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print != 0) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
     public static void main(String[] arg) {
    	 solution(321321543);
    	 String str = "A1";
    	 String[] test = str.split(" ");
    	 System.out.println(Arrays.toString(test));
    	}
}