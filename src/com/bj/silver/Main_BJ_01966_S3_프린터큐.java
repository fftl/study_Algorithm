package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01966_S3_프린터큐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			ArrayList<Obj> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr.add(new Obj(j, Integer.parseInt(st.nextToken())));
			}

			int cnt = 1;
			while (true) {
				if (arr.size() == 1) {
					if (arr.get(0).n == k) {
						System.out.println(cnt);
						break;
					} else {
						arr.remove(0);
						cnt++;
					}
					break;
				}

				Obj first = arr.get(0);
				boolean chk = false;
				for (int j = 1; j < arr.size(); j++) {
					if (first.k < arr.get(j).k) {
						chk = true;
						break;
					}
				}

				if (chk) {
					arr.add(first);
					arr.remove(0);
				} else {
					if (first.n == k) {
						System.out.println(cnt);
						break;
					} else {
						arr.remove(0);
						cnt++;
					}
				}
			}
		}
	}

	static class Obj {
		int n, k;

		public Obj(int n, int k) {
			super();
			this.n = n;
			this.k = k;
		}

		@Override
		public String toString() {
			return "obj [n=" + n + ", k=" + k + "]";
		}

	}
}
