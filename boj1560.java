
/*
 * 비숍
 * https://www.acmicpc.net/problem/1560
 */

import java.math.BigInteger;
import java.util.Scanner;

class boj1560 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();

		System.out.print(
				N.compareTo(BigInteger.ONE) == 0 ? 1 : N.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(2)));
	}
}
