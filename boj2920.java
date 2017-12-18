/*
 * À½°è
 * https://www.acmicpc.net/problem/2920
 */

package boj;

import java.util.Scanner;

public class boj2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String scale = sc.nextLine();
		if (scale.equals("1 2 3 4 5 6 7 8")) {
			System.out.print("ascending");
		} else if (scale.equals("8 7 6 5 4 3 2 1")) {
			System.out.print("descending");
		} else {
			System.out.print("mixed");
		}
	}
}
