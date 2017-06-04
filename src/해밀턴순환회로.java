import java.util.*;
import java.io.FileInputStream;

public class 해밀턴순환회로 {

	/**
	 * @param args
	 */
    static int N, M, Answer;
    static int visit[];
    static int map[][];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/해밀턴"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Answer = Integer.MAX_VALUE;
		dfs(1, 0, 0); // 방문도시카운트, 이동위치, 비용
		System.out.println(Answer);

//		for (int[] p : map) {
//			System.out.println(Arrays.toString(p));
//		}
	}

	public static void dfs(int len, int pos, int cost) {
		if (len >= N) {
			if (map[pos][0] != 0) {
				if (Answer > cost + map[pos][0]) {
					Answer = cost + map[pos][0];
					return;
				}
			}
		}
          
        for(int i = 1; i < N; i++) {
            if(map[pos][i] != 0 && visit[i] == 0) {
            	if(cost+map[pos][i] < Answer) {
            		visit[i] = 1;
            		dfs(len+1, i, cost+map[pos][i]);
            		// System.out.println(i + ", " + (len+1) + " : " + map[pos][i]);
            		visit[i] = 0; 
            		
            	}
            }
        }
    }

}
