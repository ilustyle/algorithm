package com.ad;

import java.util.*;
import java.io.*;

public class 접지봉 {

	/**
	 * @param args
	 */
	static int N, M, L, Answer, sum, count, min;
	static int[] A, visited, include;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/접지봉"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			L = sc.nextInt();
			N = sc.nextInt();
			A = new int[N];
			visited = new int[L*2];
			include = new int[L];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			Answer = 0;
			
//			for (int i = 0; i < N; i++) {
//				func(0, A[i], 1);
//			}
			
//			for (int i = 0; i < N; i++) {
//				visited[i] = 1;
//				go(visited, 1, A[i]);
//			}
			
			process(0, 0, L);

//			
			if(min == Integer.MAX_VALUE) {
				//System.out.println(-1);
			} else {
				//System.out.println(min);
			}
			
			
		} //end main for
	}
	
	public static void go(int[] visited, int count, int len) {
		if (len == L) {
			min = Math.min(min, count);
			return;
		} else if (len > L) {
			return;
		} else if (count > min) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (len + A[i] <= L
					&& (visited[len + A[i]] == 0 || visited[len + A[i]] >= count)) {
				visited[len + A[i]] = count;
				go(visited, count + 1, len + A[i]);
			}

			if (len - A[i] >= 0
					&& (visited[len - A[i]] == 0 || visited[len - A[i]] >= count)) {
				visited[len - A[i]] = count;
				go(visited, count + 1, len - A[i]);
			}

			if (A[i] - len >= 0
					&& (visited[A[i] - len] == 0 || visited[A[i] - len] >= count)) {
				visited[A[i] - len] = count;
				go(visited, count + 1, A[i] - len);
			}
		}
	}
	
	
	public static void process(int i, int total, int remaining) {

		//if (promising(total, remaining))
			if (i+1 == N) {
				System.out.println(total);
				if (total == L) {
					for (int k = 1; k <= N; k++)
						if (include[k] == 1)
							System.out.println(A[k]);
					System.out.println();
				}
			} else {
				include[i + 1] = 1;
				//System.out.println(i + 1);
				process(i + 1, total + A[i], remaining - A[i]);
				include[i + 1] = 0;
				process(i + 1, total, remaining - A[i]);
			}
	}
	
	private static void func(int x, int sum, int count) {
		visited[x] = 1;
		
		// TODO Auto-generated method stub
		if(sum == L) {
			Math.min(min, count);
			min = count;
			//System.out.println(min + " : " + count);
			return;
		} else if(min <= count) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				if(sum + A[i] <= L) {
					func(x+1, sum + A[i], count+1);
				}
				if(sum - A[i] >= 0) {
					func(x+1, sum - A[i], count+1);
				}
			}
		}
	}

}
