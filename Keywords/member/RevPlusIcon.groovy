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

public class RevPlusIcon {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnRevPlusIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/membershipBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnManageBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/manageBtn_android'), defaultTime);
	}
	@Keyword
	def verifyManageBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/membershipIcon/manageBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCanelMembershipBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/cancelMembershipBtn_android'), defaultTime);
	}
	@Keyword
	def verifyMembershipIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/membershipIcon/membershipBtn_android'), defaultTime)
	}
	@Keyword
	def verifyRevPlusBenifits(option, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/membershipIcon/revPlusBenifitsOpt_andriod',['option': option]), defaultTime, onFailure)
	}
	@Keyword
	def verifyMemberShipBenefitList(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/membershipIcon/memberShipBenifitList_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnViewMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/viewMoreBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnRevPlusManageBenifitsBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/manageBenefitsBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAffilationManageBenifitsBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipIcon/affiliationManageBenefitsBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAffilationManageBenifitsBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/membershipIcon/affiliationManageBenefitsBtn_android'), defaultTime, onFailure)
	}
}

