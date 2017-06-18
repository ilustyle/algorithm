import java.io.*;
import java.util.*;

public class 미지의섬 {

	/**
	 * @param args
	 */
	static int N, M, X;
	static int[][] Edge = new int[501][2];
	static int[][] map;
	static int[] visited;
	static ArrayList<Integer> adj[];
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/미지의섬"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 다리건너는 횟수
			M = sc.nextInt(); // 연결된 다리 갯수
			X = sc.nextInt(); // 가고자 하는 섬
			
			for (int i = 0; i < M; i++) {
				Edge[i][0] = sc.nextInt();
				Edge[i][1] = sc.nextInt();
			}
			
			// under here
			map = new int[X*2][X*2];
			visited = new int[X*2];
			adj = new ArrayList[X*2];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				map[Edge[i][0]][Edge[i][1]] = 1;
				map[Edge[i][1]][Edge[i][0]] = 1;
				adj[Edge[i][0]].add(Edge[i][1]);
				adj[Edge[i][1]].add(Edge[i][0]);
			}
			Arrays.fill(visited, 0);
			dfs(1);
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
//			for (int i = 0; i < visited.length; i++) {
//				System.out.print(visited[i] + " ");
//			}
			System.out.println("#" + (tc) + " " + (visited[X]==1 ? "YES" : "NO"));			
			
		} // end main for
	}
	
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		//System.out.println(x);
		visited[x] = 1;
		for (int i = 0; i < map.length; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				//System.out.println(x + " -> " + i);
				visited[i] = 1;
				dfs(i);
			}
		}
	}
}
