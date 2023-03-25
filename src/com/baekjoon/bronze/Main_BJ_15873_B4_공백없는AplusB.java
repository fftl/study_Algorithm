package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_15873_B4_공백없는AplusB {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int res = 0;
        for(int i=0; i<str.length(); i++){
            res += str.charAt(i)-'0';
        }
        System.out.println(res);
	}
}
