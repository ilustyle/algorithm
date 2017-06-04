package com.jungol;
import java.util.*;
public class Exam_1003 {

	/**
	 * @param args
	 * 
5
0 1 1 3 2

	 */
	static int N, AnswerN;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		int line[] = new int[N];
		int tmp = 0;
		
		for (int i = 0; i < N; i++) { // 일단 뒤에 줄을 세우고....
			line[i] = i+1;
			for (int j = 0; j < num[i]; j++) { // 뽑은 수만큼 앞으로...
				tmp = line[i-j-1];
	            line[i-j-1] = line[i-j];
	            line[i-j] = tmp;

			}
			//System.out.println(line[i]);
		}
	    for (int i = 0; i < N; i++) { // 줄선 순서 출력...
	        System.out.print(line[i]);
	      //  if (i != N - 1)
	        //    System.out.print(" ");
	    }

		
	}

}
