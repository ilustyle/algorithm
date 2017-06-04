package com.ad;

import java.util.*;
import java.io.FileInputStream;


public class Prom_06 {

	/**
	 * @param args
	 * 신입사원 - 기출
	 * 
	 */
	static int map[][];
	static int P, S, K, N, M, Answer, max, min, tmp;
	static int visit[];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom06_1"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			max = 0;
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
			
			/* 신입 사원 */
//			max = Integer.MIN_VALUE;
//			dfs(0);
//			System.out.println(max);
			
			
			/* 외계인 */
			min = Integer.MAX_VALUE;
			dfs2(0);
			System.out.println(min);
			
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main
	public static void dfs(int v) { // 신입사원
		// TODO Auto-generated method stub
		tmp = 0;
		if(v == N) {
			for (int i = 0; i < N; i++) {
				tmp += visit[i];
			}
			if(tmp > max) {
				max = tmp;
			}
			return;
		} 

		for (int i = 0; i < N; i++) {
			if (visit[i] == 0) {
				visit[i] = map[v][i];
				dfs(v + 1);
				visit[i] = 0;
			}
		}
		
	}
	public static void dfs2(int v) { // 외계인
		// TODO Auto-generated method stub
		if(v == N) {
			if(tmp < min) {
				min = tmp;
			}
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if(visit[i] == 0) {
					tmp += map[v][i];
					System.out.println(tmp + " : " + map[v][i]);
					if(tmp > min) {
						tmp -= map[v][i];
						continue;
					}
					visit[i] = 1;
					dfs2(v+1);
					tmp -= map[v][i];
					visit[i] = 0;
				}
			}
		}
		
	}
}
