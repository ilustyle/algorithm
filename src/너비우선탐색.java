import java.util.*;
import java.io.FileInputStream;

public class 너비우선탐색 {

	/**
	 * @param args
	 */
	static int v, e;
	static int N, M, Answer;
	static int map[][];
	static int visit[];
	static int queue[];
	static int rear = -1;
	static int front = -1;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/너비우선탐색"));
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		visit = new int[e*2];
		queue = new int[e*2];
		map = new int[e][e];
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		bfs(1);
	}
	public static void bfs(int node) {
		visit[node] = 1;
		queue[++rear] = node;
		while(front != rear) {
			node = queue[++front];
			for (int i = 0; i < e; i++) {
				if(map[node][i] == 1 && visit[i] == 0) {
					visit[i] = 1;
					System.out.println(node + " -> " + i);
					queue[++rear] = i;
				}
			}
		}
	}

}
