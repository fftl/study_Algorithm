package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_03954_G1_Brainfuck인터프리터 {

	static int m, c, i, p, cnt, cmdIdx;
	static int[] nums, loop, cmdCnt;
	static char[] cmds;
	static Stack<Check> check;
	static String input;

	//stack을 이용해 []의 위치를 알려줄 수 있는 배열을 만듭니다.

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); //배열 크기
			c = Integer.parseInt(st.nextToken()); //코드 크기
			i = Integer.parseInt(st.nextToken()); //입력 크기
			p = 0;	//포인터
			cnt = 0; //명령어 횟수 5000000번 넘으면??
			cmdIdx = 0;

			nums = new int[m];

			//코드를 하나씩 확인하며 Stack을 이용하 짝이되는 괄호들을 미리 찾습니다. loop 찾기
			cmds = new char[c];
			cmdCnt = new int[c];
			loop = new int[c];
			String str = br.readLine();
			Queue<Character> strs = new LinkedList<>();
			for (int j = 0; j <str.length(); j++) {
				strs.add(str.charAt(j));
			}

			cmds = str.toCharArray();
			check = new Stack<>();

			for (int j = 0; j < cmds.length; j++) {
				Check before = null;
				if(!check.isEmpty()) before = check.peek();
				if(cmds[j] == '['){
					if(before != null){
						if(before.c){	//괄호가 안닫히면 그냥 추가
							check.add(new Check(true, j));
						} else {		//괄호가 닫히면 꺼내면서 각자 연결해줍니다.
							loop[j] = before.idx;
							loop[before.idx] = j;
							check.pop();
						}
					} else {
						check.add(new Check(true, j));
					}
				} else if(cmds[j] == ']'){
					if(before != null){
						if(!before.c){	//괄호가 안닫히면 그냥 추가
							check.add(new Check(true, j));
						} else {		//괄호가 닫히면 꺼내면서 각자 연결해줍니다.
							loop[j] = before.idx;
							loop[before.idx] = j;
							check.pop();
						}
					} else {
						check.add(new Check(true, j));
					}

				}
			}
			//loop 찾기 끝

			input = br.readLine();
			boolean yes = false;
			run : while(cnt<50000000){
				if(cmdIdx >= c) {
					yes = true;
					break;
				}

				char nCmd = cmds[cmdIdx];
				switch (nCmd){
					case '-':
						int aNum = nums[p]-1;
						if(aNum<0) nums[p] = 255;
						else nums[p] = aNum;

						break;

					case '+':
						nums[p] = (nums[p]+1)%256;
						break;

					case '<':
						if(p-1 < 0) p = m-1;
						else p--;
						break;

					case '>':
						p = (p+1) % m;
						break;

					case '[':
						if(nums[p] == 0){
							cmdCnt[cmdIdx]++;
							cmdCnt[loop[cmdIdx]]++;
							cmdIdx = loop[cmdIdx];
						}

						break;
					case ']':
						if(nums[p] != 0){
							cmdCnt[cmdIdx]++;
							cmdCnt[loop[cmdIdx]]++;
							cmdIdx = loop[cmdIdx];
						}
						break;
					case '.':
						break;
					case ',':
						if(strs.isEmpty()) nums[p] = 255;
						else nums[p] = strs.poll();
						break;
				}
				cnt++;
				cmdIdx++;
			}

			if(yes) {
				System.out.println("Terminates");

			} else {
				int val = 0;
				int valIdx = 0;
				for (int j = 0; j < cmdCnt.length; j++) {
					if(val<cmdCnt[j]){
						val = cmdCnt[j];
						valIdx = j;
					}
				}
				System.out.println("Loops "+valIdx+" "+loop[valIdx]);
			}
		}
	}

	static class Check{
		boolean c;
		int idx;
		public Check(boolean c, int idx){
			this.c = c;
			this.idx = idx;
		}
		public String toString(){
			return c+" "+idx;
		}
	}
}