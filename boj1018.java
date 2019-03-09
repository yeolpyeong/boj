
/*
 * 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj1018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[] board = new String[M];
		for (int i = 0; i < M; i++) {
			board[i] = br.readLine();
		}

		final String[][] chessboard = {
				{ "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB" },
				{ "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW" } };

		int min = 64;
		for (int i = 0; i <= M - 8; i++) {
			for (int j = 0; j <= N - 8; j++) {
				for (int k = 0; k < 2; k++) {
					int count = 0;
					for (int x = 0; x < 8; x++) {
						for (int y = 0; y < 8; y++) {
							if (board[x + i].charAt(y + j) != chessboard[k][x].charAt(y)) {
								count++;
							}
						}
					}

					if (count < min) {
						min = count;
					}
				}
			}
		}

		System.out.print(min);
	}
}
