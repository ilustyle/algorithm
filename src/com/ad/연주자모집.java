package com.ad;

import java.util.*;
import java.io.*;

public class 연주자모집 {

	/**
	 * @param args
	 */
	static int N, M, L, Answer, sum, count, min;
	static int[][] map, visited;
	static int[] S, visit;
	static LinkedList<Integer> list;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/연주자"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			S = new int[N];
			map = new int[M][N];
			visited = new int[M][N];
			visit = new int[N];
			list = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				S[i] = sc.nextInt();
			}
			
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(map[j][i] != 0) {
//						map[j][i] = S[i]; 						
//					}
//				}
//			}
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			
			
//			for (int i = 0; i < M; i++) {
//				func(0, i);				
//			}
			Answer = Integer.MAX_VALUE;
			list.clear();

			backtrack(0, 0);

			
			for (int i = 0; i < visit.length; i++) {
				System.out.println(visit[i]);
			}
			
			/* 결과 값 출력 */
			System.out.println("#" + tc + " " + Answer);			

		} //end main for
	}

	public static void backtrack(int pos, int cost) {
		if (pos == N) {
			int covered = 0;

			for (int i = 0; i < M; i++) {
				visit[i] = 0;
			}

			for (int i : list) {
				for (int j = 0; j < M; j++) {
					if (map[j][i] == 1 && visit[j] == 0) {
						covered++;
						visit[j] = 1;
					}
				}
			}

			if(covered == M && cost < Answer) {
				Answer = cost;
			}
			
			return;
		}

		if(cost > Answer) {
			return;
		}

		for(int i = 0; i < 2; i++) {
			if(i == 1) {
				list.add(pos);
				backtrack(pos + 1, cost + S[pos]);
				list.removeLast();
			} else {
				backtrack(pos + 1, cost);
			}
		}
	}
	
	
//	private static void func(int x, int y) {
//		// TODO Auto-generated method stub
//		visit[x] = 1;
//		System.out.println("x >> " + x);
//		System.out.println("sum >> " + sum);
////		if(x == N) {
////			if(sum < min) {
////				min = sum;
////				Answer = min;
////			}
////			return;
////		}
//		for (int i = 0; i < N; i++) {
//			if(visit[i] == 0) {
//				visit[i] += map[x][i];
//				//sum += map[x][i];
//				func(x+1, i);
//				visit[i] = 0;
//				sum -= map[x][i];
//			}
//		}
//	}

}
