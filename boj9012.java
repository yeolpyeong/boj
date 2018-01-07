/*
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */

package boj;

import java.util.Scanner;

public class boj9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			String PS = sc.next();
			while (PS.contains("()")) {
				PS = PS.replace("()", "");
			}
			System.out.println(PS.isEmpty() ? "YES" : "NO");
		}
	}
}
