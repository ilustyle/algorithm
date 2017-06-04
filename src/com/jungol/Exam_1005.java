package com.jungol;
import java.util.*;
public class Exam_1005 {

	/**
	 * @param args
	 * 
4
36
38
40
42
	 * 
	 */
	static int N, AnswerN;
	static int fnum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < num.length; i++) {
			//System.out.println(num[i]);
		}
		isPrime(36);
		int maxf = -1;
		for (int i = 0; i < num.length; i++) {
	        if ((fnum = getNum(num[i])) > maxf)
	        {
	        	maxf = fnum;
	        	AnswerN = num[i];
	        }
			//System.out.println(getNum(num[i]));
		}
		System.out.println(AnswerN);
		
	}
	public static int isPrime(int n) {
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < n; j++) {
				if (n % j == 0) {
					return 0;
				}
			}
		}
		return 1;
	}
	public static int getNum(int k) {
		//fnum = 1;
		for (int i = k; i > 1; i--) {
			if(k % i == 0 && isPrime(i) == 0) {
				fnum = i;
				break;
			}
		}
		return fnum;
	}
}
