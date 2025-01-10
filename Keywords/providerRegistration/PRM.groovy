package providerRegistration

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver
import com.kms.katalon.core.util.KeywordUtil
import com.google.common.collect.ImmutableMap
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;
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


public class PRM {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();

	@Keyword
	def tapOnSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectStateDropdown_android'), defaultTime)
		Mobile.delay(8);
	}

	@Keyword
	def tapOnSelectFlorida() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectFlorida_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectGeorgia() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectGeorgia_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectTexas() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectTexas_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectAlaska() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectAlaska_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectCountyDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectCountyDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectLucieCounty() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectLucieCounty_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectHenryCounty() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectHenryCounty_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectAleutiansCounty() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectAleutiansEastCounty_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectJeffersonCounty() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/selectJeffersonCounty_android'), defaultTime)
	}
	
	@Keyword
	def typeInPrmCodeInputBx(prm) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/PRM/prmCodeInputBx_android'), prm, defaultTime)
	}
	
	@Keyword
	def clearPrmCodeInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/PRM/prmCodeInputBx_android'), defaultTime)
	}

	@Keyword
	def tapOnAssignMePRMBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/assignMePRMBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/doneBtn_android'), defaultTime)
	}

	@Keyword
	def tapOniAgreeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/iAgreeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnOrderBackgroundCheckBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/orderBackgroundCheckBtn_android'), defaultTime)
		//Mobile.delay(60);

	}

	@Keyword
	def verifyPRMCode() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/PRM/alaskaPRMCode_android'), "AFCXAC8")
	}

	@Keyword
	def fillPRMDetails() {
		def text = "Texas";
		tapOnSelectStateDropdown();
		tapOnSelectAlaska();
		Mobile.delay(4)
		tapOnSelectCountyDropdown();
		tapOnSelectAleutiansCounty();
		//verifyPRMCode();
		//Type PRM number if we have
		//typeInPrmCodeInputBx("AFCXAC8");
	}

	@Keyword
	def assigningPRMByPRMBtn() {
		//Click on Assign me a PRM if we didn't have prm number
		tapOnAssignMePRMBtn();
		Mobile.delay(5)
		tapOnDoneBtn();
		//		tapOniAgreeBtn()
		//		tapOnOrderBackgroundCheckBtn();
		//tapOnOrderBackgroundCheckBtn();

	}
	
	@Keyword
	def tapAssignMePRMAndVerify() {
		
		tapOnAssignMePRMBtn();
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/PRM/greenCheckMark'), defaultTime)
		def code = Mobile.getAttribute(findTestObject('Object Repository/Provider/Registration/PRM/prmCodeInputBx_android'), 'text', defaultTime)
		
		if(code.length() == 0) {
			KeywordUtil.markFailed("PRM code is not shown after clicking the Assign Me PRM button.")
		}
	}

	@Keyword
	def verifyPrmScreenExist() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/prmScreenVerify_android'), defaultTime)
	}
	
	@Keyword
	def verifyTextPresent(text) {
		//text= ["This is required for the background check", "Step 1 of 9 - Demographics", "Social security number must be 9 digits in length", "Required"]
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/verifyAnyTextInPage',["text":text]), defaultTime)
	}
	
	@Keyword
	def verifyPRMRequiredMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/PRM/prmRequiredMsg_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnubmitForBAckGroundCheckBtnExist() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/RegistrationSummary/submitForBackgroundCheckBtn_android'), defaultTime)
	}
}
