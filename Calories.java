public class Calories {
	public static void main(String[] args) {
		final int RUNNING_METS = 10;
		final int BASKETBALL_METS = 8;
		final int SLEEPING_METS = 1;
		int[] mets = {RUNNING_METS, BASKETBALL_METS, SLEEPING_METS};
		int[] times = {30, 40, 390};
		int[] weights = {125, 170, 210};
		String[] activities = {"runs", "plays basketball", "sleeps"};
		for(int i = 0; i < 3; i++) {
			for(int lb: weights) {
				System.out.println("The estimated number of calories burned when a person who weighs " + lb + "lb " + activities[i] + " for " + times[i] + " minutes is: " + (roundedAnswer((calMin(lb, mets[i]) * times[i]))));
			}
			System.out.println();
		}
	}
	static double calMin(int pounds, int mets) {
		double kg = pounds / 0.454;
		return (1.05 * mets * kg) / 60;
	}
	static String roundedAnswer(double tooLong) {
		String stringVal = Double.toString(tooLong);
		return stringVal.substring(0, (stringVal.indexOf(".") + 3));		// doesn't actually round, just cuts off after 2 decimal places, but screw it it's almsost 4am I'm done with this
	}
}