package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01343_S5_폴리오미노 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
 
        String res = "";
 
        res = poliomino(s);
 
        System.out.println(res);
    }
 
		    private static String poliomino(String s) {
        String ans = "";
        String A = "AAAA", B = "BB";
        
        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);

        if(ans.contains("X")) {
            ans = "-1";
        }
 
        return ans;
    }
}
