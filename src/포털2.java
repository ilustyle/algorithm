import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 포털2 {
	static int T, N, M;
	static int[][] Marr;
	// static int[] Dist;
	static boolean[][] Adj;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/포털이동"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			Marr = new int[M][2];
			// Dist = new int[M];
			for (int i = 0; i < M; i++) {
				Marr[i][0] = sc.nextInt();
				Marr[i][1] = sc.nextInt();
			}
			// /여기서 부터 알고리즘 시작//
			Adj = new boolean[N + 1][N + 1];
			visit = new boolean[N + 1];
			// int[] Dist = new int[N + 1];
			// Arrays.fill(Dist, -1);
			// for (int i = 0; i < N + 1; i++)
			// Dist[i] = -1;
			for (int i = 0; i < M; ++i) {
				int u = Marr[i][0];
				int v = Marr[i][1];
				Adj[u][v] = true;
				Adj[v][u] = true;
			}
			/*
			 * Check Array Print for(int i=1; i < N+1;i++){ for(int j=1; j <
			 * N+1;j++){ System.out.print(Adj[i][j]+" "); }
			 * System.out.println();
			 * 
			 * }
			 */
			/*
			 * Queue<int[]> Q = new LinkedList<int[]>(); Dist[1] = 0; Q.add(new
			 * int[]{1});
			 * 
			 * while (!Q.isEmpty()) { int here = Q.poll()[0];
			 * 
			 * //System.out.println(here);
			 * 
			 * for (int there = 1; there <= N; there++) { if (Adj[here][there]
			 * == false || Dist[there] != -1){ continue; //for문 다시 돌림 }
			 * 
			 * // 제대로 된 애들 Dist[there] = Dist[here] + 1; Q.add(new
			 * int[]{there});
			 * 
			 * 
			 * } }
			 */
			// DFS(1);
			int Answer = DFS(1);
			// System.out.printf("#%d %d\n", test_case, Dist[N]);
			if (Answer == INF) {
				Answer = -1;
			}
			System.out.println(Answer);
		}
	}

	public static int DFS(int x) {
		if (x == N) {
			return 0;
		}
		visit[x] = true;
		int ret = INF;
		for (int there = 1; there <= N; there++) {
			if (Adj[x][there] == false || visit[there] == true) {
				continue;
			}

			int subret = 1 + DFS(there);
			if (subret == INF) {
				continue;
			}
			if (ret > subret) {
				ret = subret;
			}
		}
		visit[x] = false;
		return ret;
	}
}
