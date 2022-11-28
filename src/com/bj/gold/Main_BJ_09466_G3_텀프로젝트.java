package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2
7
1 2 3 4 5 6 7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8 
*/

public class Main_BJ_09466_G3_텀프로젝트 {
	static boolean[] nowVisited, totalVisited;
	static int n, result;
	static int[] arr;

	static void dfs(int n) {
		nowVisited[n] = true; //일단 n을 방문했음을 표시!
		int next = arr[n];	  //n의 다음값을 찾아줍니다.
		
		if(!nowVisited[next]) { //다음값을 아직 방문하지 않았다면 dfs를 더 들어가줍니다.
			dfs(next);
		
			/*
			idx  - 1 2 3 4 5 6 7
			data - 3 1 3 7 3 4 6
			*/
			
			//만약 이번 dfs 반복중에 next를 방문했었는데 전체방문 기록에는 없다면?(nowVisited[next] == true && totalVisited[next] == false)
			//루프가 성립! 이번 dfs를 돌면서 다시 next가 나왔다는 것.
			//예를 들면  '4' -> 7 -> 6 -> '4' ...
			//하지만 4, 7, 6은 이전 dfs들에서는 방문한 적이 없으므로 totalVisited는 모두 false 상태입니다.
			//즉 처음보는 팀입니다. 그러므로 처음보는 팀의 팀원수를 result에 추가해줍니다. 
			
		} else if(!totalVisited[next]) { 
			
			//지금 값과 next가 같다면 혼자팀!
			if(next == n) {
				result++;
			} else {
				
				//혼자팀이 아니라면 next 부터 n까지 dfs를 돌려보면 연결이 되어있다는 것을 알 수 있습니다.
				//연결이 된 요소들을 모두 찾아 팀의 수를 세어줍니다.
				for (int num = next; num != n; num = arr[num]) {
					result++;
				}
				//본인도 팀의 수에 추가해줍니다.
				result++;
			}
			
		}
		
		//결론적으로 한번이라도 dfs를 겪은 n은 방문을 표시합니다.
		totalVisited[n] = true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		//데이터 입력..
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			nowVisited = new boolean[n + 1];
			totalVisited = new boolean[n + 1];
			result = 0;

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			//데이터 입력..
			
			//모든 arr 요소에 대하여 dfs를 실행해줍니다.
			for (int j = 1; j < arr.length; j++) {
				if(nowVisited[j]) continue;
				dfs(j);
			}
			
			//team에 포함된 사람의 수인 result를 총 사람수인 n에서 빼주어
			//팀에 포함되지 않은 사람의 수를 세어줍니다.
			System.out.println(n-result);
		}
	}

}
