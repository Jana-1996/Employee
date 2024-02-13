package functions1day1;

public class Mobile1 {
    String brand;
    int price;
    String colour;
    
    public Mobile1 findMaxPrice(Mobile1[] mb) {
    	Mobile1 max = mb[0];
    	for(int i=0; i<mb.length; i++) {
    		if(mb[i].price>max.price) {
    			max = mb[i];
    		}
    	}
    	return max;
    }
    public void aboveFifteen(Mobile1[] j) {
    	
    	for(int i=0; i<j.length; i++) {
    		if(j[i].price>15000) {
    			System.out.println(j[i].brand+" "+j[i].price+" "+j[i].colour);
    		}
    	}
    }

}
