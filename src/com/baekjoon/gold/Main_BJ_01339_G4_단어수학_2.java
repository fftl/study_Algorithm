package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//다른사람들의 풀이를 보았는데, 같은 생각을 하였지만
//짧은 코드를 통해서 같은 결과를 낸 사람들을 많이 보았다.
//조금더 효율적으로ㅠㅠ
public class Main_BJ_01339_G4_단어수학_2 {
	
	static class Value{
		char word;
		int val;
		public Value(char word, int val) {
			this.word = word;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//이미 숫자가 정의된 알파벳을 체크하기 위한 String 입니다.
		HashMap<Character, Integer> map = new HashMap<>();
		
		//문자들을 재사용하기 위해서 strs에 담아놓습니다.
		String[] strs = new String[N];
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			strs[i] = now;
			
			//strs의 각 자리수별로 가중치를 줘서 높은 수를 어떤 알파벳이 받아야할지를 판단합니다.
			//100의 자리는 +100, 십의 자리는 +10
			for (int j = 0; j < now.length(); j++) {
				char nowC = now.charAt(j);
				int gop = now.length()-1-j;
				int ten = 1;
				
				if(gop!=0) {
					while(gop>0) {
						ten *= 10;
						gop--;
					}					
				}
				
				if(!map.containsKey(nowC)) {
					map.put(nowC, ten);
				} else {
					map.put(nowC, map.get(nowC)+ten);
				}
			}
		}
		
		//HashMap을 내림차순으로 표현하기 위해서 ArrayList에 담아주었고,
		//이를 가중치를 기준으로 내림차순 해주었습니다.
		ArrayList<Value> arr = new ArrayList<>(); 
		for (char c : map.keySet()) {
			arr.add(new Value(c, map.get(c)));
		}
		
		Collections.sort(arr, new Comparator<Value>() {
			@Override
			public int compare(Value a, Value b) {
				return b.val-a.val;
			}
		});
		
		//내림차순 되어있는 arr에 각각의 9부터 수를 부여해줍니다.
		int num = 9;
		HashMap<Character, Integer> res = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			res.put(arr.get(i).word, num);
			num--;
		}
		
		//마지막으로 strs를 다시 돌며 알파벳문자열을 숫자 문자열로 변환해준 뒤
		//result에 더해주어 답을 구합니다!!
		int result = 0;
		for (int i = 0; i < strs.length; i++) {
			String now = strs[i];
			String sNum = "";
			for (int j = 0; j < now.length(); j++) {
				sNum += res.get(now.charAt(j));
			}
			result += Integer.parseInt(sNum);
		}
		
		System.out.println(result);
	}
}
