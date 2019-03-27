
/*
 * A+B - 9
 * https://www.acmicpc.net/problem/15740
 */

import java.math.BigInteger;
import java.util.Scanner;

class boj15740 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();

		System.out.print(A.add(B));
	}
}
