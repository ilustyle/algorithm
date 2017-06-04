
public class 부분집합 {

	/**
	 * @param args
	 */
	static int arr[] = {1, 2, 3, 4};
	static int[] bit = new int[arr.length];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < (1 << arr.length); i++) {
//			for (int j = 0; j < arr.length; j++) {
//				if((i & (1 << j)) != 0) {
//					System.out.print(arr[j] + " ");
//				}
//			}
//			System.out.println();
//		}
		f(0, arr.length);
	}
	private static void f(int k, int length) {
		// TODO Auto-generated method stub
		if(k == length) {
			for (int i = 0; i < arr.length; i++) {
				if(bit[i] == 1) {
					System.out.print(arr[i] + " ");									
				}
			}
			System.out.println();
		} else {
			for (int i = 0; i < arr.length-1; i++) {
				bit[k] = i;
				f(k+1, length);
			}
		}
	}

}
