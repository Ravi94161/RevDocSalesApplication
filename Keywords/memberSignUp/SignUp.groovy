package memberSignUp

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
import api.Member
import member360.Demographics
import member.SelectAddresses
import org.apache.commons.lang.RandomStringUtils

public class SignUp {
	String os = GlobalVariable.osName
	int defaultTime = GlobalVariable.defaultTime
	Generic gen = new Generic()
	Member memapi  = new Member()
	MobileActions mb = new MobileActions();

	@Keyword
	def fillDetailsInSignUpPage(password) {
		gen.tapOnOkayInAppUpdatePopup()
		def baseUsername = "member.user"
		def firstFiveDigits = "91688"
		def randomThreeDigitNumber = new Random().nextInt(900000) + 100
		def email = "${baseUsername}${randomThreeDigitNumber}@gmail.com"
		println("Random Username: ${email}")
		def randomLastFiveDigitNumber = new Random().nextInt(100000).toString().padLeft(5, '0')
		def newPhoneNumber = "${firstFiveDigits}${randomLastFiveDigitNumber}"
		println("New Phone Number: ${newPhoneNumber}")

		tapOnSignupBtn()
		verifyText("Come on in!")
		typeInEmailAddressInput(email)
		typeInMobileNumberInput(newPhoneNumber)
		typeInPasswordInput(password)
		typeInConfirmPasswordInput(password)
		tapOn18YearsOldCheckbox()
		tapOnSignupBtn()
	}
	@Keyword
	def fillMemberDetails(firstName = "Membertest", middleName ="U", lastname ='user', MemberAddress = GlobalVariable.searchAddress) {
		typeInFirstNameInput(firstName)
		typeInMiddleNameInput(middleName)
		typeInLastNameInput(lastname)
		tapOnDateOfBirthInput()
		swipeDownTwoYears(12)
		// swipeDown to select the year < 2004
		tapOnConfirmDobBtn()
		fillMyAddressInProfile(MemberAddress)
		tapOnMaleBtn()
		tapOnMaleInIIdentifyAsSection() // Commented this as I'm using v99(This option is not developed). This line should be uncommented when we run test in latest version,
		tapOnContinueBtn()
	}
	@Keyword
	def fillInviteCodeAndTapOnSubmitBtn(uniqueCode) {
		//Page 3
		typeInInviteCodeInput(uniqueCode)
		typeInReEnterInviteCodeInput(uniqueCode)
		// swipe up down of the page
		tapOnSubmitBtn()
		tapOnOkayBtn()
	}
	@Keyword
	def completeSignUpIncludeInviteCode(password,uniqueCode) {
		fillDetailsInSignUpPage(password)
		fillMemberDetails()
		fillInviteCodeAndTapOnSubmitBtn(uniqueCode)
		tapOnIAgreeBtn()
		//		tapOnAllowBtn()
	}
	@Keyword
	def completeSignUpWithoutInviteCode(password = GlobalVariable.providerPassword) {
		fillDetailsInSignUpPage(password)
		fillMemberDetails()
		tapOnIDontHaveAnInviteCodeBtn()
		tapOnIAgreeBtn()
		//		tapOnAllowBtn()
	}

	@Keyword
	def fillMyAddressInProfile(address, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Name of Address (eg: Home, Work) *", onFailure)
		typeInNameOfAddressInput("Work");
		tapOnAddressField();
		typeInSearchAddress(address);
		tapFirstSearchResult()
	}

	@Keyword
	def typeInNameOfAddressInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/nameOfAddressInput_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnAddressField(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/addressField_android'), defaultTime, onFailure)
	}

	@Keyword
	def typeInSearchAddress(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MyAddress/searchAddressInput_android'),text, defaultTime);
	}

	@Keyword
	def tapFirstSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResults_android'), 15)
	}

	@Keyword
	def tapOnSignupBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/signUpBtn_'+os), defaultTime)
	}
	@Keyword
	def tapOnAllowBtn() {
		Mobile.tap(findTestObject('Object Repository/allowPopUp_android'), 15, FailureHandling.OPTIONAL)
	}
	@Keyword
	def verifyEmailAddressAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/emailAddressAsrtick_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPasswordAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordAsrtick_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyConfirmPasswordAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/conformPasswordAsrtick_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyConfirmPasswordEye(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/conformPasswordEye_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPasswordEye(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/PasswordeyeSymbol_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyMobileNumberAstrick(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/mobileNumAsrtick_android'), defaultTime, onFailure)
	}
	@Keyword
	def verify18YearsOldCheckbox() {
		Mobile.scrollToText("Already have an account?", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/SignUpPage1/18YearsOldCheckbox_'+os), defaultTime)
	}
	@Keyword
	def verifyEmailListCheckbox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/SignUpPage1/emailListCheckbox_'+os), defaultTime)
	}
	@Keyword
	def verifySignUpBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/signUpBtn_android'), defaultTime)
	}
	@Keyword
	def verifySignInLink() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/signInLink_android'), defaultTime, FailureHandling.OPTIONAL)
	}
	@Keyword
	def VerifyRequiredText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/RequiredText_android',['index' : index]), defaultTime)
	}
	@Keyword
	def verifyValidEmailErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/validEmailErrorMsg_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPhoneNumErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/phoneNumErrorMsg_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifypasswordNumErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordNumErrorMsg_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifypasswordCharErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passwordCharErrorMsg_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifypassworDontMatchErrorMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/passDontMatchErrorMsg_android'), defaultTime, onFailure)
	}
	@Keyword
	def clearEmailTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/emailAddressTxtBx_android'), defaultTime)
	}
	@Keyword
	def clearPhoneNumTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/mobileNumberTxtBx_android'), defaultTime)
	}
	@Keyword
	def clearPasswordTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/passwordTxtBx_android'), defaultTime)
	}
	@Keyword
	def clearConfirmPasswordTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/SignUp/conformPasswordTxtBx_android'), defaultTime)
	}
	@Keyword
	def typeInEmailAddressInput(email) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/SignUpPage1/emailAddressInput_android'), email, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def typeInMobileNumberInput(phone) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/SignUpPage1/mobileNumberInput_'+os), phone, defaultTime)
	}

	@Keyword
	def typeInPasswordInput(password) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/SignUpPage1/passwordInput_'+os), password, defaultTime)
	}

	@Keyword
	def typeInConfirmPasswordInput(password) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/SignUpPage1/confirmPasswordInput_'+os), password, defaultTime)
	}

	@Keyword
	def tapOnEmailListCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/emailListCheckbox_'+os), defaultTime)
	}

	@Keyword
	def tapOnAcceptTermsCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/acceptTermsCheckbox_'+os), defaultTime)
	}

	@Keyword
	def tapOnTermsAndConditionsLink() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/termsAndConditionsLink_'+os), defaultTime)
	}

	@Keyword
	def tapOnPrivacyPolicyLink() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/privacyPolicyLink_'+os), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/closeBtn_'+os), defaultTime)
	}

	@Keyword
	def verifyCloseBtnElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/SignUpPage1/closeBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOn18YearsOldCheckbox() {
		Mobile.scrollToText("Already have an account?", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/SignUpPage1/18YearsOldCheckbox_'+os), defaultTime)
	}

	@Keyword
	def typeInFirstNameInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/FullNameDetails/firstNameInput_android'), name, defaultTime)
	}

	@Keyword
	def typeInMiddleNameInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/FullNameDetails/middleNameInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInLastNameInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/FullNameDetails/lastNameInput_'+os), name, defaultTime)
	}

	@Keyword
	def tapOnDateOfBirthInput() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/dateOfBirthInput_'+os), defaultTime)
	}

	@Keyword
	def tapOnConfirmDobBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/confirmDobBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnMaleBtn(index = 1) {
		Mobile.scrollToText("Male")
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/maleBtn_android', ['index':index]), defaultTime)
	}

	@Keyword
	def tapOnMaleInIIdentifyAsSection() {
		boolean scrolled = false

		try {
			Mobile.scrollToText("Please input text here", FailureHandling.OPTIONAL)
			scrolled = mb.verifyElementPresentByText("Please input text here", FailureHandling.OPTIONAL, 10);
		} catch (Exception e) {
			// Handle any unexpected exceptions
		}

		if (!scrolled) {
			try {
				scrolled = Mobile.scrollToText("Enter other", FailureHandling.OPTIONAL)
			} catch (Exception e) {
				// Handle the case where both scroll attempts fail
				Mobile.comment("Scrolling failed for both texts")
			}
		}

		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/maleBtnInIIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def tapOnMaleInIIdentifyAsSectionInEHR() {
		Mobile.scrollToText("Enter other", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/maleBtnInIIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def setTextInEmailAddressField(email) {
		Mobile.scrollToText("Email Address")
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emailAddressField_android'), email, defaultTime);
	}

	@Keyword
	def tapOnFemaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/femaleBtn_'+os), defaultTime)
	}
	@Keyword
	def verifyElementText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyDropDownOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/FullNameDetails/CountyDropDownBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapAndverifyDropDownBtn(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/CountyDropDownBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime,onFailure)
	}
	@Keyword
	def tapAndSelectCountry(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/CountyDropDownBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def VerifyMaleBtnInIdentifySection() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/FullNameDetails/maleBtnInIIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def tapOnMaleButton() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/maleBtnInIIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def VerifyFemaleBtnInIdentifySection() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/FullNameDetails/FemaleBtnInIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def tapOnFemaleButton() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/FemaleBtnInIdentifyAsSection_android'), defaultTime)
	}
	@Keyword
	def setTextInTextBox(text){
		//Mobile.tap(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/FullNameDetails/SetTextInTextField'),text, defaultTime)
	}
	@Keyword
	def tapOnContinueButton() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/continueBtn_android'), defaultTime)
	}
	@Keyword
	def VerifyContinueButtonExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/FullNameDetails/continueBtn_android'), defaultTime)
	}


	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/FullNameDetails/continueBtn_'+os), defaultTime)
	}

	@Keyword
	def typeInInviteCodeInput(code) {
		Mobile.clearText(findTestObject('Object Repository/Member/SignUp/InviteCode/inviteCodeInput_'+os), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/InviteCode/inviteCodeInput_'+os), code, defaultTime)
	}
	@Keyword
	def verifyInviteCodeInputTxtBx(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/inviteCodeInput_'+os), defaultTime, onFailure)
	}
	@Keyword
	def typeInReEnterInviteCodeInput(code) {
		Mobile.clearText(findTestObject('Object Repository/Member/SignUp/InviteCode/reEnterInviteCodeInput_'+os), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/SignUp/InviteCode/reEnterInviteCodeInput_'+os), code, defaultTime)
	}
	@Keyword
	def verifyReEnterInviteCodeInputTxtBx(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/reEnterInviteCodeInput_'+os), defaultTime, onFailure)
	}
	@Keyword
	def tapOnIDontHaveAnInviteCodeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/InviteCode/iDontHaveAnInviteCodeBtn_'+os), defaultTime)
	}
	@Keyword
	def verifyIDontHaveAnInviteCodeLink(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/iDontHaveAnInviteCodeBtn_'+os), defaultTime, onFailure)
	}
	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/InviteCode/okayBtn_'+os), defaultTime)
	}
	@Keyword
	def verifyOkayBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/okayBtn_'+os), defaultTime, onFailure)
	}

	@Keyword
	def tapOnIAgreeBtn() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/iAgreeBtn_'+os), 15, FailureHandling.OPTIONAL)) {
			scollUntilIAgreeBtnEnabled()
			tapIAgreeBtn()
			scollUntilIAgreeBtnEnabled()
			tapIAgreeBtn()
		}
		else {
			println("IAgree Button not there")
		}
	}

	@Keyword
	def scollUntilIAgreeBtnEnabled() {
		Mobile.delay(5)
		def enabled = Mobile.getAttribute(findTestObject('Object Repository/Member/SignUp/InviteCode/iAgreeBtn_android'), 'enabled', 1, FailureHandling.OPTIONAL)
		println("enabled": enabled)
		while(Mobile.getAttribute(findTestObject('Object Repository/Member/SignUp/InviteCode/iAgreeBtn_'+os), 'enabled', 5, FailureHandling.OPTIONAL) == 'false' ) {
			println("Inside loop": enabled)
			gen.swipeUp()
		}
	}

	def tapIAgreeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/InviteCode/iAgreeBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnSubmitBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/InviteCode/submitBtn_'+os), defaultTime)
	}
	@Keyword
	def verifySubmitBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/submitBtn_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifyText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime)
	}
	@Keyword
	def verifyElementTextNotExist(text ,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 10) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def swipeDownTwoYears(num) {
		int numberOfTimes = num

		// Loop to perform the action 12 times
		for (int i = 0; i < numberOfTimes; i++) {
			Mobile.setSliderValue(findTestObject('Object Repository/Member/SignUp/FullNameDetails/selectYearSeekbar_android'), 20, defaultTime)
		}
	}

	@Keyword
	def swipeUp(num) {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		def numberOfTimes = num
		for (int i = 0; i < numberOfTimes; i++) {
			Mobile.swipe(startX, startY, endX, endY)
		}
		Mobile.delay(10)
	}

	@Keyword
	def fillAndSubmitInviteCode(uniqueCode) {
		typeInInviteCodeInput(uniqueCode)
		typeInReEnterInviteCodeInput(uniqueCode)
		tapOnSubmitBtn()
		tapOnOkayBtn()
	}

	@Keyword
	def fillAndSubmitSignUpPage(email, phoneNumber, password = GlobalVariable.fullyCompletedUserPass) {
		tapOnSignupBtn()
		verifyText("Come on in!")
		typeInEmailAddressInput(email)
		typeInMobileNumberInput(phoneNumber)
		typeInPasswordInput(password)
		typeInConfirmPasswordInput(password)
		tapOn18YearsOldCheckbox()
		tapOnSignupBtn()
		return email
	}

	@Keyword
	def signUpViaApi(email, phoneNumber, password = GlobalVariable.MemberOTP, homeZipCode = '48867', homeState = "MI") {
		def retryCount = 3
		def success = false
		def data = null

		for (int i = 0; i < retryCount; i++) {
			try {
				def firstName = "Member" + RandomStringUtils.randomAlphabetic(6)
				def lastName = "Last" + RandomStringUtils.randomAlphabetic(6)
				println(firstName:firstName)
				println(lastName:lastName)
				Mobile.comment("${firstName}")
				Mobile.comment("${lastName}")
				def middleName = 'L'

				def signupData = memapi.postMemberSignUp(phoneNumber)
				memapi.postMemberDataSignUp()
				memapi.patchFindSomeLocalProviders(signupData.user_id, email, homeZipCode, homeState)
				data = memapi.patchFillInitialMemberSignUpDetails(signupData.user_id, email, firstName, lastName, middleName)

				// If successful, set success to true and break the loop
				success = true
				break
			} catch (Exception e) {
				println "Attempt ${i + 1} failed: ${e.message}"

				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

		if (success) {
			println "Sign up successful."
		} else {
			println "Sign up failed after ${retryCount} attempts."
		}

		return data
	}

	@Keyword
	def memberSignUpApi(homeZipCode = '48867', homeState = "MI") {
		def retryCount = 3
		def success = false
		def data = null
		def password = GlobalVariable.MemberOTP
		def email;
		def phoneNumber;
		def firstName
		def lastName

		for (int i = 0; i < retryCount; i++) {
			try {
				email = gen.generateRandomEmail();
				phoneNumber = gen.generateRandomMobileNumber()
				println("phoneNumber = " + phoneNumber)

				firstName = "Member" + RandomStringUtils.randomAlphabetic(6)
				lastName = "Last" + RandomStringUtils.randomAlphabetic(6)
				println(firstName:firstName)
				println(lastName:lastName)
				Mobile.comment("${firstName}")
				Mobile.comment("${lastName}")
				def middleName = 'L'

				def signupData = memapi.postMemberSignUp(phoneNumber)
				memapi.postMemberDataSignUp()
				memapi.patchFindSomeLocalProviders(signupData.user_id, email, homeZipCode, homeState)
				data = memapi.patchFillInitialMemberSignUpDetails(signupData.user_id, email, firstName, lastName, middleName)

				// If successful, set success to true and break the loop
				success = true
				break
			} catch (Exception e) {
				println "Attempt ${i + 1} failed: ${e.message}"

				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

		if (success) {
			println "Sign up successful."
		} else {
			println "Sign up failed after ${retryCount} attempts."
		}

		return ['data':data, 'email':email, 'phoneNumber':phoneNumber,'firstName':firstName, 'lastName':lastName]
	}

	@Keyword
	def memberSignUpAndUpgradeToRevPlus(homeZipCode = '48867', homeState = "MI", providerEmail = GlobalVariable.providerForRevplusApi) {
		def retryCount = 3
		def success = false
		def data = null
		def password = GlobalVariable.MemberOTP
		def email;
		def phoneNumber;
		def firstName
		def lastName

		for (int i = 0; i < retryCount; i++) {
			try {
				email = gen.generateRandomEmail();
				phoneNumber = gen.generateRandomMobileNumber()
				println("phoneNumber = " + phoneNumber)

				firstName = "Member" + RandomStringUtils.randomAlphabetic(6)
				lastName = "Last" + RandomStringUtils.randomAlphabetic(6)
				println(firstName:firstName)
				println(lastName:lastName)
				Mobile.comment("${firstName}")
				Mobile.comment("${lastName}")
				def middleName = 'L'

				def signupData = memapi.postMemberSignUp(phoneNumber)
				memapi.postMemberDataSignUp()
				memapi.patchFindSomeLocalProviders(signupData.user_id, email, homeZipCode, homeState)
				data = memapi.patchFillInitialMemberSignUpDetails(signupData.user_id, email, firstName, lastName, middleName)

				def isPaymentMonthly = true
				def providerPassword = GlobalVariable.fullyCompletedUserPass

				memapi.upgradeToRevPlus(phoneNumber, isPaymentMonthly, providerEmail, providerPassword)
				// If successful, set success to true and break the loop
				success = true
				break
			} catch (Exception e) {
				println "Attempt ${i + 1} failed: ${e.message}"

				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

		if (success) {
			println "Sign up successful."
		} else {
			println "Sign up failed after ${retryCount} attempts."
		}

		return ['data':data, 'email':email, 'phoneNumber':phoneNumber,'firstName':firstName, 'lastName':lastName]
	}

	@Keyword
	def verifyInviteCodeErrorMsg(errorMsg, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/inviteCodeErrorMsg_android',["errorMsg":errorMsg]), defaultTime, onFailure)
	}
	@Keyword
	def verifyReEnterInviteCodeErrorMsg(errorMsg, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/InviteCode/reEnterInviteCodeErrorMsg_android',["errorMsg":errorMsg]), defaultTime, onFailure)
	}
	@Keyword
	def verifyPopUpTitle(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/SignUp/InviteCode/popUpTitle_android'), text, onFailure)
	}

	@Keyword
	def tapOnInviteCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SignUp/InviteCode/closeBtn_'+os), defaultTime)
	}
	@Keyword
	def verifyRevDocLogoExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/revDocLogo_android'), defaultTime)
	}
	@Keyword
	def verifyContinueWithGoogleBtnExists(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/continueWithGoogleBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def fillAdditionalInfoDetails(firstName = "Membertest", middleName ="U", lastname ='user', tapOnContinue = true) {
		typeInFirstNameInput(firstName)
		typeInMiddleNameInput(middleName)
		typeInLastNameInput(lastname)
		tapOnDateOfBirthInput()
		swipeDownTwoYears(12)
		// swipeDown to select the year < 2004
		tapOnConfirmDobBtn()
		tapOnMaleBtn()
		tapOnMaleInIIdentifyAsSection() // Commented this as I'm using v99(This option is not developed). This line should be uncommented when we run test in latest version,
		if(tapOnContinue == true) {
			tapOnContinueBtn()
		}
	}
	@Keyword
	def getEmailText() {
		Mobile.scrollToText("Email Address")
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emailAddressField_android'), defaultTime);
	}
	@Keyword
	def signUpViaApiWithoutEHR(homeZipCode = '48867', homeState = "MI") {
		def retryCount = 3
		def success = false
		def data = null
		def password = GlobalVariable.MemberOTP
		def email;
		def phoneNumber;

		for (int i = 0; i < retryCount; i++) {
			try {
				email = gen.generateRandomEmail();
				phoneNumber = gen.generateRandomMobileNumber()
				println("phoneNumber ="+phoneNumber)
				def signupData = memapi.postMemberSignUp(phoneNumber)
				memapi.postMemberDataSignUp()
				memapi.patchFindSomeLocalProviders(signupData.user_id, email, homeZipCode, homeState)

				// If successful, set success to true and break the loop
				success = true
				break
			} catch (Exception e) {
				println "Attempt ${i + 1} failed: ${e.message}"

				// If it's the last attempt, rethrow the exception
				if (i == retryCount - 1) {
					throw e
				}
			}
		}

		if (success) {
			println "Sign up successful."
		} else {
			println "Sign up failed after ${retryCount} attempts."
		}

		return data
	}
}
