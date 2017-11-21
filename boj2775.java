/*
 * 부녀회장이 될테야
 * https://www.acmicpc.net/problem/2775
 */

package boj;

import java.util.Scanner;

public class boj2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] apartment = new int[k + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				apartment[0][i] = i;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];
				}
			}
			System.out.println(apartment[k][n]);
		}
	}
}
