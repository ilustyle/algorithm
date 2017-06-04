import java.util.*;
import java.io.FileInputStream;

public class 깊이우선탐색_최단거리 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map;

	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/깊이우선탐색"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		Answer = Integer.MAX_VALUE;
		dfs(0, 0, 1);
		System.out.println(Answer);
//		for (int a[] : visit) {
//			System.out.println(Arrays.toString(a));
//		}
	}

	public static void dfs(int x, int y, int l) {
		// TODO Auto-generated method stub
//		System.out.println(x + " : " + y);
		map[x][y] = 0;
		if(x == N-1 && y == N-1) {
			if(Answer > l) {
				Answer = l;
			}
			return;
		}
		if (x+1 < N && map[x+1][y] == 1) {
			dfs(x+1, y, l+1);
		}
		if (x-1 > 0 && map[x-1][y] == 1) {
			dfs(x-1, y, l+1);
		}
		if (y+1 < N && map[x][y+1] == 1) {
			dfs(x, y+1, l+1);
		}
		if (y-1 > 0 && map[x][y-1] == 1) {
			dfs(x, y-1, l+1);
		}
		map[x][y] = 1;
	}

}
