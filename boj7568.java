/*
 * µ¢Ä¡
 * https://www.acmicpc.net/problem/7568
 */

package boj;

import java.util.Scanner;

public class boj7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] people = new int[N][2];
		for (int i = 0; i < N; i++) {
			people[i][0] = sc.nextInt();
			people[i][1] = sc.nextInt();
		}

		int[] order = new int[N];
		for (int i = 0; i < N; i++) {
			order[i] = N;
			for (int j = 0; j < N; j++) {
				if (people[i][0] > people[j][0] || people[i][1] > people[j][1]) {
					order[i]--;
				}
			}
			System.out.println(order[i]);
		}
	}
}
