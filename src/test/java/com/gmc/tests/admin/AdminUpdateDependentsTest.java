package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;

import com.gmc.pageobjects.admin.AdminUpdateDependentsPage;

public class AdminUpdateDependentsTest extends TestBase
{
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminUpdateDependentsPage updatePage;
		
    @BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl() + "admin";
			driver.get(URL);
			loginPage = new AdminLoginPage(driver);
			loginPage.enterLoginName("citibr");
			loginPage.enterPassword("qaz456");
			homePage = loginPage.NavigateToHomePage();
		}
    
	@Test
		public void searchEmp() throws InterruptedException {
			updatePage = homePage.clickToUpdateDependents();
			ExtentTestManager.getTest().log(Status.INFO, "Clicked on Update Dependents after successful login");
			updatePage.enterEmployeeID("9005");
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID to edit dependents after successful Login ");
			updatePage.clickSearchbtn();
			updatePage.clickViewbtn();
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful Login ");
			updatePage.clickEditdependent();
			updatePage.changeName("prerna");
			updatePage.changeDay("21");
			updatePage.changeMon("Dec");
			updatePage.changeYear("1996");
			updatePage.changeRelationship("WIFE");
			updatePage.EnterCorrectionRemarks("Changed to daughter");
			updatePage.clickOnSubmit();
			ExtentTestManager.getTest().log(Status.INFO, "After editing dependents, entered correction remarks and submitted ");
			}
		
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
				}
		}
}
