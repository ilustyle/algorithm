package com.boj;

import java.io.*;
import java.util.*;

public class 경로찾기_11403 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map, result;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		result = new int[N][N];
		visited = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			bfs(i);
			for (int j = 0; j < N; j++) {
				//if(visited[j] == 1) {
					result[i][j] = visited[j];
				//}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			visited[i] = 0;
		}
		q.add(x);
		//visited[x] = 1;
		while (!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i < N; i++) {
				if(map[x][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
	}

}
