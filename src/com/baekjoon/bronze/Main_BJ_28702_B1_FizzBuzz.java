package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_28702_B1_FizzBuzz {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int numA = 0;
		int numB = 0;
		int numC = 0;
		int result = 0;
		if(!check(a)){
			numA = Integer.parseInt(a);
			result = numA +3;
		}
		if(!check(b)){
			numB = Integer.parseInt(b);
			result = numB +2;
		}
		if(!check(c)){
			numC = Integer.parseInt(c);
			result = numC +1;
		}

		if(result%3!=0 && result%5!=0){
			System.out.println(result);
		} else if(result%3==0 && result%5!=0){
			System.out.println("Fizz");
		} else if(result%3!=0 && result%5==0){
			System.out.println("Buzz");
		} else {
			System.out.println("FizzBuzz");
		}
	}

	static boolean check(String s){
		if(s.contains("Fizz") || s.contains("Buzz")) return true;
		return false;
	}
}
