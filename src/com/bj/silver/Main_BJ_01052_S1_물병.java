package com.bj.silver;

import java.util.Scanner;

public class Main_BJ_01052_S1_물병 {
	static int N, K;

	//n보다 작은 2의 제곱수중 가장 큰 수를 찾아 반환합니다.
	static int check1(int n) {
		int t = 2;
		while (t < n) {
			t = t << 1;
		}
		t = t >> 1;
		return t;
	}
	
	//물병이 하나 남았을 때 이제 상점에사 사야하는 물병의 개수를 구해줍니다.
	//n보다 큰 2의 제곱수(그중에 가장 작은)를 찾습니다.
	//그리고 k와 n의 차를 구합니다.(이게 필요한 물병의 개수)
	static int check2(int n) {
		int t = 2;
		while (t < n) {
			t = t << 1;
		}
		return t-n;
	}
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		while(K>1) {
			//여분 물병이 남았는데 물이 1리터밖에 남지 않았다면! 종료.
			if(N<2) break;
			
			//check1의 값을 N에서 빼줍니다. ==> 물병이 한개를 소비합니다.
			int c = check1(N); 
			System.out.println(c);
			N = N-c;
			K--;
		}
		
		if(N<2 && K>=1) System.out.println(0); // 현재 물병으로 충분할 경우
		else System.out.println(check2(N));

		sc.close();
	}
}
