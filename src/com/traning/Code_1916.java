package com.traning;

import java.util.*;

public class Code_1916 {

	/**
	 * @param args
	 * 2 와 7의 공배수 갯수
	 */
	static int N, Answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a = 2;
		int b = 7;
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 2; i < N; i++) {
			if (i % a == 0 && i % b == 0) {
				ts.add(i);
			}
		}

		int cnt = 0;
		for (Integer is : ts) {
			cnt++;
		}
		System.out.println(cnt);
	}

}
