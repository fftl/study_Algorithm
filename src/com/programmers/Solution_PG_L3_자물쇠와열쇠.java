package com.programmers;

import java.util.Arrays;

public class Solution_PG_L3_자물쇠와열쇠 {

	public static void main(String[] args) throws Exception {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}

	static int kY, kX, lY, lX;
    static int[][] bigLock, copy, k, l;
    static boolean result;
    
    static void print() {
        for(int i=0; i<bigLock.length; i++){
            for(int j=0; j<bigLock[0].length; j++){
            	System.out.print(bigLock[i][j]);
            }
            System.out.println();
        }
    	System.out.println("-------------------------------");
    }
    
    static boolean check(int y, int x){
        for(int i=y, ci=0; i<y+copy.length; i++, ci++){
            for(int j=x, cj=0; j<x+copy[0].length; j++, cj++){
                if(copy[ci][cj] == 1){
                    bigLock[i][j]++;
                }
            }
        }
        
        print();
        int cnt = 0;
        for(int i=0; i<lY; i++){
            for(int j=0; j<lX; j++){
                if(bigLock[i+kY][j+kX] == 1) cnt++;
            }
        }
        
        System.out.println(cnt);
//        if( cnt == 9 ) return true;
        if( cnt == lY*lY ) return true;
        
        for(int i=y, ci=0; i<y+copy.length; i++, ci++){
            for(int j=x, cj=0; j<x+copy[0].length; j++, cj++){
                if(copy[ci][cj] == 1){
                    bigLock[i][j]--;
                }
            }
        }
        
        return false;
    }
    
    
    static boolean moving(){
        for(int i=0; i<bigLock.length-kY+1; i++){
            for(int j=0; j<bigLock[0].length-kX+1; j++){
                if(check(i, j)){
                    return true;
                };
            }
        }
        
        return false;
    }
    
    static void turn(){
        copy = new int[kY][kX];
        for(int i=0, x=kX-1; i<kY; i++, x--){
            for(int j=0; j<kX; j++){
                copy[j][x] = k[i][j];
            }
        }
        
        for(int i=0; i<kY; i++){
            for(int j=0; j<kX; j++){
                k[i][j] = copy[i][j];
            }
        }
    }
    
    static boolean solution(int[][] key, int[][] lock) {
        k = key;
        l = lock;
        kY = key.length;
        kX = key[0].length;
        lY = lock.length;
        lX = lock[0].length;
        
        bigLock = new int[lock.length*3][lock[0].length*3];
        for(int i=0; i<lY; i++){
            for(int j=0; j<lX; j++){
                bigLock[i+kY][j+kX] = l[i][j];
            }
        }
        
        for(int i=0; i<4; i++){
            turn();
            if(moving()){
                return true;
            }
        }
        
        return false;
    }
}
