import java.util.Scanner;
pubic class Fibonacci {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("How many numbers of the Fibonacci sequence do you want to see? ");
		int[] sequence = new int[s.nextInt()];
		for(int i = 0; i < sequence.length; i++) {
			if(i < 2) {
				sequence[i] = 1;
			}
			else {
				sequence[i] = sequence[i - 1] + sequence[i - 2];
			}
			if(i > 0) {
				System.out.print(", ");
			}
			System.out.print(sequence[i]);
		}
	}
}
