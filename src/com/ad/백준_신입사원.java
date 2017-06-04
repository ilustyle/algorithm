package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class 백준_신입사원 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] P;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/백준신입"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			P = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				P[i][0] = sc.nextInt();
				P[i][1] = sc.nextInt();
			}
			
			Arrays.sort(P, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					Integer t1 = o1[1];
					Integer t2 = o2[1];
					return t1.compareTo(t2);
				}
			});
			
//			for (int i = 0; i < P.length; i++) {
//				System.out.println(P[i][0] + " : " + P[i][1]);
//			}
			
			Answer = 1;
			
//			for (int i = 0; i < N; i++) {
//				if(P[i][1] > min) {
//					Answer++;
//					min = P[i][1];
//				}
//				if(P[i][0] == 1) {
//					break;
//				}
//			}
			
			//System.out.println(P[0][0]);
			int min = P[0][0]; 
			for(int i= 0; i < N; i++) {
				if(P[i][0] < min) { 
					min = P[i][0]; 
					//System.out.println(P[i][0]);
					Answer++; 
				} 				
			}
			
			System.out.println(Answer);
			
		} //end main for
	}

}
