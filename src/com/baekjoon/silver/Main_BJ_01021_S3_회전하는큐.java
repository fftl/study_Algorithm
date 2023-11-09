package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_01021_S3_회전하는큐 {
	static int N, M; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		int num = 0;
		for (int i = 1; i < N + 1; i++) {
			arr[i] = num;
			num++;
		}

		int res = 0;
		for (int i = 0; i < M; i++) {
			System.out.println(dq.toString());
			int now = Integer.parseInt(st.nextToken());
			int nowIdx = arr[now];
			int len = 0;
			if (nowIdx < dq.size() - nowIdx) {
				System.out.println("start >>" + Arrays.toString(arr));
				len = nowIdx;
				for (int j = 0; j < len; j++) {
					dq.addLast(dq.pollFirst());
				}
				dq.poll();
				for (int j = 1; j < N + 1; j++) {
					arr[j] = arr[j] - len - 1 < 0 ? dq.size() + (arr[j] - len - 1) : arr[j] - len - 1;
				}
				res += len;
				System.out.println("end >>" + Arrays.toString(arr));
			} else {
				len = dq.size() - nowIdx;
				for (int j = 0; j < len; j++) {
					dq.addFirst(dq.pollLast());
				}
				dq.poll();
				System.out.println("dq size : " + dq.size());
				for (int j = 1; j < N + 1; j++) {
					arr[j] = arr[j] + len + 1 > dq.size() ? arr[j] + len + 1 - dq.size() : arr[j] + len + 1;
				}
				res += len;
			}
		}
=======

import java.util.StringTokenizer;

public class Main_BJ_01021_S3_회전하는큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			arr[i] = i;
		}

		int size = N;
		int res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			System.out.println(Arrays.toString(arr));
			int now = Integer.parseInt(st.nextToken());

			if(arr[now] == 1) {
				for (int j = 1; j < N+1; j++) {
					arr[j] -= 1;
				}
			} else if (arr[now] <= size-arr[now]){
				res += arr[now];
				size -= arr[now];
				for (int j = 1; j < size; j++) {
					arr[j] = arr[j] - (arr[now] - 1) < 1 ? size - (arr[j] - (arr[now] - 1)) : arr[j] - (arr[now] - 1);
				}
			} else {
				res += size-arr[now];
				size -= size-arr[now];
				for (int j = 1; j < size; j++) {
					arr[j] = arr[j] + (size-arr[now]) <= size ? (size-arr[now])  : arr[j] + (size-arr[now])-size;
				}

			}
		}

		System.out.println(res);
>>>>>>> 7dfc10f95f4a026461143283b7a72a3e74334937
	}
}
