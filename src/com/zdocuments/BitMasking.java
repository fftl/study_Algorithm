package com.zdocuments;

public class BitMasking {
	public static void main(String[] args) {
		int n = 5;
		int[] arr = {1,2,3,4,5};
		int count = 0;
		for (int i = 0; i < (1<<n); i++) {
			System.out.print(count + "번째 : ");
			count++;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                	System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
		System.out.println("총 부분집합의 개수 : "+ count);
		/**
		 * 	출력 값
		 *  0번째 : 
			1번째 : 1 
			2번째 : 2 
			3번째 : 1 2 
			4번째 : 3 
			5번째 : 1 3 
			6번째 : 2 3 
			7번째 : 1 2 3 
			8번째 : 4 
			9번째 : 1 4 
			10번째 : 2 4 
			11번째 : 1 2 4 
			12번째 : 3 4 
			13번째 : 1 3 4 
			14번째 : 2 3 4 
			15번째 : 1 2 3 4 
			16번째 : 5 
			17번째 : 1 5 
			18번째 : 2 5 
			19번째 : 1 2 5 
			20번째 : 3 5 
			21번째 : 1 3 5 
			22번째 : 2 3 5 
			23번째 : 1 2 3 5 
			24번째 : 4 5 
			25번째 : 1 4 5 
			26번째 : 2 4 5 
			27번째 : 1 2 4 5 
			28번째 : 3 4 5 
			29번째 : 1 3 4 5 
			30번째 : 2 3 4 5 
			31번째 : 1 2 3 4 5 
			총 부분집합의 개수 : 32
		 * */
		
		
	}
}
