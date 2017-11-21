/*
 * 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316 
 */

package boj;

import java.util.Scanner;

public class boj1316 {
	static int preChar;
	static int[] alphabet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		String[] S = new String[101];
		for (int i = 1; i <= N; i++) {
			preChar = 4444;
			alphabet = new int[26];
			S[i] = sc.next();
			answer += boj1316(S[i]);
		}
		System.out.print(answer);
	}

	public static int boj1316(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'a' == preChar)
				continue;
			preChar = s.charAt(i) - 'a';
			if (alphabet[preChar] == 0) {
				alphabet[preChar]++;
			} else {
				return 0;
			}
		}
		return 1;
	}
}