package day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MySecondTestNG {
	
	@Test()
	public void login() {
		Assert.assertEquals(12, 13);
		System.out.println("Login done");
	}
	
	
	@Test(dependsOnMethods="login")
	public void logout() {
		Assert.assertEquals(12, 123);
		System.out.println("Logged out");
	}
}
