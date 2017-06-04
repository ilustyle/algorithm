package com.jungol;
import java.util.*;

public class Exam_1438 {

	/**
	 * @param args
	 * 색종이(초)
	 * 
input:
3 
3 7 
15 7 
5 2

output:
260
	 */
	static int N, W, H, Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int map[][] = new int[100][100];
		int w[] = new int[N];
		int h[] = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
			for (int j = w[i]; j < w[i]+10; j++) {
				for (int k = h[i]; k < h[i]+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}	
			}
		}
		System.out.println(cnt);
		
	}

}
