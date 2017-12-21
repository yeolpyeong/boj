/*
 * 다면체
 * https://www.acmicpc.net/problem/10569
 */

package boj;

import java.util.Scanner;

public class boj10569 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			System.out.println(2 - V + E);
		}
	}
}
