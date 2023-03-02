package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_05639_G5_이진검색트리 {
	static ArrayList<Integer> tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new ArrayList<Integer>();

		//입력의 개수를 알 수 없으므로 while을 이용해서 받아줍니다.
		while(true) {
			String n = br.readLine();
			if(n==null||n.equals("")) break;

			//이진 탐색트리이기 때문에 일차원 배열으로 표현할 수 있습니다.
			tree.add(Integer.parseInt(n));
		}

		//후위 순회를 진행합니다.
		postOrder(0, tree.size()-1);
	}
	public static void postOrder(int idx, int end) {
		// 리스트 범위를 벗어나면 return
		if(idx>end) return;

		// 다음 인덱스의 값이 현재 값보다 더 작다면?
		int mid = idx+1;
		while(mid<=end && tree.get(mid)<tree.get(idx)) {
			mid++;
		}

		postOrder(idx+1, mid-1);
		postOrder(mid, end);
		System.out.println(tree.get(idx));
	}
}
