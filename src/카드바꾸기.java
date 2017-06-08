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
				tC[i] = C[i];
			}
			for (int i = 0; i < N; i++) {
				D[i] = sc.nextInt();
				tD[i] = D[i];
			}

			////////////////////////////////////////////
			
//			System.out.println();
//			for (int i = 0; i < D.length / 2; i++) {
//				int t = D[i];
//				D[i] = D[D.length-1-i];
//				D[D.length-1-i] = t;
//			}
			
			
			sort(C);
			sort(D);
			
//			for (int i = 0; i < N; i++) {
//				System.out.print(C[i]);
//			}
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.print(D[i]);
//			}
//			System.out.println();
			

			cnt = 0;
			Answer = 0;
			
			func(0);

			System.out.println("#" + (tc+1) + " " + Answer);
			////////////////////////////////////////////			
		}
	}

	public static void func(int x) {
		// TODO Auto-generated method stub
		if(x == N) {
			String s1 = Arrays.toString(C);
			String s2 = Arrays.toString(D);
//			System.out.println(s1);
//			System.out.println(s2);
			if(s1.compareTo(s2) != 0) {
				//System.out.println(s1.compareTo(s2));
				Answer = -1;
				return;
			}
			Answer = cnt;
			return;
		}
		if(C[x] != D[x]) {
			swap(C, D, x, x);
			sort(C);
			sort(D);
		}
		func(x+1);
	}

	public static void sort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] > arr[min]) {
					min = j;
				}
			}
			int t = arr[i];
			arr[i] = arr[min];
			arr[min] = t;
		}
	}

	public static void swap(int[] src, int[] dst, int a, int b) {
		// TODO Auto-generated method stub
		cnt++;
		int t = src[a];
		src[a] = dst[b];
		dst[b] = t;
	}
}
