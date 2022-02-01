package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddtocartandBill {
	@Test(dataProvider = "dp_addToCartAndBill")
	public void addToCartAndBill(String Name, String qty) {
		System.out.println("excute"+Name+"att to cart & bill");
		
	}

	
	@DataProvider
	public Object[][] dp_addToCartAndBill() {
		
	}
}
