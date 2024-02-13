package functions1day1;

public class UseBooks {
	public static void main (String[]args) {
		Books bk1 = new Books();
		bk1.brand = "Panuval";
		bk1.price = 450;
		bk1.disAmount = 50;
		System.out.println(bk1.netPrice());
}

}
