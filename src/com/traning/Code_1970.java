package com.traning;
import java.util.*;
import java.io.FileInputStream;
public class Code_1970 {

	/**
	 * @param args
	 */
    static int N;
    static int [][]a, b, c, d, e;
    static int []dir;
    static int dr;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
        System.setIn(new FileInputStream("src/data/code1970.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N+1][N+1];
        b = new int[N+1][N+1];

        boolean f = true;
        boolean flag = false;
      //  dir = new int[N];
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
                //System.out.print(a[i][j]+" ");
            }
            //System.out.println();
        }
        int m = N;
        // 배열 회전 
        while (f) {
            dr = sc.nextInt();
                if(dr == 90){
                    Rotation(m);
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                    }
                } 
                if(dr == 180){
                    Rotation(m);
                    Rotation(m);
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
                if(dr == 270){
                    Rotation(m);
                    Rotation(m);
                    Rotation(m);
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
                if(dr == 360){
                    Rotation(m);
                    Rotation(m);
                    Rotation(m);
                    Rotation(m);
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            if (dr == 0) {
                f = false;
            }
        } // end while
 
    }
 
    public static void Rotation(int n) {
        int m = n;
        int k = 0, h = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[i][j]; 
            }
        }
        for (int j = 0; j < m; j++) {
            h = 0;
            for (int i = m - 1; i >= 0; i--) {
                a[k][h] = b[i][j];
                h++;
            }
            k++;
        }
 
    }

}
