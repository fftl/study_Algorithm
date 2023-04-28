package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_07682_G5_틱택토 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			
			if(str.equals("end")) {
				System.out.println(sb.toString().trim());
				return;
			}
			
			if(check(str))sb.append("valid\n");
			else sb.append("invalid\n");
		}
	}
	
	static boolean check(String str) {
		int oCnt = 0;
		int xCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'X') xCnt++;
			if(str.charAt(i) == 'O') oCnt++;
		}
		
		
		if(oCnt == xCnt) {
			boolean oYes = false;
			boolean xYes = false;
			for (int i = 0; i < 3; i++) {
				if(str.charAt(i) == str.charAt(i+3) && str.charAt(i+3) == str.charAt(i+6) && str.charAt(i) == 'O') oYes = true;
				if(str.charAt(i) == str.charAt(i+3) && str.charAt(i+3) == str.charAt(i+6) && str.charAt(i) == 'X') xYes = true;
			}
			
			if(oYes && !xYes) return true;
			
			oYes = false;
			xYes = false;
			for (int i = 0; i < 3; i++) {
				if(str.charAt(i*3) == str.charAt(i*3+1) && str.charAt(i*3+1) == str.charAt(i*3+2) && str.charAt(i*3) == 'O') oYes = true;
				if(str.charAt(i*3) == str.charAt(i*3+1) && str.charAt(i*3+1) == str.charAt(i*3+2) && str.charAt(i*3) == 'X') xYes = true;				
			}
			if(oYes && !xYes) return true;
			
			
			if(str.charAt(0) == str.charAt(4) && str.charAt(4) == str.charAt(8) && str.charAt(4) == 'O') return true;
			if(str.charAt(2) == str.charAt(4) && str.charAt(4) == str.charAt(6) && str.charAt(4) == 'O') return true;
			
		} else if(oCnt+1 == xCnt) {
			
			boolean oYes = false;
			boolean xYes = false;
			for (int i = 0; i < 3; i++) {
				if(str.charAt(i) == str.charAt(i+3) && str.charAt(i+3) == str.charAt(i+6) && str.charAt(i) == 'O') oYes = true;
				if(str.charAt(i) == str.charAt(i+3) && str.charAt(i+3) == str.charAt(i+6) && str.charAt(i) == 'X') xYes = true;
				if(xCnt+oCnt==9 && oYes) return false;
			}
			if(!oYes && xYes) return true;
			
			oYes = false;
			xYes = false;
			for (int i = 0; i < 3; i++) {
				if(str.charAt(i*3) == str.charAt(i*3+1) && str.charAt(i*3+1) == str.charAt(i*3+2) && str.charAt(i*3) == 'O') oYes = true;
				if(str.charAt(i*3) == str.charAt(i*3+1) && str.charAt(i*3+1) == str.charAt(i*3+2) && str.charAt(i*3) == 'X') xYes = true;
				if(xCnt+oCnt==9 && oYes) return false;
			}
			if(!oYes && xYes) return true;
			
			if(str.charAt(0) == str.charAt(4) && str.charAt(4) == str.charAt(8) && str.charAt(4) == 'X') return true;
			if(str.charAt(2) == str.charAt(4) && str.charAt(4) == str.charAt(6) && str.charAt(4) == 'X') return true;

			if(xCnt+oCnt==9 && str.charAt(0) == str.charAt(4) && str.charAt(4) == str.charAt(8) && str.charAt(4) == 'O') return false;
			if(xCnt+oCnt==9 && str.charAt(2) == str.charAt(4) && str.charAt(4) == str.charAt(6) && str.charAt(4) == 'O') return false;
			if(xCnt+oCnt==9) return true;
		}
		
		return false;
	}
}
