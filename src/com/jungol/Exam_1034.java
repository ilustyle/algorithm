package com.jungol;
import java.util.*;
public class Exam_1034 {

	/**
	 * @param args
	 * 단어빈도
	 */
	static int N, AnswerN;
	static char arr[];
	static TreeSet<String> ts = new TreeSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//String str = sc.next();
		String str = "DRINKKKRIK";
		//System.out.println(str);
		arr = new char[str.length()];
		arr = str.toCharArray();
		N = str.length();
		getP(N, N);
		
		//ArrayList<String> al = new ArrayList<String>(ts);
		
		
		int j = 0;
		for (String is : ts) {
			System.out.println(is);
		}

		
	}
	public static void getP(int a, int b) {
		if(b == 1) {
			//for (int i = 0; i < a; i++) {
				String c_str = String.valueOf(arr);
//				/System.out.println(c_str);
				ts.add(c_str);
			//}
		}
		for (int i = 0; i < b; i++) {
			swap(i, b-1);
			getP(a, b-1);
			swap(i, b-1);
		}
	}
	public static void swap(int a, int b) {
		char tmp;
		if(a == b) {
			return;
		} else {
			tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
	}
}
