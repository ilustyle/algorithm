package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_09 {

	/**
	 * @param args
	 * 말이동 - 기출
	 * 
	 * 
#1 6
#2 5
#3 6
#4 6
#5 5
#6 6
#7 5
#8 4
#9 5
#10 4
#11 5
#12 6
#13 5
#14 4
#15 5
#16 5
#17 6
#18 5
#19 5
#20 6
#21 6
#22 6
#23 7
#24 6
#25 6
#26 6
#27 6
#28 6
#29 6
#30 8
#31 7
#32 8
#33 8
#34 7
#35 7
#36 7
#37 8
#38 9
#39 8
#40 8
#41 8
#42 8
#43 11
#44 9
#45 10
#46 10
#47 8
#48 8
#49 10
#50 9

	 */
	static int N, M, Answer;
	static int map[][], visit[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stubu  6
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		System.setIn(new FileInputStream("src/data/prom09"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < 1; tc++) {
			/////////////////////////////////////////////////////
			N = sc.nextInt();
			map = new int[N][N];
			visit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Answer = Integer.MAX_VALUE;
			System.out.println();
			dfs(0, 0, 0);
			System.out.println(Answer);
			/////////////////////////////////////////////////////
		} // end for

	} // end main
	public static void dfs(int i, int j, int k) {
		// TODO Auto-generated method stub
		visit[i][j] = k;
		if(i == N-1 && j == N-1) {
			if(k < Answer) {
				Answer = k;
			}
			return;
		} else {
			for (int r = 1; r <= map[i][j]; r++) {
				if(i+r >= N) { break; }
				if(visit[i+r][j] > 0 && visit[i+r][j] <= k+1  ) {
					continue;
				}
				dfs(i+r, j, k+1);
			}
			for (int r = 1; r <= map[i][j]; r++) {
				if(j+r >= N) { break; }
				if(visit[i][j+r] > 0 && visit[i][j+r] <= k+1) {
					continue;
				}
				dfs(i, j+r, k+1);
			}
		}
	}

}
