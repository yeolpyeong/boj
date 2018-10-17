/*
 * 종이의 개수
 * https://www.acmicpc.net/problem/1780
 */

package boj;

import java.util.Scanner;

public class boj1780 {
	static int[] count = new int[3];
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		solution(1, 1, N);
		System.out.print(count[0] + "\n" + count[1] + "\n" + count[2]);
	}

	public static void solution(int row, int col, int size) {
		if (size == 1) {
			count[++paper[row][col]]++;
			return;
		}

		int visited = paper[row][col];
		boolean flag = true;
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (visited != paper[i][j]) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			count[++visited]++;
			return;
		}

		for (int i = row; i < row + size; i += size / 3) {
			for (int j = col; j < col + size; j += size / 3) {
				solution(i, j, size / 3);
			}
		}
	}
}
