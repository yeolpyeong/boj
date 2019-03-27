
/*
 * Å« ¼ö A+B
 * https://www.acmicpc.net/problem/10757
 */

import java.math.BigInteger;
import java.util.Scanner;

class boj10757 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();

		System.out.print(A.add(B));
	}
}
