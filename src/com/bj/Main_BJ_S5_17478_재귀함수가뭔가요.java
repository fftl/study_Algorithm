package com.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_S5_17478_재귀함수가뭔가요 {
	
	static StringBuilder sb;
	static int T;
	
	public static void make(int n) {
		if(n>T) return;
		
		String ds = "";
		for(int i=0; i<4*n; i++) {
			ds += "_";
		}
		
		if(n != T) {
			sb.append(ds+"\"재귀함수가 뭔가요?\"\n");
			sb.append(ds+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(ds+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(ds+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			make(n+1);
			sb.append(ds+"라고 답변하였지.\n");
		} else {
			sb.append(ds+"\"재귀함수가 뭔가요?\"\n");
			sb.append(ds+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(ds+"라고 답변하였지.\n");
		}
	}
	
	public static void main(String[] args) {
		
		//재귀 횟수를 받아줍니다. 숫자 하나만 받으니까 Scanner를 사용했습니다.
		Scanner sc = new Scanner(System.in);
		T  = sc.nextInt();
		
		//출력할 것이 많다보니 StirgBuilder 를 사용하는 것이 좋을 것 같았습니다.
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		make(0);
		System.out.println(sb.toString().trim());

		sc.close();
		
	}
}
