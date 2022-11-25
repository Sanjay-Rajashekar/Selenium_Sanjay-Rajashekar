package day3;

import org.testng.annotations.Test;

public class MyFirstTestNG {

	@Test(priority = 1)
	public void login() {
		System.out.println("Login done");
	}
	
	@Test(priority =2)
	public void createAccount() {
		System.out.println("Account Created");
	}
	
	@Test(priority = 3)
	public void deleteAccount(){
		System.out.println("Account Deleted");
	}
	
	@Test(priority = 4)
	public void logout() {
		System.out.println("Logged out");
	}
}
