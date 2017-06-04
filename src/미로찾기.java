
import java.util.Scanner;
import java.util.Stack;

public class 미로찾기 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		int visit[][] = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				map[i][j] = sc.nextInt();
				visit[i][j] = map[i][j];
			}
		}
		
		Stack<String> root = new Stack<String>();
		root.add("0,0");
		visit[0][0] = 1; 
		
		int endYn = 0;
		
		while(endYn != 1) {
			
			String temp = root.pop();
			int x = Integer.parseInt(temp.split(",")[0]);
			int y = Integer.parseInt(temp.split(",")[1]);
			
			if(x == n-1 && y == n-1){
				endYn = 1;
				root.add((x)+","+(y));
				break;
			}
			
			if(y + 1 < n && visit[x][y+1] == 0 && map[x][y+1] == 0) {
				visit[x][y+1]=1;
				root.add((x)+","+(y));
				root.add((x)+","+(y+1));
			}
			
			else if(x+1 < n && y+1 < n && visit[x+1][y+1] == 0 && map[x+1][y+1] == 0){
				visit[x+1][y+1] = 1;
				root.add((x)+","+(y));
				root.add((x+1)+","+(y+1));
			}
			
			else if(x+1 < n && visit[x+1][y] == 0 && map[x+1][y] == 0){
				visit[x+1][y] = 1;
				root.add((x)+","+(y));
				root.add((x+1)+","+(y));
			}
			
			else if(x+1 < n && y-1 >= 0 && visit[x+1][y-1] == 0 && map[x+1][y-1] == 0){
				visit[x+1][y-1] = 1;
				root.add((x)+","+(y));
				root.add((x+1)+","+(y-1));
			}
			
			else if(y-1 >= 0 && visit[x][y-1] == 0 && map[x][y-1] == 0){
				visit[x][y-1] = 1;
				root.add((x)+","+(y));
				root.add((x)+","+(y-1));
			}
			
			else if(x-1 >= 0 && y-1 >= 0 && visit[x-1][y-1] == 0 && map[x-1][y-1] == 0){
				visit[x-1][y-1] = 1;
				root.add((x)+","+(y));
				root.add((x-1)+","+(y-1));
			}
			
			else if(x-1 >= 0 && visit[x-1][y] == 0 && map[x-1][y] == 0){
				visit[x-1][y] = 1;
				root.add((x)+","+(y));
				root.add((x-1)+","+(y));
			}
			
			else if(x-1 >= 0 && y+1 < n && visit[x-1][y+1] == 0 && map[x-1][y+1] == 0){
				visit[x-1][y+1] = 1;
				root.add((x)+","+(y));
				root.add((x-1)+","+(y+1));
			}
		
			else{
				root.add((x)+","+(y));
			}
		}
		
		for(int i=0; i < root.size(); i++){
			
			String temp = root.get(i);
			int x = Integer.parseInt(temp.split(",")[0]) + 1;
			int y = Integer.parseInt(temp.split(",")[1]) + 1;
			
			System.out.print("(" + x + " " + y + ")");
		}
	}
}
/*
3
0 1 1 
0 1 1 
1 0 0

5
0 1 1 1 1
0 0 0 1 1
1 0 1 1 1
1 0 0 0 1
1 0 1 0 0 
*/