package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class RegisterShopperTest extends BaseClass{
	@Test
	public void createAccountTest() throws InterruptedException {
		welcome.clickLonginButton();
		login.clickCreateAccountButton();
		
		Map<String, String> map = excel.getData("Sheet1", "shopper Registration");
		int randomNum = jutil.generateRandomNum(100);
		String email = randomNum + map.get("Email Address");
		String pwd=map.get("password")+randomNum;
		signUp.createUserAccount(map.get("First Name"), map.get("Last Name"), map.get("Gender"),
				map.get("Phone Number"), email, email, pwd);
		
		Thread.sleep(10000);
		welcome.clickLonginButton();
		login.loginToApp(email, pwd);
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}
}
