/*
 * 상금 헌터
 * https://www.acmicpc.net/problem/15953
 */

package boj;

import java.util.Scanner;

public class boj15953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int prize = 0;
			for (int i = 0; i <= 5; i++) {
				if (a > i * (i + 1) / 2 && a <= (i + 1) * (i + 2) / 2) {
					prize += i < 3 ? (50 * Math.pow(i, 2) - 250 * i + 500) * 10000 : (50 - (i - 3) * 20) * 10000;
				}
			}
			for (int i = 0; i <= 4; i++) {
				if (b >= Math.pow(2, i) && b < Math.pow(2, i + 1))
					prize += Math.pow(2, 9 - i) * 10000;
			}
			System.out.println(prize);
		}
	}
}
