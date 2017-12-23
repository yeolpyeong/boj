/*
 * 세로읽기
 * https://www.acmicpc.net/problem/10798
 */

package boj;

import java.util.Scanner;

public class boj10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] letters = new String[5];
		int max = 0;
		for (int i = 0; i < 5; i++) {
			letters[i] = sc.next();
			max = Math.max(max, letters[i].length());
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < letters[j].length())
					System.out.print(letters[j].charAt(i));
			}
		}
	}
}
