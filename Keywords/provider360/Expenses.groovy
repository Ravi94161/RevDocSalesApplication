package provider360

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Expenses {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapRevenueAndExpensesTab() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/revenueAndExpensesTab_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/revenueAndExpensesTab_android'), defaultTime);
	}

	@Keyword
	def tapExpensesTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/expensesTab_android'), defaultTime);
	}

	@Keyword
	def tapByText(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/elelmentText_android', ['text': text]), defaultTime);
	}

	@Keyword
	def getExpensesBesideYear(year) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/priceBesideYear_android', ['year': year]), defaultTime);
	}

	@Keyword
	def getTotalOrders() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/total_orders_android'), defaultTime);
	}

	@Keyword
	def getTotalMonthExpenses() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/totalMonthExpenses_android'), defaultTime)
	}

	@Keyword
	def getTotalYearExpenses() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/yearExpenses_android'), defaultTime)
	}

	@Keyword
	def tapOnShareExpensesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/shareExpensesbtn_andriod'), defaultTime)
	}

	@Keyword
	def verifySharingPopup(onFailure = FailureHandling.CONTINUE_ON_FAILURE ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/verifySharingPopup_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBackButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/RevenueAndExpenses/Expenses/backBtn_andriod'), defaultTime)
	}
}
