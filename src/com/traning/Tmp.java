package com.traning;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Tmp {
	static int N, R, C, ZR, ZC, Answer;
	static char[][] a;
    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("src/data/code2018.txt"));
    	Scanner sc = new Scanner(System.in);
    	R = sc.nextInt();
    	C = sc.nextInt();
    	ZR = sc.nextInt();
    	ZC = sc.nextInt();
    	a = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			tmp.toCharArray();
			char chr[] = tmp.toCharArray();
			for (int j = 0; j < chr.length; j++) {
				a[i][j] = chr[j];
			}
		}
    	
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < ZR*C; i++) {
				for (int j = 0; j < ZC*C; j++) {
					//System.out.print(a[i][j]);
				}
				System.out.println();
			}
		}


//    	for (int i = 0; i < ZR*C; i++) {
//			for (int j = 0; j < ZC*C; j++) {
//				if(i == j+1)
//				System.out.print(String.valueOf(a[i].charAt(i)) );
//			}
//			System.out.println();
//		}

    	
    }
}
