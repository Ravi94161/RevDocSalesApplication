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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

import internal.GlobalVariable

public class SettingsPage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnAccountIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/accountIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnSettingsIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/accountIcon_android'), defaultTime)
		Mobile.delay(3)
	}

	@Keyword
	def verifySettingIcon(onFailure= FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/accountIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPasswordAndSecurityOption() {
		Mobile.scrollToText("Password and Security", FailureHandling.OPTIONAL);
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/paswordAndSecurityOption_android'), defaultTime)
	}

	@Keyword
	def tapOnPasswordAndSecurity() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Settings/paswordAndSecurityOption_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/paswordAndSecurityOption_android'), defaultTime)
	}

	@Keyword
	def verifySyncApptsToExternalCalendarOption() {
		Mobile.scrollToText("Sync Appts to External Calendar", FailureHandling.OPTIONAL);
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/SyncApptsToExternalCalendar/syncApptsToExternalCalendar_android'), defaultTime)
	}


	@Keyword
	def tapOnSyncApptsToExternalCalendarOption() {
		verifySyncApptsToExternalCalendarOption()
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/SyncApptsToExternalCalendar/syncApptsToExternalCalendar_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/SyncApptsToExternalCalendar/syncApptsToExternalCalendar_android'), defaultTime)
	}

	@Keyword
	def navigateToSyncApptsToExternalCalendar() {
		tapOnAccountIcon()
		tapOnSyncApptsToExternalCalendarOption()
	}

	@Keyword
	def verifyFAQOption() {
		Mobile.scrollToText("FAQ", FailureHandling.OPTIONAL);
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/faqBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnFAQ() {
		Mobile.delay(3)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Settings/faqBtn_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/faqBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/faqBtn_android'), defaultTime)
	}

	@Keyword
	def verifyChangePasswordOption() {
		try{
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/changePassword_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/backBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBackBtn(onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/backBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyGeneralQuestionsTitle() {
		try {
			Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/faqGeneralQuestionsTitle_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnHowToVideosBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/howToVideosBtn_android'), defaultTime)
	}

	@Keyword
	def verifyVideoPlayBtn() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/playBtn_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnPrivacyAndLegalBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/privacyAndLegalBtn_android'), defaultTime)
	}

	@Keyword
	def verifyOnPrivacyAndLegalBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("Privacy & Legal", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/privacyAndLegalBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCommonwellEnrollmentBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.delay(3)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Settings/commonWellOption_android'), 60, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/commonWellOption_android'), 60, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/commonWellOption_android'), defaultTime)
	}

	@Keyword
	def verifyOnCommonwellEnrollmentBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/commonWellOption_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAboutRevDocOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/aboutRevdoc_android'), defaultTime)
	}

	@Keyword
	def verifyAfterTapOnAboutRevDocOptNvgToChrm(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/afterTapOnAboutRevDocOptChrm_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAboutRevDocOpt(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("About RevDoc", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/aboutRevdoc_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySuggestionsOpt(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("Suggestions", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/contactUs_android'), defaultTime, onFailure)
	}


	@Keyword
	def tapOnContactUsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/contactUs_android'), defaultTime)
	}

	@Keyword
	def verifyContactUsBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/contactUs_android'), defaultTime)
	}

	@Keyword
	def verifyContactUsPageTitle() {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Settings/bottomSheetPageTitle_android'), "Rev AI")
	}

	@Keyword
	def getDateTimeTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Settings/dateTimeFieldOnContactUs_android'), defaultTime)
	}

	@Keyword
	def verifyTodayDate(dateTxt) {
		if(dateTxt.contains('Today')) {
			println("Date verfication succeed")
		}
	}

	@Keyword
	def getDefaultAIMsg() {
		return Mobile.getText(findTestObject('Object Repository/Member/Settings/defaultMsgFromAI_android'), defaultTime)
	}

	@Keyword
	def verifyWelcomeMsg(defaultAIMsg) {
		if(defaultAIMsg.contains('welcome to RevDoc!')) {
			println("Welcome Txt is visible")
		}
	}

	@Keyword
	def verifyTermsAndCondition() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/privacyAndLegalBody_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnTermsAndCondition() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/termsAndCondition_android'), defaultTime)
	}

	@Keyword
	def verifyPrivacyPolicyTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/privacyPolicyTab_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/privacyAndLegalBody_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyDateElementOnPrivacyAndLegal() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/DateFieldonPrivacyandlegal'), defaultTime)
	}
	@Keyword
	def verifyElementTxtInSettingsPage(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Settings/PrivacyAndLegalOption_android'), text, onFailure);
	}


	@Keyword
	def verifyCommonEnrollmentToggle() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/commonwellEnrollToggle_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def verifyMsgField() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Settings/msgFieldInContactUs_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def enterQuestion(ques) {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/msgFieldInContactUs_android'), defaultTime)
		Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Member/Settings/msgFieldInContactUs_android'), ques, defaultTime)
		def driver = MobileDriverFactory.getDriver()
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	@Keyword
	def verifyUserQues(ques) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Settings/userQues_android'), ques)
	}

	@Keyword
	def getReplyFromAI() {
		return Mobile.getText(findTestObject('Object Repository/Member/Settings/replyFromAI_android'), defaultTime)
	}

	@Keyword
	def verifyValidReply(reply) {
		if(reply.contains('telemedicine')||reply.contains('Something went wrong')) {
			println("Got valid reply")
		}
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/bottomSheetCloseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProviderCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/ProviderProfile/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnLogoutBtn() {
		Mobile.scrollToText("Log Out", FailureHandling.OPTIONAL)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/logoutBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAccountAndLogoutBtn() {
		tapOnAccountIcon();
		tapOnLogoutBtn();
	}

	@Keyword
	def verifyLogoutBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("Log Out", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/logoutBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnExitWithoutSavingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/exitWithoutSavingBtn_android'), defaultTime)
	}

	@Keyword
	def verifyPageTitle(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/pageTitle_andriod',['title': title]), defaultTime, onFailure)
	}

	@Keyword
	def verifyChangePasswordWithExpndBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/changePasswordWithExpndBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyUseBiometricsToggleBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/useBiometricsToggleBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRequestToCloseAccountOpt(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/requestToCloseAccount_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRequestToCloseOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/requestToCloseAccount_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyFAQOptionWithExpandBtn(option, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/FAQ/faqPageOptions_andriod',['option': option]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCommonWellEnrollmentPageContent(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		String content = 'The CommonWell network provides participating practitioners access to your past and present medical records to make better decisions and better coordinate care across your providers. Participation is a personal decision you must make and is not a condition of receiving care. If you opt out, your health information will not be available through the CommonWell network, to RevDoc, or other clinicians.';
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/CommonWell Enrollment/commonWellPageContent_andriod',['content': content]), defaultTime, onFailure)
	}

	@Keyword
	def verifyunenrollForUsingCommonWellOpt(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/CommonWell Enrollment/unEnrollForUsingCommonWell_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCheckoutOurFaq(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/CommonWell Enrollment/checkOutOurFaq_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPaymentLabel(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/paymentLabel_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAppVersionLabel(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/revDocAppVersion_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnDeleteAccountBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnNoCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupCancelBtn_android'), defaultTime)
	}
	@Keyword
	def verifyNoCancelBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupCancelBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyYesDeleteDisabledBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/YesDeleteDisableBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyYesDeleteEnabledBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/YesDeleteEnabledBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnYesDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupDeleteBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Settings/checkboxOnDelAccountPopup_android'), defaultTime)
	}
	@Keyword
	def verifyYesDeleteBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupDeleteBtn_android'), defaultTime);
	}
	@Keyword
	def verifyNoCancelBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Settings/deleteAccountPopupCancelBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnReviewOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/reviews_android'), defaultTime)
	}
	@Keyword
	def verifyProviderRating(provider, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Reviews/providerRating_andriod',["provider": provider]), defaultTime, onFailure)
	}

	@Keyword
	def verifyBiometricToggleEnable(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/passwordAndSecurity/biometricToggleEnable_android'), defaultTime, onFailure)
	}
	
	@Keyword
	def tapOnSendAGiftCard() {
		Mobile.scrollToText("Send a Gift Card", FailureHandling.OPTIONAL)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/sendAGiftCardBtn_android'), defaultTime)
	}
	
	@Keyword
	def navigateToSendAGiftCardScreen() {
		tapOnAccountIcon()
		tapOnSendAGiftCard()
	}
}
