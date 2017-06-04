import java.io.FileInputStream;
import java.util.*;
public class Exam_02 {

	/**
	 * @param args
	 * 이진법
input:
10
45
34
23
56
9
13
47
76
22
13
	 */
	static int N, Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	     int T = sc.nextInt();
	     for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			System.out.println("input : " + N);
			String str = Integer.toBinaryString(N);
			System.out.println("input binary : " + str);
			String rev = new StringBuffer(str).reverse().toString();
			System.out.println("reverse : " + rev);
			Answer = Integer.parseInt(rev, 2);
		    System.out.println("output : " + Answer);
			
		}
	     System.out.println();
	}

}
