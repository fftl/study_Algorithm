package com.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_16637_G4_괄호추가하기 {
	static int N;
	static ArrayList<Integer> num;
	static ArrayList<Character> op;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		char[] cArr = br.readLine().toCharArray();
		num = new ArrayList<>();
		op = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if ((i + 1) % 2 == 1) { //홀수면 숫자, 짝수면 연산자
				num.add(cArr[i]-'0');
			} else {
				op.add(cArr[i]);
			}
		}

		dfs(0, num.get(0));

		bw.write(answer + "\n");

		br.close();
		bw.close();
	}

	public static void dfs(int idx, int sum) {
		if (idx == op.size()) {
			answer = Math.max(answer, sum);
			return;
		}

		dfs(idx + 1, calculate(sum, num.get(idx + 1), op.get(idx))); // 괄호 치고 넘기기

		if (idx + 2 <= op.size()) {
			dfs(idx + 2, calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx))); // 괄호
																														// 안
																														// 치고
																														// 넘기기
		}
	}

	public static int calculate(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

}
