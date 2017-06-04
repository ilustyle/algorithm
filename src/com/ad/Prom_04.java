package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_04 {

	/**
	 * @param args
	 * 장사꾼 - 기출
	 * 

#1 8
#2 6
#3 8
#3 0
	 */
	static int N, M, L, Answer;
	static int[] NTime, MCount;
	static char stack[];
	static int top;
	static int a[];
	static int W[];
	static TreeSet<Integer> list;
	static int res[];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom04"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			/////////////////////////////////////////////
			N = sc.nextInt();
			M = sc.nextInt();
			L = sc.nextInt();
			W = new int[L*2];
			for (int i = 0; i < N; i++) {
				W[i] = sc.nextInt();
			}
			list = new TreeSet<Integer>();
			res = new int[100];
			for (int i = 1; i <= M; i++) {
				back(0, 0, 0, i);
			}
			int cnt = 0;
			for (int i = 1; i < res.length; i++) {
				if(res[i] != 0) {
					cnt++;
				}
			}
			System.out.println(cnt);
			//System.out.println(list.size());
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main
	private static void back(int count, int weight, int idx, int maxLine) {
		// TODO Auto-generated method stub
		if(count == maxLine) {
			if(weight <= L) {
				res[weight] += 1;
				//list.add(j);
			}
			return;
		} else {
			for (int l = idx; l < N; l++) {
				weight += W[l];
				if(weight > L) {
					break;
				}
				back(count+1, weight, l+1, maxLine);
				weight -= W[l];
			}
		}
	}
}
