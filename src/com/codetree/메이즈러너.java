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
        
        System.out.println(person.toString());
        st = new StringTokenizer(br.readLine());
        int exitY = Integer.parseInt(st.nextToken())-1;
        int exitX = Integer.parseInt(st.nextToken())-1;
        exit = new Exit(exitY, exitX);

        for (int i = 0; i < K; i++){

        	//각자 사람들은 출구와 가까운 쪽으로 이동할 수 있다면 이동합니다.
            run();

            //사람이 모두 탈출했는지 확인 해야함.

            //출구와 한 명 이상의 참가자가 포함된 가장 작은 정사각형을 구합니다.
            find();

            //이동을 끝냈으면 미로를 회전시킵니다.
//            turn();


        }
    }

    //이미 여기서 잘못됨.
    static void run(){
        System.out.println("현재 exit 의 좌표를 확인해보자");
        System.out.println(exit.toString());
        for(int idx : person.keySet()){
            Person now = person.get(idx);
            int dis = distance(now.y, now.x);

            boolean move = false;
            for (int i = 0; i < 4; i++) {
            	if(move) break;
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				//일단 맵 위에 있으며 벽이 아닐 경우만 판단합니다.
				if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 0) {
					if(dis>distance(ny, nx)) {
                        System.out.println("어떻게 들어오는지 확인해보자 ---");
                        System.out.println(dis);
                        System.out.println(distance(ny, nx));

						now.y = ny;
						now.x = nx;
						now.len++;
						move = true;
					}
				}
			}
        }
    }

    //exit와의 거리를 반환해줍니다.
    static int distance(int y, int x) {
    	return Math.abs(y-exit.y) + Math.abs(x-exit.x);
    }

    static void find(){
    	PriorityQueue<Person> near = new PriorityQueue<>(new Comparator<Person>() {
    		@Override
    		public int compare(Person a, Person b) {
    			if(a.y==b.y) {
    				return a.x-b.x;
    			}
    			return a.y-b.y;
    		}
		});

    	int len = 10;

    	//일단 가장 가까운 사람들을 찾습니다.
    	for(int idx : person.keySet()) {
    		Person now = person.get(idx);
    		if(now.escape) continue;
    		if(len>distance(now.y, now.x)) {
    			near.clear();
    			len = distance(now.y, now.x);
    			near.add(now);
    		} else if (len == distance(now.y, now.x)) {
    			near.add(now);
    		}
    	}

    	Person nPerson = near.poll();
    	System.out.println("find()에서 사람은 제대로 구하나 확인!!");
    	System.out.println(nPerson.toString());

    	//출구와 가장 가까운 사람을 구하는 것 까지는 확인함.
    	int yCha = Math.abs(exit.y-nPerson.y);
    	int xCha = Math.abs(exit.x-nPerson.x);
    	int stX = -1;
    	int stY = -1;
    	int edX = -1;
    	int edY = -1;
    	
        //y축의 거리가 더 클 때
        if(yCha>xCha){
        	System.out.println("경우 1");
        	//상단의 Y값을 찾음.
        	int minY = Math.min(nPerson.y, exit.y);
        	int maxX = Math.max(nPerson.x, exit.x);
        	
        	stX = maxX-yCha>=0 ? maxX-yCha : 0;
        	stY = minY;
        	
        	edX = stX+yCha;
        	edY = stY+yCha;
        			
        } else if(xCha>yCha) {
        	System.out.println("경우 2");
        	//상단의 Y값을 찾음.
        	int minX = Math.min(nPerson.x, exit.x);
        	int maxY = Math.max(nPerson.y, exit.y);
        	
        	stY = maxY-xCha>=0 ? maxY-xCha : 0;
        	stX = minX;
        	
        	edX = stX+xCha;
        	edY = stY+xCha;
        	
        } else {
        	System.out.println("경우 3");
        	stY = Math.min(nPerson.y, exit.y);
        	stX = Math.min(nPerson.x, exit.x);
        	
        	edX = stX+xCha;
        	edY = stY+xCha;
        }
        
        turnBoard(new int[] {stY, stX}, new int[] {edX, edY});
    }

    //정사각형을 회전 시켜 줌
    static void turnBoard(int[] a, int[] b){
    	System.out.println("########### turnBoard 실행");
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(b));
    	System.out.println("########### 출발 도착 좌표 출력");
    	copy = new int[N][N];
    	
    	int size = b[0]-a[0];
    	int num = 0;
    	
    	for (int i = a[0]; i <= b[0]; i++) {
			for (int j = a[1]; j <= b[1]; j++) {
				if(map[i][j]>0) {
					copy[j][size-num] = map[i][j]-1;
				}
			}
			num++;
		}
    	
    	turnPrint(copy);
    }
    
    static void turnPrint(int[][] copy) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
    	
    	sb.append("\n");
    	sb.append("\n");
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(copy[i][j]+" ");
			}
			sb.append("\n");
		}
    	
    	System.out.println(sb.toString().trim());
    }

    //정사각형 안의 사람들을 회전시켜 줌
    static void turnPerson(int[] a, int[] b) {
        ArrayList<Integer> moveList = new ArrayList<>();
        for(Integer p : person.keySet()){
            Person now = person.get(p);
            if((a[0] <= now.y && now.y <=b[0]) || (a[1] <= now.x && now.x <= b[1])){
                moveList.add(now.id);
            }
        }

        int size = b[0]-a[0];
        int num = 0;

        for (int i = a[0]; i <= b[0]; i++) {
            for (int j = a[1]; j <= b[1]; j++) {
            }
            num++;
        }
    }
}
