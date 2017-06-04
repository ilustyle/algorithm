import java.util.*;
import java.io.FileInputStream;

public class 심해탐사 {

	/**
	 * @param args
	 *            심해 탐사 - 기출
	 */
	static int N, M, W, Answer;
	static int[][] S;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom11"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// ///////////////////////////////////////////////////////
			N = sc.nextInt();
			S = new int[N][2];

			for (int i = 0; i < N; i++) {
				S[i][0] = sc.nextInt();
				S[i][1] = sc.nextInt();
			}

			Arrays.sort(S, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					Integer t1 = o1[1];
					Integer t2 = o2[1];
					return t1.compareTo(t2);
				}
			});

			for (int[] i : S) {
				System.out.println(Arrays.toString(i));
			}

			int sum = 0;
			Answer = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				int a = S[i][0];
				int b = S[i][1];
				sum += a;
				
				if (sum - b > Answer) {
					Answer = sum - b;
				}
			}
			System.out.println(Answer);
			// ///////////////////////////////////////////////////////
		} // end for
	} // end main

}
