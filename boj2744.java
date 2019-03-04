
/*
 * 대소문자 바꾸기
 * https://www.acmicpc.net/problem/2744
 */

import java.util.Scanner;

class boj2744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String res = "";
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if (temp > 'Z') {
				res += String.valueOf(temp).toUpperCase();
			} else {
				res += String.valueOf(temp).toLowerCase();
			}
		}

		System.out.print(res);
	}
}
