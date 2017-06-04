package com.ad;

import java.io.*;
import java.util.*;

public class 폭탄공장 {

	/**
	 * @param args
	 */
	static int N, K, Answer, count;
	static int[] M, result;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/폭탄공장"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			M = new int[K];
			result = new int[K+1];
			
			for (int i = 0; i < K; i++) {
				M[i] = sc.nextInt();
			}
			///////////////////////////////////////////////////////////
			
//			for (int i = 0; i < K; i++) {
//				System.out.print(M[i] + " ");
//			}
//			System.out.println();
//			Arrays.sort(M);
//			for (int i = 0; i < K; i++) {
//				System.out.print(M[i] + " ");
//			}
//			System.out.println();
			
			Arrays.fill(result, -1);
			Answer = 0;
			func(0, 0);
			
			for (int i = 0; i < result.length; i++) {
				if(result[i] == -1) {
					result[i] = 0;
					//System.out.print("res >> " + result[i] + " ");
				} else {
					Answer += result[i];
				}
			}
			///////////////////////////////////////////////////////////
			System.out.println("#" + tc + " " + Answer);
		} // end main for
	}

	private static void func(int x, int cnt) {
		// TODO Auto-generated method stub
		if (x == K) {
			return;
		}
		if (N <= M[x]) {
			//System.out.println("M[i] >> " + M[x]);
			//func(x + 1, cnt + 1);
			result[x+1] = cnt + 1;
		}
		//result[x] = cnt;
		func(x + 1, cnt);
	}

}
