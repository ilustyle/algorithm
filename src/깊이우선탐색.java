import java.util.*;
import java.io.FileInputStream;

public class 깊이우선탐색 {

	/**
	 * @param args
	 */
	static int v, e;
	static int N, M, Answer;
	static int map[][];
	static int visit[];
	static int stack[];
	static int top = -1;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/占쏙옙占싱우선(占쏙옙占쏙옙)"));
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		map = new int[e][e];
		visit = new int[e];
		stack = new int[v*2];
		
		for (int i = 0; i < e; i++) {
 			int start = sc.nextInt();
 			int end = sc.nextInt();
 			map[end][start] = 1;
 			map[start][end] = 1;
		}
		
		dfs(1);
//		for (int[] s : map) {
//			System.out.println(Arrays.toString(s));
//		}
	}
	
	public static void dfs(int node) {
		visit[node] = 1;
		for (int i = 0; i < e; i++) {
			if(map[node][i] == 1 && visit[i] == 0) {
				System.out.println(node + " -> " + i);
				dfs(i);
			}
		}
	}

}
