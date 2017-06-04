package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_01 {

	/**
	 * @param args
	 * 괄호 계산
	 */
	static int N, M, Answer;
	static char stack[];
	static int top;
	static int a[];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom01"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			String s = sc.next();
			
			stack = new char [100];
			top = -1;
			char tmp;
			
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '<' ) {
					stack[++top] = s.charAt(i);
				}
				else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == '>' ) {
					tmp = stack[top];
					if(s.charAt(i) == '>' && tmp == '<') top--;
					if(s.charAt(i) == ')' && tmp == '(') top--;
					if(s.charAt(i) == ']' && tmp == '[') top--;
					if(s.charAt(i) == '}' && tmp == '{') top--;

				}
				if(top != 0) {
					Answer = 0;
				} else {
					Answer = 1;
				}
				//System.out.println(stack);
			}
			
			System.out.println("#" + tc + " " +  Answer);
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main

}
