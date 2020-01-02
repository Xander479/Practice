import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AgeChecker {
	public static void main(String[] args) {
		String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
		// Compiler complains if these aren't initialised
		int year = LocalDate.now().getYear();
		int month = LocalDate.now().getMonthValue();
		int day = LocalDate.now().getDayOfMonth();
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("In what year were you born? ");
			year = s.nextInt();
			System.out.print("In what month were you born? ");
			// Allows the user to input either the word or number for the month
			if(s.hasNextInt() == true) month = s.nextInt();
			else {
				int test = Arrays.asList(months).indexOf(s.next().toLowerCase());
				if(test == -1) throw new InputMismatchException();
				else month = test + 1;
			}
			System.out.print("On what day of the month were you born? ");
			day = s.nextInt();
		}
		// Don't try any funny business
		catch(InputMismatchException e) {
			System.out.println("Please give a sensible answer.");
			System.exit(0);
		}
		// Stores your birthday and takes the date off the current date to find your age
		LocalDate birthday = LocalDate.of(year, month, day);
		LocalDate age = LocalDate.now().minusYears(year).minusMonths(month).minusDays(day);
		try {
			// Won't let you say you were born before the Common Era or in the future
			ValidateDate(birthday);
		}
		catch(DateTimeException e) {
			System.out.print(e.getMessage());
			System.out.println(" Please give a sensible answer.");
			System.exit(0);
		}
		year = age.getYear();
		month = age.getMonthValue();
		day = age.getDayOfMonth();
		System.out.println("You are " + year + " years, " + month + " months and " + day + " days old. You were born on a " + birthday.getDayOfWeek() + ".");
	}
	
	// I didn't want to clutter main more than it already was so I made this bit separate
	static void ValidateDate(LocalDate date) throws DateTimeException {
		if(date.isAfter(LocalDate.now())) throw new DateTimeException("You weren't born in the future.");
		if(date.isBefore(LocalDate.of(0001, 01, 01))) throw new DateTimeException("You weren't born BCE.");
	}
}
