
import java.util.Scanner;

public class 치즈_백트래킹 {

	/**
	 * @param args
	 */
	static int xLength;
	static int yLength;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		xLength = in.nextInt();
		yLength = in.nextInt();
		int[][] array = new int[xLength][yLength];
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				array[x][y] = in.nextInt();
			}
		}
		in.close();

		int last = 0;
		int count = 0;

		while (true) {
			
			int remain = 0;
			checkAir(array, 0, 0);
			for (int x = 0; x < xLength; x++) {
				for (int y = 0; y < yLength; y++) {
					if (array[x][y] == 1) {
						if (array[x - 1][y] == 9 || array[x + 1][y] == 9 || array[x][y - 1] == 9 || array[x][y + 1] == 9) {
							array[x][y] = 2;
							remain++;
						}
					}
				}
			}

			for (int x = 0; x < xLength; x++) {
				for (int y = 0; y < yLength; y++) {
					if (array[x][y] == 9 || array[x][y] == 2)
						array[x][y] = 0; // 占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占싹댐옙 占싸븝옙占쏙옙 0占쏙옙占쏙옙 占쏙옙占쏙옙
				}
			}

			// 占쏙옙占싱삼옙 처占쏙옙占쏙옙 占싸븝옙占쏙옙 占쏙옙占쏙옙占쏙옙 0占쏙옙占쏙옙 占쏙옙占쏙옙
			if (remain == 0)
				break;

			count++;
			last = remain;
		} // end while

		System.out.println(count);
		System.out.println(last);
	}
	
	public static void checkAir(int[][] array, int x, int y) {
		if (array[x][y] == 0 || array[x][y] == 2) {

			array[x][y] = 9;

			if (x - 1 >= 0)
				checkAir(array, x - 1, y);

			if (x + 1 < xLength)
				checkAir(array, x + 1, y);

			if (y - 1 >= 0)
				checkAir(array, x, y - 1);

			if (y + 1 < yLength)
				checkAir(array, x, y + 1);
		}
	}
}
