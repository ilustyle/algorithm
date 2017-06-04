import java.util.*;
import java.io.FileInputStream;

public class 핵심도시 {

	/**
	 * @param args
	 */
	static int N, M, V, E, Answer;
	static int[][] map, visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/핵심도시"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			map = new int[E][E];
			visited = new int[E][E];
			for (int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
				map[y][x] = 1;
			
			}
			
			for (int[] is : map) {
				System.out.println(Arrays.toString(is));
			}
			System.out.println("#:" + tc + " " + Answer);
		}
	}

}
