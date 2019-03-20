
/*
 * 톱니바퀴
 * https://www.acmicpc.net/problem/14891 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj14891 {
	static void rotate(int[][] cogWheels, int N, int D) {
		int temp;
		if (D == 1) {
			temp = cogWheels[N][8];
			cogWheels[N][8] = cogWheels[N][7];
			cogWheels[N][7] = cogWheels[N][6];
			cogWheels[N][6] = cogWheels[N][5];
			cogWheels[N][5] = cogWheels[N][4];
			cogWheels[N][4] = cogWheels[N][3];
			cogWheels[N][3] = cogWheels[N][2];
			cogWheels[N][2] = cogWheels[N][1];
			cogWheels[N][1] = temp;
		} else if (D == -1) {
			temp = cogWheels[N][1];
			cogWheels[N][1] = cogWheels[N][2];
			cogWheels[N][2] = cogWheels[N][3];
			cogWheels[N][3] = cogWheels[N][4];
			cogWheels[N][4] = cogWheels[N][5];
			cogWheels[N][5] = cogWheels[N][6];
			cogWheels[N][6] = cogWheels[N][7];
			cogWheels[N][7] = cogWheels[N][8];
			cogWheels[N][8] = temp;
		}
	}

	static void solve(int[][] cogWheels, int N, int D, boolean[] rotable, boolean[] rotated) {
		rotate(cogWheels, N, D);
		switch (N) {
		case 1:
			if (rotable[1] && !rotated[1]) {
				rotated[1] = true;
				solve(cogWheels, 2, -D, rotable, rotated);
			}
			break;
		case 4:
			if (rotable[3] && !rotated[3]) {
				rotated[3] = true;
				solve(cogWheels, 3, -D, rotable, rotated);
			}
			break;
		default:
			if (rotable[N - 1] && !rotated[N - 1]) {
				rotated[N - 1] = true;
				solve(cogWheels, N - 1, -D, rotable, rotated);
			}
			if (rotable[N] && !rotated[N]) {
				rotated[N] = true;
				solve(cogWheels, N + 1, -D, rotable, rotated);
			}
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] cogWheels = new int[5][9];
		for (int i = 1; i <= 4; i++) {
			String line = br.readLine();
			for (int j = 1; j <= 8; j++) {
				cogWheels[i][j] = line.charAt(j - 1) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			boolean[] rotable = new boolean[4];
			for (int k = 1; k < 4; k++) {
				if (cogWheels[k][3] != cogWheels[k + 1][7]) {
					rotable[k] = true;
				}
			}
			boolean[] rotated = new boolean[4];
			solve(cogWheels, N, D, rotable, rotated);
		}

		int score = 0;
		for (int i = 1; i <= 4; i++) {
			score += Math.pow(2, i - 1) * cogWheels[i][1];
		}

		System.out.print(score);
	}
}
