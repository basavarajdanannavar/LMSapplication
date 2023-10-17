package SingleCollateralCompletionTestCases;

import org.testng.annotations.Test;

public class Custom extends CollateralDataProvider  {

	
	
	@Test(dataProvider ="Collateral")
	public void l3(String collateral){
		System.out.println(collateral);
		
	}
}
