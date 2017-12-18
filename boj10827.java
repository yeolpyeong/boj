/*
 * a^b
 * https://www.acmicpc.net/problem/10827
 */

package boj;

import java.math.BigDecimal;
import java.util.Scanner;

public class boj10827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal a = sc.nextBigDecimal();
		int b = sc.nextInt();
		System.out.println(a.pow(b).toPlainString());
	}
}
