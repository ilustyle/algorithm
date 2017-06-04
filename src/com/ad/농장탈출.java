package com.ad;

import java.io.*;
import java.util.*;

public class 농장탈출 {

	/**
	 * @param args
	 */
	static int N, M, Answer, weight, sum, count;
	static int[] W, visited;
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/농장탈출"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = new int[N];
			visited = new int[N];
			
			for (int i = 0; i < N; i++) {
				W[i] = sc.nextInt();
			}
			Arrays.sort(W);
//			for (int i = 0; i < N; i++) {
//				System.out.println(W[i]);
//			}
			count = 0;
			weight = 0;
			Answer = 0;
			func(0, 0, 0);
		
			System.out.println(Answer);
			//count = 0;
		} //end for

	}

	private static void func(int x, int weight, int count) {
		// TODO Auto-generated method stub
		if (x == N) {
			if (Answer < count) {
				Answer = count;
			}
			return;
		}
		if (isSolution(weight, W[x]) == true) {
			// count++;
			// weight += W[x];
			func(x + 1, weight + W[x], count + 1);
		}
		func(x + 1, weight, count);
			
	}
	
	private static boolean isSolution(int x, int y) {
		// TODO Auto-generated method stub
		while ((x != 0) && (y != 0)) {
			if ((x % 10 + y % 10) > 9) {
				return false;				
			}
			x /= 10;
			y /= 10;
			//System.out.println("x >> " + x  + " : "+ "y >> " +  y);
			//System.out.println("x >> " + x  + " : "+ " y >> " +  y +  " (x % 10) >> " + x % 10 + " (y % 10) >> " + y% 10 + " res >> " +  ((x % 10 + y % 10)));
		}
		return true;
	}

}
