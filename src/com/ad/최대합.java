package com.ad;

import java.util.*;
import java.io.*;

public class 최대합 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int[] num, res;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/최대합"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = new int[N];
			res = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			
			Arrays.sort(num);
			int a = 0, b = 0, ga = 0, gb = 0;
			
//			for (int i = 0; i < num.length; i++) {
//				System.out.print(num[i] + " ");
//			}
			
			for (int i = 0; i < N; i++) {
				if(num[i] <= 0) {
				//System.out.println(num[i]);
					res[i] = num[i]*num[i+1];
				}
			}
			
			for (int i = N-1; i > 1; i--) {
				//System.out.println(num[i]);	

			}

			for (int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
			}
//			
		
			
//			for (int i = N-1; i > 1; i--) {
//				if(num[i-1] >= 1) {
//					a = num[i]*num[i-1];
//				}
//			}
			//System.out.println(a);
			

			
		} // end for
	}

}
