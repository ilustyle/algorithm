package com.jungol;

import java.util.*;
import java.io.FileInputStream;

public class Exam_1357 {

	/**
	 * @param args
	 * 
	 * 합이 0이 되는 4개의 숫자들 
	 */
	static int N, M, Answer;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/exam1357"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a[] = new int[T];
		for (int tc = 0; tc < T; tc++) {
			for (int k = 0; k < 4; k++) {
				a[k] = sc.nextInt();
				//System.out.print(a[k] + " ");
			}
			for (int i = 0; i < (1 << 4 ); i++) {
				for (int j = 0; j < 4; j++) {
					if( (i & (1 << j)) != 0 ) {
						System.out.print(a[j] + " ");
					}
				}
			}
			System.out.println("");
		}
	}

}
