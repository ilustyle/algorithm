package com.traning;

import java.util.*;
import java.io.FileInputStream;
public class Main_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/main01.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int h = 0; h < testCase; h++) {
			int[] arr = new int[6];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr); // 오름차순으로 작은 순서부터 정렬됨
			
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i]);
//			}
//		System.out.println("");
			int sum1 = 0;
			int sum2 = 0;
			//sum1 += arr[0];
			//sum2 += arr[1];
			int value1 = arr[3] - arr[2];
			int value2 = arr[5] - arr[4];
			if (value1 >= value2) {
				sum1 = arr[0] + arr[3] + arr[4];
				sum2 = arr[1] + arr[2] + arr[5];
			} else {
				sum1 = arr[0] + arr[2] + arr[5];
				sum2 = arr[1] + arr[3] + arr[4];
			}

			System.out.println("Case #" + (h + 1) + " " + Math.abs(sum1 - sum2));
		}
		sc.close();
	}

}
