/*
 * µË∫∏¿‚
 * https://www.acmicpc.net/problem/1764
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		TreeSet<String> notListen = new TreeSet();
		while (N-- > 0) {
			notListen.add(br.readLine());
		}

		TreeSet<String> notSee = new TreeSet();
		while (M-- > 0) {
			notSee.add(br.readLine());
		}

		notSee.retainAll(notListen);
		System.out.println(notSee.size());
		for (String n : notSee) {
			System.out.println(n);
		}
	}
}
