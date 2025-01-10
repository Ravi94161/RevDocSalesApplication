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
import mobile.Generic
import mobile.MobileActions

public class Affiliation {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions mobile = new MobileActions();
	Generic gen = new Generic();

	@Keyword
	def verifysearchBtnExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/searchBtn_android', ["index":index]), defaultTime)
	}

	@Keyword
	def tapOnSearchBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/searchBtn_android', ["index":index]), defaultTime)
	}

	@Keyword
	def verifyEmailSearchField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/emailSearchField_android'), defaultTime);
	}

	@Keyword
	def setTxtInEmailSearchField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/Affiliation/emailSearchField_android'), txt, defaultTime);
	}

	@Keyword
	def verifyOkayBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/okayBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/okayBtn_android'), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyBuyNowBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/buyNowBtn_Android'), defaultTime)
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/buyNowBtn_Android'), defaultTime)
	}

	@Keyword
	def tapOnCloseOutLineBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/closeOutlineBtn_android'), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyNoThanksTxtExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/noThanksTxt_android'), defaultTime)
	}

	@Keyword
	def tapOnNoThanksTxt() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/noThanksTxt_android'), defaultTime)
	}

	@Keyword
	def verifyHandshakeIconExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/handShakeIcon_android'), defaultTime)
	}

	//----------------Affiliate Exclusive Procedures Page Start------------
	@Keyword
	def verifyAffiliateExclusiveProceduresTitleExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/affiliateExclusiveProceduresTitle_android'), defaultTime)
	}

	@Keyword
	def verifyIconHourExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/iconHour_android'), defaultTime)
	}

	@Keyword
	def verifyBackBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/backBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/backBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAllTabExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/allTab_android'), defaultTime)
	}


	//----------------Affiliate Exclusive Procedures Page End------------

	// ------------- Start Procedure Card -----------

	@Keyword
	def tapOnProcedureCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/procedureCard_android'), defaultTime)
	}

	@Keyword
	def verifyAffiliationProcedurePriceOnCard(procedureName, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Affiliation/ProcedureCard/procedurePriceByName_android', ['name': procedureName, 'price': price])
		try{
			Mobile.verifyElementExist(testObject, defaultTime, onFailure)
		} catch(Exception e) {
			gen.swipeUpLittle();
			Mobile.verifyElementExist(testObject, defaultTime, onFailure)
		}
	}

	@Keyword
	def getProcedureName() {
		return Mobile.getText(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/getProcedureName_android'), defaultTime);
	}

	@Keyword
	def tapOnShareIcon(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/shareIconByProcedureName_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def verifyShareIconExist(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/shareIconByProcedureName_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def getSharkingLink() {
		return Mobile.getText(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/sharingLink_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnShareLinkCopyIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/shareLinkCopyIcon_android'), defaultTime)
		Mobile.delay(10)
	}

	@Keyword
	def tapOnMoreInfoBtn(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/moreInfoBtnByProcedure_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def verifyMoreInfoBtn(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/moreInfoBtnByProcedure_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def tapOnBookApptBtn(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/bookAppointmentBtnByProcedure_android', ['name': procedureName]), defaultTime)
	}
	@Keyword
	def verifyBookApptBtn(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/bookAppointmentBtnByProcedure_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def getProcedureTagName() {
		return Mobile.getText(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/getProcedureTag_android'), defaultTime);
	}

	@Keyword
	def verifyProcedureTagExist(procedureTagName, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/Affiliate Exclusive ProceduresPage/procedureTag_android', ['procedureTagName': procedureTagName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyFavoriteIconExist(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/favoriteIcon_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def tapOnFavoriteIcon(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/Affiliation/ProcedureCard/favoriteIcon_android', ['name': procedureName]), defaultTime)
	}

	@Keyword
	def verifyAlertIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Affiliation/alertIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyProcedureImageOnCard(procedureName) {
		TestObject testObject = findTestObject("Object Repository/Member/Affiliation/ProcedureCard/procedureImage_android", ['name': procedureName])
		Mobile.verifyElementExist(testObject, defaultTime)
	}

	@Keyword
	def verifyProcedureProfileImage(expectedImagePath) {
		TestObject testObject = findTestObject("Object Repository/Member/Affiliation/ProcedureCard/ProcedureProfile/procedureProfileImage_android")
		mobile.verifyScreenshotMatchesWithElementScreenshot(expectedImagePath, testObject);
	}

	// ------------- End Procedure Card -------------
}
