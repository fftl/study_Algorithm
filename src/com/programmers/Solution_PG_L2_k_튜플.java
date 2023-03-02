package com.programmers;

import java.util.*;

public class Solution_PG_L2_k_튜플 {

	public static void main(String[] args) throws Exception {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(solution(s));
	}

	public static ArrayList<Integer> solution(String s) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		String[] strs = s.split("}");

		for (int i = 0; i < strs.length; i++) {
			String now = strs[i];
			String remove = now.replace("{", "");

			String[] nowArr = remove.split(",");
			ArrayList<Integer> miniArr = new ArrayList<>();
			for (int j = 0; j < nowArr.length; j++) {
				if (nowArr[j].length() > 0)
					miniArr.add(Integer.parseInt(nowArr[j]));
			}
			arr.add(miniArr);
		}

		Collections.sort(arr, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return Integer.compare(o1.size(), o2.size());
			}
		});

		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			ArrayList<Integer> now = arr.get(i);
			for (int j = 0; j < now.size(); j++) {
				if (set.contains(now.get(j)))
					continue;
				else {
					res.add(now.get(j));
					set.add(now.get(j));
				}
			}
		}

		return res;
	}
}
