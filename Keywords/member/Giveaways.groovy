package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import mobile.MobileActions

public class Giveaways {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;

	MobileActions ma = new MobileActions();

	@Keyword
	def scrollToGiveAwayAndSelect(giveAwayname, title = "Auto Giveaways") {
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android',['title':title]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.scrollToText(title, FailureHandling.OPTIONAL)
		}
		Mobile.scrollToText(giveAwayname, FailureHandling.OPTIONAL)
		ma.tapOnElementByText(giveAwayname, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def VerifyGiveAwayDetailsImage(expectedImagePath) {
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/Giveaways/giveAwayImageOnDetails_android')
		ma.verifyScreenshotMatchesWithElementScreenshot(expectedImagePath, testObject);
	}

	@Keyword
	def verifyTermsAndConditionsCbxChecked(isChecked = true, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject emptyCbx = findTestObject('Object Repository/Member/HomePage/Giveaways/emptyTermsAndConditionsCbx_android')
		TestObject filledCbx = findTestObject('Object Repository/Member/HomePage/Giveaways/filledTermsAndConditionsCbx_android')
		isChecked ? Mobile.verifyElementExist(filledCbx, defaultTime, onFailure) :  Mobile.verifyElementExist(emptyCbx, defaultTime, onFailure)
	}

	@Keyword
	def tapOnTermsAndConditionsCbx() {
		TestObject emptyCbx = findTestObject('Object Repository/Member/HomePage/Giveaways/emptyTermsAndConditionsCbx_android')
		Mobile.tap(emptyCbx, defaultTime)
	}

	@Keyword
	def tapOnTermsAndConditionsLink() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/termsAndConditionsLink_android')
		def eHeight = Mobile.getElementHeight(obj, defaultTime)
		def eWidth = Mobile.getElementWidth(obj, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(obj, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(obj, defaultTime)

		def x = (eLeftPos + (eWidth - 20)).toInteger()
		def y = (eTopPos + (eHeight/2)).toInteger()

		println("x": x)
		println("y": y)
		Mobile.tapAtPosition(x, y)
		//		Mobile.tap('Object Repository/Member/HomePage/Giveaways/termsAndConditionsLink_android', defaultTime)
	}

	@Keyword
	def getYourCurrentChoicesToWinCount() {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Giveaways/yourCurrentChoicesToWinCount_android'), defaultTime)
	}

	@Keyword
	def tapOnSignUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Giveaways/signUpBtn_android'), defaultTime)
	}

	@Keyword
	def verifySignUpBtnExists(isExist = true, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/signUpBtn_android')
		isExist ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifySignUpBtnEnabled(isEnabled = false) {
		isEnabled = isEnabled ? 'true' : 'false'
		TestObject signUpBtn = findTestObject('Object Repository/Member/HomePage/Giveaways/signUpBtn_android')
		Mobile.verifyElementAttributeValue(signUpBtn, 'enabled', isEnabled, defaultTime)
	}

	@Keyword
	def tapOnInviteFriendsBtn() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/inviteFriends_android')
		ma.scrollUntilElementIsVisible(obj)
		Mobile.tap(obj, defaultTime)
	}

	@Keyword
	def additionalChangeToWinForEachFriendInvitedCount(count, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/additionalChanceToWinForEachFriendInvitedCount_android', ['count': count]), defaultTime, onFailure)
	}

	@Keyword
	def additionalChangeToWinForEachFriendInvitedWhoBecodeRevPlusOrAffiliateCount(count, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/additionalChancesToWinWhoBecomeRevplusORAffiliate_android', ['count': count]), defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteFriendsBtnExists(isExist = true, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/inviteFriends_android')
		isExist ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteFriendsBtnEnabled(isEnabled = false) {
		isEnabled = isEnabled ? 'true' : 'false'
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/inviteFriends_android')
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime)
	}

	@Keyword
	def tapOnFollowUsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Giveaways/followUsBtn_android'), defaultTime)
	}

	@Keyword
	def verifyFollowUsBtnExists(isExist = true, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/followUsBtn_android')
		isExist ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyFollowUsBtnEnabled(isEnabled = false) {
		isEnabled = isEnabled ? 'true' : 'false'
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/followUsBtn_android')
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime)
	}

	@Keyword
	def followUsAdditionalChangeToWinCount(count, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/followUsAdditionalChancesToWinCount_android', ['count': count]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCalenderIconExist(defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/calenderIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyGreenCheckExist(defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/greenCheck_andorid'), defaultTime, onFailure)
	}
	//Invite Code Applied popup

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/InviteCodeApplied/closeBtn_android'), defaultTime)
	}

	@Keyword
	def getGiveawayCriteriaDetails(giveawayData, searchKey) {
		def criteria = giveawayData.criterias.find { it.criteriaKey == searchKey }
		def textOnButton =  criteria ? criteria.textOnButton : "text On button criteria not found"
		def criteraCount =  criteria ? criteria.chancesToWin : "Chances to win criteria not found"
		def criteriaLabel = criteria ? criteria.criteriaLabel : "criteriaLabel criteria not found"
		def criteriaDescription = criteria ? criteria.criteriaDescription : "criteriaDescription criteria not found"

		return [textOnButton: textOnButton, criteraCount: criteraCount, criteriaLabel: criteriaLabel, criteriaDescription: criteriaDescription]
	}

	@Keyword
	def tapOnGiveawayBtn(buttonName) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/giveAwaysBtns_android', ['name': buttonName])
		//		ma.scrollUntilElementIsVisible(obj)
		Mobile.scrollToText(buttonName)
		Mobile.tap(obj, defaultTime)
	}

	@Keyword
	def scrollToGiveawayBtn(buttonName, iterations = 2) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/giveAwaysBtns_android', ['name': buttonName])
		ma.scrollUntilElementIsVisible(obj, iterations)
	}

	@Keyword
	def verifyGiveawayBtnEnabled(buttonName, isEnabled = false) {
		isEnabled = isEnabled ? 'true' : 'false'
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/giveAwaysBtns_android', ['name': buttonName])
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime)
	}

	@Keyword
	def verifyGiveawayCriteraBtnExists(buttonName, isExist = true, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/giveAwaysBtns_android', ['name': buttonName])
		isExist ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyGiveAwayChanceToWinCount(criteraName, count, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Giveaways/giveawayCriteraChancesToWinCount_android', ['name': criteraName, 'count': count]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnTermsAndConditionsHyperLink(text) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/termAndConditionsHperLink_android', ['text': text])
		def eHeight = Mobile.getElementHeight(obj, defaultTime)
		def eWidth = Mobile.getElementWidth(obj, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(obj, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(obj, defaultTime)

		def x = (eLeftPos + (eWidth) - 100).toInteger()
		def y = (eTopPos + (eHeight/2) -10).toInteger()

		println("x": x)
		println("y": y)
		Mobile.tapAtPosition(x, y)
	}

	@Keyword
	def tapOnTermsAndConditionsBody(text) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/Giveaways/termsAndConditionsParas_android')
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement>  elements = driver.findElementsByXPath("//android.view.ViewGroup[@resource-id='p']")
		println("size": elements.size())
		for (WebElement element : elements) {
			println("text1" : element.getText())
			Mobile.waitForElementPresent(obj, 10)
			if (text.contains(element.getText())) {
				Mobile.verifyMatch(text, ".*${element.getText()}.*", true)
				Mobile.comment('The text contains the expected substring.')
			} else {
				Mobile.comment('The text does not contain the expected substring.')
				// You can also fail the test if the text does not contain the expected substring
				Mobile.verifyMatch(text, ".*${element.getText()}.*", true)
			}
		}
	}
}
