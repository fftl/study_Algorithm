package com.programmers;

import java.util.*;

public class Solution_PG_L3_표병합 {
	static Data[][] board;
	static HashMap<Integer, ArrayList<int[]>> map;
	static int index;

	static class Data{
		int idx;
		String val;

		public Data(int idx, String val){
			this.idx = idx;
			this.val = val;
		}

		public String toString(){
			return val;
		}
	}

	static void boardInit(){
		for(int i=0; i<51; i++){
			for(int j=0; j<51; j++){
				board[i][j] = new Data(0, "");
			}
		}
	}

	static void input(String[] str){
		int y = Integer.parseInt(str[1]);
		int x = Integer.parseInt(str[2]);
		String val = str[3];

		//그룹이 아니라면!
		if(board[y][x].idx == 0){
			board[y][x].val = val;
		} else {
			ArrayList<int[]> arr = map.get(board[y][x].idx);
			// System.out.println("바꿔" + val);
			for(int[] i : arr){
				board[i[0]][i[1]].val = val;
			}
		}
	}

	//문제 없음.
	static void update(String[] str){
		String search = str[1];
		String val = str[2];

		for(int i=0; i<51; i++){
			for(int j=0; j<51; j++){
				if(board[i][j].val.equals(search)){
					if(map.containsKey(board[i][j].idx)){
						ArrayList<int[]> arr = map.get(board[i][j].idx);
						for(int[] a : arr){
							board[a[0]][a[1]].val = val;
						}
					} else {
						board[i][j].val = val;
					}
				}
			}
		}
	}

	static void merge(String[] str){
		int ay = Integer.parseInt(str[1]);
		int ax = Integer.parseInt(str[2]);
		int by = Integer.parseInt(str[3]);
		int bx = Integer.parseInt(str[4]);

		if(ay==by&&ax==bx) return;
		// if(board[ay][ax].idx != 0 && board[by][bx].idx != 0 &&board[ay][ax].idx == board[by][bx].idx) return;

		Data a = board[ay][ax];
		Data b = board[by][bx];

		map.put(index, new ArrayList<>());
		//둘다 값을 가지고 있지 않거나, 둘 다 값을 가지고 있다면 ay, ax 값을 가진다.
		if(a.val.equals("") && !b.val.equals("")){
			//a 부분 입력
			if(a.idx != 0){
				if(map.containsKey(a.idx)){
					for(int[] i : map.get(a.idx)){
						board[i[0]][i[1]].val = b.val;
						board[i[0]][i[1]].idx = index;
						map.get(index).add(new int[]{i[0], i[1]});
					}
				}
			} else {
				board[ay][ax].val = b.val;
				board[ay][ax].idx = index;
				map.get(index).add(new int[]{ay, ax});
			}

			//b 부분 입력
			if(b.idx != 0){
				if(map.containsKey(b.idx)){
					for(int[] i : map.get(b.idx)){
						board[i[0]][i[1]].val = b.val;
						board[i[0]][i[1]].idx = index;
						map.get(index).add(new int[]{i[0], i[1]});
					}
				}
			} else {
				board[by][bx].val = b.val;
				board[by][bx].idx = index;
				map.get(index).add(new int[]{by, bx});
			}

		} else {
			//a 부분 입력
			if(a.idx != 0){
				if(map.containsKey(a.idx)){
					for(int[] i : map.get(a.idx)){
						board[i[0]][i[1]].val = a.val;
						board[i[0]][i[1]].idx = index;
						map.get(index).add(new int[]{i[0], i[1]});
					}
				}
			} else {
				board[ay][ax].val = a.val;
				board[ay][ax].idx = index;
				map.get(index).add(new int[]{ay, ax});
			}

			//b 부분 입력
			if(b.idx != 0){
				if(map.containsKey(b.idx)){
					for(int[] i : map.get(b.idx)){
						board[i[0]][i[1]].val = a.val;
						board[i[0]][i[1]].idx = index;
						map.get(index).add(new int[]{i[0], i[1]});
					}
				}
			} else {
				board[by][bx].val = a.val;
				board[by][bx].idx = index;
				map.get(index).add(new int[]{by, bx});
			}
		}
		index++;
	}

	//문제 없음
	static void unMerge(String[] str){
		int ay = Integer.parseInt(str[1]);
		int ax = Integer.parseInt(str[2]);
		String base = new String(board[ay][ax].val);

		if(board[ay][ax].idx > 0){
			if(map.containsKey(board[ay][ax].idx)){
				for(int[] i : map.get(board[ay][ax].idx)){
					board[i[0]][i[1]].idx = 0;
					board[i[0]][i[1]].val = "";
				}
			}
		}

		index++;

		board[ay][ax].idx = 0;
		board[ay][ax].val = base;

	}

	static void print(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<51; i++){
			for(int j=0; j<51; j++){
				sb.append(board[i][j].val+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean",
				"UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle",
				"UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
				"MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4",
				"PRINT 1 3", "PRINT 1 4"}));
	}

	static ArrayList<String> solution(String[] commands) {
		ArrayList<String> answer = new ArrayList<>();

		board = new Data[51][51];
		boardInit();
		index = 1;
		map = new HashMap<>();

		for(int i=0; i<commands.length; i++){
			String[] now = commands[i].split(" ");
			if(now[0].equals("UPDATE")){
				if(now.length == 4){
					input(now);
				} else {
					update(now);
				}
			} else if(now[0].equals("MERGE")){
				merge(now);
			} else if(now[0].equals("UNMERGE")){
				unMerge(now);
			} else {
				int ay = Integer.parseInt(now[1]);
				int ax = Integer.parseInt(now[2]);
				if(board[ay][ax].val.equals("")){
					answer.add("EMPTY");
				} else {
					answer.add(board[ay][ax].val);
				}
			}
		}

		return answer;
	}
}
