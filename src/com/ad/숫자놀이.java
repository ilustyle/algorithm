package com.ad;

import java.util.*;
import java.io.*;

public class 숫자놀이 {

	/**
	 * @param args
	 * 
	 * 
4
0 2 0 4
0 0 0 0
3 2 47 4
6 13 49 59
123 1 544 4
123 -54 23 3
4 -1 8 4
-4 8 45 34
	 */
	static int N, R, L, M;
	static int[] A, res, Answer;
	static List<Integer> li;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/숫자놀이"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
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
			li = new ArrayList<>();
			res = new int[1000000];
			Answer = new int[res.length+1];
			Arrays.fill(Answer, -5);
			int sum = 0;
			res[0] = N;
			res[1] = N*R;
			for (int i = 2; i <= res.length - 2; i++) {
				if (res[i - 1] * R < L) {
					if (res[0] == res[1]) {
						res[0] = 0;
						//res[0] =  res[i - 1] = 0;
						break;
					}
					if (res[0]*(-1) == res[1] || res[0]*1 == res[1]) {
						res[0] = res[1] = 0;
						res[i] = -1;
						break;
					}
					res[i] = res[i - 1] * R;
				}
				if (res[i] >= L) {
					break;
				}
			}
			
			for (int i = 0; i < res.length; i++) {
				if(res[i] != 0) {
					//li.add(res[i]);
					Answer[i] = res[i];
					//System.out.println(Answer[i]);
				}
			}
			
			for (int i = 0; i < Answer.length; i++) {
				for (int j = 0; j < M; j++) {
					if (Answer[i] != -5) {
						if (Answer[i] == A[j]) {
							Answer[i] = -5;
							break;
						}
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < Answer.length; i++) {
				if (Answer[i] != -5) {
					//System.out.println(Answer[i]);
					if(Answer[i] == -1) {
						cnt = -1;	
						break;
					}
					cnt++;
				}
			}
			System.out.println(cnt);
			
			//System.out.println(cnt > 0 || cnt == -1 ?cnt:0);
		
			//System.out.println("#" + tc + " " + li.size());
			///////////////////////////////////////////////////////////
			
		} //end for
	}


}
