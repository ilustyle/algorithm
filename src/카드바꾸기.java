import java.util.*;
import java.io.FileInputStream;

public class 카드바꾸기 {

	/**
	 * @param args
	 */
	static int N, M, Answer, cnt, dcnt;
	static int[] C, tC;
	static int[] D, tD;
	static Integer[][] C1, D1;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/카드바꾸기"));
		Scanner sc = new Scanner(System.in);
			
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			C = new int[N];
			D = new int[N];
			tC = new int[N];
			tD = new int[N];
			
			for (int i = 0; i < N; i++) {
				C[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				D[i] = sc.nextInt();
			}

			////////////////////////////////////////////
			
			//Arrays.sort(C);
			
			for (int i = 0; i < C.length-1; i++) {
				int min = i;
				for (int j = i+1; j < C.length; j++) {
					if(C[j] < C[min]) {
						min = j;
					}
				}
				int t = C[i];
				C[i] = C[min];
				C[min] = t;
			}
			
//			for (int i = 0; i < C.length; i++) {
//				System.out.print(C[i]);
//			}
//			System.out.println();
//			for (int i = 0; i < C.length / 2; i++) {
//				int t = C[i];
//				C[i] = C[C.length-1-i];
//				C[C.length-1-i] = t;
//			}
//			for (int i = 0; i < C.length; i++) {
//				System.out.print(C[i]);
//			}
			
//			System.out.println();
			
			for (int i = 0; i < D.length-1; i++) {
				int min = i;
				for (int j = i+1; j < D.length; j++) {
					if(D[j] < D[min]) {
						min = j;
					}
				}
				int t = D[i];
				D[i] = D[min];
				D[min] = t;
			}
			
//			for (int i = 0; i < D.length; i++) {
//				System.out.print(D[i]);
//			}
//			System.out.println();
//			for (int i = 0; i < D.length / 2; i++) {
//				int t = D[i];
//				D[i] = D[D.length-1-i];
//				D[D.length-1-i] = t;
//			}
//			for (int i = 0; i < D.length; i++) {
//				System.out.print(D[i]);
//			}
			

//			for (int i = 0; i < C.length; i++) {
//					if(C[i] == D[i]) {
//						tC[i] = C[i];
//					}
//			}
//			
//			for (int i = 0; i < tC.length; i++) {
//				System.out.print(tC[i]);
//			}
			
//			System.out.println();
//			for (int i = 0; i < D.length; i++) {
//				System.out.print(tD[i]);
//			}
//			System.out.println();
			
			
			
			cnt = 0;
			swap(C, D, 0, 0, 0);
			Answer = cnt;

			System.out.println("#" + (tc+1) + " " + Answer);
			////////////////////////////////////////////			
		}
	}
    public static void swap(int[] src, int[] dst, int a, int b, int len) {
		int t = src[a];
		src[a] = dst[b];
		dst[b] = t;
		
		Arrays.sort(src);
		Arrays.sort(dst);
		
    	if(len == N-1 ) {
    		return;
    	}
		for (int i = len; i < src.length; i++) {
			String s = Arrays.toString(src);
			String s2 = Arrays.toString(dst);
			// System.out.println(s + " : " + s2);
			if (s.equals(s2)) {
				if (i + 1 < N - 1) {
					// System.out.println(s + " : " + s2);
					cnt++;
				}
				break;
			}
			swap(C, D, a + 1, b + 1, i + 1);
		}
    }
}
