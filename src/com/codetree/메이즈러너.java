package com.codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 메이즈러너 {
	static int N, M, K;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static int[][] copy;
	static Exit exit;
	static HashMap<Integer, Person> person;

	static class Person{
		int y, x, id, len;
		boolean escape;

		public Person(int y, int x, int id, int len, boolean escape) {
			this.y = y;
			this.x = x;
			this.id = id;
			this.len = len;
			this.escape = escape;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Person{");
			sb.append("y=").append(y);
			sb.append(", x=").append(x);
			sb.append(", id=").append(id);
			sb.append(", len=").append(len);
			sb.append(", escape=").append(escape);
			sb.append('}');
			return sb.toString();
		}
	}

	static class Exit{
		int y, x;

		public Exit(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Exit{");
			sb.append("y=").append(y);
			sb.append(", x=").append(x);
			sb.append('}');
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		person = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ny = Integer.parseInt(st.nextToken())-1;
			int nx = Integer.parseInt(st.nextToken())-1;
			person.put(i, new Person(ny, nx, i, 0, false));
		}

//        System.out.println(person.toString());
		st = new StringTokenizer(br.readLine());
		int exitY = Integer.parseInt(st.nextToken())-1;
		int exitX = Integer.parseInt(st.nextToken())-1;
		exit = new Exit(exitY, exitX);
//		printNow();
		for (int i = 0; i < K; i++){
//			System.out.println("==========================================================");
//			System.out.println("exit 위치 >> "+exit.toString());
			//각자 사람들은 출구와 가까운 쪽으로 이동할 수 있다면 이동합니다.
			run();

			//사람이 모두 탈출했는지 확인 해야함.
			if(endCheck()) break;

			//출구와 한 명 이상의 참가자가 포함된 가장 작은 정사각형을 구합니다.
			find();

			//이동을 끝냈으면 미로를 회전시킵니다.
//			System.out.println((i+1)+"초 최종 결과 ==========");
//			printNow();
		}

		System.out.println(result());
	}

	static String result(){
		StringBuilder sb = new StringBuilder();
		int res = 0;
		for(int idx : person.keySet()) {
			res += person.get(idx).len;
		}

		sb.append(res+"\n");
		sb.append((exit.y+1) + " " + (exit.x+1));

		return sb.toString().trim();
	}

	static boolean endCheck(){
		for(int idx : person.keySet()) {
			if(!person.get(idx).escape) return false;
		}

		return true;
	}

	//이미 여기서 잘못됨.
	static void run(){
		for(int idx : person.keySet()){
			Person now = person.get(idx);
			if(now.escape) continue;

			int dis = distance(now.y, now.x);

			boolean move = false;
			for (int i = 0; i < 4; i++) {
				if(move) break;
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				//일단 맵 위에 있으며 벽이 아닐 경우만 판단합니다.
				if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 0) {
					if(dis>distance(ny, nx)) {
						now.y = ny;
						now.x = nx;
						now.len++;
						if(now.y == exit.y && now.x == exit.x){
							now.escape = true;
						}
						move = true;
					}
				}
			}
		}

//		System.out.println("턴이 끝날 때 person 확인 >> \n" + person.toString());
	}

	//exit와의 거리를 반환해줍니다.
	static int distance(int y, int x) {
		return Math.abs(y-exit.y) + Math.abs(x-exit.x);
	}

	static void find(){
		PriorityQueue<Person> near = new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person a, Person b) {
				if(Math.max(Math.abs(a.y-exit.y), Math.abs(a.x-exit.x)) == Math.max(Math.abs(b.y-exit.y), Math.abs(b.x-exit.x))){
					if((Math.abs(a.y-exit.y)+Math.abs(a.x- exit.x)) == (Math.abs(b.y-exit.y)+Math.abs(b.x- exit.x))){
						if(a.y==b.y) {
							return a.x-b.x;
						}
						return a.y-b.y;
					}
					return (Math.abs(a.y-exit.y)+Math.abs(a.x- exit.x)) - (Math.abs(b.y-exit.y)+Math.abs(b.x- exit.x));
				}
				return Math.max(Math.abs(a.y-exit.y), Math.abs(a.x-exit.x)) - Math.max(Math.abs(b.y-exit.y), Math.abs(b.x-exit.x));
			}
		});

		int len = N*N;

		//일단 가장 가까운 사람들을 찾습니다.
		for(int idx : person.keySet()) {
			Person now = person.get(idx);
			if(now.escape) continue;
			near.add(now);
		}

//		System.out.println("먼저 near 목록을 확인해보자");
//		System.out.println(near.toString());

		Person nPerson = near.poll();
//    	System.out.println("find()에서 사람은 제대로 구하나 확인!!");
//    	System.out.println(nPerson.toString());

		//출구와 가장 가까운 사람을 구하는 것 까지는 확인함.
		int yCha = Math.abs(exit.y-nPerson.y);
		int xCha = Math.abs(exit.x-nPerson.x);
		int stX = -1;
		int stY = -1;
		int edX = -1;
		int edY = -1;

		//y축의 거리가 더 클 때
		if(yCha>xCha){
			//상단의 Y값을 찾음.
			int minY = Math.min(nPerson.y, exit.y);
			int maxX = Math.max(nPerson.x, exit.x);

			stX = maxX-yCha>=0 ? maxX-yCha : 0;
			stY = minY;

			edX = stX+yCha;
			edY = stY+yCha;

		} else if(xCha>yCha) {
			//상단의 Y값을 찾음.
			int minX = Math.min(nPerson.x, exit.x);
			int maxY = Math.max(nPerson.y, exit.y);

			stY = maxY-xCha>=0 ? maxY-xCha : 0;
			stX = minX;

			edX = stX+xCha;
			edY = stY+xCha;

		} else {
			stY = Math.min(nPerson.y, exit.y);
			stX = Math.min(nPerson.x, exit.x);

			edX = stX+xCha;
			edY = stY+xCha;
		}

//		System.out.println("#### 좌표 근황을 출력합니다.");
//		System.out.println(stY+","+stX+"/"+edY+","+edX);
//		System.out.println(exit);
		turnBoard(new int[] {stY, stX}, new int[] {edY, edX});
		turnPerson(new int[] {stY, stX}, new int[] {edY, edX});

	}

	//정사각형을 회전 시켜 줌
	static void turnBoard(int[] a, int[] b){
//    	System.out.println("########### turnBoard 실행");
//    	System.out.println(Arrays.toString(a));
//    	System.out.println(Arrays.toString(b));
//    	System.out.println("########### 출발 도착 좌표 출력");
		copy = new int[N][N];

		int size = b[0]-a[0];
		int num = 0;

		for (int i = a[0], i2 = 0; i <= b[0]; i++, i2++) {
			for (int j = a[1], j2 = 0; j <= b[1]; j++, j2++) {
				if(map[i][j]>0) {
					copy[a[0]+j2][b[1]-i2] = map[i][j]-1;
				}
			}
			num++;
		}

		for (int i = a[0]; i <= b[0]; i++) {
			for (int j = a[1]; j <= b[1]; j++) {
				map[i][j] = copy[i][j];
			}
			num++;
		}
	}

	//정사각형 안의 사람들을 회전시켜 줌
	static void turnPerson(int[] a, int[] b) {
		int size = b[0] - a[0];
		int num = 0;
		boolean exitMove = false;
		HashSet<Integer> move = new HashSet<>();


//		copy[a[0]+j2][b[1]-i2] = map[i][j]-1;

		for (int i = a[0], i2 = 0; i <= b[0]; i++, i2++) {
			for (int j = a[1], j2 = 0; j <= b[1]; j++, j2++) {
				for (int key : person.keySet()) {
					Person now = person.get(key);
					if(now.escape) continue;
					if (i == now.y && j == now.x) {
						if (!move.contains(now.id)) {
//							System.out.println("여기서 >> "+i+","+j);
							now.y = a[0]+j2;
							now.x = b[1]-i2;
							move.add(now.id);
//							System.out.println("여기로 >> "+now.y+","+now.x);
						}
					}
					if (i == exit.y && j == exit.x && !exitMove) {
						exit.y = a[0]+j2;
						exit.x = b[1]-i2;
						exitMove = true;
					}
				}
			}
			num++;
		}

//		System.out.println(person);
	}

	static void printNow() {
		int[][] justPrint = new int[N][N];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				justPrint[i][j] = map[i][j];
			}
		}

		for(int key : person.keySet()) {
			Person now = person.get(key);
			if(now.escape) continue;
			justPrint[now.y][now.x] = -9;
		}

		justPrint[exit.y][exit.x] = -4;


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(justPrint[i][j]+" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}
