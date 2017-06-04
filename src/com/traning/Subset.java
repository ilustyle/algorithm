package com.traning;

public class Subset {

	/**
	 * @param args
	 */
	static int N, M, Answer;
	static int c[] = {1, 2, 3, 4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-7, -3, -1, 4, 8};
		int b[] = {1, 2, 3};
//		for (int i = 0; i < (1 << a.length); i++) { 
//			int sum = 0;
//			System.out.print("{");
//			for (int j = 0; j < a.length; j++) { 
//				if ((i & (1 << j)) != 0) { 
//					sum += a[j];
//					//System.out.print(a[j]+ ", ");
//					if(sum == 0) {
//						System.out.print( a[j]+ ", ");
//					}
//				}
//			}
//			System.out.println("}");
//		}
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(b[i] != b[j]) {
					for (int k = 0; k < b.length; k++) {
						if(b[i] != b[k] && b[j] != b[k]) {
							System.out.println(b[i] + ", " + b[j] + ", " + b[k]);
						}
					}
				}
			}
		}
		System.out.println("================================");
		ps(0, 0, c.length);
		
	}
	public static void swap(int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	public static void ps(int n, int k, int len) {
		if(n == len) {
			for (int i = 0; i < len; i++) {
				System.out.print(c[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = n; i < len; i++) {
				swap(n, i);
				ps(n+1, k, len);
				swap(n, i);
			}
		}
	}
}
