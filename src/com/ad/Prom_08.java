package com.ad;
import java.util.*;
import java.io.FileInputStream;

public class Prom_08 {

	/**
	 * @param args
	 * 재구성된 이진트리
	 */
	static int N, M, Answer;
	static int a[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom08"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			///////////////////////////////////////
			N = sc.nextInt();
			a = new int[N];
			List<Integer> list = new ArrayList<Integer>();
			
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
				list.add(a[i]);
			}
			Collections.sort(list);
			//System.out.println(list);
			
			int map[][] = new int[N][N];
			int z = 0;
			int cnt = 0;
			int last = 0;
			
			while (list.size() != cnt) {
				int i = (int) Math.pow(2, z)-1;
				if(list.size()-cnt < i) {
					i = list.size()-cnt-1;
					last = list.get(i);
				};
				for (int j = i; j >= 0; j--) {
					cnt += 1;
					map[z][j] = list.get(list.size()-cnt);
				}
				z += 1;
			}
//			
//			int map2[][] = new int[N][N];
//			int z2 = 0;
//			int cnt2 = 0;
//			int rX = 0;
//			int rY = 0;
//			
//			while (list.size() != cnt2) {
//				int i = (int) Math.pow(2, z2)-1;
//				if(list.size()-cnt2 < i) {
//					i = list.size()-cnt2-1;
//					break;
//				};
//				for (int j = i; j >= 0; j--) {
//					cnt2 += 1;
//					map2[z2][j] = list.get((list.size()-1)-cnt2);
//					if(map2[z2][j] == last) {
//						rX = z2;
//						rY = j + 1;
//						cnt2 += list.size();
//						break;
//					}
//				}
//				z2 += 1;
//			}
//			System.out.println(rX + " " + rY);
			
			for (int[] is : map) {
				System.out.println(Arrays.toString(is));
			}
			
			///////////////////////////////////////
		} // end for
	} // end main

}
