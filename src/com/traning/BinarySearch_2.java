package com.traning;

import java.util.Arrays;


class BinarySearch_2 {

	static int[] arr = { 3, 4, 10, 8, 2, 3, 8, 1, 9, 8, 6, 5, 7 };
	static int[] frq = new int[arr.length];
	
	public static void main(String args[]) {
		
		// 오름차순 정렬e
		Arrays.sort(arr);
		print(arr.length);
		
		// 유일성 검사
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i - 1]) {
				// 유일하지 않은 원소를 출력
				System.out.printf("%d ", arr[i]);
			}
		}
		System.out.println();
		
		// 빈도수 구하기
		int cnt = 1;
		frq[0] = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i - 1]) {
				frq[i - cnt] = cnt + 1;
				cnt ++;
			} else {
				cnt = 1;
				frq[i] = 1;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("FRQ: %d ", frq[i]);
		}
		System.out.println();
		
		// 중복값 삭제
		cnt = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i - 1]) {
				arr[cnt] = arr[i];
				System.out.println("arr[cnt] >> " + arr[cnt]);
				cnt++;
			}
		}
		print(cnt);
		System.out.println("cnt : " + cnt);
		
		// 이진 검색(찾는 수의 인덱스 값을 반환)
		System.out.println("BS: " + Arrays.binarySearch(arr, 5, cnt, 2));
		
		// 더해서 10이 되는 정수쌍
		int last = cnt - 1;
		for(int i = 0; i < last; i++) {
			for(int j = last; j > i; j--) {
				if(arr[i] + arr[j] == 10) {
					System.out.printf("%d, %d\n", arr[i], arr[j]);
					last = j - 1;
					break;
				}
			}
		}
	}
	
	public static void print(int size) {
		for(int i = 0; i < size; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
}


