package com.zother;

import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {
	static int N; // 요소 개수
	static int[] parents; // 대표자(부모) 저장

	static void make() {	//집합만들기
		for(int i=0; i<N; i++) {
			parents[i] = i;	//우선 내가 나의 대표. (각각 대표자 => 대표자는 마음(배열)속에 )
		}
	}

	static int find(int a) { // 대표자 찾기
		if(parents[a] == a) return a;	//내 대표가 나라면?! 이 집합의 주인은 나 이다.
		return find(parents[a]); //parents[a] == a(즉 대표를 찾을때까지 반복합니다.)
	}

	static boolean union(int a, int b) { // 두집합의 결합, 합체 결합하자 a가 b의 집합을 먹는다!
		//포인트 코드 parents[b] = a;
		int aRoot = find(a); //a의 대표자 찾기
		int bRoot = find(b); //b의 대표자 찾기
		
		if(aRoot == bRoot) return false; //대표가 같다는 것은 이미 같은 집합이라는 것!
		
		parents[bRoot] = aRoot; //서로다른 집합이라면 bRoot의 집합의 대표를 aRoot로 변경해줍니다.
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 5;
		parents = new int[N]; // 각요소의 대표자 정보 저장
		System.out.println(Arrays.toString(parents));
		
		// 1.연산 make
		System.out.println("===== make =====");
		make();
		System.out.println(Arrays.toString(parents));
		
		// 2. 연산 union(집합간의 합체, 동일한 대표자 갖기)
		System.out.println("===== union =====");
		System.out.println(union(0,1));
		System.out.println("union(0,1)="+ Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println("union(1,2)="+ Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println("union(3,4)="+ Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println("union(0,2)="+ Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println("union(0,4)="+ Arrays.toString(parents));
		//자식까지 바뀌지는 않는다?
		
		sc.close();
	}
}
