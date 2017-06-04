import java.io.FileInputStream;
import java.util.Scanner;


public class test {
	static int T;
	static int N;
	static int M;
	
	static int[] src;
	static int[] dst;
	static int minCost;
	static int[] visited;
	static int[][] map;
	static int AnswerN;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/data/ex00"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case ++) {
			M = sc.nextInt();
			N = sc.nextInt();
			visited = new int[N+1];
			AnswerN = Integer.MAX_VALUE;
			minCost = 0;
			map = new int[M][2];
			
			for(int i = 0; i < M; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
//			src = new int[M];
//			dst = new int[M];
			
			visited[1] = 1;
			minCost++;
			move(1);
			
			System.out.println(AnswerN);
			
		}
	}
	//dfs????? 백트래킹?
	public static void move(int idx) {
		int cnt = 0;
		if(minCost >= AnswerN){
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i] == 1){
				cnt++;
			} else {
				break;
			}
		}
		if(cnt == N) {
			if(AnswerN > minCost){
				AnswerN = minCost;
			}
			return;
		} else {
			for(int i = 1; i <= N; i++) {
				if(visited[i] == 0) {
					int cost = 1;
//					for(int j = 1; j <= N; j++){
				for(int j = 0; j < M; j++){
//						if(map[idx][i] == 1 ) {
						if(map[j][0] == idx && map[j][1] == i){
							cost = 0;
							break;
						}
					}
					visited[i] = 1;
					minCost += cost;
					move(i);
					minCost -= cost;
					visited[i] = 0;
				}
			}
		}
		
	}
}
