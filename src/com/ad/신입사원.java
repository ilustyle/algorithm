package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class 신입사원 {

	/**
	 * @param args
	 */
	static int N, M, Answer, tmp, max, min;
	static int[][] map;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/신입사원"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new int[N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Answer = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			//fMax(0);
			fMin(0);

			System.out.println("#" + tc + " " + Answer);
			
		} //end for
	}


	private static void fMin(int x) {
		// TODO Auto-generated method stub
		if(x == N) {
			//System.out.println(tmp);
			if(tmp < min) {
				min = tmp;
				Answer = min;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				tmp += map[x][i];
				visited[i] = 1;
				fMin(x+1);
				visited[i] = 0;
				tmp -= map[x][i];
			}
		}
	}


	private static void fMax(int x) {
		// TODO Auto-generated method stub
		tmp = 0;
		if(x == N){
			for (int i = 0; i < N; i++) {
				tmp += visited[i];
			}
			if(tmp > max) {
				max = tmp;
				Answer = max;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = map[x][i];
				fMax(x+1);
				visited[i] = 0;
			}
		}
		
	}

}
