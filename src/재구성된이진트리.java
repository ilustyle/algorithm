

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 재구성된이진트리 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++){
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		int map[][] = new int[n][n];
		int zegop = 0;
		int cnt = 0;
		int last = 0;
		
		while(list.size()!=cnt){
			int i = (int)Math.pow(2,zegop)-1;
			
			if(list.size()-cnt<i){
				i = list.size()-cnt-1;
				last = list.get(i);
			}
			
			for(int j=i; j>=0; j--){
				cnt = cnt + 1;
				map[zegop][j] = list.get(list.size()-cnt);
			}
			zegop = zegop + 1;
		}
		
		int map2[][] = new int[n][n];
		int zegop2 = 0;
		int cnt2 = 0;
		int resultX = 0;
		int resultY = 0;
		
		while(list.size()!=cnt2){
			int i = (int)Math.pow(2,zegop2)-1;
			
			if(list.size()-cnt2<i){
				i = list.size()-cnt2-1;
			}
			
			for(int j=i; j>=0; j--){
				cnt2 = cnt2 + 1;
				map2[zegop2][j] = list.get(list.size()-1-cnt2);
				if(map2[zegop2][j]==last){
					resultX = zegop2;
					resultY = j+1;
					cnt2 = list.size();
					break;
				}
			}
			zegop2 = zegop2 + 1;
		}
		
		System.out.println(resultX + " " + resultY);
	}
}

/*

12
1 2 3 4 7 9 10 11 12 15 18 20



*/
