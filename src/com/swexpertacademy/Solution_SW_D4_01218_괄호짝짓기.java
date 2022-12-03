package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SW_D4_01218_괄호짝짓기 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1218.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			boolean ok = true;
			char[] arr = br.readLine().toCharArray();
			Stack<Character> s = new Stack<>();

			for (int i = 0; i < arr.length; i++) {

				char c = arr[i];
				if (c == '<' || c == '(' || c == '[' || c == '{') {
					s.push(c);
				} else {
					if (c == ']') {
						if (s.peek() == '[') {
							s.pop();
						} else {
							ok = false;
							break;
						}
					} else if (c == '}') {
						if (s.peek() == '{') {
							s.pop();
						} else {
							ok = false;
							break;
						}
					} else if (c == ')') {
						if (s.peek() == '(') {
							s.pop();
						} else {
							ok = false;
							break;
						}
					} else if (c == '>') {
						if (s.peek() == '<') {
							s.pop();
						} else {
							ok = false;
							break;
						}
					} else {
						ok = false;
						break;
					}
				}
			}

			if (ok)
				System.out.println("#" + test_case + " " + 1);
			else
				System.out.println("#" + test_case + " " + 0);
		}
	}
}