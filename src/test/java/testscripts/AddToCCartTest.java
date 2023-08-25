package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCCartTest extends BaseClass {
	@Test
	public void addToCartTest() throws InterruptedException {
		Map<String, String> map = excel.getData("Sheet1", "Add to cart");
		welcome.clickLonginButton();
		login.loginToApp(map.get("Email"), map.get("password"));
		Thread.sleep(2000);
		home.mouseHoverToElectronics(webUtil);
		Thread.sleep(2000);
		home.clickHeadPhonesLink();
		headPhone.ClickAddToCart();
		Thread.sleep(2000);
		Assert.assertEquals(headPhone.getAddToCartText(), "ADDED");
		String itemName = headPhone.getItemName();
		headPhone.ClickAddToCart();
		Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
	}
	
}
