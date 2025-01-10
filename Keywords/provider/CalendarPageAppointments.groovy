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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import api.Admin
import api.Member

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import internal.GlobalVariable
import io.appium.java_client.android.nativekey.KeyEvent
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.nativekey.AndroidKey
import mobile.Generic
import mobile.MobileActions
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.LocalDate
import java.time.LocalDateTime
import member.MyPrograms



public class CalendarPageAppointments {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	Generic gen = new Generic();
	MyPrograms prog = new MyPrograms()
	Member api = new Member();
	Admin admin = new Admin();
	MobileActions ma = new MobileActions()

	@Keyword
	def verifyPriceOnClanderPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/priceOnCalendar_android'), defaultTime);
	}
	@Keyword
	def getPriceOnClanderPage() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/priceOnCalendar_android'), defaultTime);
	}
	@Keyword
	def tapOnmemberAppointment() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/memberProfilePic_android'), defaultTime);
	}
	@Keyword
	def verifyAppointmentTitle(memberName, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value": memberName, "index": index]), defaultTime);
	}
	@Keyword
	def tapOnAppointmentTitle(memberName, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value": memberName, "index": index]), defaultTime);
	}

	@Keyword
	def tapOnMemberSlot(member, slot) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/memberNameByTime_android',["member":member,'slot':slot]), defaultTime);
	}

	@Keyword
	def verifDeliveryMethodText(DeliveryMethod, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value":DeliveryMethod, "index": index]), defaultTime);
	}
	@Keyword
	def verifyPriceOnAppointment(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value":price]), defaultTime);
	}

	@Keyword
	def verifydateTitle(date, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value":date, "index": index]), defaultTime);
	}

	@Keyword
	def verifyLocationTitle(location) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberNameTitle_android',["value":location]), defaultTime);
	}

	@Keyword
	def verifyPatientHealthRecordOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/patientHealthRecordOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnPatientHealthRecordOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/patientHealthRecordOpt_android'), defaultTime);
	}
	@Keyword
	def verifyMessageOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/messageOption_android'), defaultTime);
	}
	@Keyword
	def tapOnMessagePatientOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/messageOption_android'), defaultTime);
	}
	@Keyword
	def tapOnMemberApptCardBasedOnDelivery(memberName, DM) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/providerNameBasedOnDelivery_android', ['memberName': memberName, 'DM': DM]), defaultTime)
	}
	@Keyword
	def verifyCancelAppointmentOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/cancelAppointmentOption_android'), defaultTime);
	}
	@Keyword
	def verifyBookFollowUpOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/bookFollowUpOption_android'), defaultTime)
	}

	@Keyword
	def tapOnBookFollowUpOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/bookFollowUpOption_android'), defaultTime);
	}

	@Keyword
	def verifyCallMemberTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/callMemberTxt_android'), defaultTime);
	}
	@Keyword
	def verifyVideoCallBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/videoCallBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnVideoCallBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/videoCallBtn_android'), defaultTime);
	}
	@Keyword
	def minimizeVideoCallScreen() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/minimizeVideoScreenBtn'), defaultTime);
	}
	@Keyword
	def maximizeVideoCallScreen() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/maximizeVideoScreenBtn'), defaultTime);
	}
	@Keyword
	def verifyAppointmentNotesOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/appointmentNotesOpt_android'), defaultTime);
	}
	@Keyword
	def verifyPatientVerificationOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/patientVerificationOption_android'), defaultTime);
	}
	@Keyword
	def verifyCodeMatchRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/codeMathRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapAndSetTxtOnMsgMemberTxtField(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/msgMemberTxtBx_android'), 30);
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/msgMemberTxtBx_android'), 30);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/msgMemberTxtBx_android'), txt, defaultTime);
		//		def driver = MobileDriverFactory.getDriver()
		//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}
	@Keyword
	def verifysentMessage(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/sentMessage_android', ['txt': txt]), defaultTime);
	}

	@Keyword
	def tapOncalender() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/calendarIcon_'+os), defaultTime)
	}

	@Keyword
	def selectDate(date) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date]), defaultTime)
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/prevMonthBtn_android'), defaultTime)
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date]), defaultTime)
		}
	}

	@Keyword
	def selectDate(date, boolean futureDate) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date]), defaultTime)
		}
		catch(Exception e) {

			if(futureDate) {
				Mobile.tap(findTestObject('Object Repository/Provider/Calendar/nextMonthBtn_android'), defaultTime)
			}
			else {
				Mobile.tap(findTestObject('Object Repository/Provider/Calendar/prevMonthBtn_android'), defaultTime)
			}
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date]), defaultTime)
		}
	}

	@Keyword
	def selectFutureDate(date, index = 1) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date, 'index': index]), defaultTime)
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/nextMonthBtn_android'), defaultTime)
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/date_android',['date': date, 'index': index]), defaultTime)
		}
	}

	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/editBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnEditDayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/editDayBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnEditWeek() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/editAllWeek'), defaultTime)
	}
	@Keyword
	def tapOnEditAllWeekdayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editAllWeekDaysBtn_android'), defaultTime)
	}

	@Keyword
	def verifySpecificMemberProfilePic(timeRange) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/specificMemberProfilePic_android',["timeRange":timeRange]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSpecificMemberProfilePic(timeRange) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/specificMemberProfilePic_android',["timeRange":timeRange]), defaultTime, onFailure);
	}

	@Keyword
	def verifyMemberProfilePicNotExists(timeRange) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Calendar/specificMemberProfilePic_android',["timeRange":timeRange]), defaultTime, onFailure);
	}

	@Keyword
	def verifySpecificMemberDetailsOnCalendar(timeRange,text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/SpecificMemberDetailsOnCalendar_android',["timeRange":timeRange,"text":text]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSpecificMemberDetailsOnCalendar(timeRange,text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/SpecificMemberDetailsOnCalendar_android',["timeRange":timeRange,"text":text]), defaultTime);
	}

	@Keyword
	def getPatientNameOnAppt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/getPatientNameOnAppt_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPatientNameOnApptPresent(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/getPatientNameOnAppt_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnPatientNameOnAppt(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/patientNameOnAppoinment_android', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnPatientName(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, index = 2, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/providerNameAppoinment_andriod', ["name": name,'index':index]), defaultTime, onFailure)
	}

	@Keyword
	def getPriceOnAppt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/priceOnAppt_android'), defaultTime, onFailure)
	}

	@Keyword
	def getTimeSlotOnAppt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/timeSlotOnAppt_android'), defaultTime, onFailure)
	}

	@Keyword
	def getProcedureNameOnAppt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/procedureOnAppt_android'), defaultTime, onFailure)
	}

	@Keyword
	def selectDayInCalender(day) {
		Mobile.tap(findTestObject("Object Repository/Provider/Calendar/selectDayInCalender_android", ['day': day]), defaultTime)
	}

	@Keyword
	def tapNextMonthIcon() {
		Mobile.tap(findTestObject("Object Repository/Provider/Calendar/nextMonthBtn_android"), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/closeBtn_android', ["index": index]), defaultTime)
	}

	@Keyword
	def verifyCurrentRevDocIdImg(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/currentRevDocIdImg_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCancelAppoinmentBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/cancelAppointmentOption_android'), defaultTime);
	}

	/// Appoinment Cancellation Options
	@Keyword
	def tapOnIHaveTocancelOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/ihaveToCancelApptOption_android'), defaultTime)
	}

	@Keyword
	def tapOnContraindicationFundAtTimAppt() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/cantradictionFundAtAppt_android'), defaultTime)
	}

	@Keyword
	def tapOnContraindicationAccurateInfoInPHRBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/ContraindicationAccurateInfoInPHR_andriod'), defaultTime)
	}

	@Keyword
	def tapOnRefundPatientbtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/refundPatientBtn_android'), defaultTime)
	}

	@Keyword
	def getCancellationMsgText() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Calendar/cancellationMsg_andriod'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/cancellationMsg_andriod'), "Your Appt Is Cancelled", defaultTime)
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/cancellationMsg_andriod'), defaultTime)
	}

	@Keyword
	def tapOnSendCancellationMsgBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/sendCancellationMsgBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/okayBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyCancelAppoinmentNotClickable(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/cancelAppointmentOption_android'), defaultTime);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Calendar/sendCancellationMsgBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def addDaysToCurrentDate(int daysToAdd) {
		// Get the current date
		Calendar calendar = Calendar.getInstance()

		// Add days to the current date
		calendar.add(Calendar.DAY_OF_MONTH, daysToAdd)

		// Get the updated date
		Date updatedDate = calendar.getTime()

		// Format the updatedDate
		SimpleDateFormat dateFormat = new SimpleDateFormat("d") // Customize the format as needed
		String formattedDate = dateFormat.format(updatedDate)

		return formattedDate
	}
	@Keyword
	def tapOnDayAvailability() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/availabilityToggle_android'), defaultTime)
	}
	@Keyword
	def tapOnEditWeekdays(day) {
		def testObject = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/editWeekday_android', [('day') : day])
		Mobile.tap(testObject, defaultTime)
	}

	@Keyword
	def tapOnToggleIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/toggleIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnEditAllWeekDaysBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editAllWeekDays_btn'), defaultTime)
	}

	@Keyword
	def verifyTxtOnEditAllBtnSummaryPage(text, onFailure = FailureHandling.OPTIONAL) {
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), defaultTime, onFailure)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def verifyEditAllWeekDaysBtnExist(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editAllWeekDays_btn'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRevDocLogo(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/revDocLogo_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/backBtn_android'), defaultTime);
	}
	@Keyword
	def getTotalAppointmentsText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/getTotalApptText_android'), defaultTime);
	}
	@Keyword
	def verifyTotalAppointmentsText(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/getTotalApptText_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCurrentWeekDay(text, day,onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/currentWeekDay_android',["text":text, "day":day]), defaultTime, onFailure);
	}
	@Keyword
	def verifydotUnderDay(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/dotUnderDay_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifynextMonthBtn(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/nextMonthBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifypreviousMonthBtn(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/prevMonthBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyspecificDay(day, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/specificDay_android',["day":day]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnspecificDay(day, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/specificDay_android',["day":day]), defaultTime, onFailure);
	}
	//--------------------------------Patient-EHR-Allergies-------------------------------------------------------------
	@Keyword
	def verifyEHRtypeWithCaretIcon(ehrType, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/EHRtypeWithCaretIcon_android',["ehrType":ehrType]), defaultTime, onFailure)
	}
	@Keyword
	def verifyUpdatedDateofAllergy(date, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/UpdatedDateOfAllergy_android',["date":date]), defaultTime, onFailure);
	}
	@Keyword
	def verifyListOfDrugAllergies(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/listOfDrugAllergies_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnPlusBtnForAddNotes() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/plusBtnForAddNote_android'), defaultTime);
	}
	@Keyword
	def verifyPlusBtnForAddNotes(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/plusBtnForAddNote_android'), defaultTime, onFailure);
	}
	@Keyword
	def setTextInNoteTextField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/noteTextField_android'), text, defaultTime)
	}
	@Keyword
	def verifyNoteTextField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/noteTextField_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifySaveNoteBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/saveNoteBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSaveNoteBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/saveNoteBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyDiscardBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/discardBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnDiscardBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/discardBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifynoteTextFieldErrorMsg(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/Allergies/noteTextFieldErrorMsg_android',["text":text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyMedicalHistoryTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistory_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicalHistory() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistory_android'), defaultTime);
	}

	@Keyword
	def verifyMedicalHistoryNotesTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotes_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicalHistoryNotes() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotes_android'), defaultTime);
	}

	@Keyword
	def verifyMedicalHistoryNotesPlusIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotesPlusIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicalHistoryNotesPlusIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotesPlusIcon_android'), defaultTime);
	}

	@Keyword
	def verifyAddNotesText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/addNotesTxt_android'), defaultTime);
	}

	@Keyword
	def verifyNotesTxtBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/modicalHistoryNotesTxtBx_android'), defaultTime);
	}

	@Keyword
	def verifyMedicalHistoryNotesDiscardBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotesDiscardBtn_android'), defaultTime);
	}

	@Keyword
	def fillMedicalHistoryNotes(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/EditDatePage/modicalHistoryNotesTxtBx_android'), text, defaultTime);
	}

	@Keyword
	def verifyMedicalHistoryNotesSaveBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotesSaveBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicalHistoryNotesSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/medicalHistoryNotesSaveBtn_android'), defaultTime);
	}

	@Keyword
	def verifySurgicalHistoryTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/SurgicalHistory/SurgicalHistoryOpt_android'), defaultTime);
	}

	@Keyword
	def tapOnSurgicalHistory() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/SurgicalHistory/SurgicalHistoryOpt_android'), defaultTime);
	}

	@Keyword
	def verifySurgeryName(name)
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/SurgicalHistory/surgeryName_android',['name': name]), defaultTime);
	}

	@Keyword
	def verifySurgeryYear(year)
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/SurgicalHistory/surgeryYear_android',['year': year]), defaultTime);
	}
	@Keyword
	def verifyCloseBtn(index = 1){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/closeBtn_android',['index': index]), defaultTime);
	}
	//@Keyword
	//def verifyApptAddressText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
	//Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/ProviderProfile/verifyAddressText_android'), text, onFailure);
	//}
	@Keyword
	def verifyApptAddressText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/ProviderProfile/verifyAddressText_android'), text, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def tapOnViewProcedureBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/viewProcedureBtn_android'), defaultTime)
	}
	@Keyword
	def verifyImageExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/appointmentMemberImage_android'), 30);
	}
	@Keyword
	def selectTimeSlot() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/timeSlot_android'), defaultTime);
	}
	@Keyword
	def getDateAndTimeText(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/timeSlot_android'),defaultTime);
	}
	//Converting slot time(EST) to calendar time(GMT)
	@Keyword
	def convertSlotTimeToCalendarTimeFormat(dateTime, slotDuration) {
		def currentTimezone = gen.getTimezone(dateTime);
		def providerDate = gen.convertToTimezone(dateTime, currentTimezone);
		def convertedDateTime = gen.convertDateToFormat(providerDate, "MMMM dd, yyyy • h:mm a");
		println "Converted time to GMT: ${convertedDateTime}";

		def dateFormat1 = new SimpleDateFormat("MMMM dd, yyyy • hh:mm a");
		def timeFormat = new SimpleDateFormat("h:mm a");
		def date = dateFormat1.parse(convertedDateTime);
		def calendar = Calendar.getInstance();
		calendar.time = date;
		calendar.add(Calendar.MINUTE, slotDuration);

		def startTime = timeFormat.format(date).toLowerCase();
		def endTime = timeFormat.format(calendar.time).toLowerCase();
		return "$startTime - $endTime";
	}

	@Keyword
	def convertSlotTimeToCalendarTimeFormatGMT(dateTime, slotDuration) {
		def inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, h:mm a z")
		def inputDateTime = ZonedDateTime.parse(dateTime, inputFormatter)
		def outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy • h:mm a")
		// Convert to GMT
		def gmtZoneId = ZoneId.of("GMT")
		def dateTimeInGMT = inputDateTime.withZoneSameInstant(gmtZoneId)
		println(dateTimeInGMT:dateTimeInGMT)
		def formattedDateTimeInGMT = dateTimeInGMT.format(outputFormatter)
		println "Converted time to GMT: ${formattedDateTimeInGMT}";

		def dateFormat1 = new SimpleDateFormat("MMMM dd, yyyy • hh:mm a");
		def timeFormat = new SimpleDateFormat("h:mm a");
		def date = dateFormat1.parse(formattedDateTimeInGMT);
		def calendar = Calendar.getInstance();
		calendar.time = date;
		calendar.add(Calendar.MINUTE, slotDuration);

		def startTime = timeFormat.format(date).toLowerCase();
		def endTime = timeFormat.format(calendar.time).toLowerCase();
		return "$startTime - $endTime";
	}

	@Keyword
	def getAppointmentNotesText(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/apptNotesText_'+os),defaultTime);
	}

	@Keyword
	def tapOnHouseCallAppt(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/houseCallApptByMemberName_android', ["memberName": memberName]), defaultTime)
	}

	@Keyword
	def tapOnTelemedicineAppt(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/teleMedicineApptBymemberName_andriod', ["memberName": memberName]), defaultTime)
	}
	@Keyword
	def tapOnFacilityAppt(memberName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/facilityApptByMemberName_android', ["memberName": memberName]), defaultTime)
	}

	@Keyword
	def tapOnApptByMemberNameAndDMName(memberName, DM) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/apptByMemNameAndDM_android', ['memberName': memberName, 'DM':DM]), defaultTime)
	}

	@Keyword
	def verifyApptDetailsInCalendar(time, proc, delivery, member, price = '$') {
		def timerange = gen.convertToTimezone(time, "EDT", "UTC").replace("AM", "am").replace("PM","pm");
		println(timerange)
		def providerApptTime = gen.getProviderApptTimings(timerange, delivery)
		Mobile.scrollToText(providerApptTime, FailureHandling.OPTIONAL);
		verifySpecificMemberProfilePic(providerApptTime)
		verifySpecificMemberDetailsOnCalendar(providerApptTime, member);
		verifySpecificMemberDetailsOnCalendar(providerApptTime, price);
		verifySpecificMemberDetailsOnCalendar(providerApptTime, proc)
		verifySpecificMemberDetailsOnCalendar(providerApptTime, delivery);
	}

	@Keyword
	def verifyMemberApptDetailsInCalendar(providerApptTime, proc, delivery, member, price = '$') {
		//Mobile.scrollToText(providerApptTime, FailureHandling.OPTIONAL);
		TestObject testObject = findTestObject('Object Repository/Provider/Calendar/SpecificMemberDetailsOnCalendar_android',["timeRange":providerApptTime,"text":member])
		ma.scrollUntilElementIsVisible(testObject)
		verifySpecificMemberProfilePic(providerApptTime)
		verifySpecificMemberDetailsOnCalendar(providerApptTime, member);
		verifySpecificMemberDetailsOnCalendar(providerApptTime, price);
		verifySpecificMemberDetailsOnCalendar(providerApptTime, proc)
		verifySpecificMemberDetailsOnCalendar(providerApptTime, delivery);
	}

	//---------------------------------invite to Book---------------------------------------------------------
	@Keyword
	def tapOnInviteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/inviteBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBookSameApptOption(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/bookSameApptOption_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/bookSameApptOption_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifySelectDifferentProcedureOption(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/selectaDiffProcedure_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/selectaDiffProcedure_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnBookSameApptOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/bookSameApptOption_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectDifferentProcedureOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/selectaDiffProcedure_android'), defaultTime);
	}

	@Keyword
	def getProcedureName() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/Invite to Book/getProcedureName_android'), defaultTime);
	}

	@Keyword
	def verifySpecificProcedureCheckboxFilledorEmpty(procedure, status = "Empty", onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(status == "Empty") {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/procedureCheckBox_android', ['procedure':procedure, 'status':status]), defaultTime, onFailure);
		} else {
			status = "Filled"
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/procedureCheckBox_android', ['procedure':procedure, 'status':status]), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnSpecificProcedureCheckBox(procedure, status = "Empty", onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(status == "Empty") {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/procedureCheckBox_android', ['procedure':procedure, 'status':status]), defaultTime, onFailure)
		} else {
			status = "Filled"
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/procedureCheckBox_android', ['procedure':procedure, 'status':status]), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifyShareProcedureBtn(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/shareProcedureBtn_android', ['procedure':procedure]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnShareProcedureBtn(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/shareProcedureBtn_android', ['procedure':procedure]), defaultTime, onFailure)
	}

	@Keyword
	def verifyMoreInfoBtn(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/moreInfoBtn_android', ['procedure':procedure]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMoreInfoBtn(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/moreInfoBtn_android', ['procedure':procedure]), defaultTime, onFailure)
	}

	@Keyword
	def verifyInvitePatientBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/invitePatientBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnInvitePatientBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/invitePatientBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCategoryNameOnProcedureCard(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/categoryNameOnCard_android', ['procedure':procedure]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAlertIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/alertIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRemoveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/removeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRemoveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/removeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelOrderBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/cancelOrderBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCancelOrderBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/cancelOrderBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifysendInviteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/Invite to Book/sendInviteBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnsendInviteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/Invite to Book/sendInviteBtn_android'), defaultTime, onFailure)
	}
	//---------------------------------end - invite to Book---------------------------------------------------------
	//--------------------------------Start- Add on Procedure----------------------------------------------------
	@Keyword
	def tapOnAddOnProcBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/addOnProcBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProcCheckboxExist(procName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/procedureCheckBox_android', ['ProcName': procName]), defaultTime)
	}

	@Keyword
	def tapOnProcCheckbox(procName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/procedureCheckBox_android', ['ProcName': procName]), defaultTime)
	}

	@Keyword
	def verifyProceedToCheckoutBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/proceedToCheckout_android'), defaultTime)
	}

	@Keyword
	def tapOnProceedToCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/proceedToCheckout_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureRemoveBtnExist(procedure) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/removeBtn_android', ['procedure':procedure]), defaultTime)
	}

	@Keyword
	def verifyCancelOrderBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/cancelOrderBtn_android'), defaultTime)
	}

	@Keyword
	def verifySendToPatientBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/sendToPatientBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSendToPatientBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/sendToPatientBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProcedureRemoveBtn(procedure, text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/AddOnProceduresPopup/removeBtn_android', ['procedure':procedure]), defaultTime)
		Mobile.delay(5)
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text, "index":1]), defaultTime, onFailure)
	}

	@Keyword
	def selectProcedureAndCheckout(category, proc) {
		prog.scrollToCategoriesAndProcedures(category, proc)
		verifyProcCheckboxExist(proc)
		tapOnProcCheckbox(proc)
		tapOnProceedToCheckoutBtn()
	}

	@Keyword
	def verifyMemberAppointmentDetailsOnCalendar(timerange, memberName, procedure, delivery, revenue) {
		Mobile.scrollToText(timerange, FailureHandling.OPTIONAL);
		verifySpecificMemberProfilePic(timerange);
		def apptDetails = [
			memberName,
			"\$${revenue}",
			procedure,
			delivery
		]
		apptDetails.each { apptDetail ->
			verifySpecificMemberDetailsOnCalendar(timerange, apptDetail);
		}
	}

	@Keyword
	def calculateProviderActualRevenueForMemberAppt( procedureIds,  deliveryPrice,  deliveryMethod) {
		// Initialize variables to accumulate fees from multiple procedures
		double totalProcedurePrice = 0.0
		double totalMaterialFee = 0.0
		double totalPharmaceuticalFee = 0.0
		def procedureDetails = null

		// Loop through each procedure name, calling the API method to get prices
		procedureIds.each { procedureId ->
			//procedureId = api.getProcedureIdByProcedureName(procedureName)
			procedureDetails = admin.getProcedureById(procedureId)

			// Accumulate the prices for each procedure
			totalProcedurePrice += procedureDetails.procedurePrice
			totalMaterialFee += procedureDetails.materialPrice
			totalPharmaceuticalFee += procedureDetails.pharmaceuticalPrice
		}

		// Define constants for various fees
		double providerAdminFee = 0.1625
		double creditCardFee = 0.05
		double prmFee = 0.03

		// Calculate Subtotal Revenue based on delivery method
		double subtotalRevenue
		double providerAdminCost
		double creditCardCost
		double prmCost
		double deliveryAndProcedureCost = deliveryPrice + totalProcedurePrice

		if (deliveryMethod == "Telemedicine Call") {
			subtotalRevenue = deliveryPrice + totalProcedurePrice

			// Calculate costs
			providerAdminCost = providerAdminFee * subtotalRevenue
			creditCardCost = creditCardFee * subtotalRevenue
			prmCost = prmFee * deliveryAndProcedureCost

		} else {
			// House Call, Van Call, Facility calculation
			subtotalRevenue = deliveryPrice + totalMaterialFee + totalPharmaceuticalFee + totalProcedurePrice
			//			deliveryAndProcedureCost = deliveryPrice + totalProcedurePrice

			// Calculate costs
			providerAdminCost = providerAdminFee * subtotalRevenue
			creditCardCost = creditCardFee * subtotalRevenue
			prmCost = prmFee * deliveryAndProcedureCost
		}

		// Calculate Actual Revenue
		int actualRevenue = (int) Math.round(subtotalRevenue - (providerAdminCost + creditCardCost + prmCost))

		return actualRevenue
	}
}
