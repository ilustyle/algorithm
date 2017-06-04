import java.util.*;
import java.io.*;

public class 보석 {

	/**
	 * @param args
	 */
	static int N, M, K, Answer, min, max;
	static int[][] MV;
	static int[] C;
	static List<int[]> li = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/보석"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			MV = new int[N][2];
			C = new int[K];
			for (int i = 0; i < N; i++) {
				MV[i][0] = sc.nextInt();
				MV[i][1] = sc.nextInt();
				// li.add(new int[]{MV[i][0], MV[i][1]});
			}
			for (int i = 0; i < K; i++) {
				C[i] = sc.nextInt();
			}

			Arrays.sort(MV, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					Integer t1 = o1[0];
					Integer t2 = o2[0];
					return t2.compareTo(t1);
				}
			});

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < K; j++) {
					if (MV[i][0] <= C[0]) {
						 System.out.println(MV[i][0]+","+MV[i][1] + " : " + C[j]);
						//li.add(new int[] { MV[i][0], MV[i][1] });
						break;
					}
				}
				// System.out.println(MV[i][0] + ", " + MV[i][1]);
			}

			for (int[] is : li) {
				System.out.println(Arrays.toString(is));
			}

			for (int i = 0; i < K; i++) {
				//int t[] = li.get(i);
			//	Answer += t[1];
			}
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
