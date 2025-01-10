package provider

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import mobile.Generic
import mobile.MobileActions

public class HomePage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	MobileActions ma = new  MobileActions()


	@Keyword
	def verifyOpenTasksTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/openTasksTitle_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifynpName(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(name, FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/npName_android', ['value': name]), defaultTime, onFailure)
	}

	@Keyword
	def verifySupervisorRequest(name, supervisor, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(supervisor, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/supervisorRequestOpenTask_'+os, ['value': name]), defaultTime, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/supervisorRequestOpenTaskTimeLimit_'+os, ['value': supervisor]), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/infoOnSupervisorRequest_'+os), "Call the candidate directly if you wish to interview them.", onFailure);
	}

	@Keyword
	def verifySupervisorRequestAbsence(name, supervisor, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 45) {
		Mobile.delay(6);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/supervisorRequestOpenTaskTimeLimit_'+os, ['value': supervisor]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAcceptBtn(name,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/acceptBtn_'+os, ['name': name]), defaultTime, onFailure)
	}
	@Keyword
	def verifyAcceptBtnNotExist(name,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/acceptBtn_'+os, ['name': name]), defaultTime, onFailure)
	}
	@Keyword
	def verifyDenyBtn(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/denyBtn_android', ['name': name]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnDenyBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/denyBtn_android', ['name': name]), defaultTime)
	}

	@Keyword
	def verifyHomeIconExists(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/homeIcon_'+os), defaultTime, onFailure)
	}
	@Keyword
	def tapOnHomeIconExists() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/homeIcon_'+os), defaultTime)
	}
	@Keyword
	def verifyFilterByDrpdwn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/filterByDrpdwn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnFilterByDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/filterByDrpdwn_android'), defaultTime)
	}

	@Keyword
	def tapOnPatientOptionInDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/patientOptionInDrpdwn_'+os), defaultTime)
	}

	@Keyword
	def tapOnApplyFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/applyFilterBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnMemberProfileName(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/memberProfileName_'+os, ['name': name]), defaultTime)
	}

	@Keyword
	def tapOnTaskType(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/taskType_android', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def verifyElementVisible(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/HomePage/taskType_android', ['name': name]),defaultTime, onFailure)
	}

	@Keyword
	def verifyElementPresentInTheDropDown(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/taskTypeInDropDown_android', ['name': name]),defaultTime, onFailure)
	}

	@Keyword
	def tapOnElementPresentInTheDropDown(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/taskTypeInDropDown_android', ['name': name]),defaultTime, onFailure)
	}

	@Keyword
	def tapOnRevDocEHRReviewBtn(dateTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtn_'+os, ['dateTime': dateTime]), defaultTime)
	}

	@Keyword
	def scrollToRevDocEHRReviewBtn(dateTime) {
		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtn_'+os, ['dateTime': dateTime]), defaultTime)) {
			at1.gen.swipeUp();
		}
		Mobile.scrollToText(dateTime);
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtn_'+os, ['dateTime': dateTime]), defaultTime)
	}

	@Keyword
	def verifyMembeNameInEHR(memberName){
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/EHR/memberName'), memberName, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnYesCancelApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/cancelApptBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnNoConfirmApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/confirmApptBtn_android'), defaultTime)
	}

	@Keyword
	def getApptCancelCnfmText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/getApptCancelCnfmText_'+os), defaultTime);
	}

	@Keyword
	def tapOnSendCancellationMessageBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/sendCancellationMessageBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnSendConfirmationMessageBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/sendConfirmationMessageBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnIAgreeBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/HomePage/iAgreeBtn_'+os), defaultTime);
		}
		catch (Exception e) {
			println("I agree element not found")
		}
	}

	@Keyword
	def tapOnAllowPopUp() {
		try {
			Mobile.tap(findTestObject('Object Repository/allowPopUp_'+os), defaultTime);
		}
		catch (Exception e) {
			println("Popup not found")
		}
	}

	@Keyword
	def getApptConfirmationMessage() {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/confirmApptMessageEditText_android'), defaultTime);
	}

	@Keyword
	def verifyJoinRevolutionText(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/SignUp/joinTheRevolutionText_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementTxtExist(txt, onFailure=FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementTxtNotExist(txt, onFailure=FailureHandling.OPTIONAL, defaultTime = 10) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnElementTxt(txt) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/verifyElementTxt_android',["txt":txt]), defaultTime, FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	def tapOnCalendarIcon(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/calendarIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnCalendarAndVerifySpinningIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/calendarIcon_android'), defaultTime);
		Mobile.waitForElementPresent(findTestObject('Object Repository/revdocLoadingIcon_android'), 5, FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/revdocLoadingIcon_android'), 3, FailureHandling.OPTIONAL)
	}
	@Keyword
	def getAppointmentTimeOnProviderEHR() {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/getAppointmentTime_android'), defaultTime);
	}

	@Keyword
	def verifyElementWithTextExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/elementText_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyElementWithTextNotExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/elementText_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyAvatarExistsInEHR(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/EHR/avatar_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSignNoteBtn(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/signNoteBtn_android', ['memberName': memberName]), defaultTime);
	}

	@Keyword
	def getProviderNameForSignNote() {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/getProviderName_android'), defaultTime)
	}

	@Keyword
	def getApptDateAndTime() {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/getApptDateAndTime_android'), defaultTime)
	}
	@Keyword
	def verifyUpdateCalendarBtn() {
		Mobile.scrollToText("Update Calendar", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/updateCalendarBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnUpdateCalendarBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/updateCalendarBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def	tapOnUpdateLicenseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/License/updateLicense_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def	tapOnUpdateBtnAfterUpdating() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/License/updateBtnAfterUpdating_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyOpenTaskCardsOnHomePage(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/openTaskCards_android', ["index":index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyReviewRevPrivatePracticeBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/reviewRevPrivatePracticeBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnReviewRevPrivatePracticeBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/reviewRevPrivatePracticeBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnAcceptBtn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/acceptBtn_android', ['index': index]), defaultTime);
		Mobile.delay(10)
	}
	@Keyword
	def tapOnAcceptBtnUsingName(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/superviseeAcceptBtnByName_android', ['name': name]), defaultTime)
	}
	@Keyword
	def tapOnrevPrivateStartDateField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/revPrivateStartDateField_android'), defaultTime);
	}
	@Keyword
	def tapOnConfirmBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/confirmBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSendApprovalBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/sendApprovalBtn_android'), defaultTime);
		Mobile.delay(20);
	}
	@Keyword
	def tapOnAdministrativeBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/administrativeBtn_android'), defaultTime);
	}

	//  -----------  Start Follow up ----------
	@Keyword
	def tapOnFollowUpBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpBtnByMemberName_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyFollowUpBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpBtnByMemberName_android', ['memberName': memberName]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilFollowUpBtnByMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		while(!(verifyFollowUpBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnFollowUpBtnByMemberName(memberName)
	}

	@Keyword
	def verifyCloseBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/closeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyBottomSheetTitleText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/FollowUp/bottomSheetTitle_android'), text, onFailure)
	}

	@Keyword
	def typePatientFolllowUpText(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpTextBox_android'), text, defaultTime)
	}

	@Keyword
	def tapPatientFollowUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/FollowUp/patientFollowUpBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyPatientFollowUpBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/patientFollowUpBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyFollowUpAppointmentText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpAppointmentText_android'), defaultTime)
	}

	@Keyword
	def verifyFollowUpText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpText_android', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyFollowUpNoButton() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpNoButton_android'), defaultTime)
	}
	@Keyword
	def verifyFollowUpYesButton() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpYesButton_android'), defaultTime)
	}
	@Keyword
	def verifyClickingCloseButton(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/closeBtn_android',['index': index]), defaultTime);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpNoButton_android'), defaultTime)
	}
	@Keyword
	def verifyClickingNoButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpNoButton_android'), defaultTime)
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/followUpNoButton_android'), defaultTime)
	}
	@Keyword
	def scrollToTelemedicineFollowUpBtnByDateAndMemberName(memberName, date, iteration) {

		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/telemedicinefollowUpBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, FailureHandling.OPTIONAL) && iteration > 0) {
			Mobile.scrollToText(date, FailureHandling.OPTIONAL)
			gen.swipeUpLittle();
			iteration--;
		}
	}
	@Keyword
	def verifyTelemedicineFollowUpBtnByDateAndMemberName(memberName, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/telemedicinefollowUpBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, onFailure)
	}
	@Keyword
	def verifyTelemedicineFollowUpBtnByDateAndMemberNameNotExist(memberName, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/telemedicinefollowUpBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, onFailure)
	}
	//  -----------  End Follow up ----------


	//  -----------  Start Sign Note ----------
	@Keyword
	def tapOnSignNoteBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/signNoteBtnByMemberName_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def tapOnSignSupervisorNoteBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/signSupevisorNote_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def tapOnViewNoteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/viewNoteBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifySignNoteBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/SignNote/signNoteBtnByMemberName_android', ['memberName': memberName]), defaultTime, onFailure)
	}

	@Keyword
	def verifySignSupervisorNoteBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/SignNote/signSupevisorNote_android', ['memberName': memberName]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilSignNoteWithMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		def value = verifySignNoteBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 10)
		println("value": value)
		while(!(verifySignNoteBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnSignNoteBtnByMemberName(memberName)
	}

	@Keyword
	def tapOnSignNoteBtnByMemberAndDeliveryMethodName(memberName, deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/signNoteBtnByMemberAndDeliveryMethod_android', ['memberName': memberName, 'deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifySignNoteBtnByMemberAndDeliveryMethodNameExist(memberName, deliveryMethod, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/SignNote/signNoteBtnByMemberAndDeliveryMethod_android', ['memberName': memberName, 'deliveryMethod': deliveryMethod]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilSignNoteWithMemberAndDeliveryMethodNameAndTap(memberName, deliveryMethod, maxIterations = 1) {
		def iteration = 1
		def value = verifySignNoteBtnByMemberAndDeliveryMethodNameExist(memberName, deliveryMethod, FailureHandling.OPTIONAL, 10)
		println("value": value)
		while(!(verifySignNoteBtnByMemberAndDeliveryMethodNameExist(memberName, deliveryMethod, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnSignNoteBtnByMemberAndDeliveryMethodName(memberName, deliveryMethod)
	}

	@Keyword
	def getProcedureNameForSignNoteCardByMemberAndDeliveryMethodName(memberName, deliveryMethod) {
		Mobile.getText(findTestObject('Object Repository/Provider/HomePage/SignNote/procedureNameFromSignCardByMemberAndDeliveryMethod_android', ['memberName': memberName, 'deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def tapOnSignNoteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/signNoteBtn_android'), defaultTime);
	}
	@Keyword
	def verifySignNoteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/signNoteBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTelemedicineSignNoteBtnByDateAndMemberName(memberName, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/teleMedicineSignNoteBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnTelemedicineSignNoteBtnByDateAndMemberName(memberName, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/FollowUp/teleMedicineSignNoteBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, onFailure)
	}

	@Keyword
	def scrollToTelemedicineSignNoteBtnByDateAndMemberName(memberName, date, iteration) {

		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/teleMedicineSignNoteBtnByDateAndMemberName_andriod', ["memberName": memberName, "date": date]), defaultTime, FailureHandling.OPTIONAL) && iteration > 0) {
			Mobile.scrollToText(date, FailureHandling.OPTIONAL)
			gen.swipeUpLittle();
			iteration--;
		}
	}

	//  -----------  End Sign Note ----------

	//  -----------  Start Enroute Note ----------
	@Keyword
	def tapOnEnrouteBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Enroute/EnrouteBtnByMemberName_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyEnrouteBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Enroute/EnrouteBtnByMemberName_android', ['memberName': memberName]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilEnrouteBtnByMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		while(!(verifyEnrouteBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnEnrouteBtnByMemberName(memberName)
	}

	@Keyword
	def verifyNoCancelBtnOnEnroutePopupExist(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Enroute/noCancelBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapNoCancelBtnOnEnroutePopupExist() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Enroute/noCancelBtn_android'), defaultTime)
	}

	@Keyword
	def verifyOnMyWayBtnOnEnroutePopupExist(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Enroute/onMyWayBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMyWayBtnOnEnroutePopupExist() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Enroute/onMyWayBtn_android'), defaultTime)
	}

	@Keyword
	def getTimeFromEnrouteCardByMemberName(memberName) {
		Mobile.getText(findTestObject('Object Repository/Provider/HomePage/Enroute/timeFromEnrouteCardByMemberName_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Enroute/doneBtn_android'), defaultTime)
	}

	//  -----------  End Enroute  ----------

	//  -----------  Start Arrived Card ----------

	@Keyword
	def tapOnArrivedBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Arrived/arrivedBtnByMemberName_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyArrivedBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Arrived/arrivedBtnByMemberName_android', ['memberName': memberName]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilArrivedBtnByMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		while(!(verifyArrivedBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnArrivedBtnByMemberName(memberName)
	}

	@Keyword
	def tapOnArrivedBtnByMemberNameAndTime(memberName, time) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Arrived/arrivedBtnByMemberNameAndTime_android', ['memberName': memberName, 'time': time]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyArrivedBtnByMemberNameAndTimeExist(memberName, time, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Arrived/arrivedBtnByMemberNameAndTime_android', ['memberName': memberName, 'time': time]), defaultTime, onFailure)
	}

	@Keyword
	def scrollUntilArrivedBtnByMemberNameAndTimeAndTap(memberName, time, maxIterations = 1) {
		def iteration = 1
		while(!(verifyArrivedBtnByMemberNameAndTimeExist(memberName, time, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnArrivedBtnByMemberNameAndTime(memberName, time)
	}

	//  -----------  End Arrived Card ----------

	//  -----------  Start Revdoc Review EHR Card ----------

	@Keyword
	def tapOnRevDocEHRReviewByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/FollowUp/revDocEHRReviewMemberNameAndTIme_andorid', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifyRecDocEHRReviewByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/FollowUp/revDocEHRReviewMemberNameAndTIme_andorid', ['memberName': memberName]), defaultTime, onFailure)
	}
	@Keyword
	def scrollUntilRevdocEHRReviewByMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		while(!(verifyRecDocEHRReviewByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnRevDocEHRReviewByMemberName(memberName)
	}

	@Keyword
	def verifyRecDocEHRReviewByDateTimeExist(dateTime, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtn_'+os, ['dateTime': dateTime]), defaultTime, onFailure)
	}

	@Keyword
	def scrollToRevDocEHRReviewBtnByDateTimeAndTap(dateTime, maxIterations = 1) {
		def iteration = 1
		while(!(verifyRecDocEHRReviewByDateTimeExist(dateTime, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			println("iteration": iteration)
			gen.swipeUp();
		}
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtn_'+os, ['dateTime': dateTime]), defaultTime)
	}

	@Keyword
	def tapOnIHaveArrivedBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Arrived/iHaveArrivedBtn_android'), defaultTime)
	}

	@Keyword
	def verifyRevDocLoadingLogo(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/revdocLoadingIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAnyRevDocEHRReviewBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/anyRevDocEHRReviewBtn_android', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyAnyRevDocEHRReviewBtn(index, onFailure = FailureHandling.OPTIONAL) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/anyRevDocEHRReviewBtn_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRevDocEHRReview(member) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtnBasedOnMember_android', ['member': member]), defaultTime)
	}
	@Keyword
	def tapOnMessagePatientBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/messagePatientBtn_android'), defaultTime);
	}
	@Keyword
	def verifyPatientHealthRecordExist(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/patientHealthRecordBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAppointmentNotesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/appointmentNotesBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAppointmentNotesBtnExist(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/appointmentNotesBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCancelAptExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/cancelApptBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyConfirmAptExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/confirmApptBtn_android'), defaultTime, onFailure);
	}
	//verifying appointment cancellation pop up screen
	@Keyword
	def verifySendCancellationMessageBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/sendCancellationMessageBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyApptCancelCnfmText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/getApptCancelCnfmText_'+os), defaultTime);
	}

	//  -----------  Start Join call ----------
	@Keyword
	def tapOnJoinCallBtnByMemberName(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/joinCallBtn_android', ['memberName': memberName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifyJoinCallBtnByMemberNameExist(memberName, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/joinCallBtn_android', ['memberName': memberName]), defaultTime, onFailure)
	}
	@Keyword
	def scrollUntilJoinCallBtnByMemberNameAndTap(memberName, maxIterations = 1) {
		def iteration = 1
		while(!(verifyJoinCallBtnByMemberNameExist(memberName, FailureHandling.OPTIONAL, 3)) && iteration <= maxIterations) {
			iteration = iteration + 1;
			println("iteration": iteration)
			gen.swipeUp();
		}
		tapOnJoinCallBtnByMemberName(memberName)
	}
	@Keyword
	def tapOnWhileUsingTheApp(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/JoinCallPopup/allowRecordAudioPopUp_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMenuOptionInCallScreen(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/menuOption_android'), 50);
	}
	@Keyword
	def verifyMenuOptionOfCallScreenNotPresent(){
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/menuOption_android'), 50);
	}
	@Keyword
	def tapOnMenuOptionInCallScreen(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/menuOption_android'), 50);
	}

	@Keyword
	def verifyMicInMuteState(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/muteIcon_android'), 10);
	}
	@Keyword
	def verifyMicInUnMuteState(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/unMuteIcon_android'), 50);
	}
	@Keyword
	def tapOnMuteIcon(){
		Mobile.doubleTap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/muteIcon_android'), 50);
	}
	@Keyword
	def tapOnUnMute(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/unMuteIcon_android'), 50);
	}
	@Keyword
	def verifyVideoCameraIsOn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/videoCameraOnIcon_android'), 50);
	}
	@Keyword
	def tapToOffVideoCamera(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/videoCameraOnIcon_android'), 50);
	}
	@Keyword
	def verifyVideoCameraIsOff(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/videoCameraOffIcon_android'), 50);
	}

	@Keyword
	def tapToOnVideoCamera(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/videoCameraOffIcon_android'), 50);
	}
	@Keyword
	def verifyCameraFlipIconExists(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/cameraFlipIcon_android'), 50);
	}
	@Keyword
	def verifyEndCallBtnExists(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/callEndBtn_android'), defaultTime);
	}
	@Keyword
	def tapToOnCallEndBtn(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/callEndBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnNoBtnInEndCallPopUp(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/JoinCallPopup/endCallPopupNoBtn_andorid'), defaultTime);
	}
	@Keyword
	def tapOnYesBtnInEndCallPopUp(){
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/JoinCall/JoinCallPopup/endCallPopupYesBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnReviewRevPrivateRequest(mobile, onFailure = FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Administrative/tapOnReviewRevPrvateRequest_android', ['mobile': mobile]), defaultTime, onFailure)
	}
	@Keyword
	def convertSlotTimeToHomePageTimeFormat(dateTime) {
		def currentTimezone = gen.getTimezone(dateTime);
		def providerDate = gen.convertToTimezone(dateTime, currentTimezone);
		def convertedDateTime = gen.convertDateToFormat(providerDate, "MMMM d, yyyy • h:mm a");
		println "Converted time to GMT: ${convertedDateTime}";
		return convertedDateTime
	}
	@Keyword
	def verifyMemberRevDocEHRNotExist(txt, onFailure=FailureHandling.OPTIONAL, defaultTime = 10) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/revDocEHRReviewBtnBasedOnMember_android',["member":txt]), defaultTime, onFailure);
	}
	//------------------------------------------------my staff or revprivate request-----------------------------------------------------------------------------------------------
	@Keyword
	def verifyProviderProfileInfoIcon(providerName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/providerprofileInfoIcon_android',["providerName":providerName]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnProviderProfileInfoIcon(providerName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/providerprofileInfoIcon_android',["providerName":providerName]), defaultTime, onFailure);
	}
	//------------------------------------------------my staff or revprivate request-----------------------------------------------------------------------------------------------
	//----------------------------------------ReUsable method for approve revprivate request----------------------------------------------------------------------------------------------
	@Keyword
	def approveTheRevPrivateRequest() {
		tapOnFilterByDrpdwn();
		tapOnAdministrativeBtn();
		tapOnApplyFilterBtn();
		while(verifyReviewRevPrivatePracticeBtn()) {
			Mobile.scrollToText("Review Private Practice Request", FailureHandling.OPTIONAL);
			tapOnReviewRevPrivatePracticeBtn();
			tapOnAcceptBtn();
			tapOnrevPrivateStartDateField();
			tapOnConfirmBtn();
			tapOnSendApprovalBtn();
		}
	}
	//----------------------------------------End of ReUsable method for approve revprivate request----------------------------------------------------------------------------------------------
	//----------------------------------------Go Online chat Feature--------------------------------------------------------------------------------
	@Keyword
	def verifyGoToOnlineChatBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/goToOnlineChatViewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnGoToOnlineChatBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/goToOnlineChatViewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySwitchToOpenTaskBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/switchToOpenTaskBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSwitchToOpenTaskBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/switchToOpenTaskBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyStartANewPatientChatBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/startaNewPatientChatBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnStartANewPatientChatBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/startaNewPatientChatBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelChatQueueBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/cancelOnlineChatQueueBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCancelChatQueueBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/cancelOnlineChatQueueBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMemberNameWithTimeRange(memberName, timerange, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/memberNameWithTimerange_android', ["memberName":memberName, "timerange":timerange]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAppointmentDetails(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/Go to Online Chat View/appointmentDetailsBtn_android'), defaultTime, onFailure)
	}

	//----------------------------------------close - Go Online chat Feature--------------------------------------------------------------------------------

	//-------------- Start Revplus Request --------

	@Keyword
	def tapOnReviewPlusPracticeRequest(name, iterations = 15, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Provider/HomePage/RevPlusRequest/reviewPlusPracticeRequest_android', ['name': name])
		ma.scrollUntilElementIsVisible(obj, iterations, 5)
		Mobile.delay(5)
		Mobile.tap(obj, defaultTime)
	}

	@Keyword
	def tapOnrevPlusStartDateField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/RevPlusRequest/revplusStartDate_android'), defaultTime);
	}

	@Keyword
	def approveTheRevplusRequest(name, iterations = 15, defaultTime = defaultTime) {
		tapOnFilterByDrpdwn();
		tapOnAdministrativeBtn();
		tapOnApplyFilterBtn();
		tapOnReviewPlusPracticeRequest(name, iterations, defaultTime)
		tapOnAcceptBtn();
		//ma.verifyElementPresentByText("Please make sure you and the patient have discussed the start date. That is the date that the billing and care will start.")
		//tapOnrevPlusStartDateField();
		//tapOnConfirmBtn();
		//tapOnSendApprovalBtn();
	}

	//-------------- End Revplus Request --------
	//-------------------------------------------------------get Member Appt Card details and verify ------------------------------------------------
	@Keyword
	def getMemberNameForApptCard(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/getMemberName_android', ["index":index]), defaultTime);
	}

	@Keyword
	def getDateTimeForApptCard(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/getApptDateTime_android', ["index":index]), defaultTime);
	}
	@Keyword
	def getTaskType(memberName, dateTime, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/memberNamewithDateTime_android', ["memberName":memberName, "dateTime":dateTime, "index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifySlotTimeWithMemberNameAndTaskType(memberName, dateTime, text, index = 1, isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist == true) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/slotTimeAndTaskType_android', ["memberName":memberName, "dateTime":dateTime, "index":index, "text":text]), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/HomePage/slotTimeAndTaskType_android', ["memberName":memberName, "dateTime":dateTime, "index":index, "text":text]), defaultTime, onFailure);
		}
	}

	@Keyword
	def getDateTimeForApptCardByTask(task="RevDoc EHR Review", index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/getDateTimeByTask_android', ["index":index, "task": task]), defaultTime);
	}
	
	//-------------------------------------------------------close -- get Member Appt Card details and verify ------------------------------------------------
	//-------------------------------------------------------clear Task ---------------------------------------------------
	@Keyword
	def tapOnCloseCrossBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/ClearTask/closeCrossBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnClearTaskBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/ClearTask/clearTaskBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def removePastTasksFromHomePage() {
		while(ma.verifyElementPresentByText("days ago", FailureHandling.OPTIONAL, 6)||ma.verifyElementPresentByText("month ago", FailureHandling.OPTIONAL, 6) ||ma.verifyElementPresentByText("months ago", FailureHandling.OPTIONAL, 6)) {
			tapOnCloseCrossBtn();
			tapOnClearTaskBtn();
			Mobile.delay(5);

		}
	}

	@Keyword
	def removeTaskBydateTimeAndTask(task="RevDoc EHR Review", dateTime, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		def closeBtnObj = findTestObject('Object Repository/Provider/HomePage/crossCloseBtnByDateTime_android', ["dateTime":dateTime, "task": task]);
		if(!Mobile.verifyElementExist(closeBtnObj, 10, FailureHandling.OPTIONAL)) {
			gen.swipeDownLittle();
		}
		Mobile.tap(closeBtnObj, defaultTime, onFailure);
		tapOnClearTaskBtn();
		Mobile.delay(5);
	}
	
	@Keyword
	def verifySpecificTaskRemoved(task, dateTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def closeBtnObj = findTestObject('Object Repository/Provider/HomePage/crossCloseBtnByDateTime_android', ["dateTime":dateTime, "task": task]);
		Mobile.verifyElementNotExist(closeBtnObj, 10, onFailure);
	}

	//-------------------------------------------------------Close--clear Task ---------------------------------------------------
	//------------------------------------------programCard------------------------------------------------------------------------

	@Keyword
	def verifyProgramCardDetails(programName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		gen.waitForRevdocLoaderToDisappear();
		def testObject = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': programName])
		ma.scrollUntilElementIsVisible(testObject)
		ma.verifyElementPresentByText(programName)
		ma.verifyElementPresentByText("Program Details")
		ma.verifyElementPresentByText("Program Invite")
		def acceptBtn = findTestObject('Object Repository/Provider/HomePage/OpenTasks/ProgramCard/programCardAcceptBtn_android', ['programName':programName])
		def denyBtn = findTestObject('Object Repository/Provider/HomePage/OpenTasks/ProgramCard/programCardDenyBtn_android', ['programName':programName])
		def programDetailsInfoBtn = findTestObject('Object Repository/Provider/HomePage/OpenTasks/ProgramCard/programDetailsInfoBtnByProgramName_android', ['programName':programName])
		Mobile.verifyElementExist(acceptBtn, defaultTime, onFailure);
		Mobile.verifyElementExist(denyBtn, defaultTime, onFailure);
		Mobile.verifyElementExist(programDetailsInfoBtn, defaultTime, onFailure);
	}

	@Keyword
	def tapOnProgramAcceptBtn(programName) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/ProgramCard/programCardAcceptBtn_android', ['programName':programName]), defaultTime)
	}

	@Keyword
	def tapOnProgramDetailsInfoBtn(programName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def programDetailsInfoBtn = findTestObject('Object Repository/Provider/HomePage/OpenTasks/ProgramCard/programDetailsInfoBtnByProgramName_android', ['programName':programName]);
		Mobile.tap(programDetailsInfoBtn, defaultTime, onFailure)
	}

	//------------------------------------------End - programCard------------------------------------------------------------------------
}
