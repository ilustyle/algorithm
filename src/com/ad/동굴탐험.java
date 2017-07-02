package com.ad;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 동굴탐험 {

	/**
	 * @param args
	 */
	static int N, M, count, Answer;
	static int[][] E;
	static int[][] map;
	static int[] visited;
	static Queue<Integer> q;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/동굴탐험"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			E = new int[N][2];
			for (int i = 0; i < M; i++) {
				E[i][0] = sc.nextInt();
				E[i][1] = sc.nextInt();
			}
			map = new int[N+1][N+1];
			visited = new int[N+1];
			q = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				map[E[i][0]][E[i][1]] = 1;
				map[E[i][1]][E[i][0]] = 1;
			}
			count = 1;
			Arrays.fill(visited, 0);
			bfs(1);
			
			Answer = Integer.MIN_VALUE;
			for (int i = 0; i < visited.length; i++) {
				//System.out.print(visited[i] + " ");
				if(visited[i] > Answer) {
					Answer = visited[i];
				}
			}
			System.out.println("#" + tc + " " + Answer);
		} // end main for
	}
	
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		q.add(x);
		visited[x] = 1;
		while (!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i <= N; i++) {
				if (map[x][i] == 1 && visited[i] == 0) {
					//System.out.println(x + " -> " + i);
					visited[i] = visited[x] + 1;
					q.add(i);
				}
			}
		}
	}
}
