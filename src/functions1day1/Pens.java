package functions1day1;

public class Pens {
	String brand;
	int price;
	int taxPer;
	int disPer;
	
	public String taxAmount() {
		return "Tax Price "+price*taxPer/100;
	}
	public String disAmount() {
		return "Dis Price "+ price*disPer/100;
	}
	public void findNet() {
		//System.out.println("Net Price "+(price+(price*taxPer/100)-(price*disPer/100)));
	
	      //System.out.println("Taxable net Price= "+(price+(price*taxPer/100)));
	      //System.out.println("Dis net Price= "+(price-(price*disPer/100)));
System.out.println("Net Price "+(price+(price*taxPer/100)-(price*disPer/100)));
	}

}
