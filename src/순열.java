
public class 순열 {

	/**
	 * @param args
	 */
	static int arr[] = {1, 2, 3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(arr.length, arr.length);
	}
	public static void swap(int n, int m) {
		if(n == m) {
			return;
		}
		int tmp = arr[n];
		arr[n] = arr[m];
		arr[m] = arr[tmp];
	}
	public static void perm(int n, int m) {
		if(m == 1) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		for (int i = 0; i < m; i++) {
			swap(i, m-1);
			perm(n, m-1);
			swap(i, m-1);
		}
	}
}
