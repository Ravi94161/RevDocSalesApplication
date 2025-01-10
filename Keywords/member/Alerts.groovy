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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import mobile.Generic
import member.Chat
import provider.HomePage

public class Alerts {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	Chat chat = new Chat();
	HomePage home = new HomePage();
	@Keyword
	def tapOnProviderToChat() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/providerMessage_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/providerMessage_android'), defaultTime);
	}
	@Keyword
	def tapOnProviderByNameToChat(providerName) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/providerMessageByName_android', ['providerName': providerName]), defaultTime);
	}
	@Keyword
	def tapOnAlertsIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/alertIcon_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/alertIcon_android'), defaultTime);
	}
	@Keyword
	def verifyTheAlertsIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/alertIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def convertDateFormatAsInChatPage(dateTime) {
		// Define the input and output date formats
		// Parse the original date string
		String formattedDateString = dateTime.replaceAll(/(\w+ )0(\d, \d{4}, \d{1}:\d{2} \w{2} \w{3})/, '$1$2')
		println(formattedDateString)
		return  formattedDateString   // Output: August 7, 2024, 12:30 PM CDT
	}

	@Keyword
	def verifySearchField() {
		try{
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/searchField_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def verifyAlertsSearchBar() {
		Mobile.delay(5)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/searchField_android'), defaultTime)
	}

	@Keyword
	def verifyProviderChat() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/providerMessage_android'), defaultTime)
	}

	@Keyword
	def verifySomethingFeelsOffErrorMsgNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Alerts/somethingFeelsOffMsg_android'), defaultTime)
	}

	@Keyword
	def verifyNoResultsMsg() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/noResultsMsg_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def verifyRevPrivateRequest(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/revPrivateInvitationsTxt_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevPrivateRequestTextNotExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/revPrivateInvitationsTxt_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapRevPrivateRequest(onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/revPrivateInvitationsTxt_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyELementTxtExist(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/elementText_android', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def verifyProviderNameInRevPrivate(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/providerNameInRevPrivate_android'), text, onFailure)
	}

	@Keyword
	def tapCancelRequestForProvider(providerName, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/cancelRequestByProviderName_android', ['providerName': providerName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelRequestForProviderNotExists(providerName, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementNotPresent(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/cancelRequestByProviderName_android', ['providerName': providerName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelRequestBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/cancelRequest_android'), defaultTime, onFailure)
	}

	@Keyword
	def removAllRevPrivateRequests() {
		tapOnAlertsIcon();
		Mobile.delay(3)
		verifyRevPrivateRequest(FailureHandling.OPTIONAL, 10)
		if(verifyRevPrivateRequest(FailureHandling.OPTIONAL, 10)) {
			tapRevPrivateRequest();

			AppiumDriver<?> driver = MobileDriverFactory.getDriver();
			List<WebElement> elements = driver.findElementsByXPath("//android.view.ViewGroup[@content-desc='banOrange, Cancel Request']")
			println("size": elements.size())
			for( def i = 1; i <= elements.size(); i++) {
				println ("i value": i)
				Mobile.waitForElementPresent(findTestObject('//android.view.ViewGroup[@content-desc="banOrange, Cancel Request"]'), 10)
				Mobile.tap(findTestObject('//android.view.ViewGroup[@content-desc="banOrange, Cancel Request"]'), 10)
			}
		}
	}

	@Keyword
	def getpendingRequestCount() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath("//android.view.ViewGroup[@content-desc='banOrange, Cancel Request']")
		println("size": elements.size())
		return elements.size()
	}

	@Keyword
	def tapOnFirstAppoinmentInAlertsPageList(def index = 0) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/firstAppoinmentInAlertsPageList_andriod', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyCancellationMsg(msg, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/cancelApptMsg_android', ['msg': msg]), defaultTime, onFailure)
	}

	@Keyword
	def verifyFirstAppoinmentCancellationMsgIcon(provider, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/firstAppoinmentCancellationMsg_andriod', ['provider' : provider]), defaultTime, onFailure)
	}
	@Keyword
	def verifyAndGetUnreadMsgCount() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), defaultTime, FailureHandling.OPTIONAL)) {
			return Mobile.getText(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), defaultTime)
		}
		else {
			return 0
		}
	}

	@Keyword
	def scrollUntilElementVisible(maxScrollAttempts) {
		Mobile.delay(5)
		def visible = Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), maxScrollAttempts, FailureHandling.OPTIONAL)
		println("visible: $visible")

		int attempts = 0
		while (!visible && attempts < maxScrollAttempts) {
			println("Inside loop: $visible")
			gen.swipeUp()
			attempts++
			visible = Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), maxScrollAttempts - attempts, FailureHandling.OPTIONAL)
		}

		if (!visible) {
			println("Element not found after scrolling.")
			// Add your failure handling logic here
		}
	}

	@Keyword
	def tapOnUnreadMsg() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), defaultTime)
	}

	@Keyword
	def verifyChatTitle() {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Alerts/Chat/chatTitle_android'), "Provider Chat")
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/chatPopupCloseBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProviderName() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/apptProviderName_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureName() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/aaptProcedureName_android'), defaultTime)
	}

	@Keyword
	def verifyDateAndTime() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/apptDateAndTime_android'), defaultTime)
	}

	@Keyword
	def verifyInfoIcon() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/infoIcon_android'), defaultTime)
	}

	@Keyword
	def verifyProviderChatFuctionalityInAlerts() {
		if(isApptCancelLabelExist()== true) {
			Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/apptCompletedMsg_android'), defaultTime)
		}
		else {
			Mobile.verifyElementText(findTestObject('Object Repository/Member/Alerts/Chat/msgField_android'), "Message Provider")
			chat.tapAndSetTxtOnMsgTxtField("Hello! Provider");
			home.verifyElementTxtExist("Hello! Provider");
		}
	}

	@Keyword
	def isApptCancelLabelExist() {
		try {
			return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/Chat/apptCancelLabel_android'), defaultTime)
		} catch (Exception e) {
			return false
		}
	}

	@Keyword
	def verifyExistingMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Alerts/Chat/txtMsg_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/Chat/chatPopupCloseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnrevPrivateInvitation() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/revPrivateInvitation_android'), defaultTime)
	}
	@Keyword
	def tapOnBilledYearlyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/billedYearlyOption_android'), defaultTime)
	}
	@Keyword
	def tapOnBilledQuarterlyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/RevprivateInvitations/billedQuarterlyOption_android'), defaultTime)
	}
	@Keyword
	def enterInputInSearchField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/Alerts/searchField_android'), txt, defaultTime)
		Mobile.hideKeyboard();
	}
	@Keyword
	def verifyHistoryOfMessages(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchResults_android', ['txt': txt]), defaultTime, onFailure);
	}
	@Keyword
	def verifyThankYouForUsingRevDocOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/thankYouForUsingRevDoc_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnThankYouForUsingRevDocOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/thankYouForUsingRevDoc_andriod'), defaultTime)
	}
	@Keyword
	def tapOnStars() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/ratingStars_andriod'), defaultTime)
	}
	@Keyword
	def tapOnSubmitRatingButton() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/submitRating_andriod'), defaultTime)
	}

	@Keyword
	def tapOnCompletedAppoinment(date) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/completedAppoinment_andriod', ['date': date]), defaultTime)
	}

	@Keyword
	def verifyProviderNameInChat(providerProfileName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/Chat/providerName', ['providerName': providerProfileName]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnCloseButton(pageTitle) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/Chat/closeButtons',['sheetTitle': pageTitle]), defaultTime)
	}

	@Keyword
	def tapOnProviderByIndex(index = 0) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/selectChatByIndex_android', ['index': index]), defaultTime);
	}

	//Provider Feedback Form
	@Keyword
	def tapOnStarsInProviderRating(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Feedback Form/starRating_android', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnSubmitRatingBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Feedback Form/submitRating_android'), defaultTime)
	}

	@Keyword
	def verifyFollowUpDetails(promoAmount, inputHours) {
		int expectedHours = (inputHours.toInteger()) - 1;
		String regexPattern = "offer expires in ${expectedHours} hrs 5[1-9] min"

		def actualText = home.ma.getFullText("offer expires in ${expectedHours} hrs");

		if (actualText ==~ regexPattern) {
			KeywordUtil.markPassed("The displayed message is correct: ${actualText}")
		} else {
			KeywordUtil.markFailed("Expected a message matching: '${regexPattern}' but got: '${actualText}'")
		}
		home.ma.verifyElementPresentByText("SPECIAL OFFER!");
		home.ma.verifyElementPresentByText("Rebook today and get \$${promoAmount} off");
		home.ma.verifyElementPresentByText("Rebook now to save!");

		return actualText;
	}

	@Keyword
	def getMessageTxt() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/Chat/revPrivateCancelledMsgTxt_android'), defaultTime);
	}

}

