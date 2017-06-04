import java.util.*;
import java.io.FileInputStream;

public class 미로기출 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[][] map, visited;
	static Stack<String> st = new Stack();
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/미로"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < 1; tc++) {
			////////////////////////////////////////////////
			N = sc.nextInt();
			map = new int[N+1][N+1];
			visited = new int[N+1][N+1];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) -'0';
				}
			}
//			for (int[] is : visited) {
//				System.out.println(Arrays.toString(is));
//			}
			st.clear();
			dfs("0,0");
			////////////////////////////////////////////////
			//System.out.println("#" + tc + " " + Answer);
		}
		
	}
	private static void dfs(String xy) {
		// TODO Auto-generated method stub
		st.add(xy);
		int collCount = 0;
		int x = Integer.parseInt(xy.split(",")[0]);
		int y = Integer.parseInt(xy.split(",")[1]);
		visited[x][y] = 1;
		//System.out.println(x + " " + y);
		if(x == N-1 && y == N-1) {
			System.out.println();
			for (int i = 0; i < st.size(); i++) {
				String tmp = st.get(i);
				int fx = Integer.parseInt(tmp.split(",")[0]);
				int fy = Integer.parseInt(tmp.split(",")[1]);
				System.out.println(fx+1 + ", " + (fy+1));
			}
		}
		if(x+1 < N && map[x+1][y] == 1 && visited[x+1][y] == 0) {
			collCount++;
			dfs((x+1) + "," + y);
		}
		
		if(x-1 >= 0 && map[x-1][y] == 1 && visited[x-1][y] == 0) {
			collCount++;
			dfs((x-1) + "," + y);
		}
		
		if(y+1 < N && map[x][y+1] == 1 && visited[x][y+1] == 0) {
			collCount++;
			dfs(x + "," + (y+1));
		}
		
		if(y-1 >= 0 && map[x][y-1] == 1 && visited[x][y-1] == 0) {
			collCount++;
			dfs(x+ "," + (y-1));
		}
		
		if(x+1 < N &&  y+1 < N && map[x+1][y+1] == 1 && visited[x+1][y+1] == 0) {
			collCount++;
			dfs((x+1) + "," + (y+1));
		}
		
		if(x-1 >= 0 && y-1 >= 0 && map[x-1][y-1] == 1 && visited[x-1][y-1] == 0) {
			collCount++;
			dfs((x-1) + "," + (y-1));
		}
		
		if(x+1 < N && y-1 >= 0 && map[x+1][y-1] == 1 && visited[x+1][y-1] == 0) {
			collCount++;
			dfs((x+1) + "," + (y-1));
		}
		
		if(x-1 >= 0 && y+1 < N && map[x-1][y+1] == 1 && visited[x-1][y+1] == 0) {
			collCount++;
			dfs((x-1) + "," + (y+1));
		}
		if(collCount == 0) {
			st.pop();
		}
		
	}
}
