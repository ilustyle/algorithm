import java.io.*;
import java.util.*;

public class 행렬접기 {

	/**
	 * @param args
	 * 
	 * 
1
5 6
3 15 51 0 6 4
39 7 29 3 6 12
5 49 22 13 21 17
71 28 13 44 2 8
18 13 52 12 10 9
	 */
	static int N, M, Answer;
	static int R, C, count;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/행렬접기"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int[] is : map) {
				System.out.println(Arrays.toString(is));
			}
			
			int iMin = Integer.MAX_VALUE;
			int iMax = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > iMax) {
						iMax = map[i][j];
					} 
					if(map[i][j] < iMin) {
						iMin = map[i][j];
					}
				}
			}
			
			count = 0;
			f(N, M);
			
			System.out.println(count + " : " + iMax + " : " + iMin);
		} // end main for
	}

	private static void f(int r, int c) {
		// TODO Auto-generated method stub
		if(r%2 != 0 && c%2 != 0) {
			return;
		} else if(r%2 == 0 && c%2 == 0) {
			if(r > c) {
				int[][] nMap =  new int[r/2][c];
			} else {
				int[][] nMap =  new int[r][c/2];
			}
			
		}
		count++;
	}

}
