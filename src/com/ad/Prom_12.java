package com.ad;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Prom_12 {
	
	/**
	 * @param args
	 * 자동차 경주
	 * 
	 */
	static int T, N, F;
	static int[] Life, Time, Cost;

	public static void main(String args[]) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom12"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			/////////////////////////////////////////////////////////
			N = sc.nextInt();
			F = sc.nextInt();

			Life = new int[N + 2];
			Time = new int[N + 2];
			Cost = new int[N + 2];

			//Life[0] = F;

			for (int i = 1; i < N + 1; i++) {
				Life[i] = sc.nextInt();
				Time[i] = sc.nextInt();
			}

			for(int i = F; i > 0; i-- ) {
				bt(0, i, 1);	
			}
		//	System.out.println("#" + test_case + " " + Cost[N + 1]);
			/////////////////////////////////////////////////////////
		}
	}

	public static void bt(int start, int end, int node) {
		if (node > 3 || end > N+1) {
			return;
		}
		
		if (Cost[end] == 0 || Cost[end] > Cost[start] + Time[end]) {
			Cost[end] = Cost[start] + Time[end];
			System.out.println(Cost[end] + " >> " + Cost[start] + "+" + Time[end]);
		} 
		
		for(int i = end+Life[end]; i > 0; i-- ) {
			bt(end, i, node+1);
		}
	}
}
