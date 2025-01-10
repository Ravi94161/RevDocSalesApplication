package providerRegistration

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

public class Signature {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();
	ContactInformation contactInfo = new ContactInformation();
	Empower empower =  new Empower();

	@Keyword
	def verifyErrorMsgExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Signature/errorMsg_android'), defaultTime)
	}

	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Signature/clearBtn_android'), defaultTime)
	}

	@Keyword
	def verifyPrmScreenExist() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/prmScreenVerify_android'), defaultTime)
	}

	@Keyword
	def addSignature() {
		demo.swipeUpTopofScreen();
		demo.swipeRightOnSignature();
	}
	
	@Keyword
	def verifyErrorMsgOfSignature() {

		//Click on Next Button
		contactInfo.tapOnNextBtn();

		//Verify Error message
		verifyErrorMsgExist();

		//Signature
		//Mobile.delay(10)
		demo.swipeUpTopofScreen();
		demo.swipeRightOnSignature();

		//Click on Next Button
		contactInfo.tapOnNextBtn();
		empower.verifyIAgreeBtn();

		//Click on Back Button
		demo.tapOnBackBtn();

		//Clear the Signature
		tapOnClearBtn();

		//Signature
		//Mobile.delay(10)
		demo.swipeUpTopofScreen();
		demo.swipeRightOnSignature();

		//Click on Next Button
		contactInfo.tapOnNextBtn();


		//Signature
		//			Mobile.delay(10)
		//			demo.swipeUpTopofScreen();
		//			demo.swipeRightOnSignature();
		//
		//			//Click on Next Button
		//			contactInfo.tapOnNextBtn();
		//
		//			//Verify prm Screen
		//			verifyPrmScreenExist();
		//
		//			//Click on Back Button
		//			demo.tapOnBackBtn();
		//
		//			//Clear the Signature
		//			tapOnClearBtn();
		//
		//			//Click on Next Button
		//			contactInfo.tapOnNextBtn();
		//
		//			//Verify Error message
		//			verifyErrorMsgExist();
		//
		//			//Signature
		//			demo.swipeRightOnSignature();
		//
		//			//Click on Next Button
		//			contactInfo.tapOnNextBtn();
		//			Mobile.delay(10)
	}
}
