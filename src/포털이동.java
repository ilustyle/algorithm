import java.io.*;
import java.util.*;

public class 포털이동 {

	/**
	 * @param args
	 */
	static int N, M, Answer, cnt;
	static int[][] Marr;
	
	static int[][] map;
	static ArrayList<Integer>[] al;
	static Queue<Integer> q;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/포털이동"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			///////////////////////////////////////////////////
			N = sc.nextInt();
			M = sc.nextInt();
			Marr = new int[M][2];
			for (int i = 0; i < M; i++) {
				Marr[i][0] = sc.nextInt();
				Marr[i][1] = sc.nextInt();
			}
			
			visited = new int[N+1];
			q = new LinkedList<>();
			
//			for (int[] is : Marr) {
//				System.out.println(Arrays.toString(is));
//			}
			
			//인접 행렬
			map = new int[M][M];
			for (int i = 0; i < M; i++) {
				map[Marr[i][0]][Marr[i][1]] = 1;
				map[Marr[i][1]][Marr[i][0]] = 1;
			}
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			Answer = Integer.MAX_VALUE;
			cnt = 0;
			
//			al = new ArrayList[M];
//			// 인접 리스트
//			for (int i = 0; i < M; i++) {
//				al[i] = new ArrayList<>();
//			}
//			for (int i = 0; i < M; i++) {
//				al[Marr[i][0]].add(Marr[i][1]);
//				al[Marr[i][1]].add(Marr[i][0]);
//			}
//			
//			for (ArrayList<Integer> is : al) {
//				System.out.println(is);
//			}
			//for (int i = 1; i < N; i++) {
				dfs(1);
				//bfs(1);
				int res = visited[N];
				if (Answer > res) {
					Answer = res;
				}
			//}
			
//			for (int i = 1; i < N; i++) {
//				bfs(i);
//				int res = visited[N];
//				if(Answer > res) {
//					Answer = res;
//				}
//			}
			
//			for (int i = 0; i < visited.length; i++) {
//				System.out.print(visited[i]);
//			}
			
			Answer = (Answer == 0)?(-1):Answer;
			//}	
			///////////////////////////////////////////////////
			System.out.println("#" + testCase + " " + Answer);
		} // end for
	}
	private static void bfs(int x) {
		// TODO Auto-generated method stub
		q.add(x);
		//visited[x] = 1;
		while (!q.isEmpty()) {
			x = q.poll();
			//System.out.println("x >> " + x );
			for (int i = 0; i < M; i++) {
				if(map[x][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = visited[x]+1;
				}
			}
		}
	}
	
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		if(x == N) {
			return;
		}
		visited[x] = 1;
		for (int i = 0; i < M; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				visited[i] = visited[x]+1;
				dfs(i);
			}				
		}
	}
}
