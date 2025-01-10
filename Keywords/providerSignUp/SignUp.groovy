package providerSignUp

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

public class SignUp {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();

	@Keyword
	def tapOnSignInLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/signInLink_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnSignUpLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/signUpLink_android'), defaultTime);
	}
	@Keyword
	def tapOnSignUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/signUpBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnEmailListCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/emailListCheckBx_android'), defaultTime);
	}
	@Keyword
	def tapOnAcceptTermsCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/acceptTermsCheckBx_android'), defaultTime);
	}
	@Keyword
	def typeInEmailTxtBx(email) {
		Mobile.setText(findTestObject('Object Repository/Provider/SignUp/emailAddressTxtBx_android'),email, defaultTime);
	}
	@Keyword
	def typeInPasswordTxtBx(password) {
		Mobile.setText(findTestObject('Object Repository/Provider/SignUp/passwordTxtBx_android'),password, defaultTime);
	}
	@Keyword
	def typeInconformPasswordTxtBx(password) {
		Mobile.setText(findTestObject('Object Repository/Provider/SignUp/conformPasswordTxtBx_android'),password, defaultTime);
	}
	@Keyword
	def typeMobileNumberTxtBx(number) {
		Mobile.setText(findTestObject('Object Repository/Provider/SignUp/mobileNumberTxtBx_android'),number, defaultTime);
	}
	@Keyword
	def verifyThisMailAlreadyExistErrorMsg(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/thisMailAlreadyInUseErrorMsg_android', ["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyNpinumberTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Npi Details/npiNumber_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEmailAddressAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/emailAddressAsrtick_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPasswordAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordAsrtick_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyConformPasswordAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/conformPasswordAsrtick_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyConformPasswordEye(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/conformPasswordEye_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPasswordEye(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PasswordeyeSymbol_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMobileNumberAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/mobileNumAsrtick_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRadioBtnEmailListTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/radioBtnEmailListTxt_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRadioBtnIagreeTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/radioBtnIagreeTxt_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyValidEmailErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/validEmailErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTermsConditionErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/termsConditionErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRequiredErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/requiredErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPhoneNumErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/phoneNumErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifypasswordNumErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordNumErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifypasswordCharErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordCharErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifypassworDontMatchErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passDontMatchErrorMsg_android'), defaultTime, onFailure);
	}
	@Keyword
	def clearEmailTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/emailAddressTxtBx_android'), defaultTime);
	}
	@Keyword
	def clearPhoneNumTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/mobileNumberTxtBx_android'), defaultTime);
	}
	@Keyword
	def clearPasswordTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/passwordTxtBx_android'), defaultTime);
	}
	@Keyword
	def clearConformPasswordTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/conformPasswordTxtBx_android'), defaultTime);
	}
	@Keyword
	def tapOnTermsAndConditionLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/termsAndConditionLink_android'), defaultTime);
	}
	@Keyword
	def tapOnPrivacyPolicyLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/privacyPolicyLink_android'), defaultTime);
	}
	@Keyword
	def verifyTermsAndConditionsTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/termsAndConditionsTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPrivacyPolicyTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/privacyAndPolicyTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCloseOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/closeOption_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/closeOption_android'), defaultTime, onFailure);
	}

	// Privacy and Legal

	@Keyword
	def verifyPrivacyAndLeagalScreenTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/privacyAndLegalTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyTermsAndConditionsTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/termsAndConditionsTab_andorid'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPrivacyPolicyTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/PrivacyAndPolicyTab_andorid'), defaultTime, onFailure);
	}

	@Keyword
	def tabIAgreeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/iAgreeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnIAgreeBtn() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/iAgreeBtn_android'), defaultTime, FailureHandling.OPTIONAL)) {
			scollUntilIAgreeBtnEnabled();
			verifyElementTextPresent("You must read the entire document to agree")
			tabIAgreeBtn();
			scollUntilIAgreeBtnEnabled();
			verifyElementTextPresent("You must read the entire document to agree")
			tabIAgreeBtn();
			Mobile.delay(5)
		}
		else {
			println("IAgree Button not there");
		}
	}

	@Keyword
	def scollUntilIAgreeBtnEnabled() {
		verifyPrivacyAndLeagalScreenTitle();
		def enabled = Mobile.getAttribute(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/iAgreeBtn_android'), 'enabled', 1, FailureHandling.OPTIONAL)
		println("enabled": enabled)
		int i = 0;
		while(Mobile.getAttribute(findTestObject('Object Repository/Provider/SignUp/PrivacyAndLegal/iAgreeBtn_android'), 'enabled', 5, FailureHandling.OPTIONAL) == 'false' && i < 60) {
			println("Inside loop": i )
			i = i+ 1;
			gen.swipeUp();
		}
		println("loop break")
	}

	@Keyword
	def verifyGetReadyForRegistrationScreenTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/GetReadyForRegistrationScreen/getReadyForRegistration_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapContinueBtnInGetReadyForRegistrationScreen(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/SignUp/GetReadyForRegistrationScreen/continueBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyErrorMessageTxt(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/errorMsgText_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEmailListCheckBoxFilled(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/emailListFilledCheckBox_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementTextPresent(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/elementText_android', ['Text': Text]), defaultTime, onFailure)
	}
}
