package com.swexpertacademy;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_SW_D3_01289_원재의메모리복구하기 {

	static char[] my;
	
	static void change(int sIdx) {
		for (int i = sIdx; i < my.length; i++) {
			my[i] = (my[i] == '1') ? '0' : '1';
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("res/input_1289.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
			my = new char[s.length()];
			for(int i=0; i<s.length(); i++) {
				my[i] = '0';
			}
			
			
			int result = 0;
			for(int i=0; i<s.length(); i++) {
				if(my[i] != s.charAt(i)) {
					change(i);
					result++;
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}

}

