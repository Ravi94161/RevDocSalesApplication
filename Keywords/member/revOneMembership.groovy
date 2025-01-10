package member

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

public class revOneMembership {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnRevoneMembershipBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/membershipBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/addToCartBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnCompareToRev1Btn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/compareToRev1Btn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/addBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyTitleText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevOneMembership/membershipComparisonTitle_android'), text, onFailure)
	}

	@Keyword
	def tapOnMonthlyRevPlusMembershipBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/monthlyBtn_android'), defaultTime);
	}
}
