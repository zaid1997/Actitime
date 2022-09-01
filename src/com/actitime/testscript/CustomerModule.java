package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Create customer");
		FileLib f=new FileLib();
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		String custDespt = f.getExcelData("CreateCustomer", 1, 3);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getCustNameTbx().sendKeys(custName);
		t.getCustDespTbx().sendKeys(custDespt);
		t.getSelectCustDropDown().click();
		t.getOurCompanyOption().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(4000);
		String actualCustomer =t.getCustName().getText();
	Assert.assertEquals(actualCustomer, custName);
	}
	
}
