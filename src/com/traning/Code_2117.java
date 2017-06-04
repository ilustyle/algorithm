package com.traning;
import java.util.*;
import java.io.FileInputStream;

public class Code_2117 {

	/**
	 * @param args
	 * 위성사진II (섬의 개수 구하기)
	 */
	static int N, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/exam2117.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int map[][] = new int [N][N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			tmp.toCharArray();
			char chr[] = tmp.toCharArray();
			for (int j = 0; j < chr.length; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(chr[j]));
			}
		}
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
	public static void dfs(int a, int b) {
		
	}
}
