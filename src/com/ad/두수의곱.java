package com.ad;

import java.util.*;
import java.io.*;

public class 두수의곱 {

	/**
	 * @param args
	 * 
	 * 
	 */
	static int N, R, L, M;
	static int[] A, res, Answer;

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/숫자놀이"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		int s_time = (int) System.currentTimeMillis();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt(); //숫자
			R = sc.nextInt(); //제곱 할수
			L = sc.nextInt(); //제한값
			M = sc.nextInt(); // 싫어하는숫자
			A = new int[M];
			for (int i = 0; i < M; i++) {
				A[i] = sc.nextInt();
			}
			///////////////////////////////////////////////////////////

			res = new int[1000000];
			Answer = new int[res.length+1];
			Arrays.fill(Answer, Integer.MIN_VALUE);
			
			int sum = 0;
			res[0] = N;
			res[1] = N*R;
			for (int i = 2; i <= res.length - 2; i++) {
				if (res[i-1] * R  < L) {
					if (res[0] == res[1]) {
						res[0] = 0;
						break;
					}
					if (res[0]*(-1) == res[1] || res[0]*1 == res[1]) {
						res[0] = res[1] = 0;
						res[i] = -1;
						break;
					}
					res[i] = res[i-1] * R;
				}
			}
			
			for (int i = 0; i < res.length; i++) {
				if(res[i] != 0) {
					Answer[i] = res[i];
				}
			}
			
			for (int i = 0; i < Answer.length; i++) {
				for (int j = 0; j < M; j++) {
					if (Answer[i] != Integer.MIN_VALUE) {
						if (Answer[i] == A[j]) {
							Answer[i] = Integer.MIN_VALUE;
							break;
						}
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < Answer.length; i++) {
				if (Answer[i] != Integer.MIN_VALUE) {
					//System.out.println(Answer[i]);
					if(Answer[i] == -1) {
						cnt = -1;	
						break;
					}
					cnt++;
				}
			}
			System.out.println(cnt);

			///////////////////////////////////////////////////////////
			
		} //end for
		//System.out.println("Time >> " + (((int) System.currentTimeMillis()-s_time)/1000));
	}


}
