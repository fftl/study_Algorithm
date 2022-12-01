package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10845_S4_큐 {
	static int front;
	static int back;
	static int qSize;
	static int[] q;

	static void push(int n) {
		q[back] = n;
		back++;
	}

	static int front() {
		if (empty() == 1) return -1;
		else return q[front];
	}

	static int back() {
		if (empty() == 1) return -1;
		else return q[back-1];
	}

	static int size() {
		return Math.abs(front - back);
	}

	static int empty() {
		if (size() == 0)
			return 1;
		else
			return 0;
	}

	static int pop() {
		if (empty() == 1) {
			return -1;
		}
		
		int result = q[front];
		front++;
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		qSize = t;
		q = new int[t];
		front = 0;
		back = 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String[] str = br.readLine().split(" ");
			if (str.length > 1) {
				push(Integer.parseInt(str[1]));
			} else {
				if(str[0].equals("front")) {
					sb.append(front()+"\n");
				} else if(str[0].equals("back")) {
					sb.append(back()+"\n");
				} else if(str[0].equals("size")) {
					sb.append(size()+"\n");
				} else if(str[0].equals("empty")) {
					sb.append(empty()+"\n");
				} else if(str[0].equals("pop")) {
					sb.append(pop()+"\n");
				}
			}
		}
		
		System.out.println(sb.toString().trim());

	}
}
