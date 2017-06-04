package com.ad;

import java.util.*;
import java.io.*;

public class 미로로봇 {

	/**
	 * @param args
	 * 
	 * output: 9
	 */
	static int N, M, Answer, sx, sy, dx, dy;
	static int[][] map, visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/미로로봇"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			sx = sc.nextInt();
			sy = sc.nextInt();
			dx = sc.nextInt();
			dy = sc.nextInt();
			map = new int[M+1][N+1];
			visited = new int[M+1][N+1];
			
			for (int i = 1; i <= M; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt()== 0 ? 1:0;
				}	
			}
			
			bfs(sx, sy);
			System.out.println(visited[dx][dy]);
			//System.out.println(st.size());
//			System.out.println((sx-1) + " : " + (sy-1));
//			
			for (int[] is : visited) {
				System.out.println(Arrays.toString(is));
			}
		} //end for
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		q.add(new int[]{x,y});
		visited[x][y] = 1;
		int collCount = 0;
		
		while (!q.isEmpty()) {
			int arr[] = q.poll();
			x = arr[0];
			y = arr[1];
			//System.out.println(x + ", " + y);
			if(x == dx && y == dy) {
				break;
			}

			if(map[x-1][y] == 1 && visited[x-1][y] == 0){
				q.add(new int[] {x-1, y});
				visited[x-1][y] = visited[x][y]+1;
			}
			
			if(map[x+1][y] == 1 && visited[x+1][y] == 0){
				q.add(new int[] {x+1, y});
				visited[x+1][y] = visited[x][y]+1;
			}
			
			if(map[x][y-1] == 1 && visited[x][y-1] == 0){
				q.add(new int[] {x, y-1});
				visited[x][y-1] = visited[x][y]+1;
			}
			
			if(map[x][y+1] == 1 && visited[x][y+1] == 0){
				q.add(new int[] {x, y+1});
				visited[x][y+1] = visited[x][y]+1;
			}	
		} // end while
		

		
	}

}
