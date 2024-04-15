package com.programmers;

public class Solution_PG_L1_문자열내p와y의개수 {
	public static void main(String[] args) throws Exception {
		System.out.println(solution("pPoooyY"));
	}

	static boolean solution(String s) {
		int pCnt = 0;
		int yCnt = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pCnt++;
			if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yCnt++;
		}

		if(pCnt==yCnt || (pCnt == 0 && yCnt == 0)) return true;
		else return false;
	}
}
