package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class 단지번호 {

	/**
	 * @param args
	 */
	static int N, M, Answer, count, num;
	static int[][] map, visit;
	static int[] result;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/단지번호"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			visit = new int[N][N];
			result = new int[N*N];
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			num = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && visit[i][j] == 0) {
						dfs(i, j);
						num++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visit[i][j] != 0) {
						result[visit[i][j]]++;
					}
				}
			}
			
//			for (int[] is : visit) {
//				System.out.println(Arrays.toString(is));
//			}
			
			Arrays.sort(result);
			
			System.out.println(num-1);
			for (int i = 0; i < result.length; i++) {
				if(result[i] != 0) {
					System.out.println(result[i]);					
				}
			}
		} // end main for
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = num;
		if(x == N && y == N) {
			return;
		}
		if(x+1 < N && map[x+1][y] == 1 && visit[x+1][y] == 0) {
			dfs(x+1, y);
		}
		if(x-1 >= 0 && map[x-1][y] == 1 && visit[x-1][y] == 0) {
			dfs(x-1, y);
		}
		if(y+1 < N && map[x][y+1] == 1 && visit[x][y+1] == 0) {
			dfs(x, y+1);
		}
		if(y-1 >= 0 && map[x][y-1] == 1 && visit[x][y-1] == 0) {
			dfs(x, y-1);
		}
	}

}
