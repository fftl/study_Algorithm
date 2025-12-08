package com.programmers;

import java.util.*;

public class Solution_PG_L0_디렉토리만들기 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(7, new int[][]{{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}}, new String[]{"root", "abcd","cs","hello","etc","hello","solution"}));
        System.out.println(solution(7, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,6},{6,7}}, new String[]{"root", "a","b","c","d","efghij","k"}));
	}

	static int solution(int n, int[][] relation, String[] dirname) {
		int answer = 0;
        int[] dirs = new int[n+1];
        for(int i=1; i<n+1; i++){
            dirs[i] = dirname[i-1].length();
        }

        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for(int i=1; i<n+1; i++){
            tree.put(i, new ArrayList<>());
        }

        for(int i=0; i<relation.length; i++){
            int[] now = relation[i];
            tree.get(now[0]).add(now[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int now = q.poll();
            ArrayList<Integer> nodes = tree.get(now);

            for(int num : nodes){
                dirs[num] += dirs[now]+1;
                q.add(num);
            }
        }

//        System.out.println(Arrays.toString(dirs));
        Arrays.sort(dirs);

		return dirs[n];
	}
}
