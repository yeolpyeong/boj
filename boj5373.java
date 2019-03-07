
/*
 * 큐빙
 * https://www.acmicpc.net/problem/5373
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj5373 {
	static void clockwise(char[][] side) {
		char temp = side[0][0];
		side[0][0] = side[2][0];
		side[2][0] = side[2][2];
		side[2][2] = side[0][2];
		side[0][2] = temp;
		temp = side[0][1];
		side[0][1] = side[1][0];
		side[1][0] = side[2][1];
		side[2][1] = side[1][2];
		side[1][2] = temp;
	}

	static void U(char[][][] cube) {
		char[][] temp = cube[0];
		cube[0] = cube[4];
		cube[4] = cube[5];
		cube[5] = cube[2];
		cube[2] = temp;

		clockwise(cube[5]); clockwise(cube[5]);
		clockwise(cube[4]); clockwise(cube[4]);
		clockwise(cube[1]);
		clockwise(cube[3]); clockwise(cube[3]); clockwise(cube[3]);
	}

	static void F(char[][][] cube) {
		char[][] temp = cube[1];
		cube[1] = cube[4];
		cube[4] = cube[3];
		cube[3] = cube[2];
		cube[2] = temp;

		clockwise(cube[2]); clockwise(cube[2]); clockwise(cube[2]);
		clockwise(cube[3]); clockwise(cube[3]); clockwise(cube[3]);
		clockwise(cube[4]); clockwise(cube[4]); clockwise(cube[4]);
		clockwise(cube[1]); clockwise(cube[1]); clockwise(cube[1]);
		clockwise(cube[0]); clockwise(cube[0]); clockwise(cube[0]);
		clockwise(cube[5]);
	}

	static void L(char[][][] cube) {
		char[] temp = { cube[0][0][0], cube[0][1][0], cube[0][2][0] };
		for (int i = 0; i < 3; i++) {
			cube[0][i][0] = cube[3][i][0];
			cube[3][i][0] = cube[5][i][0];
			cube[5][i][0] = cube[1][i][0];
			cube[1][i][0] = temp[i];
		}
		clockwise(cube[4]);
	}

	static void R(char[][][] cube) {
		char[] temp = { cube[0][0][2], cube[0][1][2], cube[0][2][2] };
		for (int i = 0; i < 3; i++) {
			cube[0][i][2] = cube[1][i][2];
			cube[1][i][2] = cube[5][i][2];
			cube[5][i][2] = cube[3][i][2];
			cube[3][i][2] = temp[i];
		}
		clockwise(cube[2]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			char[][][] cube = new char[6][3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cube[0][i][j] = 'w';
					cube[1][i][j] = 'r';
					cube[2][i][j] = 'b';
					cube[3][i][j] = 'o';
					cube[4][i][j] = 'g';
					cube[5][i][j] = 'y';
				}
			}

			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				String order = st.nextToken();

				int k = 1;
				if (order.charAt(1) == '-') {
					k = 3;
				}

				char side = order.charAt(0);
				if (side == 'U') {
					U(cube);
					for (int i = 0; i < k; i++) {
						R(cube);
					}
					for (int i = 0; i < 3; i++) {
						U(cube);
					}
				} else if (side == 'D') {
					U(cube);
					for (int i = 0; i < k; i++) {
						L(cube);
					}
					for (int i = 0; i < 3; i++) {
						U(cube);
					}
				} else if (side == 'F') {
					F(cube);
					for (int i = 0; i < k; i++) {
						R(cube);
					}
					for (int i = 0; i < 3; i++) {
						F(cube);
					}
				} else if (side == 'B') {
					F(cube);
					for (int i = 0; i < k; i++) {
						L(cube);
					}
					for (int i = 0; i < 3; i++) {
						F(cube);
					}
				} else if (side == 'L') {
					for (int i = 0; i < k; i++) {
						L(cube);
					}
				} else if (side == 'R') {
					for (int i = 0; i < k; i++) {
						R(cube);
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}
		}
	}
}
