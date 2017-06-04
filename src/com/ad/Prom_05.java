package com.ad;

import java.util.*;
import java.io.FileInputStream;


public class Prom_05 {

	/**
	 * @param args
	 * 운동회 - 기출
	 * 
	 */
	static int map[][];
	static int P, S, K, N, M, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom05"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			P = sc.nextInt();
			S = sc.nextInt();
			K = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[S][5];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			Arrays.sort(map, new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					Integer t1 = o1[0];
					Integer t2 = o2[1];
					return t1.compareTo(t2);
				}
			});
			
//            Arrays.sort(map, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] a, int[] b) {
//                    return a[0] < b[0] ? -1 : 1;
//                }
//            });   
			
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			int nG = 0;
			int mG = 0;
			int tG = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

//			while (nG < P * N) {
//				int i = 0;
//				nG += map[i][1];
//				i++;
//			}
//			while (mG < P * M) {
//				int i = 0;
//				mG += map[i][3];
//				i++;
//			}

			for (int i = 0; i < K; i++) {
				//nG += map[i][1];
				//mG += map[i][3];
                nG = makeGroup(map[i][1], N);
                mG = makeGroup(map[i][3], M);

				
               // System.out.println(nG + " " + mG);
				//System.out.println(nG + " : " + mG);
//				if(i == 0) {
//					min = (nG * map[i][2]) + (mG * map[i][4]);
//					max = (nG * map[i][2]) + (mG * map[i][4]);
//				} else {
					tG = (nG * map[i][2]) + (mG * map[i][4]);
					if(min > tG) {
						min = tG;
					}
					if(max < tG) {
						max = tG;
					}
//				}
			}

			
			System.out.println(max + " " + min);
			//System.out.println(list.size());
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main
    public static int makeGroup(int num, int c) {
        int result = num;
        while(result < (P * c)) {
            result += num;
        }
        return result;
    }
}
