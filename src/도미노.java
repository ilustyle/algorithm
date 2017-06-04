import java.util.*;
import java.io.*;

public class 도미노 {

	/**
	 * @param args
	 */
	static int N, M, L, Answer;
	static int[][] Edge = new int[3000][2];
	static int Z[] =new int [3000];
	
	static int[][] map;
	static int[] visited;
	static Queue<Integer> q;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/도미노"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			L = sc.nextInt();
			for (int i = 0; i < M; i++) {
				Edge[i][0] = sc.nextInt();
				Edge[i][1] = sc.nextInt();
			}
			for (int i = 0; i < L; i++) {
				Z[i] = sc.nextInt();
			}
			
			map = new int[N+1][N+1];
			visited = new int[N+1];
			q = new LinkedList<>();
			
			Answer = 0;
			for (int i = 0; i < N; i++) {
				if(Edge[i][0] != 0 && Edge[i][1] != 0) {
					map[Edge[i][0]][Edge[i][1]] = 1;		
				}
			}
			
//			for (int i = 0; i < L; i++) {
//					dfs(Z[i]);	
//			}
			
			for (int i = 0; i < L; i++) {
					bfs(Z[i]);	
			}
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			System.out.println("#" + testCase + " " + Answer);
		} // end of testCase
	}
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		q.add(x);
		visited[x] = 1;	
		while (!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i < N; i++) {
				if(map[x][i] == 1 && visited[i] == 0) {
					q.add(i);
				//	visited[x] = 1;
				}
			}
			Answer++;
		}
		
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		if(visited[x] == 1) {
			return;
		}
		//visited[x] = 0;
		//map[x-1][x] = 1;
		for (int i = x; i <= N; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
		//map[x-1][x] = 0;
		Answer++;
		visited[x] = 1;
	}

}
