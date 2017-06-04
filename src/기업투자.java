import java.io.FileInputStream;
import java.util.*;

public class 기업투자 {

	/**
	 * @param args
	 */
	static int[][] arr, DP;
	static int M, C, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/기업투자"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			C = sc.nextInt();
			arr = new int[M+1][C+1];
			DP = new int[M+1][C+1];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			Answer = 0;
			//
			for (int i = 1; i <= M; i++)
			{
			    for (int j = 1; j <= C; j++)
			    {
			        DP[i][j] = Math.max(DP[i][j - 1], arr[i][j]);
			        for (int k = 1; k < i; k++) {
			        	DP[i][j] = Math.max(DP[i][j], DP[k][j - 1] + arr[i - k][j]);	
						//Answer = DP[i][j];
			        }
			    }
			}
			System.out.println("#:" + tc + " " + DP[M][C]);
		} //end test for
	}
	private static int f_max(int m, int n) {
		int max = 0, tmp = 0;
		// TODO Auto-generated method stub
		if(n == 1) {
			return arr[m][n];
		}
		for (int i = 0; i <= M; i++) {
			if(max == 0) {
				max = f_max(i, n-1) + arr[m-i][n];
			} else {
				tmp = f_max(i, n-1) + arr[m-i][n];
			}
			if(max < tmp) {
				max = tmp;
			}
		}
		return max;
	}
}
