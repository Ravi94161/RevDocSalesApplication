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

import internal.GlobalVariable

public class Revcash {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnRevCashTab(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.delay(2);
		Mobile.scrollToText("RevCash", FailureHandling.OPTIONAL);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/revCash_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/revCash_android'), defaultTime);
	}

	@Keyword
	def verifyRevCashTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("RevCash", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/revCash_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOninviteFriendsTab() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Revcash/inviteFriends_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Revcash/inviteFriends_android'), defaultTime);
	}

	@Keyword
	def verifyInviteFriendsTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/inviteFriends_android'), defaultTime, onFailure)
	}

	@Keyword
	def getTotalRevcash() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/Revcash/MyRevCash/totalRevcash_android'), defaultTime);
	}

	@Keyword
	def getYearRevcash(year) {
		try {
			return Mobile.getText(findTestObject('Object Repository/Member/Member360/Revcash/MyRevCash/yearRevCash_android', ['year': year]), 10, FailureHandling.OPTIONAL);
		}
		catch (Exception e) {
			println("I agree element not found")
			return 0;
		}
	}

	@Keyword
	def getUniqueCode() {
		//return Mobile.getText(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/uniqueCode_android'), defaultTime);
		tapOnRevFriendsTab();
		tapOnInviteorShareAndEarnBtn()
		Mobile.delay(3);
		return getInviteFrdLink()
	}

	@Keyword
	def tapOnBack() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Revcash/backBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Revcash/backBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnRevFriendsTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/revFriendsTab_android'), defaultTime);
	}

	@Keyword
	def verifyRevFriendsTab(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/revFriendsTab_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyOptionsTitle(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/optionsTitle_andriod', ['title': title]), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevcashPageTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/revCashTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyImageInOptions(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/imageLayout_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyTermsAndConditionOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/termsAndConditions_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnTermsAndConditions() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Revcash/termsAndConditions_andriod'), defaultTime)
	}

	@Keyword
	def verifyTermsAndConditionPageTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/termsAndConditionsPageTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Revcash/closeBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyTotalRevCashOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/MyRevCash/totalRevcash_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyYearRevCashOpt(year, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		try{
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/MyRevCash/yearRevCash_android', ['year': year]), defaultTime, onFailure)
		}
		catch(Exception e) {
		}
	}

	@Keyword
	def verifyCopyBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/copyBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyReferenceCode(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/uniqueCode_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyShareBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/shareBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnShareBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/shareBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifySharingPopup(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/InviteFriends/sharingPopUp_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyFriendsInRevFriendsTab(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Revcash/revFriends/friendsList_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def getRevCashAmount(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Revcash/revcashAmount_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnInviteorShareAndEarnBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/inviteFriendTab/inviteorShareAndEarnBtn_android'), defaultTime);
	}

	@Keyword
	def getInviteFrdLink() {
		def textAndLink = Mobile.getText(findTestObject('Object Repository/Member/Member360/inviteFriendTab/getInviteFrdLink_android'), defaultTime)
		def matcher = textAndLink =~ /(https?:\/\/[^\s]+)/
		def link = matcher.find() ? matcher.group(0) : null
		return link;
	}

	@Keyword
	def getInviteFrdTextAndLink() {
		def textAndLink = Mobile.getText(findTestObject('Object Repository/Member/Member360/inviteFriendTab/getInviteFrdLink_android'), defaultTime)
		return textAndLink;
	}

	@Keyword
	def tapOnReferralProgramTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/inviteFriendTab/referralProgramTab_android'), defaultTime)
	}

	@Keyword
	def verifyInviteorShareAndEarnBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/inviteFriendTab/inviteorShareAndEarnBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/inviteFriendTab/inviteorShareAndEarnBtn_android'), defaultTime, onFailure);
		}
	}
}
