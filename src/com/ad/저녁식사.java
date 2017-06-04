package com.ad;

import java.util.*;
import java.io.*;

public class 저녁식사 {

	/**
	 * @param args
	 */
	static int N, M, F, D, Answer;
	static int[] count;
	static long[] arr;
	static int[][] S;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/저녁식사"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			S = new int[N][2];
			count = new int[N];
			arr = new long[N];
			
			for (int i = 0; i < N; i++) {
				S[i][0] = sc.nextInt();
				S[i][1] = sc.nextInt();
			}
			
			Map<Long, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++)
				arr[i] = 9223372036854775807L;

			for (int i = 0; i < N; i++) {
				long x = S[i][0], y = S[i][1];
				map.put(x * 1000000001 + y, i + 1);
				arr[i] = x * 1000000001 + y;
			}

			Arrays.sort(arr);

			long min = 2000000000;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				long x = arr[i] / 1000000001;
				long y = arr[i] % 1000000001;
				if (min > y) {
					min = y;
					count[cnt] = map.get(arr[i]);
					cnt++;
				}
			}
			
			for (int i = 0; i < cnt; i++)
				System.out.print(count[i] + " ");
			System.out.println("");
			
		} // end main for
	}

}
