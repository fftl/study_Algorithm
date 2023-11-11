package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_01764_S4_듣보잡 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		//먼저 맵을 만든 뒤 듣도 못한 사람의 명단을 모두 담아줍니다.
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < d; i++) {
			String now = br.readLine();
			map.put(now, 1);
		}
		
		//이후 보도 못한 사람의 명단을 확인하며 이미 이름이 들어있는 사람일 경우에만
		//수를 추가해주는 방식을 사용합니다.
		for (int i = 0; i < b; i++) {
			String now = br.readLine();
			if(map.containsKey(now)) {
				map.put(now, map.get(now)+1);
			}
		}

		//위의 과정을 통해서 만들어진 map에서 value를 2 가진 사람 즉 듣도 보도 못한 사람의 이름만
		//list에 담아줍니다.
		ArrayList<String> list = new ArrayList<>();
		for(String name : map.keySet()) {
			if(map.get(name)==2) list.add(name);
		}
		
		//듣도보도 못한 사람 리스트를 사전순으로 정렬해줍니다.
		Collections.sort(list);
		
		//사람 수를 먼저 담아주고, 이름을 차례로 담아줍니다.
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()+"\n");
		for(String name : list) {
			sb.append(name+"\n");
		}
		
		//결과물 출력!
		System.out.println(sb.toString().trim());
	}
}
