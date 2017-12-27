/*
 * 유니크
 * https://www.acmicpc.net/problem/5533
 */

package boj;

import java.util.Scanner;

public class boj5533 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] score = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][j] = sc.nextInt();
			}
		}

		int[] sum = new int[N];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				boolean flag = true;
				for (int k = 0; k < N; k++) {
					if (j != k && score[j][i] == score[k][i])
						flag = false;
				}
				if (flag == true)
					sum[j] += score[j][i];
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(sum[i]);
		}
	}
}
