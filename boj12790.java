/*
 * Mini Fantasy War
 * https://www.acmicpc.net/problem/12790
 */

package boj;

import java.util.Scanner;

public class boj12790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int HP = sc.nextInt();
			int MP = sc.nextInt();
			int SP = sc.nextInt();
			int DP = sc.nextInt();
			HP += sc.nextInt();
			MP += sc.nextInt();
			SP += sc.nextInt();
			DP += sc.nextInt();
			System.out.println(1 * Math.max(HP, 1) + 5 * Math.max(MP, 1) + 2 * Math.max(SP, 0) + 2 * DP);
		}
	}
}
