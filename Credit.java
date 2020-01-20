import java.util.Scanner;
public class Credit {
	boolean validate(long n) {
		int sum = 0;
		for(int parity = 0; n != 0; parity++) {
			int last = (int)(n % 10);
			// Every other digit, starting with the last
			if(parity % 2 == 0) {
				sum += last;
			}
			// Every other digit, starting with the second-to-last
			else {
				last *= 2;
				// Handles cases where multiplying the last digit by 2 becomes double-digits
				if(last > 9) {
					int second = last % 10;
					int first = last / 10;
					sum += first + second;
				}
				else {
					sum += last;
				}
			}
			// Truncates the last digit, to work on a new one in the next iteration
			n /= 10;
		}
		if(sum % 10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String args[]) {
		Credit card = new Credit();
		Scanner s = new Scanner(System.in);
		long cardNo = 0;
		try {
			// Prompt the user for a credit card no.
			System.out.print("Enter a credit card number: ");
			cardNo = s.nextLong();
		}
		catch(java.util.InputMismatchException e) {}
		// Checks if card no. is valid
		if(card.validate(cardNo) == false) {
			System.out.println("INVALID");
		}
		else {
			// Find length of card no.
			int len = (int)(Math.log10(cardNo)+1);
			// Determine type of card
			switch(len) {
				/* American Express cards have 15 digits and the first 2 digits are either 34 or 37
				 * MasterCard cards have 16 digits and the first 2 digits are between 51 and 55 (those included)
				 * Visa cards have either 13 or 16 digits and always start with a 4
				 *
				 * (MasterCard cards can also use some other starting numbers, but I've not included those.)
				 */
				case 13:
					cardNo /= 1000000000000L;					// 12 zeros; gets the first digit
					if(cardNo == 4) {
						System.out.println("VISA");
					}
					else {
						System.out.println("INVALID");
					}
					break;
				case 15:
					cardNo /= 10000000000000L;					// 13 zeros; gets the first 2 digits
					if (cardNo == 34 || cardNo == 37) {
						System.out.println("AMEX");
					}
					else {
						System.out.println("INVALID");
					}
					break;
				case 16:
					cardNo /= 100000000000000L;					// 14 zeros; gets the first 2 digits
					if(50 < cardNo && cardNo < 56) {
						System.out.println("MASTERCARD");
					}
					else if(39 < cardNo && cardNo < 50) {
						System.out.println("VISA");
					}
					else {
						System.out.println("INVALID");
					}
					break;
				default:
					System.out.println("INVALID");
			}
		}
	}
}
