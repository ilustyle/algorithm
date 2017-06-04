import java.io.FileInputStream;
import java.util.Scanner;


public class Exam_01 {
	static int N=5;
	static int Answer;
	static int [][] input = new int[N][N];
	static int visited [] = new int[N];
	static int tempAmt;
 
	public static void main(String args[]) throws Exception{
		 System.setIn(new FileInputStream("src/data/exam01.txt"));
		 Scanner sc = new Scanner(System.in);
	     N = sc.nextInt();
	     //System.out.println(N);
		 for(int i = 0; i < N ; i++){
			 	visited [i] = 0;
			 	for(int j = 0; j < N; j++){
			 		input[i][j]= sc.nextInt();
			 	}   
		 }
	     Answer = Integer.MAX_VALUE;
	
	     backtrack(0);
	     
	     System.out.println("# " + Answer);
	}
 
	public static void backtrack(int depth){

		if(depth==N){ 
				if(tempAmt < Answer) Answer = tempAmt; 
				return;
		}
  
		for(int i=0; i<N ; i++){
			if(visited[i]==0){
				//System.out.println(depth+":"+i+"="+input[depth][i]+","+tempAmt);
				tempAmt = tempAmt + input[depth][i];
				if(tempAmt > Answer) {
					tempAmt = tempAmt - input[depth][i];
					continue;  
				}
				visited[i]=1;
				backtrack(depth+1);
				tempAmt = tempAmt - input[depth][i];
				visited[i]=0;
			}  
		}
	}
}
