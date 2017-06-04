package org.codexpert;

import java.util.*;
import java.io.FileInputStream;

public class 문자사각형 {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int arr[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
	            M = 64 + N * (N - j) - i;
	            if(M > 90) {
	                M = 65 + (M - 65) % 26;
	            }
	            System.out.print((char) M + " ");
			}
			System.out.println();
		}
	}
}
