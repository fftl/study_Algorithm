package com.zother;

import java.util.Arrays;
import java.util.Scanner;

public class PCSTest {
	
	static int N, R, input[], numbers[]; // input : 입력 배열, numbers : 순열, 조합에 선택된 수 배열
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		System.out.println("============= 순열 =============");
		permutation(0, 0);
		System.out.println("============= 조합 =============");
		combination(0, 0);
		System.out.println("============= 부분집합 =============");
		subset(0);
	}
	public static void permutation(int cnt, int flag) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) != 0) continue;
			numbers[cnt] = input[i];
			permutation(cnt+1, flag | 1<<i);
		}
	}
	
	public static void combination(int cnt, int s) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = s; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
