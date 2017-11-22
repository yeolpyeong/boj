/*
 * 팬그램
 * https://www.acmicpc.net/problem/5704
 */

package boj;

import java.util.Scanner;

public class boj5704 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			if (line.equals("*"))
				return;

			int[] alphabet = new int[26];
			for (int i = 0; i < line.length(); i++) {
				if (!(line.charAt(i) == ' '))
					alphabet[line.charAt(i) - 'a']++;
			}
			
			boolean pangram = true;
			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i] == 0) {
					pangram = false;
					break;
				}
			}
			
			System.out.println(pangram == true?'Y':'N');
		}
	}
}
