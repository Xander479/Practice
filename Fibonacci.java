pubic class Fibonacci {
	public static void main(String args[]) {
		int[] sequence = new int[10];
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
