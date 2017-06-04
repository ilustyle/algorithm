import java.util.*;
import java.io.FileInputStream;

public class 테이프 {

	/**
	 * @param args
	 */
	static int N, M, L, Answer, sum, count;
	static int[] arr;
	static TreeSet<Integer> result = new TreeSet<Integer>(); 
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/테이프"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			//////////////////////////////////
			L = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N];
					
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.print(arr[i]);
//			}
//			System.out.println();
			
			int min, tmp;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					if(arr[i] > arr[j]) {
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
			
			
			for (int i = 1; i <= N; i++) { 
				bt(0, 0, i); // 곡수, 길이, 시작
			}
			
			System.out.println("#" + tc + " : " + Answer);
			//////////////////////////////////
		}
	}
	public static void bt(int cnt, int len, int max) {
		if (cnt == max) {
			Answer = len;
			return;
		}

		for (int i = 0; i < N; i++) {
			len = len + arr[i]; 
			if(len > L) {
				break;
			}
			bt(cnt + 1, len, max);
			len = len - arr[i]; 

		}
	}
	
	
}
