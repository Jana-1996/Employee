package functions1day1;

public class UsePens {
	public static void main (String[]args) {
		Pens p1 = new Pens();
		p1.brand = "Reynolds";
		p1.price = 200;
		p1.taxPer = 5;
		p1.disPer=7;
		System.out.println("Price: "+p1.price);
		System.out.println(p1.taxAmount());
		System.out.println(p1.disAmount());
		p1.findNet();
		
	
	}

}
