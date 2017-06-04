package org.codexpert;

import java.util.*;
import java.io.FileInputStream;

public class 숫자의종류 {

	/**
	 * @param args
	 * 
input: 
50
123 321 123 231 321 

output:
3
	 */
	
	
	static int N, M, Answer;
	static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			ts.add(arr[i]);
		}
		System.out.println(ts.size());
	}
	public static int Reverse(int num) {
		int res = 0;
		for (int i = num; i != 0; i /= 10) {
			res = res * 10 + i % 10;
		}
		return res;
	}

}
