package com.ad;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 베스트앨범 {

	/**
	 * @param args
	 */
	static int N, L, Answer, count, sum, max;
	static int[] M, bit, visit;
	static TreeSet<Integer> ts;
	static int result = 0;

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/베스트앨범"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			M = new int[N];

			for (int i = 0; i < N; i++) {
				M[i] = sc.nextInt();
			}
			
			visit = new int[N];
			Arrays.sort(M);
			
//			Set<Integer> set = new HashSet<Integer>();
//			for(int i = 0; i < N; i++) {
//				set.add(M[i]);
//			}
//			
//			m = set.toArray();
			
			Answer = 0;
			count = 0;
			sum = 0;
		
			func(0, 0);
		
			System.out.println("#" + tc + " " + result);
		} // end main for
			
	}

	private static void func(int x, int sum) {
		if(x == N) {
			//System.out.println(sum);
			return;
		} else if(sum == L) {
			return;
		}
		
		// 현재곡을 선택할 경우
		if(sum + (int)M[x] <= L) {
			result++;
			func(x+1, sum + (int)M[x]);
		}
		// 핸재곡을 선택하지 않을 경우
		func(x+1, sum);
	}
	
//	1 3 5 5 8
//	
//	1
//	3 1,3
//	5, 3,5 1,3 1,3,5

}
