package provider

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
import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class SettingsPage {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	static driver = null;

	@Keyword
	def tapOnSettingsIcon() {
		Mobile.tap(findTestObject("Object Repository/Provider/Settings/settingsIcon_"+os), GlobalVariable.defaultTime);
	}

	@Keyword
	def verifySettingsIconExists() {
		Mobile.verifyElementExist(findTestObject("Object Repository/Provider/Settings/settingsIcon_"+os), GlobalVariable.defaultTime);
	}

	@Keyword
	def clickOnSecurityAndPasswordOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/passwordAndSecurityOption_'+os), defaultTime);
	}

	@Keyword
	def verifyBiometricsAnd2FactorAuthenticationOptions() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/biometricsTxt_android'), defaultTime);
	}

	@Keyword
	def clickOnBiometricsOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/biometricsToggle_option'), defaultTime);
	}

	@Keyword
	def clickOn2factorAuthenticationToggle() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/2factorAuthenticationToggleBtn_android'), defaultTime);
	}

	@Keyword
	def clickOnContactUsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/contactUs_'+os), defaultTime);
	}

	@Keyword
	def clickOnMsgPrmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/messagePrm_'+os), defaultTime);
	}

	@Keyword
	def verifyChatCloseBtnAndChatTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/msgPrmCloseBtn_'+os), defaultTime);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/prmChatTitle_'+os), defaultTime);
	}

	@Keyword
	def clickOnTextField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/messageField_'+os), defaultTime);
	}

	@Keyword
	def enterTxtMsg(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/Settings/messageField_'+os), txt, defaultTime);
	}

	@Keyword
	def verifyEnteredTxtMsg() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/textMsg_'+os), defaultTime);
	}

	@Keyword
	def clickOnChatCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/msgPrmCloseBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyMsgPrmBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/messagePrm_'+os), defaultTime);
	}

	@Keyword
	def clickOnRequestCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/requestCloseAccountOption_android'), defaultTime);
	}

	@Keyword
	def verifyDeleteAccountPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPageTitle_android'), defaultTime);
	}

	@Keyword
	def verifyWarningMsgOnDeleteAccountPage() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Settings/warningTxtOnDelAccountPage_android'), "This action is permanent.");
	}

	@Keyword
	def verifyBackBtnOnDeleteAccountPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPageBackBtn_android'), defaultTime);
	}

	@Keyword
	def clickOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountBtn_android'), defaultTime);
	}

	@Keyword
	def verifyDeletePopupCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deletePopupCloseBtn_android'), defaultTime);
	}

	@Keyword
	def verifyTxtOnDeletePopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deletePopupTxt_android'), defaultTime);
	}

	@Keyword
	def clickOnCheckboxOnDeletePopup() {
		Mobile.checkElement(findTestObject('Object Repository/Provider/Settings/checkboxOnDelAccountPopup_android'), defaultTime);
	}

	@Keyword
	def verifyDeleteBtnOnDeleteAccountPopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupDeleteBtn_android'), defaultTime);
	}

	@Keyword
	def tapDeleteBtnOnDeleteAccountPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupDeleteBtn_android'), defaultTime);
	}

	@Keyword
	def clickOnCancelBtnOnDeleteAccountPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupCancelBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAbsenceOfDeletePopup() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Settings/deletePopupTxt_android'), defaultTime);
	}

	@Keyword
	def clickOnBackBtnOnDeleteAccountPage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountPageBackBtn_android'), defaultTime);
	}

	@Keyword
	def clickOnBackBtnOnDelecteAccountPage() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPageTitle_android'), defaultTime);
	}

	//Verify Settings page UI Elements

	@Keyword
	def verifyPasswordAndSecurityOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/passwordAndSecurityOption_android'), defaultTime);
	}

	@Keyword
	def verifyFaqOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/faqOption_android'), defaultTime);
	}

	@Keyword
	def tapOnFaqOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/faqOption_android'), defaultTime);
	}

	@Keyword
	def verifyHowToVideosOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/howToVideosOption_android'), defaultTime);
	}

	@Keyword
	def verifyPrivacyAndLegalOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/privacyAndLegalOption_android'), defaultTime);
	}

	@Keyword
	def verifyContactUs() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/contactUs_android'), defaultTime);
	}

	@Keyword
	def verifyAboutRevDocOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/aboutRevDocOption_android'), defaultTime);
	}

	@Keyword
	def verifyLogoutOption() {
		Mobile.scrollToText("Log Out", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/logoutOption_android'), defaultTime);
	}

	@Keyword
	def verifyRequestCloseAccountOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/requestCloseAccountOption_android'), defaultTime);
	}

	//Verify PRM Profile screen

	@Keyword
	def tapOnPrmProfileOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmProfileOption_android'), defaultTime);
	}

	@Keyword
	def getPRMName() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmProfileNameOnContactUsPage_android'), defaultTime)
	}

	@Keyword
	def getPrmAddress() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmProfileAddressOnContactUsPage_android'), defaultTime);
	}

	@Keyword
	def verifyPrmProfileName(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmProfileName_android', ['prmName': name]), defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyPrmAddress(adrs) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmAddress_android', ['prmAddress': adrs]), defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyPrmStateCounty(prm) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmStateCounty_android', ['prmAssigned': prm]), defaultTime);
	}

	@Keyword
	def verifyPrmReports(report) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/Prm Profile/prmReports_android', ['prmReports': report]), defaultTime);
		Mobile.hideKeyboard();
	}


	def openChromeBrowser(def path) {
		if(driver == null){
			def driverPath = PathUtil.relativeToAbsolutePath(path, RunConfiguration.getProjectDir())
			println "driverPath: " + driverPath
			System.setProperty("webdriver.chrome.driver",driverPath)
			driver = new ChromeDriver()
			DriverFactory.changeWebDriver(driver)
		}
	}
	@Keyword
	def clickOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/backBtnOfPassAndSec_android'), defaultTime);
	}
	@Keyword
	def tapOnHowToVideosOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/howToVideosOption_android'), defaultTime);
	}
	@Keyword
	def tapOnvideoBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/videoBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyVideoBtnAbsence(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Settings/videoBtn_android',['index': index]), defaultTime);
	}
	@Keyword
	def isUploadDateExists(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/uploadDateOption_android',['index': index]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def isDetailsUnderVdoExists(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/uploadDateOption_android',['index': index]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnLogoutBtn() {
		Mobile.scrollToText("Log Out", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/logoutBtn_android'), defaultTime);
	}
	@Keyword
	def clickOnAboutRevDoc() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/aboutRevDocOption_'+os), defaultTime);
	}

	@Keyword
	def clickOnPrivacyAndLegal() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/privacyAndLegal_'+os), defaultTime);
	}

	@Keyword
	def clickOnTermsAndConditionsTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/termsAndConditionsTab_'+os), defaultTime);
	}

	@Keyword
	def clickOnPrivacyPolicyTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/privacyPolicy_'+os), defaultTime);
	}
	@Keyword
	def verifyTermsAndConditionsTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/termsAndConditionsVerificationTxt_android'), defaultTime);
	}

	@Keyword
	def verifyPrivacyPolicyTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/Prm Profile/privacyPolicyTitle_android'), defaultTime);
	}

	@Keyword
	def verifyContactUsBtnPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/contactUs_'+os), defaultTime);
	}

	@Keyword
	def verifyUrl(url) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/verifyUrl_'+os,['url':url]), defaultTime);
	}

	@Keyword
	def logoutFromProvider() {
		tapOnSettingsIcon()
		Mobile.delay(3)
		verifyLogoutOption()
		tapOnLogoutBtn()
	}
	//verify Faq Page
	@Keyword
	def verifyProviderFaq() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/FAQ/providerFaq_android'), defaultTime);
	}

	@Keyword
	def verifyTestCategory() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/FAQ/testCategory_android'), defaultTime);
	}

	@Keyword
	def tapOnProviderFaq() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/FAQ/providerFaq_android'), defaultTime);
	}
}
