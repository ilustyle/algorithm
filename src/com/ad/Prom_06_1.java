package com.ad;

import java.util.*;
import java.io.FileInputStream;


public class Prom_06_1 {

	/**
	 * @param args
	 * 신입사원 - 기출
	 * 
	 */
	static int map[][];
	static int P, S, K, N, M, Answer, max, tmp;
	static int visit[];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom06_1"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			N = sc.nextInt();
			map = new int [N][N];
			visit = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			
			int min = 0;
			int tmp = 0;
//			Arrays.sort(map, new Comparator<int []>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					// TODO Auto-generated method stub
//					Integer t1 = o1[0];
//					Integer t2 = o2[0];
//					return t1.compareTo(t2);
//				}
//			});
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
//			
			/* 외계인 */
			for (int i = 0; i < map.length; i++) {
				min = map[i][0];
				for (int j = 0; j < map[i].length; j++) {
					if(min > map[i][j]) {
						min = map[i][j];
					}
				}
				tmp += min;
				//System.out.print(max+ " ");
				//System.out.println();
			}
			
//			/*  신입 */
//			for (int i = 0; i < map.length; i++) {
//				min = map[i][0];
//				for (int j = 0; j < map[i].length; j++) {
//					if(min <= map[j][i]) {
//						min = map[j][i];
//					}
//				}
//				tmp += min;
//				//System.out.print(max+ " ");
//				//System.out.println();
//			}
			
			System.out.println(tmp);
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main


}
