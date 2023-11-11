package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_01620_S4_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//index를 key로하는 map과 문자열을 key로하는 맵을 각각 만들어서 데이터를 완성시켜줍니다.
		HashMap<String, Integer> strMap = new HashMap<>();
		HashMap<Integer, String> intMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			strMap.put(str, i);
			intMap.put(i, str);
		}
		
		//이제 문제를 풉니다.
		//출력이 여러줄이므로 StringBuilder를 이용해서 한번에 출력하는 방식을 생각했습니다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();						//이번 입력을 받고
			char first = str.charAt(0);						//첫글자를 char로 받아서
			if(Character.isDigit(first)) {					//숫자인지 아닌지를 판단합니다.
				sb.append(intMap.get(Integer.parseInt(str))+"\n");		//숫자가 맞다면 intMap에서 index로 접근하여 답을 찾아내고
			} else {
				sb.append(strMap.get(str)+"\n");//숫자가 아니라면 strMap에서 문자열으로 답을 찾아냅니다.
			}
		}
		
		//결과 출력!
		System.out.println(sb.toString().trim());
	}
}
