package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class 장사꾼 {

	/**
	 * @param args
	 */
	static int N, M, L, Answer, tmp, max, min;
	static int[] w;
	static TreeSet ts;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/장사꾼"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			M = sc.nextInt();
			
			w = new int[N];
			for (int i = 0; i < N; i++) {
				w[i] = sc.nextInt();
			}
			max = 0;
			ts = new TreeSet<>();
			
			for (int i = 1; i <= L; i++) {
				func(0, 0, i);
			}
			System.out.println(ts.size());
		} //end for
	}
	private static void func(int cnt, int idx, int max_line) {
		// TODO Auto-generated method stub
		if(cnt == max_line) {
			if (max <= M) {
				ts.add(max);
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			max += w[i];
			if(max > M) {
				break;
			}
			func(cnt+1, i+1, max_line);
			max -= w[i];
		}
	}

}
