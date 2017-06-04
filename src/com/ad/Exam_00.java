package com.ad;

import java.io.FileInputStream;
import java.util.*;

public class Exam_00 {

	/**
	 * @param args
	 * 바이러스 - 그래프 - 인접행렬
	 */
	static int Answer, N, M, K;
	static int a[][];
	static int map[][];
	static Queue<Integer> q = new LinkedList();
	static int visit[];
	static int rslt[];
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/data/ex00"));
		System.setIn(new FileInputStream("src/data/ex00"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
		///////////////////////////////////////////////////////	
			N = sc.nextInt();
			M = sc.nextInt();
			a = new int[N][2];
			for (int i = 0; i < N; i++) {
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
//			Arrays.sort(a, new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					// TODO Auto-generated method stub
//					Integer t1 = o1[0];
//					Integer t2 = o2[0];
//					return t1.compareTo(t2);
//				}
//			});
			
			// 인접행렬
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[a[i][0]][a[i][1]] = 1;
					map[a[i][1]][a[i][0]] = 1;
				}
			}
			
//			// 출력
//			for (int i = 0; i <= M; i++) {
//				for (int j = 0; j <= M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			Answer = Integer.MAX_VALUE;
			visit = new int[N];
			rslt = new int[N];
			
			for (int i = 1; i <= M; i++) {
//				q.offer(i);
//				visit[i] = 1;
				int res = bfs(i);
				if(Answer >  res) {
					Answer = res;
				}
			}	
			
			System.out.println("#" + tc+ " " + (Answer));   
		///////////////////////////////////////////////////////
		}
	}
	public static int bfs(int i) {
		// TODO Auto-generated method stub
		q.offer(i);
		visit[i] = 1;
		while (!q.isEmpty()) {
			//System.out.println("p >> " + q.peek());
			int tp = q.poll();
			//System.out.println(tp);
            for (int j = 0; j < N; j++) {
                if(map[tp][j] == 1 && visit[j] == 0) {
                	//System.out.println(map[i][j]);
                    q.offer(j);
                    visit[j] = visit[tp] + 1;
                }
            }
		}
        Arrays.sort(visit);
        return visit[N-1]+1;
	}
	
}
