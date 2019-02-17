/*
 * 최대공약수
 * https://www.acmicpc.net/problem/1850
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1850 {
	public static long gcd(long a, long b) {
		return b != 0 ? gcd(b, a % b) : a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long gcd = gcd(A, B);
		while (gcd-- > 0) {
			bw.append('1');
		}
		bw.flush();
	}
}
