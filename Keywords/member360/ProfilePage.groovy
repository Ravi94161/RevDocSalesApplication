package member360

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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import internal.GlobalVariable

public class ProfilePage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnRevdocId() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/revdocId_android'), defaultTime)
	}

	@Keyword
	def verifyRevdocIdTitle() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/revdocUserIDTitle_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnMyAddressesOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/myAddresses_android'), defaultTime)
	}

	@Keyword
	def verifyHomeAddress() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/homeAddress_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnReciepts() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/reciepts_android'), defaultTime)
	}

	@Keyword
	def verify2024OnReciepts() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/2024REciept_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def verifyNoRecieptsMsg() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/noReceiptsMsg_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnRevcashOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/revCash_android'), defaultTime)
	}

	@Keyword
	def verifyRevcashTabs() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/myRevCashTab_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/inviteFriendsTab_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/revFriendsTab_android'), defaultTime)
	}

	@Keyword
	def tapOnInviteCodeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/inviteCode_android'), defaultTime)
	}

	@Keyword
	def verifyInviteCodeTextField() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/inviteCodeField_android'), defaultTime)
	}

	@Keyword
	def tapOnReviewsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/reviews_android'), defaultTime)
	}

	@Keyword
	def verifyNoReviewsTxt() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/noResults_android'), defaultTime)
	}
	@Keyword
	def verifyReviewsTxt() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Reviews/reviewsTitle_android'), defaultTime)
	}
	@Keyword
	def tapOnExitWithoutSavingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/exitWithoutSavingBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/backBtn_android'), defaultTime)
	}
	@Keyword
	def verifyTheUploadedDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(dateFormatter);
		println("Current Date (MM/dd/yyyy): " + formattedDate);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/dateInRevDocIdPage_andriod'), formattedDate)
	}
	@Keyword
	def verifyScreenshots(expectedImage,actualImage,expectedImage2,actualImage2) {
		if (expectedImage==actualImage) {
			println('Images match!')
		} else {
			println('Images do not match!')
		}
		if (expectedImage2==expectedImage) {
			println('Images match!')
		} else {
			println('Images do not match!')
		}
	}

	@Keyword
	def tapOnOrdersOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ordersBtn_android'), defaultTime)
	}

	@Keyword
	def verifySpecificOption(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(text, FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MY INFORMATION/specificOption_android', ['text':text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRatingOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Ratings/ratingsOptn_andorid'), defaultTime)
	}

	@Keyword
	def getRatingCount() {
		def starCount = Mobile.getText(findTestObject('Object Repository/Member/Member360/Ratings/getRatingStar_android'), defaultTime);
		def number = starCount.substring(0, starCount.indexOf('('))
		return number;
	}

	@Keyword
	def verifyRatingStarsExists(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Ratings/startCount_android', ['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnProgramsTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/programsTab_android'), defaultTime, onFailure);
	}

	@Keyword
	def getMemberProfileNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/getProfileNameText_android'), defaultTime);
	}
}
