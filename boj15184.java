/*
 * Letter Count
 * https://www.acmicpc.net/problem/15184 
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15184 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		text = text.toUpperCase();

		int[] alphabet = new int[26];
		for (int i = 0; i < text.length(); i++) {
			int letter = text.charAt(i) - 'A';
			if (letter >= 0 && letter <= 25)
				++alphabet[letter];
		}

		for (int i = 0; i < alphabet.length; i++) {
			System.out.print((char) (65 + i) + " | ");
			for (int j = 0; j < alphabet[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
