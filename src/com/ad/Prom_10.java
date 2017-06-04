package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_10 {

	/**
	 * @param args
	 * 정예 병사 - 기출
	 * 
	 */
	static int N;
	static int Answer;
	static int sol[][];
	static int min;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom10"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			//////////////////////////////////////
			N = sc.nextInt();
			sol = new int[N][2];
			for(int i = 0 ; i < N ; i++) {
				sol[i][0] = sc.nextInt();
				sol[i][1] = sc.nextInt();
				//sol[i][2] = i;
				//System.out.println(sol[i][0] + " - " + sol[i][1] + " - " + sol[i][2]);
			}

//			for (int[] is : sol) {
//				System.out.println(Arrays.toString(is));
//			}
//			
//			System.out.println("----------------------");
			
			Arrays.sort(sol, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					Integer t1 = o1[0];
					Integer t2 = o2[0];
					return t1.compareTo(t2);
				}
			});
			
//			for (int[] is : sol) {
//				System.out.println(Arrays.toString(is));
//			}
			min = Integer.MAX_VALUE;
			Answer = 0;
			
			for (int i = 0; i < N; i++) {
				if(sol[i][1] < min) {
					min = sol[i][1];
					Answer++;
				}
//				if(sol[i][1] == 1) {
//					break;
//				}
			}
			System.out.println(Answer);
			//////////////////////////////////////
		} // end for
	} // end main

}
