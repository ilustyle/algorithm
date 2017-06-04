package com.jungol;

import java.util.*;

public class Exam_1002 {

	/**
	 * @param args
	 *            최대 공약수, 최소공배수 
	 *            input: 
3 
2 8 10 
	 *            output: 2 40
	 */
	static int N, Answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

	    // 최소공배수, 최대공약수 구하기
	    int g = gcd(num[0], num[1]);
	    int l = lcm(num[0], num[1]);
	 
	    for (int i = 2; i < N; i++) {
	        g = gcd(g, num[i]);
	        l = lcm(l, num[i]);
	    }
	 
	    System.out.println(g + " " + l);


	}
	public static int gcd(int a, int b) { //최소공배수
	    if (b == 0) {
	        return a;
	    }
	    else {
	        return gcd(b, a % b);
	    }
	}
	 
	public static int lcm(int a, int b) { //최대공약수
	    return a * b / gcd(a, b);
	}

}
