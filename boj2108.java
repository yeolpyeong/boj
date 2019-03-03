
/*
 * ≈Î∞Ë«–
 * https://www.acmicpc.net/problem/2108
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class boj2108 {
	static int mean(int[] numbers) {
		double sum = 0;
		for (int n : numbers) {
			sum += n;
		}

		return (int) Math.round(sum / numbers.length);
	}

	static int median(int[] numbers) {
		return numbers[numbers.length / 2];
	}

	static int mode(int[] numbers) {
		int[] count = new int[8001];
		for (int n : numbers) {
			count[n + 4000]++;
		}

		int mode;
		int max = 0;
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for (int i = 0; i <= 8000; i++) {
			if (count[i] == 0) {
				continue;
			}
			
			if (count[i] == max) {
				pq.add(i);
			}

			if (count[i] > max) {
				max = count[i];
				pq.clear();
				pq.add(i);
			}
		}

		if (pq.size() == 1) {
			mode = pq.poll();
		} else {
			pq.poll();
			mode = pq.poll();
		}
		
		return mode - 4000;
	}

	static int range(int[] numbers) {
		return numbers[numbers.length - 1] - numbers[0];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		Arrays.sort(numbers);
		System.out.println(mean(numbers));
		System.out.println(median(numbers));
		System.out.println(mode(numbers));
		System.out.println(range(numbers));
	}
}
