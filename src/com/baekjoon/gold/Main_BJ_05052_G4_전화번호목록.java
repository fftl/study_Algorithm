package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//문제가 뭔가  테스트케이스가 50개에 10000개의 전화번호 이다보니까
//10000*10000 은 1억이고, 50번의 테케라서 시간초과가 나올수 있지 않을까 했지만
//전화번호는 모두 다르고, 길어야 10자리 라는 것에서 같은 길이의 전화번호는 모두 탐색을
//하지 않아도 된다고 생각하니 시간이 충분하다고 생각하여 풀이를 그렇게 했습니다.
//현재에는 if else를 통해서 길이를 확인해서 시간초과를 피했지만
//각 전화번호 길이가 시작되는 인덱스를 기억해서 한다면 더 줄일 수 있을 것이라 생각하긴 합니다.
public class Main_BJ_05052_G4_전화번호목록 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		//테스트 케이스마다 전화번호를 입력받습니다.
		r : for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> arr = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				arr.add(br.readLine());
			}
			
			//전화번호 길이순으로 리스트를 정렬해줍니다.
			Collections.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String a, String b) {
					return a.length()-b.length();
				}
			});
			
			//같은 길이의 전화번호는 바로 continue 하고,
			//길이가 더 긴 전화번호는 startWith를 통해서 확인합니다.
			//접두어를 발견하면 바로 이 테스트케이스를 종료합니다.
			for (int i = 0; i < n; i++) {
				String now = arr.get(i);
				int len = now.length();
				for (int j = i+1; j < n; j++) {
					if(arr.get(j).length() == len) continue;
					if(arr.get(j).startsWith(now)) {
						System.out.println("NO");
						continue r;
					}
				}
			}
			
			//for문을 도는동안 접두어가 발견되지 않는다면 YES!!
			System.out.println("YES");
		}
	}
}
