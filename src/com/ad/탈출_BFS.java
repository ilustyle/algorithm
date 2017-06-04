package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class 탈출_BFS {

	/**
	 * @param args
	 */
	static int N, M, Answer, W, H, count;
	static char[][] map;
	static int[][] visited, f_visited;
	static Queue<int[]> fq;
	static boolean isOut;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/탈출"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			W = sc.nextInt();
			H = sc.nextInt();
			map = new char[H+2][W+2];
			visited = new int[H+2][W+2];
			f_visited = new int[H+2][W+2];
			
			
			fq = new LinkedList<>();
			
			int h_x = 0;
			int h_y = 0;
			count = 0;
			isOut = false;
			
			for (int i = 0; i < H + 2; i++) {
				for (int j = 0; j < W + 2; j++) {
					if (i == 0 || i == H+1 || j == 0 || j == W+1) {
						map[i][j] = 'X';
					}
				}
			}
			
			for (int i = 1; i <= H; i++) {
				String s = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j + 1] = s.charAt(j);
					if (map[i][j + 1] == '@') {
						h_x = i;
						h_y = j + 1;
						//map[i][j + 1] = '.';
					}
				}
			}
			
			
			for (char[] is : map) {
			System.out.println(Arrays.toString(is));
		}
			
			
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '*') {
						fq.add(new int[]{i, j, count, 1});
						f_visited[i][j] = 1;
					}
				}
			}
			//System.out.println(h_x + " : " + h_y + ", " + f_x + " : " + f_y);
		
			bfs(h_x, h_y, count);
			
			
			if (isOut == false) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(count);
			}
			
//			for (char[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
//			
//			for (int[] is : visited) {
//				System.out.println(Arrays.toString(is));
//			}
		
			//System.out.println(count);
		} //end main for
	}

	private static void bfs(int x, int y, int num) {
		// TODO Auto-generated method stub

		
		fq.add(new int[]{x, y, num, 0});
		visited[x][y] = 1;
		
		while (!fq.isEmpty()) {
			int[] hrr = fq.poll();
			int fx = hrr[0];
			int fy = hrr[1];
			int cnt = hrr[2];
			int tp = hrr[3];
			
			//System.out.println(fx + " , " +  fy + " , " + cnt + " , " + tp);
			if(map[fx][fy] == 'X' && tp == 0) {
				isOut = true;
				count = cnt;
				break;
			}
			
			if(tp == 1) {  // 현재 좌표가 불이면
				
				//System.out.println(fx + " : " + fy);
				if(map[fx+1][fy] == '.' && f_visited[fx+1][fy] == 0){
					f_visited[fx+1][fy] = 1;
					map[fx+1][fy] = '*';
					fq.add(new int[]{fx+1,fy,cnt+1,1});
				}
				
				if(map[fx-1][fy] == '.' && f_visited[fx-1][fy] == 0){
					f_visited[fx-1][fy] = 1;
					map[fx-1][fy] = '*';
					fq.add(new int[]{fx-1,fy,cnt+1,1});
				}
				
				if(map[fx][fy+1] =='.' && f_visited[fx][fy+1] == 0){
					f_visited[fx][fy+1] = 1;
					map[fx][fy+1] = '*';
					fq.add(new int[]{fx,fy+1,cnt+1,1});
				}
				
				if(map[fx][fy-1] =='.' && f_visited[fx][fy-1] == 0){
					f_visited[fx][fy-1] = 1;
					map[fx][fy-1] = '*';
					fq.add(new int[]{fx,fy-1,cnt+1,1});
				}
			} else if(tp == 0) {  // 상근이좌표면
				
				if(map[fx+1][fy] != '*' && map[fx+1][fy] != '#' && visited[fx+1][fy] == 0){
					visited[fx+1][fy] = 1;
					fq.add(new int[]{fx+1,fy,cnt+1,0});
				}
				
				if(map[fx-1][fy] != '*' && map[fx-1][fy] != '#' && visited[fx-1][fy] == 0){
					visited[fx-1][fy] = 1;
					fq.add(new int[]{fx-1,fy,cnt+1,0});
				}
				
				if(map[fx][fy+1] != '*' && map[fx][fy+1] != '#' && visited[fx][fy+1] == 0){
					visited[fx][fy+1] = 1;
					fq.add(new int[]{fx,fy+1,cnt+1,0});
				}
				
				if(map[fx][fy-1] != '*' && map[fx][fy-1] != '#' && visited[fx][fy-1] == 0){
					visited[fx][fy-1] = 1;
					fq.add(new int[]{fx,fy-1,cnt+1,0});
				}
			} // end if - else if
			
//			for (char[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
		}
	}

}
