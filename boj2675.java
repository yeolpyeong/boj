/*
 * 문자열 반복
 * https://www.acmicpc.net/problem/2675
 */

package boj;

import java.util.Scanner;

public class boj2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			String answer = "";
			int R = sc.nextInt();
			String S = sc.next();
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					answer += S.charAt(i);
				}
			}
			System.out.println(answer);
		}
	}
}
