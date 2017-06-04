package com.jungol;
import java.util.*;
import java.io.FileInputStream;
public class Exam_1215 {
	/*
	 * CD만들기
	 */
	static int N, T, Answer;
    public static void main(String[] args)throws Exception {
    	System.setIn(new FileInputStream("src/data/code01.txt"));
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	T = sc.nextInt();
    	int m[] = new int [N];
    	for (int i = 0; i < N; i++) {
			m[i] = sc.nextInt();
		}
    	int tmp = 0;
    	int min = 0;
    	
    	// Selection sort
    	for (int i = 0; i < m.length; i++) {
			min = i;
			for (int j = i+1; j < m.length; j++) {
				if(m[min] > m[j]) {
					min = j;
				}
			}
			tmp = m[min];
			m[min] = m[i];
			m[i] = tmp;
		}
    	
    	int sum = 0;
    	Answer = 0;
    	for (int i = 1; i < N; i++) {
    		if(m[i] > T) {
    			Answer = 0;
    			break;
    		}
			sum += m[i];
			if(sum >= T) {
				break;
			}
			Answer = i+1;
		}
		System.out.println(Answer);
    }

}