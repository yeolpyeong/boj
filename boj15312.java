/*
 * 이름 궁합
 * https://www.acmicpc.net/problem/15312
 */

package boj;

import java.util.Scanner;

public class boj15312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int[] numberOfStrokes = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		int[][] maritalCompatibility = new int[2 * A.length() - 1][2 * A.length()];
		for (int i = 0; i < A.length(); i++) {
			maritalCompatibility[0][2 * i] = numberOfStrokes[(int) A.charAt(i) - 'A'];
			maritalCompatibility[0][2 * i + 1] = numberOfStrokes[(int) B.charAt(i) - 'A'];
		}
		for (int i = 1; i < 2 * A.length() - 1; i++) {
			for (int j = i; j < 2 * A.length(); j++) {
				maritalCompatibility[i][j] = (maritalCompatibility[i - 1][j - 1] + maritalCompatibility[i - 1][j]) % 10;
			}
		}
		System.out.print("" + maritalCompatibility[2 * A.length() - 2][2 * A.length() - 2]
				+ maritalCompatibility[2 * A.length() - 2][2 * A.length() - 1]);
	}
}
