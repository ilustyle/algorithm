import java.util.*;
import java.io.FileInputStream;

public class 컴퓨터바이러스 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map;
	static int[] visited;
	static Queue<Integer> q;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/컴퓨터바이러스"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			////////////////////////////////////////
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N+1][N+1];
			visited = new int[N+1];
			q = new LinkedList<>();
			
			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				map[s][e] = 1;
				map[e][s] = 1;
			}
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			
			//visited[1] = 1;
			//dfs(1);
			bfs(1);
			////////////////////////////////////////		
			
//			for (int i = 0; i < visited.length; i++) {
//				System.out.println(visited[i]);
//			}
			System.out.println("#" + tc + " " + Answer);
		}
	}
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		q.add(x);
		visited[x] = 1;		
			while (!q.isEmpty()) {
				x = q.poll();
				for (int i = 1; i <= N; i++) {	
					if(map[x][i] == 1 && visited[i] == 0) {
						visited[i] = 1;
						Answer++;
						q.add(i);
					}
				}
			}
		
	}
	private static void dfs(int n) {
		// TODO Auto-generated method stub
		visited[n] = 1;
		if(n == N) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (map[n][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				Answer++;
				dfs(i);
			}
		}

		
	}

}
