/*
 * 이번학기 평점은 몇점?
 * https://www.acmicpc.net/problem/2755
 */

package boj;

import java.util.Scanner;

public class boj2755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int totalCredit = 0;
		double grade = 0;
		while (N-- > 0) {
			sc.next();
			int credit = sc.nextInt();
			totalCredit += credit;
			grade += credit * calculateCredit(sc.next());
		}
		System.out.print(String.format("%.2f", grade / totalCredit));
	}

	public static double calculateCredit(String G) {
		double grade = 0;

		if (G.charAt(0) == 'A') {
			grade = 4;
		} else if (G.charAt(0) == 'B') {
			grade = 3;
		} else if (G.charAt(0) == 'C') {
			grade = 2;
		} else if (G.charAt(0) == 'D') {
			grade = 1;
		} else if (G.charAt(0) == 'F') {
			return grade;
		}

		if (G.charAt(1) == '+') {
			grade += 0.3;
		} else if (G.charAt(1) == '-') {
			grade -= 0.3;
		}
		return grade;
	}
}
