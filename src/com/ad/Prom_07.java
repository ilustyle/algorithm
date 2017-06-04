package com.ad;

import java.util.*;
import java.io.FileInputStream;
public class Prom_07 {

	/**
	 * @param args
	 * 미로찾기 - 경로 출력
	 */
	static int N, M, K, Answer;
	static int map[][], visit[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom07"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < 3; tc++) {
			/////////////////////////////////////////////
			N = sc.nextInt();
			map = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					visit[i][j] = map[i][j];
				}
			}

			for (int[] is : map) {
				System.out.println(Arrays.toString(is));
			}
			
			Stack<String> pass = new Stack<String>();
			pass.add("0,0");
			visit[0][0] = 1;
			
			boolean f = true;
			
			while (f) {
				String tmp = pass.pop();
				int x = Integer.parseInt(tmp.split(",")[0]);
				int y = Integer.parseInt(tmp.split(",")[1]);
				
				if(x == N-1 && y == N-1) {
					pass.add(x+","+y);
					f = false;
					break;
				} else{
					if(x+1 < N && map[x+1][y] == 0 && visit[x+1][y] == 0) {
						visit[x+1][y] = 1;
						pass.add(x+","+y);
						pass.add((x+1)+","+y);
					} else if (x-1 >= 0 && map[x-1][y] == 0 && visit[x-1][y] == 0) {
						visit[x-1][y] = 1;
						pass.add(x+","+y);
						pass.add((x-1)+","+y);
					} else if (y+1 < N && map[x][y+1] == 0 && visit[x][y+1] == 0) {
						visit[x][y+1] = 1;
						pass.add(x+","+y);
						pass.add(x+","+(y+1));
					} else if (y-1 >= 0 && map[x][y-1] == 0 && visit[x][y-1] == 0) {
						visit[x][y-1] = 1;
						pass.add(x+","+y);
						pass.add(x+","+(y-1));
					} else if (x+1 < N && y+1 < N && map[x+1][y+1] == 0 && visit[x+1][y+1] == 0) {
						visit[x+1][y+1] = 1;
						pass.add(x+","+y);
						pass.add((x+1)+","+(y+1));
					} else if (x-1 > 0 && y-1 >= 0 && map[x-1][y-1] == 0 && visit[x-1][y-1] == 0) {
						visit[x-1][y-1] = 1;
						pass.add(x+","+y);
						pass.add((x-1)+","+(y-1));
					} else if (x+1 < N && y-1 >= 0 && map[x+1][y-1] == 0 && visit[x+1][y-1] == 0) {
						visit[x+1][y-1] = 1;
						pass.add(x+","+y);
						pass.add((x+1)+","+(y-1));
					} else if (x-1 >= 0 && y+1 < N && map[x-1][y+1] == 0 && visit[x-1][y+1] == 0){
						visit[x-1][y+1] = 1;
						pass.add(x+","+y);
						pass.add((x-1)+","+(y+1));
					} else {
						pass.add(x+","+y);
						f = false;
					}
				}
			}
			for (int i = 0; i < pass.size(); i++) {
				String tmp = pass.get(i);
				int x = Integer.parseInt(tmp.split(",")[0]);
				int y = Integer.parseInt(tmp.split(",")[1]);
				System.out.println((x+1) + ", " + (y+1));
			}
			System.out.println();
			/////////////////////////////////////////////
		} // end for
	} // end main

}
