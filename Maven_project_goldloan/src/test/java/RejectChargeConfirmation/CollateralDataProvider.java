package RejectChargeConfirmation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CollateralDataProvider {

	@DataProvider(name="Collateral")
	public Object[] dataSet1() {
		return new Object[][] {
	
			{"014526000168"}
		};
		};
		@DataProvider(name="Packet ID")
		public Object[] dataSet2() {
			return new Object[][] {
		
				{"MAG0100000050138"}
				
				
			};
		
		
	}
}
