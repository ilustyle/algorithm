package com.jungol;
import java.util.*;
public class Exam_1004 {

	/**
	 * @param args
	 * 
input:
3
1500
2000
2500

8
1001
3343
2453
1840
3595
3727
1640
1356

18955
2369.4
1000.7


16
1227
3278
3476
3807
1892
1499
2464
3616
1743
1688
1377
2527
3845
1361
2925
2401

39126
2445.4
910

	 */
	static int N, M, AnswerN;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int nums[] = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		double sum = 0;
		double avg = 0d;
		double stdv = 0d;
		
		for (int i = 0; i < N; i++) {
			sum += nums[i];

		}
		avg += sum / N;		
		
		for(int i = 0;i < N; i++){
			stdv += (nums[i]-avg) * (nums[i]-avg);
		}
		stdv /= N;
		stdv = Math.sqrt(stdv);	
	
		String tmp = String.format("%.1f", (stdv*100)/100.0);
//		System.out.println(tmp.contains(".0"));

		//System.out.println((avg*10)%10);
		System.out.println((int)sum);
		//System.out.println(String.format("%.1f", stdv));
		if((avg*10)%10 == 0) {
			System.out.println(String.format("%.0f", avg));
		}
		else {
			System.out.println(String.format("%.1f", (avg*100)/100.0));
		}
		if(tmp.contains(".0")) {
			System.out.println(String.format("%.0f", stdv));
		}
		else {
			System.out.println(String.format("%.1f", (stdv*100)/100.0));
		}	
	}

}
