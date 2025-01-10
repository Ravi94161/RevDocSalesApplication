package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.FindElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.beans.ListenerList
import groovy.json.internal.ValueList
import internal.GlobalVariable

public class Profile {

	@Keyword
	def clickOnGoals() {
		TestObject goals = findTestObject('Object Repository/Profile/button_Goals');
		WebUI.click(goals);
	}

	@Keyword
	def clickOnPayment() {
		TestObject payment = findTestObject('Object Repository/Profile/button_Payment');
		WebUI.click(payment);
	}

	@Keyword
	def clickOnStatus() {
		TestObject status = findTestObject('Object Repository/Profile/button_Status');
		WebUI.click(status);
	}

	@Keyword
	def clickOnMySales() {
		TestObject mySales = findTestObject('Object Repository/Profile/button_My Sales');
		WebUI.click(mySales);
	}

	@Keyword
	def verifyRecordAddedToMonthlySales() {

		WebDriver driver = DriverFactory.getWebDriver()
		List<String> valueList = new ArrayList<>()
		// Locate elements by XPath
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item-pop-first MuiBox-root css-c3vlm2'][1]//div//h6"))
		for (WebElement element : elements) {
			valueList.add(element.getText())
		}
		TestObject nameOBJ = findTestObject('Object Repository/Profile/InvitedPersonName')
		String name = WebUI.getText(nameOBJ);
		TestObject earnedDollars = findTestObject('Object Repository/Profile/EarnDollars')
		String dollars = WebUI.getText(earnedDollars)
		if(name.equals(elements.get(2)) && dollars.equals(elements.get(4))) {
			println("Record added to payments tab.....")
		}else {
			throw new Exception("Record is not added.....")
		}
	}
}
