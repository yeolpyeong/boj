/*
 * 헤라클레스와 히드라
 * https://www.acmicpc.net/problem/10205
 */

package boj;

import java.util.Scanner;

public class boj10205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for (int i = 1; i <= K; i++) {
			int h = sc.nextInt();
			String behavior = sc.next();
			for (int j = 0; j < behavior.length(); j++) {
				if (behavior.charAt(j) == 'c') {
					h = h > 0 ? h + 1 : h;
				} else if (behavior.charAt(j) == 'b') {
					h = h > 0 ? h - 1 : h;
				}
			}
			System.out.println("Data Set " + i + ":");
			System.out.println(h);
			System.out.println();
		}
	}
}
