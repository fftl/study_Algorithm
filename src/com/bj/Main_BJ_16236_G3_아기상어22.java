package com.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_G3_아기상어22 {

    static int n;
    static int[][] arr;
    static int[] dy = {-1, 0, 0, 1}; //세로
    static int[] dx = {0, -1, 1, 0};//가로, 상좌하우
    static int[][] visited; //방문 처리
    static int shark_size; //상어 크기
    static int shark_eat; //상어가 먹은 개수
    static int time; //시간
    static int shark_x, shark_y; //상어 위치, 가로, 세로
    static int food_x, food_y; //물고기 위치
    static ArrayList<int[]> foodArr;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==9) {
                    shark_x = j;
                    shark_y = i;
                    arr[i][j] = 0;
                }
            }
        } //입력 완료

        shark_size = 2;
        shark_eat = 0;
        time = 0;

        while(CanEat()) {}

        System.out.println(time);

    }//main

    public static boolean CanEat() {
        ArrayList<int[]> EatArr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] != 0 && arr[i][j] < shark_size) {
                    EatArr.add(new int[] {i, j}); //세로, 가로
                }
            }
        }

        if(EatArr.size()==0) return false; //먹을 먹이가 없다면 끝

        //먼저 BFS를 통해 먹이까지 도달하자!
        food_x = 0;
        food_y = 0;
        bfs(); //먹이 위치 주기

        food_x = foodArr.get(0)[1];
        food_y = foodArr.get(0)[0];
        if(food_x == -1 && food_y == -1) return false;
        System.out.println(food_y+","+food_x +","+time);
        time += visited[food_y][food_x];


        //먹고 난 후 처리
        arr[food_y][food_x] = 0;
        shark_x = food_x;
        shark_y = food_y;
        shark_eat += 1;
        if(shark_eat == shark_size) {
            shark_eat = 0;
            shark_size += 1;
        }

        return true;

    }//CanEat

    public static void bfs() {
    	System.out.println("========================");
        Queue<int[]> queue = new LinkedList<>();
        visited = new int[n][n];
        queue.offer(new int[] {shark_y, shark_x}); //상어의 세로, 가로 값
        visited[shark_y][shark_x] = 0;

        foodArr = new ArrayList<>();

        int len = 1;
        a:
        while(!queue.isEmpty()) {

            int size = queue.size(); //큐 사이즈 만큼 돌리기
            for(int i=0; i<size; i++) {
                int[] temp = new int[2];
                temp = queue.poll();
                int ny = temp[0];
                int nx = temp[1];
                if(arr[ny][nx]!=0 && (arr[ny][nx] < shark_size)) {
                    food_x = nx;
                    food_y = ny;
                    foodArr.add(new int[] {food_y, food_x, len-1});
//                    return;
                }
                for(int j=0; j<4; j++) {
                    int mx = nx+dx[j];
                    int my = ny+dy[j];
                    if(mx>=0 && mx<n && my>=0 && my<n && visited[my][mx]==0 && arr[my][mx] <= shark_size) {
                        visited[my][mx] = visited[ny][nx]+1;
                        queue.offer(new int[] {my, mx});
                    }

                }
            }
            len++;
        }//while

        if(foodArr.size()==0) {
            foodArr.add(new int[] {-1, -1, -1});
        }

        Collections.sort(foodArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]) {
                    if(o1[0]==o2[0]) {
                        return o1[1]-o2[1];
                    }
                    return o1[0]-o2[0];
                }

                return o1[2]-o2[2];
            }
        });

//        for(int i=0; i<foodArr.size(); i++) {
//            System.out.println(Arrays.toString(foodArr.get(i)));
//        }


    }//bfs
    
    
    

}//class