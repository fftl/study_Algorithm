package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_11726_S3_2xn타일링 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//n이 1일때, 2일때는 직관적으로 답을 구할 수 있는 상황입니다.
		if(n<3) {
			if(n==1) {
				System.out.println(1);
				sc.close();
				return;
			} else {
				System.out.println(2);
				sc.close();
				return;
			}
		}
		
		//그리고 그 이상의 수는 i-1 + i-2 라는 규칙을 가지고 있는 상태이기 때문에
		//dp를 만들어 답을 구하기로 했습니다.
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		//수가 int를 넘어설 수 있기 때문에 미리 10007의 나머지 연산을 해줍니다.
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		
		//결과 출력!
		System.out.println(dp[n]);
		sc.close();
	}
}
