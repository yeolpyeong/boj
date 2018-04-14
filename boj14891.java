/*
 * Åé´Ï¹ÙÄû
 * https://www.acmicpc.net/problem/14891
 */

package boj;

import java.util.Scanner;

public class boj14891 {
	static int[][] cogWheels = new int[5][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 4; i++) {
			String row = sc.next();
			for (int j = 1; j <= 8; j++) {
				cogWheels[i][j] = row.charAt(j - 1) == '0' ? 0 : 1;
			}
		}

		int K = sc.nextInt();
		while (K-- > 0) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] rotated = new int[4];
			boj14891(N, D, checkRotable(N), rotated);
		}
		System.out.print(scoring());
	}

	public static int[] checkRotable(int N) {
		int[] rotable = new int[4];
		rotable[1] = cogWheels[1][3] != cogWheels[2][7] ? 1 : 0;
		rotable[2] = cogWheels[2][3] != cogWheels[3][7] ? 1 : 0;
		rotable[3] = cogWheels[3][3] != cogWheels[4][7] ? 1 : 0;
		return rotable;
	}

	public static void boj14891(int N, int D, int[] rotable, int[] rotated) {
		rotate(cogWheels[N], D);
		switch (N) {
		case 1:
			if (rotable[1] == 1 && rotated[1] == 0) {
				rotated[1] = 1;
				boj14891(2, -D, rotable, rotated);
			}
			break;
		case 4:
			if (rotable[3] == 1 && rotated[3] == 0) {
				rotated[3] = 1;
				boj14891(3, -D, rotable, rotated);
			}
			break;
		default:
			if (rotable[N - 1] == 1 && rotated[N - 1] == 0) {
				rotated[N - 1] = 1;
				boj14891(N - 1, -D, rotable, rotated);
			}
			if (rotable[N] == 1 && rotated[N] == 0) {
				rotated[N] = 1;
				boj14891(N + 1, -D, rotable, rotated);
			}
			break;
		}
	}

	public static void rotate(int[] cogWheel, int D) {
		int temp = 4444;
		if (D == 1) {
			temp = cogWheel[8];
			cogWheel[8] = cogWheel[7];
			cogWheel[7] = cogWheel[6];
			cogWheel[6] = cogWheel[5];
			cogWheel[5] = cogWheel[4];
			cogWheel[4] = cogWheel[3];
			cogWheel[3] = cogWheel[2];
			cogWheel[2] = cogWheel[1];
			cogWheel[1] = temp;
		} else if (D == -1) {
			temp = cogWheel[1];
			cogWheel[1] = cogWheel[2];
			cogWheel[2] = cogWheel[3];
			cogWheel[3] = cogWheel[4];
			cogWheel[4] = cogWheel[5];
			cogWheel[5] = cogWheel[6];
			cogWheel[6] = cogWheel[7];
			cogWheel[7] = cogWheel[8];
			cogWheel[8] = temp;
		}
	}

	public static int scoring() {
		return cogWheels[1][1] + 2 * cogWheels[2][1] + 4 * cogWheels[3][1] + 8 * cogWheels[4][1];
	}
}
