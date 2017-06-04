package com.ad;

import java.io.FileInputStream;
import java.util.Scanner;


public class 최빈수 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static String S;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/ex06"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int cnt[] = new int[10];
			S = sc.next(); 
			for (int i = 0; i < S.length(); i++) {
				int d = S.charAt(i)-'0';
				cnt[d]++;
			}
			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i]);
			}
			System.out.println();
			int max = 0;
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[max] <= cnt[i]) {
					max = i;
				}
			}

			System.out.println("#"+tc + " " + max + " " + cnt[max]); 
		}
	}
}
