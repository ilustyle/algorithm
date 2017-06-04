package com.ad;

public class 수의부분합 {

	/**
	 * @param args
	 */
	static int data[] = { 0, 40, 20, 30, 10 };
	static int include[] = new int[5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process(0, 0, 100);
	}

	public static boolean promising(int total, int remaining) { // 이 함수를 유망함수라 함
		if (total > 50 || total + remaining < 50)
			return false;
		return true;
	}

	public static void process(int i, int total, int remaining) {
		int k;

		if (promising(total, remaining))
			if (i == 4) {
				if (total == 50) {
					for (k = 1; k <= 4; k++)
						if (include[k] == 1)
							System.out.println(data[k]);
					System.out.println();
				}
			} else {
				include[i + 1] = 1;
				process(i + 1, total + data[i + 1], remaining - data[i + 1]);
				include[i + 1] = 0;
				process(i + 1, total, remaining - data[i + 1]);
			}
	}

}
