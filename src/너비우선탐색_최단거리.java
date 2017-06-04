import java.util.*;
import java.io.FileInputStream;

public class 너비우선탐색_최단거리 {
	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] queue;
	static int[][] map, visit;
	static int rear = -1;
	static int front = -1;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/너비우선탐색"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visit = new int[N][N];
		queue = new int[2][100];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		Answer = Integer.MAX_VALUE;
		bfs(0, 0, 0);
		for (int a[] : visit) {
			System.out.println(Arrays.toString(a));
		}
	}
	public static void bfs(int x, int y, int l) {
		visit[x][y] = 1;
		queue[0][++rear] = x;
		queue[1][++rear] = y;
		int cnt = 0;
		while (front != rear) {
			x = queue[0][++front];
			y = queue[1][++front];
			if(x+1 < N  && map[x+1][y] == 1 && visit[x+1][y] == 0) {
				visit[x+1][y] = visit[x][y] + 1;
				queue[0][++rear] = x+1;
				queue[1][++rear] = y;
			}
			if(x-1 > 0 && map[x-1][y] == 1 && visit[x-1][y] == 0) {
				visit[x-1][y] = visit[x][y] + 1;
				queue[0][++rear] = x-1;
				queue[1][++rear] = y;
				cnt += 1;
			}
			if(y+1 < N && map[x][y+1] == 1 && visit[x][y+1] == 0) {
				visit[x][y+1] = visit[x][y] + 1;
				queue[0][++rear] = x;
				queue[1][++rear] = y+1;
			}
			if(y-1 > 0 && map[x][y-1] == 1 && visit[x][y-1] == 0) {
				visit[x][y-1] = visit[x][y] + 1;
				queue[0][++rear] = x;
				queue[1][++rear] = y-1;
			}
		}
		System.out.println(visit[N-1][N-1]);
	}
}
