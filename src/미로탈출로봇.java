import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class 미로탈출로봇 {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/data/p02"));
		Scanner scan = new Scanner(System.in);
		
		int TC = scan.nextInt();		
		for (int z = 1; z <= TC; z++) {
			int V = scan.nextInt();
			int V1 = scan.nextInt();
			int grape[][] = new int[V1+2][V+2];
			
			int y = scan.nextInt();
			int x = scan.nextInt();
			int y1 = scan.nextInt();
			int x1 = scan.nextInt();
			
			for (int i = 1; i < V1+1; i++) {
				for (int j = 1; j < V+1; j++) {
					grape[i][j] = scan.nextInt()==0?1:0;
				}				
			}
//			for (int i = 0; i < V1+2; i++) {
//			System.out.println(Arrays.toString(grape[i]));
//			}
			
			int find[][] = new int[V1+2][V+2];
			int queue[][] = new int[V*V1][2];
			
			int rear = -1;
			int front = -1;
			
			//Start 1
			int sx = x;
			int sy = y;
			rear = rear + 1;
			queue[rear][0] = sx;
			queue[rear][1] = sy;
					
			//level
			find[sx][sy] = 1;
			
			/*
			 *  1 1 1 1 1 1 1 1
				0 0 0 0 0 1 1 1
				1 0 1 1 0 0 1 1
				1 0 1 1 1 0 0 1
				1 0 1 1 1 1 0 1
				1 0 0 0 0 0 0 1
				1 1 1 1 1 1 1 1
			 */
			while(rear != front){
				front = front + 1;
				sx = queue[front][0];
				sy = queue[front][1];
//				System.out.println(sx+ " "+ sy +" = " + find[sx][sy]);
						
				//정답이 스타트
				if(sx == x1 && sy == y1) {
					System.out.println("<ANS>" + sx+ " "+ sy +" = " + (find[sx][sy]-1));
					break;
				}
				
				
				//인접 찾기 상하좌우.
				if(grape[sx-1][sy] == 1 && find[sx-1][sy] == 0){
					rear = rear + 1;
					queue[rear][0] = sx-1;
					queue[rear][1] = sy;
					find[sx-1][sy] = find[sx][sy]+1;
				}
				
				if(grape[sx+1][sy] == 1 && find[sx+1][sy] == 0){
					rear = rear + 1;
					queue[rear][0] = sx+1;
					queue[rear][1] = sy;
					find[sx+1][sy] = find[sx][sy]+1;
				}
				
				if(grape[sx][sy-1] == 1 && find[sx][sy-1] == 0){
					rear = rear + 1;
					queue[rear][0] = sx;
					queue[rear][1] = sy-1;
					find[sx][sy-1] = find[sx][sy]+1;
				}
				
				if(grape[sx][sy+1] == 1 && find[sx][sy+1] == 0){
					rear = rear + 1;
					queue[rear][0] = sx;
					queue[rear][1] = sy+1;
					find[sx][sy+1] = find[sx][sy]+1;
				}				
			}			
		}
	}
}
