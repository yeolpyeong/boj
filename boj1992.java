
/*
 * 쿼드트리
 * https://www.acmicpc.net/problem/1992
 */

import java.util.Scanner;

public class boj1992 {
	static String res = "";
	static int[][] video;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		video = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String temp = sc.next();
			for (int j = 1; j <= N; j++) {
				video[i][j] = temp.charAt(j - 1) - '0';
			}
		}

		solution(1, 1, N);
		System.out.print(res);
	}

	public static void solution(int row, int col, int size) {
		boolean flag = true;
		int visited = video[row][col];
		loop: for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (visited != video[i][j]) {
					flag = false;
					break loop;
				}
			}
		}

		if (flag) {
			res += visited;
		} else {
			res += '(';
			for (int i = row; i < row + size; i += size / 2) {
				for (int j = col; j < col + size; j += size / 2) {
					solution(i, j, size / 2);
				}
			}
			res += ')';
		}
	}
}
