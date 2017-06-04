package com.jungol;

import java.util.*;
import java.io.FileInputStream;

public class Exam_1695 {

	/**
	 * @param args
	 * 단지번호 붙이기
	 */
	static int N, Answer, index;
	static int size[];
	static int map[][];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/exam1695.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			char ch[] = tmp.toCharArray();
			for (int j = 0; j < ch.length; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(ch[j]));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					index++;
					dfs(i, j, index+1);
				}
			}
		}
		
		size = new int[100];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					size[map[i][j]]++;				
				}
			}
		}
		System.out.println(index);
		int tmp, mid;
		for (int i = 0; i < size.length; i++) {
			mid = i;
			for (int j = 0; j < size.length; j++) {
				if(size[mid] < size[j]) {
					tmp = size[mid];
					size[mid] = size[j];
					size[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < size.length; i++) {
			if(size[i] != 0) {
				System.out.println(size[i]);
			}
		}

		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	} //end main
	public static void dfs(int a, int b, int c) {
		map[a][b] = c;
		if(a+1 < N && map[a+1][b] == 1) {
			dfs(a+1, b, c);
		}
		if(a-1 > -1 && map[a-1][b] == 1) {
			dfs(a-1, b, c);
		}
		if(b+1 < N && map[a][b+1] == 1) {
			dfs(a, b+1, c);
		}
		if(b-1 > -1 && map[a][b-1] == 1) {
			dfs(a, b-1, c);
		}
	}

}
