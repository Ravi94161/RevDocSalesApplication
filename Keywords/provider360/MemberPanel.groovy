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

public class MemberPanel {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnMemberPanelBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberPanelBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAppointmentCancelledBtn(dateTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/appointmentCancelledBtn_android', ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def verifyApptCancelledMsgElementExist(msg) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/apptCancelledMsg_'+os, ['msg': msg]), defaultTime);
	}

	@Keyword
	def verifyApptPriceZeroTextElementExist(dateTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/apptPriceZeroText_'+os, ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def verifyMemberNameOnCard(dateTime, expName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberNameOnCard_android', ['dateTime': dateTime]), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberNameOnCard_android', ['dateTime': dateTime]), expName, onFailure);
	}

	@Keyword
	def verifyMemberNameCard(dateTime, memberName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberNameOnCard_android', ['dateTime': dateTime]), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberNameCard_andriod', ['dateTime': dateTime, 'memberName':memberName]), defaultTime, onFailure);
	}

	@Keyword
	def tapMemberNameOnCard(dateTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberNameOnCard_android', ['dateTime': dateTime]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTextOnMemberCard(dateTime, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		println("//android.widget.TextView[contains(@text, '${dateTime}')]/..//android.widget.TextView[contains(@text, '${text}')]")
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/verifyTextOnMemberCard', ['dateTime': dateTime, 'text': text]), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/verifyTextOnMemberCard', ['dateTime': dateTime, 'text': text]), text, onFailure);
	}

	@Keyword
	def verifyBottomSheetTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/bottomSheetTitle_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/bottomSheetTitle_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyElementText(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/elementText_android', ['text': text]), defaultTime, OnFailure)
	}

	@Keyword
	def verifyCrossRedIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/crossRedIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOkayBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/okayBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapApptCancelledBtnInMemberProfile(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/apptCancelledBtnInProviderProfile_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapBackIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/backBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyGeneralMembersExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/providerName_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyMyRevprivateMembersExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevprivateMembers_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifySearchGeneralMembersExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/searchGeneralMembers_'+os), defaultTime, onFailure);
	}
	@Keyword
	def getMemberNameText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/providerNameOnCard_'+os, ['index' : index]),defaultTime);
	}

	@Keyword
	def verifyLocation() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/location_android'), defaultTime);
	}
	@Keyword
	def getMemberNamesInGeneralMembersList(onFailure = FailureHandling.OPTIONAL,defaultTime = defaultTime) {
		// Initialize an empty list to store member information
		List<String> memberNameList = new ArrayList<String>()
		for(int index = 1;index < 4;index++) {
			String memberNameInfo = getMemberNameText(index);
			memberNameList.add(memberNameInfo);
		}
		// Return the list of member information
		return memberNameList
	}
	@Keyword
	def getProcedureNameText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/procedureNameOnCard_'+os, ['index' : index]),defaultTime);
	}
	@Keyword
	def getProcedureNamesInGeneralMembersList(onFailure = FailureHandling.OPTIONAL,defaultTime = defaultTime) {
		// Initialize an empty list to store member information
		List<String> procedureNameList = new ArrayList<String>()
		for(int index = 1;index < 4;index++) {
			String procedureNameInfo = getProcedureNameText(index);
			procedureNameList.add(procedureNameInfo);
		}
		// Return the list of member information
		return procedureNameList
	}
	@Keyword
	def getDeliveryTypeText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/deliveryTypeOnCard_'+os, ['index' : index]),defaultTime);
	}
	@Keyword
	def getDeliveryTypeInGeneralMembersList(onFailure = FailureHandling.OPTIONAL,defaultTime = defaultTime) {
		// Initialize an empty list to store member information
		List<String> deliveryTypeList = new ArrayList<String>()
		for(int index = 1;index < 4;index++) {
			String deliveryTypeInfo = getDeliveryTypeText(index);
			deliveryTypeList.add(deliveryTypeInfo);
		}
		// Return the list of member information
		return deliveryTypeList
	}
	@Keyword
	def getDateAndTimeText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/dateTimeOnCard_'+os, ['index' : index]),defaultTime);
	}
	@Keyword
	def getDateAndTimeInGeneralMembersList(onFailure = FailureHandling.OPTIONAL,defaultTime = defaultTime) {
		// Initialize an empty list to store member information
		List<String> dateTimeList = new ArrayList<String>()
		for(int index = 1;index < 4;index++) {
			String dateTimeInfo = getDateAndTimeText(index);
			dateTimeList.add(dateTimeInfo);
		}
		// Return the list of member information
		return dateTimeList
	}
	@Keyword
	def verifyMemberCardBoxExist(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberCardBx_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAvatarProfileExist(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/avatarProfile_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyMemberNameTextOnCard(index, text, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/providerNameOnCard_'+os, ['index': index]), text, onFailure);
	}
	@Keyword
	def verifyProcedureNameTextOnCard(index, text, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/procedureNameOnCard_'+os, ['index': index]), text, onFailure);
	}
	@Keyword
	def verifyDeliveryTypeTextOnCard(index, text, onFailure = FailureHandling.OPTIONAL) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/deliveryTypeOnCard_'+os, ['index': index]), text, onFailure);
	}
	@Keyword
	def verifyDateAndTimeTextOnCard(index, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/dateTimeOnCard_'+os, ['index': index]), text, onFailure);
	}
	@Keyword
	def tapOnRevprivateMembers(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevprivateMembers_'+os), defaultTime, onFailure)
	}
	@Keyword
	def verifySearchMyRevprivateMembersExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/searchMyRevprivateMembers_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyRevprivateTextOnCard(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/revPrivateRectangleTxt_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyMemberSinceTxtOnCard(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memeberSinceTxt_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyCityAndStateTxtOnCard(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/cityAndStateTx_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def typeInNameOfSearchGeneralMembers(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/searchGeneralMembers_'+os),name, defaultTime)
	}
	@Keyword
	def tapOnCloseBtnInSearch(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/closeBtnSearch_'+os), defaultTime, onFailure)
	}
	@Keyword
	def typeInNameOfMyRevprivateMembers(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/searchMyRevprivateMembers_'+os),name, defaultTime)
	}

	@Keyword
	def typeInNameOfMyRevplusMembers(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/searchMyRevplusMembers_'+os), name, defaultTime)
	}
	@Keyword
	def tapOnCardFirstMyRevprivateMembers(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevPrivateMemberCardFirst_'+os), defaultTime, onFailure)
	}
	@Keyword
	def verifyChatMessageMember(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/chatMessageMember_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnChatMessageMember(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/chatMessageMember_'+os), defaultTime, onFailure)
	}
	@Keyword
	def verifyGroupMessageMember(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/groupMessageMember_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyManageMembership(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/manageMembership_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnManageMembership(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/manageMembership_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyShareEHRBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/shareEHR_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyExpandAllBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/expandAll_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyEHRUpdatedAtPresent(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/MemberPanel/EHRUpdatedAt_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnApptCancelledBtnWithIndex(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/apptCancelledBtnIndex_'+os), defaultTime, onFailure);
	}
	@Keyword
	def getAppointmentCancelledText(index) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/getApptCancelledTxt_'+os, ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnGeneralMemberFirstBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/generalMemberFirst_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyHouseIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/houseIcon_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyPatientHealthRecordBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/patientHealthRecordBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyMessagePatientBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/messagePatient_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyCancelOrRefundBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/cancellOrRefundApt_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyTeleMedicineIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/teleMedicineIcon_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyVideoCallDisabledBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/videoCallDisabledBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnMemberBtnWithIndex(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/memberBtnWithIndex_'+os, ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnDirectionBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/directionBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyDirectionBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/directionBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyCodesMatchCheckBoxExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/codesMatchCheckBx_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyCodesMatchCheckBoxGreenExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/codesMatchCheckBxGreen_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyIDVerificationCheckBoxExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/idVerificationCheckBx_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyIDVerificationCheckBoxGreenExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/idVerificationCheckBxGreen_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCodesMatchCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/codesMatchCheckBx_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnIDVerificationCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/idVerificationCheckBx_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyConfirmCodeBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/confirmCodeBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnConfirmCodeBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/confirmCodeBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnConfirmIDBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/confirmIDBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyProviderNameOnCardExist(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/providerNameOnCard_'+os, ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyShareBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/shareEHR_android'), defaultTime);
	}

	@Keyword
	def verifyGroupMessage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/groupMessage_'+os), defaultTime);
	}
	@Keyword
	def tapOnGroupMessage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/groupMessage_'+os), defaultTime);
	}

	@Keyword
	def verifyMessageMember() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/messageMember_'+os), defaultTime);
	}

	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevPrivateMemberBackBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAnyMember(index){
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/selectMyRevPrivateMember_android', ['index' : index]), defaultTime);
	}

	@Keyword
	def tapOnMyRevprivateMembers() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevprivateMembers_android'), defaultTime);
	}

	@Keyword
	def tapOnMyRevplusMembers() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/myRevplusMembers_android'), defaultTime);
	}

	@Keyword
	def verifyProcedureNameOnCardExist(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/procedureNameOnCard_'+os, ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyDateAndTimeOnCardExist(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/dateTimeOnCard_'+os, ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyappointmentCancelledBtnExist(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/appointmentCancelledBtn_'+os, ['index' : index]), defaultTime);
	}

	@Keyword
	def verifyPatientHealthRecordExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/patientHealthRecord_'+os), defaultTime);
	}
	@Keyword
	def verifyMessagePatientExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/patientHealthRecord_'+os), defaultTime);
	}

	@Keyword
	def verifyAppointmentNotesExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/appointmentNotes_'+os), defaultTime);
	}

	@Keyword
	def verifyVideoCallBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/videoCallBtn_'+os), defaultTime);
	}

	@Keyword
	def getProducerType(index) {
		return Mobile.getAttribute(findTestObject('Object Repository/Provider/Provider360/MemberPanel/getProcedureType',['index': index]), 'text', defaultTime)
	}

	@Keyword
	def verifyElementTextNotExist(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/MemberPanel/elementText_android', ['text': text]), defaultTime, OnFailure)
	}

	@Keyword
	def verifyDeliveryMethodNotVisible(deliveryMethod) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/MemberPanel/deliveryMethodInEditPopUp_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def tapOnSkipButtonInMaps(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/skipBtnMaps_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnMessageTextBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/groupMessageTxtBx_android'), defaultTime)
	}
	@Keyword
	def verifyTxtMessageExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/TxtMessage_android'), defaultTime);
	}
	@Keyword
	def verifyAppoinmentByDateAndMemberName(membername, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/verifyApptBymemberNameAndDate_andriod',["membername": membername, "date": date]), defaultTime, onFailure)
	}
	@Keyword
	def verifyPriceOfTelemedicineAppoinment(procedure, time, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MemberPanel/verifyPriceOfTelemedicineAppoinment_andriod', ['procedure': procedure, "time": time, "price": price]), defaultTime, onFailure)
	}

	@Keyword
	def tapOncancelMembershipOnRenewalBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/cancelMembershipOnRenewalBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnInviteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/inviteBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCheckBox(procedure = "A Manual Test Procedure Checkbox") {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/AppointmentCancelled/checkBox_android', ["procedure": procedure]), defaultTime)
	}
	
	@Keyword
	def tapOnInfoIcon(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MemberPanel/infoIcon_android', ["index": index]), defaultTime)
	}
}

