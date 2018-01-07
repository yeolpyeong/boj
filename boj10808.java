/*
 * 알파벳 개수
 * https://www.acmicpc.net/problem/10808
 */

package boj;

import java.util.Scanner;

public class boj10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] alphabet = new int[26];
		for (int i = 0; i < S.length(); i++) {
			alphabet[(int) S.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}
