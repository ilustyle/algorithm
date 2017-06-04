package com.traning;
import java.util.*;
import java.io.FileInputStream;
public class Code_1961 {

	/**
	 * @param args
	 * 연속 부분 최대 곱
	 */
	static int N, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/code03.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		double ans = 0, cur = -1.0;
		for (int i = 1; i <= N; i++) {
			double num;
			num = sc.nextDouble();
			if(cur*num > num) {
				cur *= num;
				//System.out.println(cur);	
			} else {
				cur = num;
			} 
			if(ans < cur) {
				ans = cur;
			}
		}

		System.out.println(String.format("%.3f", ans));

	}

}
