import java.util.*;
import java.io.FileInputStream;

public class 컴퓨터바이러스_List {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map;
	static int[] visited;
	static ArrayList<Integer> al[];
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
			al = new ArrayList[N+1];
			for (int i = 0; i < al.length; i++) {
				al[i] = new ArrayList();
			}
			
			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				map[s][e] = 1;
				map[e][s] = 1;
				al[s].add(e);
				al[e].add(s);
			}
			
//			for (int i = 0; i < al.length; i++) {
//				System.out.println(al[i]);
//			}
			Answer = 1;
			
			dfs(1);
			System.out.println(Answer);
		} //end for
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < al[x].size(); i++) {
			if(visited[i] == 1) {
				continue;
			}
			int v = al[x].get(i);
			if(visited[v] == 0) {
				visited[i] = 1;
				Answer++;
				dfs(v);
			}
		}
	}
}
