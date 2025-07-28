package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13172_G4_Σ {

	final static int MOD = 10_0000_0007;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		long ans = 0;
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			int[] num = getFraction(s, n);

			if(num[1] == 1){
				ans += num[0] % MOD;
				ans %= MOD;
				continue;
			}

			long reverseModuler = getReverseModuler(num[1]);
			ans += (num[0] * reverseModuler) % MOD;
			ans %= MOD;
		}

		System.out.println(ans);
	}

	public static int getGCD(int a, int b){
		if( a == 0 || b == 0 ){
			return a^b;
		}

		return getGCD(b, a%b);
	}

	private static int[] getFraction(int s, int n){
		int GCD = getGCD(s, n);
		return new int[] {s/GCD, n/GCD};
	}

	private static long getReverseModuler(int num){
		return pow(num, MOD-2);
	}

	private static long pow(int num, int cnt){
		if(cnt <= 1){
			return num;
		}

		long temp = pow(num, cnt/2);
		return ((temp* temp) % MOD * (cnt%2==1 ? num : 1)) % MOD;
	}
}
