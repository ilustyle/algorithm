package com.boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 연결요소의개수_11724 {

	/**
	 * @param args
	 */
	static int N, M, Answer, count;
	static int[][] map, result, Edge;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Edge = new int[M][2];
		map = new int[N+1][N+1];
		result = new int[N][N];
		visited = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			Edge[i][0] = sc.nextInt();
			Edge[i][1] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			map[Edge[i][0]][Edge[i][1]] = 1;
			map[Edge[i][1]][Edge[i][0]] = 1;
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		for (int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		visited[x] = 1;
		for (int i = 1; i <= N; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				//System.out.println(x + " -> " + i);
				visited[i] = 1;
				dfs(i);
				//count++;
			}
		}
	}

}
