package com.bj.gold;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_02493_G5_탑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] result = new int[n + 1];
		Stack<Integer> stkVal = new Stack<>();
		Stack<Integer> stkKey = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		stkVal.add(arr[1]);
		stkKey.add(1);
		result[1] = 0;

		for (int i = 2; i <= n; i++) {

			// stack이 null일 경우에 peek()을 하면 오류 발생!!
			while (stkVal.size() > 0 && stkVal.peek() < arr[i]) {
				if (!stkVal.empty()) {
					stkVal.pop();
					stkKey.pop();
				} else {
					break;
				}
			}

			//empty()는 비어있을 때 true
			if (!stkVal.empty()) {
				result[i] = stkKey.peek();
				stkVal.add(arr[i]);
				stkKey.add(i);
			} else {
				result[i] = 0;
				stkVal.add(arr[i]);
				stkKey.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
