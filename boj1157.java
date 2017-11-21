/*
 * 단어 공부
 * https://www.acmicpc.net/problem/1157
 */

package boj;

import java.util.Scanner;

public class boj1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s = s.toUpperCase();
		
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i)-'A']++;
		}
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > max) {
				max = alphabet[i];
				index = i;
			} else if (alphabet[i] == max) {
				index = -2;
			}
		}
		System.out.print((char)(index + 'A'));
	}
}
