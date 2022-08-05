package com.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_1244_S3_스위치켜고끄기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N, M;
		N = sc.nextInt();

		//스위치 번호가 1번부터라 배열의 인덱스를 맞춰주기 위해서
		int[] light = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			light[i] = sc.nextInt();
		}

		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			//남학생일 경우 배수의 스위치를 바꿔준다.
			if (gender == 1) {

				for (int j = 1; j < N + 1; j++) {
					if (j % num == 0) {
						if (light[j] == 1) {
							light[j] = 0;
						} else {
							light[j] = 1;
						}
					}
				}

			//여학생일 경우
			} else {
				//대칭넓이가 몇개까지 가능한지
				int width = 1;
				//대칭이 하나도 안될 경우를 확인하기 위한 ok 입니다.
				int ok = 0;
				while (true) {
					if (1 <= num - width && num + width < N+1) {
						if (light[num + width] == light[num - width]) {
							ok++;
							width++;
						} else {
							break;
						}
					} else {
						break;
					}
				}
				
				//대칭이 하나도 안되었다면 기준 위치만 스위치를 바꾸고
				//아닐 경우에는 해당 부분들을 다 바꾸어줍니다.
				if(ok == 0) {
					if (light[num] == 1) {
						light[num] = 0;
					} else {
						light[num] = 1;
					}
				} else {
					for (int j = num - ok; j < num + ok + 1; j++) {
						if (light[j] == 1) {
							light[j] = 0;
						} else {
							light[j] = 1;
						}
					}
					
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			sb.append(light[i]+" ");
			if(i%20 == 0) sb.append("\n"); //스위치 20개 이후에 줄바꿈을 해줍니다.
		}
		System.out.println(sb.toString().trim());
	}
}
