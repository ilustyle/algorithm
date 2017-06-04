package com.traning;
import java.util.*;

public class BinarySearch {

	/**
	 * @param args
	 */
	static int N;
	static int nums[] = new int[50];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < nums.length; i++) {
				nums[i] = (int) (Math.random()*100);

		}
		
		int tmp, min;
		for (int i = 0; i < nums.length; i++) {
			min = i;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] > nums[min]) {
					min = j;
				}
			}
			tmp = nums[min];
			nums[min] = nums[i];
			nums[i] = tmp;
		}
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			ts.add(nums[i]);
			//System.out.println(nums[i]);
		}

		Integer[] arr = ts.toArray(new Integer[ts.size()]);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		int res = 0;
		while (true) {
			N = sc.nextInt();
			res = Bs(N, arr);
			if(res != -1) {
				System.out.println(res+1);
				break;
			} else {
				System.out.println("No data");
				break;
			}
		}

		// Search	

	}
	public static int Bs(int n, Integer[] arr) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high)/2;
			if(arr[mid] == n) {
				return mid;
			}  
			if(arr[mid] < n) {
				low = mid + 1;
			} 
			if(arr[mid] > n) {
				high = mid - 1;
			}
		}
		return -1;
	}

}
