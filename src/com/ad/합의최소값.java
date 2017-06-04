package com.ad;

import java.util.*;
import java.io.*;

public class 합의최소값 {

	/**
	 * @param args
	 */
	static int N, M, Answer, count, sum;
	static int[] A, visit;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/합의 최소값"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N+1];
			visit = new int[N+1];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			Answer = Integer.MIN_VALUE;
			sum = 0;
			
			func(0, 0);
			
			int result = 0;
			result = Answer-M;
			
			System.out.println(result >= 0 ? result : -result);
			
		} // end main for 
		
	}
	
	private static void func(int x, int sum) {
		// TODO Auto-generated method stub
		if (x == N) {
			//System.out.println("sum >> " + sum);
			if (sum < M) {
				if (Answer < sum) {
					Answer = sum;
				}
				// System.out.println(sum);
			}
			return;
		}
		if(sum + A[x] <= M) {	
			func(x + 1, sum + A[x]);
		}
		func(x + 1, sum);			
		
	}

}
