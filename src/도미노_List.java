import java.util.*;
import java.io.*;

public class 도미노_List {

	/**
	 * @param args
	 */
	static int N, M, L, Answer;
	static int[][] Edge = new int[3000][2];
	static int Z[] = new int [3000];
	
	static ArrayList<Integer>[] adjList;
	static int visited[];
	
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
			
			// under here 
			
			adjList = new ArrayList[N+1];	
			visited = new int[N+1];
			Answer = 0;
		
			for (int i = 0; i < N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			for (int i = 0; i < N; i++) {
				adjList[Edge[i][0]].add(Edge[i][1]);
			}
			
//			for (int i = 0; i < adjList.length; i++) {
//				if(adjList[i] != null) {
//					System.out.println(i + " : " + adjList[i]);				
//				}
//			}
//			System.out.println();
			
			for (int i = 0; i < L; i++) {
				dfs(Z[i]);
				//System.out.println("Z[i] >> " + Z[i]);
			}
			
			System.out.println("#" + testCase + " " + (Answer));
		} // end of testCase
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		//System.out.println("x >> " + x);
		if(visited[x] == 1) {
			return;
		}
		visited[x] = 0;
		if(null != adjList[x]) {
			for (int i = x; i < adjList[x].size(); i++) {
				int V = adjList[x].get(i);
				if (visited[V] == 0) {
					dfs(V);
				}
			}	
		}
		Answer++;
		visited[x] = 1;
	}

}
