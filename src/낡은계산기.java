import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class 낡은계산기 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	static int N, M, Answer;
	static int arr[];
	//static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/낡은계산기"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			
			///////////////////////////////////////////////////
			N = sc.nextInt();
			arr = new int[N];
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); 
				pq.add(arr[i]);
				//System.out.println(arr[i]);
			}
			int a = 0;
			int b = 0;
			while (pq.isEmpty() == false) {
				a = pq.poll();
				b = pq.poll();
				Answer = a+b;
				if(pq.isEmpty() == false) {
					pq.add(a+b);
				}
			}
			
			///////////////////////////////////////////////////
			System.out.println("#" + (tc+1) + " " + Answer);
		}
	}
}
