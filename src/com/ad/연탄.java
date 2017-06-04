package com.ad;

import java.io.*;
import java.util.*;

public class 연탄 {

	/**
	 * @param args
	 */
	static int N, M, C, Answer, count;
	static int[][] Edge, map;
	static int[] Z, visited;
	static ArrayList<Integer> adj[];
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/도미노"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			Edge = new int[N][2];
			Z = new int[C];
			for (int i = 0; i < M; i++) {
				Edge[i][0] = sc.nextInt();
				Edge[i][1] = sc.nextInt();
			}
			for (int i = 0; i < C; i++) {
				Z[i] = sc.nextInt();
			}
			
			adj = new ArrayList[N+1];
			visited = new int[N+1];
			map = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				map[Edge[i][0]][Edge[i][1]] = 1;
				//map[Edge[i][1]][Edge[i][0]] = 1;
			}
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			
			for (int i = 0; i < N+1; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; i++) {
				adj[Edge[i][0]].add(Edge[i][1]);
				//adj[Edge[i][1]].add(Edge[i][0]);
			}
			
//			for (int i = 0; i < adj.length; i++) {
//				System.out.println(adj[i]);
//			}
			Answer = 0;
			count = 0;
			for (int i = 0; i < C; i++) {
				//count = 0;
				//dfs0(Z[i]);
				//dfs(Z[i]);
				//dfs2(Z[i]);
				bfs(Z[i]);
				//Answer += count;
			}
			
			System.out.println("#" + tc + " " + count);

		} // end main for
	}

	private static void dfs0(int x) {
		// TODO Auto-generated method stub
		if(visited[x] == 1) {
			return;
		}
		visited[x] = 1;
		for (int i = 0; i < adj[x].size(); i++) {
			int V = adj[x].get(i);
			if (visited[V] == 0) {
				//System.out.println("dfs0 >> " + x + " -> " + V);
				dfs0(V);
				count++;
			}
		}
	}
	
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		if(visited[x] == 1) {
			return;
		}
		visited[x] = 1;
		for (int i = 0; i < adj[x].size(); i++) {
			int V = adj[x].get(i);
			if(visited[V] == 0) {
				//System.out.println("dfs >> " + x + " -> " + V);
				dfs(V);
				count++;
				//visited[i] = 1;
			}
		}
	}
	
	private static void dfs2(int x) {
		// TODO Auto-generated method stub
		if(visited[x] == 1) {
			return;
		}
		visited[x] = 1;
		for (int i = 0; i <= N; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				//System.out.println("dfs2 >> " + x + " -> " + i);
				dfs2(i);
				count++;
			}
		}
	}
	
	
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		q.add(x);
		visited[x] = 1;	
		while (!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i <= N; i++) {
				if(map[x][i] == 1 && visited[i] == 0) {
					//System.out.println("bfs >> " + x + " -> "+ i);
					q.add(i);
					count++;
					visited[i] = 1;	
				}
			}
		}	
	}

}
