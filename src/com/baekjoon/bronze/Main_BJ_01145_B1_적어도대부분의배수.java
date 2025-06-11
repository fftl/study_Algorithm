package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01145_B1_적어도대부분의배수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//다섯개의 수만 주어지기 때문에 5의 크기를 가지는 배열을 선언합니다.
		int[] nums = new int[5];

		//nums 배열에 입력받은 수를 넣어줍니다.
		for (int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		//최솟값을 찾기 위해 정렬해줍니다.
		//입력 받은 수 중 최솟값부터 정답이 될 수 있는 가능성이 있습니다.
		Arrays.sort(nums);

		//최솟값을 시작 값으로 두고 while문을 시작합니다.
		//result는 찾아낸 정답을 담기 위해 미리 만들어 줍니다.
		int start = nums[0];
		int result;

		while(true){

			//세 개 이상의 배수를 판단하기 위해 cnt를 이용해 개수를 세어줍니다.
			int cnt = 0;

			//입력 받은 다섯 개의 수 중에 현재 start 수로 나누어 떨어지는 수의 개수를 세어줍니다.
			for(int n : nums){
				if(start%n==0) cnt++;
			}

			//만약 세어낸 cnt가 3이상일 경우 답을 찾았습니다.
			//result에 start값을 담아주고 반복을 종료합니다.
			if(cnt>=3){
				result = start;
				break;

			//세 개 이상 나누어 떨어지는 수가 없다면, start를 증가시키고 다시 반복합니다.
			} else {
				start++;
			}
		}

		//찾아낸 result를 출력합니다.
		System.out.println(result);
	}
}
