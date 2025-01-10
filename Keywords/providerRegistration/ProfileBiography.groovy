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
import mobile.Generic
import mobile.MobileActions
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class ProfileBiography {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic()
	MobileActions mobileActions = new MobileActions()

	@Keyword
	def verifyProfileBiographyTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyPageTitle_android'), 30);
	}

	@Keyword
	def tapOnProfileBiographyOption() {
		Mobile.tap(findTestObject('Provider/Provider360/Profile Biography/profileBiographyOption_android'), 30);
	}

	@Keyword
	def tapOnProfileUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyUploadPhoto_android'), 30);
	}

	@Keyword
	def tapOnChooseFromLibraryBtn() {
		Mobile.tap(findTestObject('Provider/Provider360/SetUpYourAvailability/chooseFromLibraryBtn_android'), 30);
	}

	@Keyword
	def tapOnFirstImageInLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/firstImageInLibrary_android'), 30);
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/cropBtn_andriod'), defaultTime)
		}
		catch(Exception e) {
			println("crop btn not present")
		}
	}

	//	@Keyword
	//	def tapOnCropBtn() {
	//		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/imageCropBtn_android'), defaultTime)
	//	}
	@Keyword
	def verifyPhotoReuploadBtn() {
		Mobile.delay(10);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyReuploadBtn_android'), 30);
	}

	@Keyword
	def tapOnPhotoReuploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyReuploadBtn_android'), 30);
	}

	@Keyword
	def verifyimageIsVisible() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/imageOnProfileBiographyPage_android'), 30);
	}

	@Keyword
	def tapOnUploadVideoBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyUploadVideoBtn_android'), 30);
	}

	@Keyword
	def tapOnSecondVideoFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/secondVideoFromLibrary_android'), 30);
	}

	@Keyword
	def waitAndVerifyVideoReuploadBtn(index = 1) {
		Mobile.delay(30)

		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideo_android', ['index': index]), 30);
		//Mobile.scrollToText('What should I include?', FailureHandling.STOP_ON_FAILURE)
		//Mobile.scrollToText("Gender *", FailureHandling.STOP_ON_FAILURE)
		//Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideo_android'), defaultTime)
	}
	@Keyword
	def verifyReUploadloadBtn(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideo_android',  ['index': index]), 30);
	}

	@Keyword
	def tapOnVideoReuploadBtn(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideo_android', ['index': index]), 30);
	}

	@Keyword
	def verifyVideoIsVisible() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/videoOnProfileBiographyPage_android'), 30);
	}

	@Keyword
	def tapOnVideoPlayBtnAndVerify() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/videoPlayBtn_android'), 30);
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/videoPlayBtn_android'), defaultTime)
		Mobile.scrollToText("What should I include?", FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def enterTextInInfoDetailsBox(msg) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/infoDetailsTxtboxProfileBiographypage_android'), msg, 30);
	}

	@Keyword
	def VerifyLanguageDrpdwn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/languageDrpdwnInProfileBiographyPage_android'), 30);
	}

	@Keyword
	def tapOnLanguageDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/languageDrpdwnInProfileBiographyPage_android'), 30);
	}

	@Keyword
	def tapOnEnglishLanguage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/englishOptionInprofileBiographyLangDrpdwn_android'), 30);
	}

	@Keyword
	def tapOnArabicLanguage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/arabicLanguage_android'), 30);
	}

	@Keyword
	def saveLangBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveLangProfileBiography_android'), 30);
	}
	@Keyword
	def verifySaveLangBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveLangProfileBiography_android'), 30);
	}

	@Keyword
	def verifyGenderBtns() {
		Mobile.delay(3)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/maleProfileBiography_android'), 30);
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/femaleBtn_android'), 30);
	}

	@Keyword
	def tapOnMaleBtn() {
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/maleProfileBiography_android'), 30);
	}

	@Keyword
	def tapOnSaveProfileBiography() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/saveProfileBiographyBtn_android'), 30);
	}
	@Keyword
	def verifySaveProfileBiography() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/saveProfileBiographyBtn_android'), 30);
	}

	@Keyword
	def verifyRequiredFieldError() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/requiredFieldError_android'), 30)
	}

	@Keyword
	def verifyRequiredFieldErrorAbsence() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/requiredFieldError_android'), 30)
	}

	@Keyword
	def verifyAboutTitleInBiographyScreen() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/aboutTitle_android'), 30)
	}

	@Keyword
	def verifyPhotoUploadPopUpOptions() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/takeNewImageBtn_android'), 30)
		Mobile.verifyElementVisible(findTestObject('Provider/Provider360/SetUpYourAvailability/chooseFromLibraryBtn_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyVideoUploadPopUpOptions() {
		//Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/takeNewVideoBtn_android'), 30)
		Mobile.verifyElementVisible(findTestObject('Provider/Provider360/SetUpYourAvailability/chooseFromLibraryBtn_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Profile Biography/closeBtn_android'), defaultTime)
	}

	@Keyword
	def reuploadImage() {
		tapOnPhotoReuploadBtn()
		verifyPhotoUploadPopUpOptions()
		tapOnChooseFromLibraryBtn()
		tapOnFirstImageInLibrary()
		Mobile.delay(10)
	}

	@Keyword
	def reuploadVideo() {
		tapOnVideoReuploadBtn()
		Mobile.delay(5)
		verifyVideoUploadPopUpOptions()
		tapOnChooseFromLibraryBtn()
		tapOnSecondVideoFromLibrary()
		Mobile.delay(10)
		Mobile.scrollToText("Video *")
		Mobile.delay(15)
	}

	@Keyword
	def completeProfileBiography() {
		tapOnProfileBiographyOption()
		verifyProfileBiographyTitle()
		verifyAboutTitleInBiographyScreen()
		tapOnProfileUploadBtn()
		verifyPhotoUploadPopUpOptions()
		tapOnChooseFromLibraryBtn()
		tapOnFirstImageInLibrary()
		//tapOnCropBtn()
		verifyPhotoReuploadBtn()
		verifyimageIsVisible()
		tapOnUploadVideoBtn()
		tapOnChooseFromLibraryBtn()
		tapOnSecondVideoFromLibrary()
		waitAndVerifyVideoReuploadBtn()
		//waiting for reupload video button
		boolean isTextVisible = mobileActions.waitForTextVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideoSecond_android'), "Reupload", 45, FailureHandling.OPTIONAL);
		if(isTextVisible) {
			println('video is uploaded successfully')
		}
		else {
			mobileActions.waitForTextVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideoSecond_android'), "Reupload", 45, FailureHandling.OPTIONAL);
		}
		verifyVideoIsVisible()
		gen.swipeUpLittle();
		enterTextInInfoDetailsBox("Hello, this is a test account");
		gen.swipeUpLittle();
		tapOnLanguageDrpdwn()
		tapOnEnglishLanguage()
		tapOnArabicLanguage()
		saveLangBtn()
		gen.swipeUpLittle();
		verifyGenderBtns()
		Mobile.delay(5)
		tapOnMaleBtn()
		verifyRequiredFieldErrorAbsence()
		Mobile.delay(45)
		tapOnSaveProfileBiography()
	}
	//-----------------------------------SocialMedia----------------------------------------------------------------
	@Keyword
	def enterSocialMediaDetails(fieldName, value) {

		def accessibilityValue

		switch (fieldName) {
			case "Linkedin":
				accessibilityValue = "linkedin name"
				break
			case "Facebook":
				accessibilityValue = "facebook name"
				break
			case "Instagram":
				accessibilityValue = "instagram handle"
				break
			case "Twitter":
				accessibilityValue = "x handle"
				break
			case "Website":
				accessibilityValue = "url for your website"
				break
			default:
				KeywordUtil.markFailedAndStop("Invalid Field Name")
		}
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Profile Biography/socialMediaInputFields',['placeholder': accessibilityValue]), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Profile Biography/socialMediaInputFields',['placeholder': accessibilityValue]), value, defaultTime);
	}
	@Keyword
	def getTextAndClearSocialMediaDetails(fieldName, value) {

		def accessibilityValue

		switch (fieldName) {
			case "Linkedin":
				accessibilityValue = "linkedin name"
				break
			case "Facebook":
				accessibilityValue = "facebook name"
				break
			case "Instagram":
				accessibilityValue = "instagram handle"
				break
			case "Twitter":
				accessibilityValue = "x handle"
				break
			case "Website":
				accessibilityValue = "url for your website"
				break
			default:
				KeywordUtil.markFailedAndStop("Invalid Field Name")
		}
		def text = Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Profile Biography/socialMediaInputFields',['placeholder': accessibilityValue]), defaultTime);
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Profile Biography/socialMediaInputFields',['placeholder': accessibilityValue]), defaultTime)
		return text;
	}
}
