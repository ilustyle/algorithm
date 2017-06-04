import java.io.*;
import java.util.*;

public class 도시연결도로 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] xy;
	static ArrayList<Integer>[] al;
	static int[] visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/도로"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			xy = new int[M][2];
			for (int i = 0; i < M; i++) {
				xy[i][0] = sc.nextInt();
				xy[i][1] = sc.nextInt();
			}
			visited = new int[M];
			al = new ArrayList[M];
			for (int i = 0; i < al.length; i++) {
				al[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				al[xy[i][0]].add(xy[i][1]);
				al[xy[i][1]].add(xy[i][0]);
			}
			
			for (int i = 0; i < al.length; i++) {
				System.out.println(al[i]);
			}
			
			System.out.println("#" + tc + " " + Answer);
		} //end for
	}

}
