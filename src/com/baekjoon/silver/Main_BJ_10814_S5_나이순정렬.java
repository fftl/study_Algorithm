package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_10814_S5_나이순정렬 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		ArrayList<Person> arr = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			arr.add(new Person(i, age, name));
		}

		Collections.sort(arr, new Comparator<Person>() {

			@Override
			public int compare(Person a, Person b) {
				if(a.age != b.age) {
					return a.age-b.age;
				} else {
					return a.idx-b.idx;
				}
			};
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i).age + " " + arr.get(i).name+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	static class Person {
		int idx, age;
		String name;

		public Person(int idx, int age, String name) {
			super();
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [idx=" + idx + ", age=" + age + ", name=" + name + "]";
		}
	}
}
