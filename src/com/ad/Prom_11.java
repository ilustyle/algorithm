package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_11 {

	/**
	 * @param args
	 * 심해 탐사 - 기출
	 */
	static int N, M, W, Answer;
	static int[][] S;


	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom11"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			/////////////////////////////////////////////////////////
			N = sc.nextInt();
			S = new int[10000][2];
			int[] sort = new int [N];
			
			for (int i = 0; i < N; i++) {
				S[i][0] = sc.nextInt();
				S[i][1] = sc.nextInt();
				sort[i] = S[i][1]*10000+S[i][0];
				sort[i] = S[i][1]*10000+S[i][0];
				//System.out.println(sort[i]);
			}
			Arrays.sort(sort);
			
			for (int i = 0; i < sort.length; i++) {
				System.out.println(sort[i]);
			}
			
			int sum = 0;
			Answer = 0;
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				int a = sort[i]/10000;
				int b = sort[i]%10000;
				sum += b;
				//System.out.println(sum-a);
				if(sum-a > max) {
					max = sum-a;
				}
			}
			System.out.println(max);
			/////////////////////////////////////////////////////////
		} // end for
	} // end main

}
