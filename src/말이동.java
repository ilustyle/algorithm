import java.util.*;
import java.io.FileInputStream;

public class 말이동 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map, visit;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/말이동"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < 1; tc++) {
			/////////////////////////////////
			N = sc.nextInt();
			map = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();	
				}
			}
			Answer = 100000;
			dfs(0, 0, 0); // x, y, 이동 카운트
			System.out.println(Answer);
			/////////////////////////////////
			
		}
		
		for (int[] is : visit) {
			System.out.println(Arrays.toString(is));
		}
	} // end of main

	public static void dfs(int x, int y, int count) {
		// TODO Auto-generated method stub
		visit[x][y] = count;
		if(x == N-1 && y == N-1) {
			if(count < Answer) {
				Answer = count;				
			}
			return;
		}
		for (int i = 1; i <= map[x][y]; i++) {
			if(x+i >= N) {
				break;
			}
			if (visit[x + i][y] > 0 && visit[x + i][y] <= count + 1) {
				continue;
			}
			dfs(x+i, y, count+1);				
		}
		for (int i = 1; i <= map[x][y]; i++) {
			if(y+i >= N) {
				break;
			}
			if (visit[x][y+1] > 0 && visit[x][y+1] <= count + 1) {
				continue;
			}
			dfs(x, y+i, count+1);				
		}
	}

}
