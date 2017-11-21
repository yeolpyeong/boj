/*
 * 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 */

package boj;

import java.util.Scanner;

public class boj10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] listOfAlphabet = alphabet.split("");
		for (String s : listOfAlphabet) {
			System.out.print(S.indexOf(s) + " ");
		}
	}
}
