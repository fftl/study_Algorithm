//package com.codetree;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class 메이즈러너 {
//    static int N, M, K;
//    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//    static int[][] map;
//    static Exit exit;
//    static HashMap<Integer, Person> person;
//
//    static class Person{
//        int y, x, id, len;
//        boolean escape;
//
//        public Person(int y, int x, int id, int len, boolean escape) {
//            this.y = y;
//            this.x = x;
//            this.id = id;
//            this.len = len;
//            this.escape = escape;
//        }
//
//        @Override
//        public String toString() {
//            final StringBuilder sb = new StringBuilder("Person{");
//            sb.append("y=").append(y);
//            sb.append(", x=").append(x);
//            sb.append(", id=").append(id);
//            sb.append(", len=").append(len);
//            sb.append('}');
//            return sb.toString();
//        }
//    }
//
//    static class Exit{
//        int y, x;
//
//        public Exit(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//
//        @Override
//        public String toString() {
//            final StringBuilder sb = new StringBuilder("Exit{");
//            sb.append("y=").append(y);
//            sb.append(", x=").append(x);
//            sb.append('}');
//            return sb.toString();
//        }
//    }
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        map = new int[N][N];
//
//        person = new HashMap<>();
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int ny = Integer.parseInt(st.nextToken())-1;
//            int nx = Integer.parseInt(st.nextToken())-1;
//            person.put(i, new Person(ny, nx, i, 0));
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int exitY = Integer.parseInt(st.nextToken());
//        int exitX = Integer.parseInt(st.nextToken());
//        exit = new Exit(exitY, exitX);
//
//        for (int i = 0; i < K; i++){
//
//        	//각자 사람들은 출구와 가까운 쪽으로 이동할 수 있다면 이동합니다.
//            run();
//
//            //사람이 모두 탈출했는지 확인 해야함.
//
//            //출구와 한 명 이상의 참가자가 포함된 가장 작은 정사각형을 구합니다.
//            find();
//
//            //이동을 끝냈으면 미로를 회전시킵니다.
////            turn();
//
//
//        }
//    }
//
//    static void run(){
//        for(int idx : person.keySet()){
//            Person now = person.get(idx);
//            int dis = distance(now.y, now.x);
//
//            boolean move = false;
//            for (int i = 0; i < 4; i++) {
//            	if(move) break;
//				int ny = now.y + dy[i];
//				int nx = now.x + dx[i];
//
//				//일단 맵 위에 있으며 벽이 아닐 경우만 판단합니다.
//				if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 0) {
//					if(dis>distance(ny, nx)) {
//						now.y = ny;
//						now.x = nx;
//						now.len++;
//						move = true;
//					}
//				}
//			}
//        }
//    }
//
//    //exit와의 거리를 반환해줍니다.
//    static int distance(int y, int x) {
//    	return Math.abs(y-exit.y) + Math.abs(x-exit.x);
//    }
//
//    static void find(){
//    	PriorityQueue<Person> near = new PriorityQueue<>(new Comparator<Person>() {
//    		@Override
//    		public int compare(Person a, Person b) {
//    			if(a.y==b.y) {
//    				return a.x-b.x;
//    			}
//    			return a.y-b.y;
//    		}
//		});
//
//    	int len = 10;
//
//    	//일단 가장 가까운 사람들을 찾습니다.
//    	for(int idx : person.keySet()) {
//    		Person now = person.get(idx);
//    		if(now.escape) continue;
//    		if(len>distance(now.y, now.x)) {
//    			near.clear();
//    			len = distance(now.y, now.x);
//    			near.add(now);
//    		} else if (len == distance(now.y, now.x)) {
//    			near.add(now);
//    		}
//    	}
//
//    	Person nPerson = near.poll();
//
//    	//출구와 가장 가까운 사람을 구하는 것 까지는 확인함.
//    	int exitSum = exit.x+exit.y;
//    	int nearSum = nPerson.x+nPerson.y;
//
//
//
//    }
//
//    static void turnBoard(){
//
//    }
//
//    static void turnPerson() {
//
//    }
//}
