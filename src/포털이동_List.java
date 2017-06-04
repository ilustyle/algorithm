import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class 포털이동_List {

	/**
	 * @param args
	 */
	static int N, M, Answer, cnt;
	static int[][] Marr;
	
	static int[][] map;
	static ArrayList<Integer>[] al;
	static int[] count;
	static boolean[] visited;
	static TreeSet<Integer> ts;
	public static void main(String[] args)throws Exception {
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
			
			visited = new boolean[M];
			count = new int[M];
			al = new ArrayList[M];
			ts = new TreeSet<>();
			for (int i = 0; i < al.length; i++) {
				al[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				al[Marr[i][0]].add(Marr[i][1]);
				al[Marr[i][1]].add(Marr[i][0]);
			}
			
//			for (int i = 0; i < al.length; i++) {
//				if(al[i].size() != 0) {
//					System.out.println(i + ": " + al[i]);						
//				}
//			}
			
//			for (int i = 0; i < count.length; i++) {
//				System.out.print( count[i]);
//			}
//			System.out.println();
			
			dfs(1);
			
			Answer = (ts.last() != N)?(-1):ts.size();
			System.out.println("#" + testCase + " " + Answer);
		}
			///////////////////////////////////////////////////
	}

	private static void dfs(int x) {
		// TODO Auto-generated method stub
		visited[x] = true;
		if(x == N) {
			return;
		}
		for (int i = 1; i < al[x].size(); i++) {	
				int V = al[x].get(i);
				if(visited[V] == false) {
				//	System.out.println("V >> " + V);
					dfs(V);
					ts.add(V);
					visited[i] = true;
				}
		}
	}

}
