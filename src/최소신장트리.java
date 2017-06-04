import java.util.*;
import java.io.*;

public class 최소신장트리{

	/**
	 * @param args
	 * Prim - 최소비용 트리
	 */
	static int N, M, Answer, min, idx, org;
	static int[][] arr;
	static int[] w;
	static int[][] map, n_map;
	static int[] cost, visited;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/최소신장"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			///////////////////////////////////////////////////////
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[M][2];
			w = new int[M];
			
			cost = new int[N+1];
			visited = new int[N+1];
			
			for (int i = 0; i < M; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				w[i] = sc.nextInt();
			}
			
			
			map = new int[N+1][N+1];
			n_map = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
					map[arr[i][0]][arr[i][1]] =  w[i];
					map[arr[i][1]][arr[i][0]] =  w[i];
			}
			Answer = 0;
			
			Arrays.fill(cost, 99);
			//prim(1);
			dfs(0);
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
//			for (int i = 1; i < map.length; i++) {
//				for (int j = 1; j < map.length; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
			for (int i = 0; i < visited.length; i++) {
				System.out.print(visited[i]);
			}
//			
			System.out.println();
			for (int i = 0; i < cost.length; i++) {
				System.out.print(cost[i]);
			}
			
			System.out.println();
			
			System.out.println(Answer);
			///////////////////////////////////////////////////////
		}
		
	}
	
	private static void dfs(int v) {
		// TODO Auto-generated method stub

		cost[v] = 0;
		visited[v] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N+1; j++) {				
				if (visited[j] == 1) {
					continue;
				}
				if(map[v][j] == 0) {
					continue;
				}
				if(map[v][j] < cost[j]) {
					cost[j] = map[v][j];
				}
			}
			for (int j = 0; j < N+1; j++) {
				if(visited[j] == 0) {
					v = j;
					break;
				}
			}
			for (int j = v; j < N+1; j++) {
				if(visited[j] == 1) {
					continue;
				}
				
				if(cost[j] < cost[v]) {
					v = j;
				}
			}
			visited[v] = 1;
			Answer += cost[v];
		}
	}

	public static void prim(int x) {
		int i, j, k;
		visited[x] = 1;
		min = map[x][x];
		for (i = 0; i < N-1; i++) {
			if(map[x][i] < min) {
				idx = i;
				Answer = map[x][i];
			}
		}
		visited[idx] = 1;
		n_map[x][i] = n_map[i][x] = 1;
		System.out.println("x " + x + ", " + idx + " : " + min);
		
		for (i = 0;  i < N; i++) {
			min = 999;
			for ( j = 0; j < N-1; j++) {
				for ( k = 0; k < N-1; k++) {
					if(visited[j] == 1 && visited[k] == 0) {
						if(map[j][k] < min && n_map[j][k] == 0) {
							idx = k;
							org = j;
							Answer = map[j][k];
						}
					}
				}
			}
			visited[idx] = 1;
			n_map[org][idx] = n_map[idx][org] = 1;
			System.out.println("x " + org + ", " + idx + " : " + min);
		}
	}

}
