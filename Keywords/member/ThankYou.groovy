package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.internal.runners.statements.FailOnTimeout

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import mobile.MobileActions

public class ThankYou {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE

	MobileActions  ma = new MobileActions()

	@Keyword
	def verifyThankYouTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouTitle_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouTitle_android'), 'Thank You', onFailure);
	}

	@Keyword
	def verifyThankYouTitleExists(isExist = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouTitle_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouTitle_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifyThankYouForYourPurchaseText(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouMsg_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/thankYouMsg_android'), 'Thank you for your purchase',onFailure);
	}

	@Keyword
	def getApptItemName(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/ThankYou/apptTitle_android', ['index': index]), defaultTime,onFailure);
	}

	@Keyword
	def getApptPrice(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/ThankYou/apptPrice_android', ['index': index]), defaultTime,onFailure);
	}

	@Keyword
	def VerifyProcedureExistUnderPaymentSummary(procedureName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Payment Summary')
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/ThankYou/procedureNameUnderPaymentSummary_android',['procedureName': procedureName]), defaultTime, onFailure)
	}

	@Keyword
	def getApptPriceUnderPaymentSummary(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/ThankYou/itemPriceUnderPaymentSummary_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getTotalPriceUnderPaymentSummary() {
		Mobile.scrollToText('Order Total', FailureHandling.OPTIONAL);
		def actualPrice = Mobile.getText(findTestObject('Object Repository/Member/Cart/ThankYou/totalPriceUnderPaymentSummary_android'), defaultTime);
		actualPrice = actualPrice.trim();
		return actualPrice;
	}


	@Keyword
	def tapOnContinueToHealthRecordsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/continueToHealthRecordsBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnNoChangesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/noChangeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyNonStikeAmtofAppt(price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/itemPriceNonStrikeAmt_android', ['index': index]), price, onFailure);
	}

	@Keyword
	def verifyNonStikeApptPriceUnderPaymentSummary(price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/nonStrikeItemPriceUnderPaymentSummary_android', ['index': index]), price, onFailure);
	}

	@Keyword
	def verifyRevplusSavingsPrice(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Rev+ Savings', onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/revplusSavingsPrice_android'), price, onFailure);
	}

	@Keyword
	def verifyRevPrivateSavingsPrice(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('RevPrivate Savings', onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/ThankYou/revPrivateSavingsPrice_android'), price, onFailure);
	}

	@Keyword
	def tapRemindMeLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/remindMeLaterBtn_android'), defaultTime);
	}

	@Keyword
	def tapRemindMeLaterOrNoChangesButton(defaultTime = defaultTime) {
		def exists = Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/ThankYou/noChangeBtn_android'), defaultTime, FailureHandling.OPTIONAL)
		if (exists) {
			tapOnNoChangesBtn();
		} else if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/ThankYou/remindMeLaterBtn_android'), defaultTime, FailureHandling.OPTIONAL)) {
			tapRemindMeLaterBtn();
		}
	}
	@Keyword
	def tapOnCompleteNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/completeNowBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddressAndInstruction(deliveryMethod, index, text) {
		Mobile.delay(5)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Thank You Screen/verifyAddress_android',['index':index, , "deliveryMethod": deliveryMethod]), text)
	}

	@Keyword
	def verifyAddressAndInstructionInReceipts(dm,index, text) {
		Mobile.delay(3)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Checkout Screen/verifyAddress_android',['dm': dm,'index':index]), text)
	}

	@Keyword
	def verifyAddressInstructionInReceipts(modifiedAddress, instruction, dm, modifiedAddressIndex = 1, instructionIndex = 2) {
		verifyAddressAndInstructionInReceipts(dm, modifiedAddressIndex, modifiedAddress);
		verifyAddressAndInstructionInReceipts(dm, instructionIndex, instruction);
	}

	@Keyword
	def tapOnDoneBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/doneBtn_android'), defaultTime)
		} catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Member/Appointments/Thank You Screen/continueBtn_android'), defaultTime);
		}
	}

	// Sync Calendar

	@Keyword
	def verifyYesSyncBtnExists(isExists = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/Cart/ThankYou/SyncCalendar/yesSync_android')
		def description = "Would you like to sync appointments to your phone’s calendar?"
		def sectionName = "Sync to Calendar"
		if(isExists) {
			ma.verifyElementPresentByText(sectionName, onFailure)
			ma.verifyElementPresentByText(description, onFailure)
			ma.verifyElementPresentByText("Sync to Calendar", onFailure)
			Mobile.verifyElementExist(obj, defaultTime, FailureHandling.STOP_ON_FAILURE)
		} else  {
			ma.verifyElementNotPresentByText(sectionName, onFailure, 5)
			ma.verifyElementNotPresentByText(description, onFailure, 5)
			Mobile.verifyElementNotExist(obj, defaultTime, FailureHandling.STOP_ON_FAILURE)
		}
	}

	@Keyword
	def tapOnYesSyncBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/SyncCalendar/yesSync_android'), defaultTime)
	}

	@Keyword
	def acceptCalendarPermission(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/allowPopUp_android'), defaultTime, onFailure)
		ma.verifyElementPresentByText("Allow RevDoc to access your calendar?", onFailure)
		Mobile.tap(findTestObject('Object Repository/allowPopUp_android'), defaultTime, onFailure);
	}

	@Keyword
	def dontAllowCalendarPermission(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/dontAllowPopUp_andriod'), defaultTime, onFailure)
		ma.verifyElementPresentByText("Allow RevDoc to access your calendar?", onFailure)
		Mobile.tap(findTestObject('Object Repository/dontAllowPopUp_andriod'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnContinueToInviteFriends() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/continueToInviteFriends_andriod'), defaultTime)
	}

	@Keyword
	def tapOnXbtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/searchClose_android'), defaultTime)
	}
	
	@Keyword
	def enterTheMessageToInvitees(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Cart/ThankYou/messageToInvitees_andriod'), text, defaultTime)
	}
	
	@Keyword
	def tapOnAddBtn() {
		Mobile.scrollToText("Add", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/addBtn_andriod'), defaultTime);
	}
	
	@Keyword
	def tapOnPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/plusBtn_andriod'), defaultTime)
	}
	
	@Keyword
	def tapOnSaveImages() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/ThankYou/saveImagesBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Thank You Screen/continueBtn_android'), defaultTime);
	}

}
