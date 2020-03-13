public class Fizzbuzz {
	public enum Word {
		FIZZ(3, "Fizz"),
		BUZZ(5, "Buzz");
		
		private int value;
		private String name;
		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
			
		Word(int value, String name) {
			this.value = value;
			this.name = name;
		}
	}
		
	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			String output = "";
			for(Word word : Word.values()) {
				if(i % word.getValue() == 0) output += word.getName();
			}
			if(output.length() == 0) output += i;
			System.out.println(output);
		}
	}
}
