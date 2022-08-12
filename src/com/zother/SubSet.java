package com.zother;

public class SubSet {
	
	static int N, totalCount;
	static int[] numbers = {3,5,7,8,9};
	static boolean[] selected;
	
	public static void main(String[] args) {
		N = numbers.length;
		selected = new boolean[N];
		subset(0);
		System.out.println("===> "+totalCount);
	}

	private static void subset(int index) {
		
		if(index == N) {
			totalCount++;
			for(int i=0; i<N; ++i) {
				if(selected[i]) System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		selected[index] = true;
		subset(index+1);
		selected[index] = false;
		subset(index+1);
	}
	
	

}
