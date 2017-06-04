package com.jungol;
import java.io.FileInputStream;
import java.util.*;
public class Exam_1974 {

	/**
	 * @param args
	 *  금메달은 누구
	 */
	static int N, AnswerN;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("data/main00.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int map[][] = new int[N][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int pl[] = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < 5; j++) {
				pl[i] += map[i][j];
			}
		}

		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 0; i < pl.length; i++) {
			if(a < pl[i]) {
				a = pl[i]; 
			}
		}
		for (int i = 0; i < pl.length; i++) {
			if(b < pl[i] && pl[i] != a) {
				b = pl[i];
			}
		}
		for (int i = 0; i < pl.length; i++) {
			if(c < pl[i] && pl[i] != a && pl[i] != b) {
				c = pl[i];
			}
		}
		//System.out.println(a + " / "  + b + " / " + c);

		
		System.out.print("GOLD :");					
		for (int i = 0; i < pl.length; i++) {
			if(pl[i] == a) {
				System.out.print(" ");
				System.out.print(i+1);	
			}
		}
		
		System.out.println();
		System.out.print("SILVER :");					
		for (int i = 0; i < pl.length; i++) {
			if(pl[i] == b) {
				System.out.print(" ");
				System.out.print(i+1);	
			}
		}
		System.out.println();
		System.out.print("BRONZE :");					
		for (int i = 0; i < pl.length; i++) {
			if(pl[i] == c) {
				System.out.print(" ");
				System.out.print(i+1);
			}
		}
		System.out.println();

//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
	}

}
