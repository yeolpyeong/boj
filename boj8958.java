/*
 * OXÄûÁî
 * https://www.acmicpc.net/problem/8958
 */

package boj;

import java.util.Scanner;

public class boj8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			String C = sc.next();
			int score = 0;
			int sum = 0;
			for (int i = 0; i < C.length(); i++) {
				if (C.charAt(i) == 'O') {
					score++;
					sum += score;
				} else {
					score = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
