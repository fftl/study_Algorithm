package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이 문제는 모든 테스트케이스를 각각 판단하면 무조건 시간초과가 나오는 입력이 주어집니다.
//그렇기 때문에 미리 모든 팰린드롬의 여부를 미리 구해놓고 문제에 접근해야 했습니다.
//저는 바로 답을 생각하지 못했기 때문에 풀이를 보고 이해하게 되었습니다. 
public class Main_BJ_10942_G4_팰린드롬 {

	// dp 배열은 dp[a][b] 라고 하면 a ~ b 까지의 수가 팰린드롬을 이루면 true를 담아줄 dp 배열입니다.
	static boolean[][] dp;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		// 일단 arr배열에 팰린드롬을 판단할 데이터를 넣어줍니다.
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 이제 makeDP 함수를 통해서 모든 팰린드롬의 경우를 확인합니다.
		makeDP();

		// makeDP를 이용해서 모든 팰린드롬을 찾았다면 이제 주어지는 테스트케이스를 가지고
		// 주어지는 테스트케이스를 대입하여 팰린드롬 여부를 판단합니다.
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (dp[s][e])
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}

		System.out.println(sb.toString().trim());
	}

	// 나올수 있는 모든 dp를 찾아냅니다.
	static void makeDP() {

		// dp 배열을 초기화 해줍니다.
		dp = new boolean[N + 1][N + 1];

		// 일단 길이가 1일때, 2일떄를 판단해줍니다.
		// 길이가 1 일때 (dp[1][1] 과 같은 경우)는 숫자가 하나이므로 무조건 팰린드롬입니다.
		// 길이가 2 일떄는 두 수가 같다면 팰림드롬입니다. 이를 바탕으로 dp를 생성해줍니다.
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
			if (arr[i - 1] == arr[i])
				dp[i - 1][i] = true;
		}

		// 이제는 위에서 만들어놓은 정보를 이용해 길이가 3 이상일떄를 판단합니다.
		// 시작점, 끝점의 수가 같고 그 안의 수들이 팰린드롬을 이룬다면 이 수열은 팰린드롬을 이루는 것을 이해한다면
		// 문제를 풀 수 있게됩니다.
		int len = 3;
		while (len <= N) {
			int s = 1;
			for (int i = len; i <= N; i++) {
				// 시작점 끝점의 수가 같고, 그 안의 수가 팰린드롬을 이룬다면 arr[s][i]는 팰린드롬을 이룹니다.
				if (arr[s] == arr[i] && dp[s + 1][i - 1])
					dp[s][i] = true;
				s++;
			}
			len++;
		}
	}
}
