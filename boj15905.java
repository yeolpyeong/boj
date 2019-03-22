
/*
 * 스텔라(STELLA)가 치킨을 선물했어요
 * https://www.acmicpc.net/problem/15905
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj15905 {
	static final int FIVE = 5;

	static class Score implements Comparable<Score> {
		int s, p;

		public Score(int s, int p) {
			this.s = s;
			this.p = p;
		}

		@Override
		public int compareTo(Score o) {
			return this.s != o.s ? o.s - this.s : this.p - o.p;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Score[] scoreboard = new Score[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			scoreboard[i] = new Score(s, p);
		}

		Arrays.sort(scoreboard);

		int count = 0;
		Score fifth = scoreboard[FIVE - 1];
		for (int i = FIVE; i < N; i++) {
			if (scoreboard[i].s == fifth.s && scoreboard[i].p > fifth.p) {
				count++;
			}
		}

		System.out.print(count);
	}
}
