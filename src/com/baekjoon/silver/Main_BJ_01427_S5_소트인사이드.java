package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_01427_S5_소트인사이드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//정렬이 빠르고 쉬운 Collections를 이용하기 위해서 ArrayList를 만들어 주었습니다.
		ArrayList<Character> arr = new ArrayList<>();
		String str = br.readLine();
		
		//받은 문자열을 arr에 추가해줍니다.
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.charAt(i));
		}
		
		//arr를 내림차순 정렬해줍니다.
		Collections.sort(arr, Collections.reverseOrder());
		
		//메모리를 효율적으로 사용할 수 있는 StringBuilder를 이용해 다시 문자열을 만들어줍니다.
		StringBuilder sb = new StringBuilder();
		for (Character character : arr) {
			sb.append(character);
		}
		
		//정답 출력!!
		System.out.println(sb.toString().trim());
	}
}
