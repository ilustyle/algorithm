package com.ad;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class 나눗셈계산 {

	/**
	 * @param args
	 */
	static int A, B;
	static int[] arr;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/나눗셈"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			arr = new int[26];

			int mok = A % B;
			int div = mok * 10;
			
			for (int i = 0; i < 26; i++) {
				arr[i] = div / B;
				mok = div % B;
				div = mok * 10;
			}
			
			if(arr[25] >= 5) {
				arr[24]++;
				for (int j = 24; j >= 0; j--) {
					if(arr[j] > 9) {
						arr[j] = 0;
						arr[j-1]++;
					}
				}
			}
			
			System.out.print("A >> 0.");
			for (int i = 0; i < 25; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			
			BigDecimal da = new BigDecimal(A);
			BigDecimal db = new BigDecimal(B);
			BigDecimal r = da.divide(db,25, BigDecimal.ROUND_HALF_UP);
			System.out.println("B >> " + r);	
			
		} //end main for
	
	}

}
