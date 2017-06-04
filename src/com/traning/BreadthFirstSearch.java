package com.traning;
import java.util.*;
import java.io.FileInputStream;

public class BreadthFirstSearch {

	/**
	 * @param args
	 */
	static int N, Answer;
	static int[][] ad;
	static boolean[] visit;
	static int Ne, Nv, Nw;
	static int queue[];
	static int front, end;

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/data/BreadthFirstSearch.txt"));
        Scanner scan = new Scanner(System.in);
        Nv = scan.nextInt();
        Ne = scan.nextInt();
        ad = new int[Nv+1][Nv+1];
        visit = new boolean[Nv+1];
        queue = new int [Nv*2];
        front = 0;
        end = 0;
        
        for(int i = 0; i < Ne; i++){
            int t1, t2, t3;
            t1 = scan.nextInt();
            t2 = scan.nextInt();
           // t3 = scan.nextInt(); // 가중치 그래프일 경우 1 대신 가중치를 배열에 저장.
            
            ad[t1][t2] = 1;
            ad[t2][t1] = 1;
        }
        
        bfs(1);
//        for (int[] as : ad) {
//			System.out.println(Arrays.toString(as));
//		}

	}
	public static void bfs(int i) {
//		Queue<Integer> q = new<Integer> LinkedList();
//		q.offer(i);
		visit[i] = true;
		queue[end++] = i;
		
		while (front != end) {
			//int temp = q.poll();
			int temp = queue[front++];
		
			System.out.println(temp);
			for (int j = 1; j <= Nv; j++) {
				if (ad[temp][j] == 1 && visit[j] == false) {
					System.out.println(temp + "," + j);
					//q.offer(j);
					queue[end++] = j;
					//System.out.println("elem 1: " + q.element());
					//System.out.println("elem 2: " + q.element());
					visit[j] = true; 
				}
			}
		} //end while
	}
}
