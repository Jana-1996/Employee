package functions1day1;

public class UseEligible {
	public static void main (String[]args) {
		Eligible age = new Eligible();
		System.out.println(age.check(25));
		System.out.println(age.check(17));
	}

}
