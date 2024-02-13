package functions1day1;

public class UseMobile1 {
	public static void main(String[] args) {
		Mobile1 mbl1 = new Mobile1();
		mbl1.brand = "Vivo";
		mbl1.price = 25000;
		mbl1.colour = "Green";

		Mobile1 mbl2 = new Mobile1();
		mbl2.brand = "Mi";
		mbl2.price = 23000;
		mbl2.colour = "Black";

		Mobile1 mbl3 = new Mobile1();
		mbl3.brand = "iPhone";
		mbl3.price = 45000;
		mbl3.colour = "While";

		Mobile1[] mbls = { mbl1, mbl2, mbl3 };
		Mobile1 mm = mbl1.findMaxPrice(mbls);

		System.out.println(mm.brand + " " + mm.colour + " " + mm.price);
		mbl1.aboveFifteen(mbls);
	}
}
