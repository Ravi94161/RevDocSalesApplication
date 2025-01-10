package provider360

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
import mobile.MobileActions
import providerRegistration.License

public class RevPrivateMedicine {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions mob = new MobileActions()
	License lic = new License()

	@Keyword
	def verifyRevPrivatemedicineOptionPresence() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/revPrivateMedicineOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnRevPrivatemedicineOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/revPrivateMedicineOption_'+os), defaultTime)
	}

	@Keyword
	def verifyRevPrivatemedicineOptionAbsence() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/revPrivateMedicineOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnNextBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/nextBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnMessageStaff() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/messageStaff_android'), defaultTime)
	}

	@Keyword
	def tapOnMyStaff() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/myStaff_andriod'), defaultTime)
	}

	@Keyword
	def sendRevprivateRequest(staffName) {
		verifyRevPrivatemedicineOptionPresence();
		tapOnRevPrivatemedicineOption();
		tapOnNextBtn();
		tapOnMyStaff();
		verifyExistingRevPrivateInvite(staffName)
		verifyInviteRevPrivateStaffBtn();
		tapOnInviteRevPrivateStaffBtn();
		tapAndSetTextOnSearchStaff(staffName);
		//Sending Request to the first Staff Result
		tapOnFirstStaffProvider();
		def name = getFirstStaffProvider();
		tapOnSendStaffInvite();
		Mobile.delay(20)
		tapOnViewPendingRequest();
		Mobile.scrollToText("Pending Request");
		Mobile.scrollToText(name);
		return name;
	}

	@Keyword
	def verifyExistingRevPrivateInvite(staff) {
		if(mob.verifyElementPresentByText(staff, FailureHandling.OPTIONAL) == true) {
			if(mob.verifyElementPresentByText("Cancel Invite", FailureHandling.OPTIONAL) == true) {
				tapOnCancelInviteBtn()
				tapOnCancelInviteBtnOnPopup()
			}
			else {
				verifyRemoveBtn()
				tapOnRemove()
				verifyCalendar()
				tapOnCalendar()
				lic.tapOnConfirmBtn()
				tapOnConfirmRemoval()
				mob.verifyElementPresentByText("You don't have any staff yet")
				Mobile.delay(4)
			}
		}
	}

	@Keyword
	def verifyBackBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/backBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMyStaffProvider(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/myStaffProviderName_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteRevPrivateStaffBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/inviteRevPrivateStaffBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnInviteRevPrivateStaffBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/inviteRevPrivateStaffBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapAndSetTextOnSearchStaff(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/searchStaff_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/searchStaff_android'), text, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyMyPracticeEditOptions(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/myPracticeOptionsEditbtn_andriod', ["text": text]), defaultTime, onFailure)
	}

	@Keyword
	def verifyPendingRequestProvider(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/pendingRequestProviderName_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelInviteBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/cancelInviteBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnViewPendingRequest() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/viewPendingRequest_android'), defaultTime)
	}

	@Keyword
	def tapOnCancelInviteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/cancelInviteBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnProviderCancelInviteBtn(providerName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/providerCancelInviteOpt_android', ["providerName":providerName]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCancelInviteBtnOnPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/cancelinviteBtnOnPopup_andriod'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPopupTitle(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/popUpTitle_andriod'), text)
	}

	@Keyword
	def getFirstStaffProvider() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/firstStaffProvider_android'), defaultTime)
	}

	@Keyword
	def tapOnFirstStaffProvider() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/firstStaffProvider_android'), defaultTime)
	}

	@Keyword
	def verifyNoSearchResult(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/firstStaffProvider_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSendStaffInvite() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/sendStaffInvite_android'), defaultTime)
	}

	@Keyword
	def verifyNoBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/noBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelInviteConfirmBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/cancelinvite_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCancelInviteConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/cancelinvite_andriod'), defaultTime)
	}
	@Keyword
	def verifyRemoveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/removeStaff_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnRemove() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/removeStaff_android'), defaultTime)
	}
	@Keyword
	def verifyCalendar(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/calendarRemoval_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCalendar() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/calendarRemoval_android'), defaultTime)
	}
	@Keyword
	def tapOnConfirmRemoval() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/confirmRemoval_android'), defaultTime)
	}
	@Keyword
	def verifyRevPrivateSetUpBtn(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/revPrivateSetUpBtn_android', ["text": text]), defaultTime, onFailure)
	}
	@Keyword
	def TapOnRevPrivateSetUpBtn(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/revPrivateSetUpBtn_android', ["text": text]), defaultTime, onFailure)
	}
	@Keyword
	def clearPerMemberRateTxt() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/ratePerMonthTxtFieldInPerMemberRate_android'), defaultTime);
	}
	@Keyword
	def setPerMemeberRate(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/ratePerMonthTxtFieldInPerMemberRate_android'), text, defaultTime);
	}
	@Keyword
	def clearNumberOfRevPrivateMemberTxtField() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/numberOfRevPrivateMemberTxtField_android'), defaultTime);
	}
	@Keyword
	def setNumberOfRevPrivateMember(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/numberOfRevPrivateMemberTxtField_android'), text, defaultTime);
	}
	@Keyword
	def clearRevPrivateDeliveryMethodTxtField() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/revPrivateDeliveryMethodTxtField_android'), defaultTime);
	}
	@Keyword
	def setRevPrivateDeliveryMethodTxtField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/revPrivateDeliveryMethodTxtField_android'), text, defaultTime);
	}

	@Keyword
	def setMemeberAgeFromTxtField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/memberAgeFromTxtField_android'), text, defaultTime);
	}
	@Keyword
	def setMemeberAgeToTxtField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/memberAgeToTxtField_android'), text, defaultTime);
	}
	@Keyword
	def tapOnProcedureAttestationCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/procedureAttestationCheckBx_android'), defaultTime)
	}
	@Keyword
	def getPerMonthMemberRate() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyPractice/getPerMonthMemberRate_android'), defaultTime);
	}
	@Keyword
	def setTextInSearchStaffInputField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/MyStaff/searchStaffInputField_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}
	//------------------------------------------start-rev private Official link--------------------------------------------------------------------------------------------------------------
	@Keyword
	def verifyVisitTheRevPrivateWebsiteLink(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/visitTheRevPrivateWebsiteLink_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnVisitTheRevPrivateWebsiteLink(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/visitTheRevPrivateWebsiteLink_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyUrlLocationBarOnChrome(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/locatonBarOnChrome_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyOfficialRevPrivateWebsite(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/officialRevPrivateWebsite_android'),defaultTime, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/officialRevPrivateWebsite_android'), defaultTime, onFailure)
	}
	//------------------------------------------end-rev private Official link--------------------------------------------------------------------------------------------------------------


	// Complete the sign up of RevPrivate
	@Keyword
	def tapOnsetUpBtnRevPrivate(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/setUpBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def tapOnSaveBtnRevPrivate() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/saveBtn_android'), defaultTime);
		Mobile.delay(5);
	}

	@Keyword
	def typeInLocationMilesInput(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/locationMilesInput_android'),text, defaultTime)
	}
	
	@Keyword
	def tapOnDeliveryMethodAndLocationEditIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Revprivate Medicine/editIconLocation_android'), defaultTime);
	}
}
