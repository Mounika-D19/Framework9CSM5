package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddAddressTest extends BaseClass{
	@Test
	public void addAddressTest() throws InterruptedException {
		Map<String, String>map=excel.getData("sheet1", "Add Address");
		welcome.clickLonginButton();
		login.loginToApp(map.get("Email"), map.get("password"));
		Thread.sleep(2000);
		home.clickProfileButton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(2000);
		myProfile.ClickMyAddresses();
		myAddress.ClickAddress();
		address.addAddressDetails(webUtil, map);
		Thread.sleep(2000);
		Assert.assertEquals(myAddress.getClass(), "successful added");
		Thread.sleep(20002);
	}

	
}
