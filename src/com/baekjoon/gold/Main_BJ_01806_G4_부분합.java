package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01806_G4_부분합 {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		//입력을 받습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		//모든 수를 더해도 S를 넘지 못하는지를 확인하기위한 allSum입니다.
		int allSum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			allSum += arr[i];
		}
		
		//투포인터를 사용하기 위한 start, end 각 s, e입니다.
		int s = 0;
		int e = 0;
		
		//최소값을 구해야하기 때문에 시작은 생각할 수 있는 최대값인 N으로 설정해놓고 탐색을 시작합니다.
		int result = N;
		
		//첫번째 숫자 하나만을 가지고 연석된 수의 합을 탐색하기 시작합니다.
		int nowSum = arr[0];
		
		//시작인덱스가 N까지 도달할 때 까지 반복합니다.
		while(s<N) {
			
			//만일 현재의 nowSum이 S이상이 되었다면 현재 길이를 저장해줍니다.(이번에 증가시킨 arr[N]의 크기 덕에 S를 넘었다고 볼 수 있다.)
			if(nowSum>=S) {
				result = Math.min(result, (e-s)+1); //현재의 길이를 저장해주고
				if(result == 1) break;			    //만약 저장한 길이가 1이라면 이보다 작을 수 없기에 바로 종료시켜줍니다.
				else {	//1이 아니었다면, 시작인덱스 s를 뒤로 한칸 미루어서 이래도 S를 넘을 수 있는지 판단합니다.
					nowSum -= arr[s];
					s++;
				}
			
			//만약 nowSum이 S이상이 되지 못하였다면 경우입니다.
			} else {
				//만약 종료인덱스가 arr의 마지막 인덱스를 넘지 않았다면
				if(e<N-1) {
					e++;	//종료인덱스를 증가시켜 주고 해당 수를 nowSum에 추가시켜줍니다.
					nowSum += arr[e];
				
				//종료 인덱스가 arr의 마지막 인덱스에 도달했는데 else 즉 nowSum이 S를 넘지 못했다면 반복을 종료해줍니다.
				//더이상 S를 넘을 수 없기 떄문에
				} else {
					break;
				}
			}
		}
		
		//시작할 때 담아놓은 allSum이 만약 S를 넘지 못했다면 result는 N그대로 일 것이기 때문에 그럴 경우엔 0을 출력해줍니다.
		//아니라면 직접 구한 resut를 출력합니다.
		if(allSum<S) System.out.println(0);
		else System.out.println(result);
	}
}
