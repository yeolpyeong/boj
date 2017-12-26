/*
 * ³ó±¸ °æ±â
 * https://www.acmicpc.net/problem/1159
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj1159 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] list = new String[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.next();
		}
		Arrays.sort(list);
		int[] alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			alphabet[(int) list[i].charAt(0) - 'a']++;
		}
		String letter = "abcdefghijklmnopqrstuvwxyz";
		String res = "";
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] >= 5)
				res += letter.charAt(i);
		}
		System.out.print(res.length() > 0 ? res : "PREDAJA");
	}
}
