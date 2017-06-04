package com.ad;

import java.util.*;
import java.io.*;

public class Test {

	/**
	 * @param args
	 * 
	 * 
	 */
	static int N, R, L, M, result;
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
			res[1] = R;
			res[2] = N*R;
			boolean f = true;
			
				if (N == 0) {
					for (int i = 0; i < M; i++) {
						if (A[i] == 0) {
							result = 0;
						} else {
							result = -1;						
						}
					}
				} else if (R == 0) {
					for (int i = 0; i < M; i++) {
						if (A[i] == 0 && A[i] != N) {
							result = 1;
						}
						if (A[i] == 0 && A[i] == N) {
							result = 0;
						}
						if (A[i] != 0) {
							result = -1;
						}
					}

				} else if (R == 1) {
					for (int i = 0; i < M; i++) {
						if (A[i] == N) {
							result = 0;
						}
						if (A[i] != N) {
							result = -1;
						}
					}

				} else if (R == -1) {
					for (int i = 0; i < M; i++) {
						if (A[i] == N && A[i] == N * (-1)) {
							result = 0;
						}
						if (A[i] == N && A[i] != N * (-1)) {
							result = -1;
						}
					}
				} 
				else {
					int tmp = N;
					while (true) {
						if (tmp < 0)
							tmp = -tmp;
						if (tmp < L) {
							result++;
							tmp = tmp * R;
							System.out.println(tmp);
						} else {
							break; 
						}
					}
				}

			
			System.out.println(result);
			
//			
//			
//			for (int i = 0; i < res.length; i++) {
//				if(res[i] != 0) {
//					Answer[i] = res[i];
//				}
//			}
//			
//			for (int i = 0; i < Answer.length; i++) {
//				if (Answer[i] != Integer.MIN_VALUE) {
//
//					if (Answer[i] == Answer[i + 2]) {
//						System.out.println(Answer[i] +" : "+ Answer[i + 2]);
//						Answer[i] = -1;
//					} else {
//						Answer[i] = 0;
//					}
//					for (int j = 0; j < M; j++) {
//						if (Answer[i] == A[j]) {
//							Answer[i] = Integer.MIN_VALUE;
//							//System.out.println(Answer[i]);
//						}
//					}
//
//				} // end main if
//			}
//			
//			int cnt = 0;
//			for (int i = 0; i < Answer.length; i++) {
//				if (Answer[i] != Integer.MIN_VALUE) {
//					System.out.println(Answer[i]);
//					if(Answer[i] == -1) {
//						cnt = -1;	
//						break;
//					}
//					cnt++;
//				}
				

			//System.out.println(cnt);

			///////////////////////////////////////////////////////////
			
		} //end for
//		System.out.println("Time >> " + (((int) System.currentTimeMillis()-s_time)/1000));
	}


}
