package com.programmers;

import java.util.Arrays;

public class Solution_PG_L1_k_비밀지도 {
	static int size;
    static String convert(int num){
        String result = "";
        while(num>0){
            result += num%2;
            num /= 2;
        }
        
        StringBuilder sb = new StringBuilder(result);
        while(sb.length()<size){
            sb.append("0");
        }
        
        return sb.reverse().toString();
    }

	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}

	static String[] solution(int n, int[] arr1, int[] arr2) {
        size = n;
        
        String[] board1 = new String[n];
        String[] board2 = new String[n];
        
        for(int i=0; i<n; i++){
            board1[i] = convert(arr1[i]);
        }
        
        for(int i=0; i<n; i++){
            board2[i] = convert(arr2[i]);
        }
        
        
        String[] result = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                int a = board1[i].charAt(j)-'0';
                int b = board2[i].charAt(j)-'0';
                if(a+b>0) sb.append("#");
                else sb.append(" ");
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}
