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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import member.AtHomeLabs
import mobile.Generic
import provider.HomePage

public class myCarePage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	AtHomeLabs atl = new AtHomeLabs();
	HomePage home = new HomePage();
	Generic gen = new Generic();
	@Keyword
	def tapOnMyCareIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/myCareIcon_android'), defaultTime)
	}

	@Keyword
	def verifyMyCareIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/myCareIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyUpcomingTab(value) {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/myCarePage_android/upcomingTab_android', ['value': value]), defaultTime)
		}
		catch (Exception e){
			return false
		}
	}

	@Keyword
	def scrollToAppointment(date, time, providerName, iterations = 10) {
		Mobile.scrollToText(date);

		def count = 1 ;
		while(!atl.verifyElementExist(date) || !atl.verifyElementExist(providerName) && count <=iterations) {
			gen.swipeUp();
			count = count + 1;
		}

		count = 1 ;
		while(home.verifyElementTxtNotExist(time) ||home.verifyElementTxtNotExist(providerName) &&  count<=iterations) {
			gen.swipeUpLittle();
			count += 1;
		}
	}

	@Keyword
	def verifyAndTapOnUpcomingTab(value) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/myCarePage_android/upcomingTab_android', ['value': value]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/upcomingTab_android', ['value': value]), defaultTime)
	}

	@Keyword
	def verifyAppointmentCards() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/myCarePage_android/appointmentCards_android'), defaultTime)
	}

	@Keyword
	def verifyAtHomeLabsProviderName() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/myCarePage_android/atHomeLabProviderName_android'), defaultTime)
	}

	@Keyword
	def verifyNoApptMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Appointments/noAppointmentsMsg_android'), defaultTime)
	}
	@Keyword
	def tapOnAtHomeLabsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/atHomeLabsBtn_android'), defaultTime)
	}
	@Keyword
	def verifyAndTapOnHealthCareTitleExist(index) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/FirstResultInOrderTracking_android',['index' : index]), defaultTime)
	}
	@Keyword
	def tapOnTrackOrderOption() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/trackOrderOpt_android'), defaultTime)
	}

	@Keyword
	def tapOnOrderTrackingOption() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/orderTrackingOption_android'), defaultTime)
	}

	@Keyword
	def verifyPreparingToShipTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/preparingToShipTxt_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyOrderReceivedbyPharmacyTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/Order Tracking/orderReceivedbyPharmacyText_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyShippedToPatient() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/shippedToPatientTxt_android'), defaultTime);
	}
	@Keyword
	def verifyDeliveredToPatientTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveredToPatientTxt_android'), defaultTime);
	}
	@Keyword
	def verifyShippedToLab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/ShippedTolabTxt_android'), defaultTime);
	}
	@Keyword
	def verifyRecivedByLab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/recivedByLab_android'), defaultTime);
	}
	@Keyword
	def verifyDeliveredToLab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveredToLab_android'), defaultTime);
	}
	@Keyword
	def verifyResultsTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/resultsTxt_android'), defaultTime);
	}
	@Keyword
	def verifyTrackYourOrderTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/trackYourOrderTitle_android'), defaultTime);
	}
	@Keyword
	def verifyHelpWithAtHomeLabsBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/helpWithAtHomeLabsBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnHelpWithAtHomeLabsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/helpWithAtHomeLabsBtn_android'), defaultTime);
	}
	@Keyword
	def verifyHelpWithOrderTitlepopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/helpWithOrderTitle_android'), defaultTime);
	}
	@Keyword
	def verifyMyBoxDamagedOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/myBoxDamagedOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnMyBoxDamagedOption() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/myBoxDamagedOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnShipMeNewKitBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/ShipMeNewKitBtn_android'), defaultTime);
	}
	@Keyword
	def verifyOrderedMyBoxTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/orderedMyBoxTxt_android'), defaultTime);
	}
	@Keyword
	def verifyMyBoxMissingTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/myBoxMissingTxt_android'), defaultTime);
	}
	@Keyword
	def verifyIdidNotFollowTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/iDidNotFollowTxt_android'), defaultTime);
	}
	@Keyword
	def verifyTheAppoinment(procedure, time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/verifyAppoinmentInMyCarepage_andriod', [procedure :procedure,time: time]), defaultTime, onFailure);
	}
	@Keyword
	def verifyProviderName(provider, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/providerNameInMyCare_andriod', ['provider': provider]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/closeBtn_android'), defaultTime);
		Mobile.delay(5);
	}
	@Keyword
	def tapOnOrderTrackingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/OrderTrackingBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnCompletedBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completedOption_android'), defaultTime);
		Mobile.delay(5);
	}
	@Keyword
	def verifyElementTextPresent(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/ANewLabKitConfirmPopUp_android', ['Text': Text]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAppoinmentInOpenTab(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/appoinmentInOpenTab_andriod', ['index': index]), defaultTime)
	}
	@Keyword
	def getProcedureOnAppointment(){
		return Mobile.getText(findTestObject('Object Repository/Member/myCarePage_android/procedureNameOnAppointment_android'), defaultTime);
	}
	@Keyword
	def tapOnProcedureInfoButton(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureInfoButton_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyDeliveryFeesTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/deliiveryFeesTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyDeliveryFeesDetails(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/deliveryFeesDescription_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnDeliveryFeesInfoButton(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/infoIconOnDeliveryFees_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/infoIconOnDeliveryFees_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyIconsPresent(iconType) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/iconsPresent_android', ['iconType': iconType]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	def tapOnViewResultsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/viewResultsOptn_android'), defaultTime);
	}
	@Keyword
	def verifyMakeAnAppointmentBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/makeAnAppointBtn_android'), defaultTime);
	}
	@Keyword
	def verifyDeliveryFeesCostByItsType(serviceType, text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/deliveryFees/deliveryFeesCost_android', ['serviceType': serviceType, 'text': text]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def tapOnProviderProfileInfoOption(text) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/providerNameTxtAvatar_android', ['text': text]), defaultTime);
	}
	@Keyword
	def tapOnProviderProfile() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/providerProfileBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnAddSymptomsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/addSymptomsBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnAddAdditionalInfo(text) {
		Mobile.setText(findTestObject('Object Repository/Member/myCarePage_android/Open/addAdditionalInfo_android'),text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnSymptomsDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/symptomsDrpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnSymptom(symptom) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/symptom_android', ['symptom': symptom]), defaultTime);
	}
	@Keyword
	def getFirstSymptom(){
		return Mobile.getText(findTestObject('Object Repository/Member/myCarePage_android/Open/symptom_android'), defaultTime);
	}
	@Keyword
	def tapOnUploadSymptoms() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/uploadSymptoms_android'), defaultTime);
	}
	@Keyword
	def tapOnChooseFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/chooseFromLibrary_android'), defaultTime);
	}
	@Keyword
	def verifyPhotoOfSymptomsExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/Open/photoOfSymptoms_android'), defaultTime);
	}
	@Keyword
	def getIdentificationCode(){
		return Mobile.getText(findTestObject('Object Repository/Member/myCarePage_android/identificationCode_android'), defaultTime);
	}

	@Keyword
	def tapOnViewProgramBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/CancelAppt/viewProgramBtn_android'), defaultTime)
	}

	def tapOnProvider() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/providerProfile_android'), defaultTime);
	}

	@Keyword
	def tapOnInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/infoIcon_android'), defaultTime);
	}

	@Keyword
	def verifyAlertIconExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/Open/alertIcon_android'), defaultTime);
	}

	@Keyword
	def verifyCancelApptBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/Open/cancelAppt_android'), defaultTime);
	}
	@Keyword
	def tapOnCancelApptBtnExist() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/cancelAppt_android'), defaultTime);
	}
	//---------CONSENT FORM---------
	@Keyword
	def tapOnReviewBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/ConsentForm/reviewBtn_android'), defaultTime)
	}
	
	@Keyword
def swipeRightOnConsentFormSignature() {
    int device_Height = Mobile.getDeviceHeight()
    int device_Width = Mobile.getDeviceWidth()

    // Adjust the Y values to target a position near the bottom of the screen
    int startY = (device_Height * 0.85) as int  // 85% from the top (near the bottom)
    int endY = startY  // Y values remain the same for a horizontal swipe

    // Adjust the X values for horizontal swipe (can remain as is)
    int startX = device_Width * 0.20  // Start from 20% of the width (from the left)
    int endX = device_Width * 0.80  // End at 80% of the width (near the right)

    println("startX: " + startX + ", startY: " + startY + ", endX: " + endX + ", endY: " + endY)

    // Swipe horizontally from left to right near the bottom of the screen
    Mobile.swipe(startX, startY, endX, endY)
}

	
	@Keyword
	def tapOnSignBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/ConsentForm/signBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnViewBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/ConsentForm/viewBtn_android'), defaultTime)
	}
}
