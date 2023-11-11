package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_02170_G5_선긋기 {

	static ArrayList<int[]> data, res;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		data = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			data.add(new int[]{s, e});
		}

		//입력 받은 선분들의 정보를 정렬해줍니다.
		Collections.sort(data, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[0] == b[0]){
					return a[1]-b[1];
				} else {
					return a[0]-b[0];
				}
			}
		});

		res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] nowData = data.get(i);

			//첫번째 선분은 비교할 것이 없으니 그냥 입력해줍니다.
			if(i==0){
				res.add(nowData);

				//res 입력된 가장 마지막 선분의 끝 점과 비교해
				//현재 선분이 연결되는 부분이라면 연결하고 아니면
				//새로운 선분을 추가해줍니다.
			} else {
				int maxIdx = res.size()-1;
				int[] maxRes = res.get(maxIdx);

				if(nowData[0]<=maxRes[1]){
					//다음 선분의 끝이 현재 maxRes의 선분보다 낄때만 연장해줍니다.
					if(maxRes[1]<nowData[1]){
						maxRes[1] = nowData[1];
					}
				} else {
					res.add(nowData);
				}
			}
		}

		long result = 0;
		for (int[] now : res){
			result += now[1] - now[0];
		}

		System.out.println(result);
	}

}
