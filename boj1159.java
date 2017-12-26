/*
 * 농구 경기
 * https://www.acmicpc.net/problem/1159
 */

package boj;

import java.util.Scanner;

public class boj1159 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			alphabet[(int) name.charAt(0) - 'a']++;
		}
		String res = "";
		for (char c = 'a'; c <= 'z'; c++) {
			if (alphabet[c - 'a'] >= 5)
				res += c;
		}
		System.out.print(res.length() > 0 ? res : "PREDAJA");
	}
}
