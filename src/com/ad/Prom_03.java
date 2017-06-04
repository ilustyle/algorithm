package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_03 {

	/**
	 * @param args
	 * 음식점 매출액
	 */
	static int N, M, Answer;
	static int[] NTime, MCount;
	static char stack[];
	static int top;
	static int a[];
	static double res;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom03"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			N = sc.nextInt(); // 버너수
			NTime = new int [N];
			int NRTime[] = new int[N];
			int NOccp[] = new int[N];
			
			for (int i = 0; i < N; i++) {
				NTime[i] = sc.nextInt();
				NRTime[i] = NTime[i];
			}
			
			M = sc.nextInt(); // 주문수
			List<Integer> mQty = new ArrayList<Integer>();
			List<Integer> delayTime = new ArrayList<Integer>();
			int inComQty = 0;
			int OcpQty = 0;
			
			MCount = new int[M];
			for (int i = 0; i < M; i++) {
				mQty.add(sc.nextInt());
				delayTime.add(0);
			}
			
			while (mQty.size() > 0) {
				for (int i = 0; i < mQty.size(); i++) {
					int order = mQty.get(i);
					int tmpOcpQty = 0;
					
					for (int k = 0; k < N; k++) {
						if(NOccp[k] == 1) {
							NRTime[k] = NRTime[k]-1;
							if (NRTime[k] == 0) {
								inComQty += 1;
								OcpQty -= 1;
								NOccp[k] = 0;
								NRTime[k] = NTime[k];
							}
						}
					}
					
					if(N-OcpQty >= order) {
						mQty.remove(i);
						delayTime.remove(i);
						for (int k = 0; k < N; k++) {
							if(NOccp[k] == 0) {
								NOccp[k] = 1;
								tmpOcpQty += 1;
								OcpQty += 1;
							}
							if(tmpOcpQty == order) {
								break;
							}
						}
						i--;
					} else {
						delayTime.add(i, delayTime.get(i)+1);
						delayTime.remove(i);
						if(delayTime.get(i) == 5) {
							delayTime.remove(i);
							mQty.remove(i);
							break;
						}
					}
				}
			} // end while
			System.out.println(5000*inComQty);
			
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main
}
