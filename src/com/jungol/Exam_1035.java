package com.jungol;
import java.util.*;
public class Exam_1035 {

	/**
	 * @param args
	 * 배열 최대값과 위치 찾기
	 * 
3
29
38
12
57
74
40
85
61
	 * 
	 */
	static int N, AnswerN;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num[] = new int[9];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		int max = 0;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if(max < num[i]) {
				max = num[i];
			}
		}
		for (int i = 0; i < num.length; i++) {
			if(num[i] == max) {
				count += i;
			}
		}
		System.out.println(max);
		System.out.println(count+1);
	}

}
