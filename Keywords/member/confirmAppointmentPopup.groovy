package member

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import provider.ProviderEHR

public class confirmAppointmentPopup {
	String os = GlobalVariable.osName
	int defaultTime = GlobalVariable.defaultTime
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE
	Checkout check = new Checkout()
	SelectAddresses select = new SelectAddresses()
	ProviderEHR prov = new ProviderEHR()

	@Keyword
	def getTxtOfProcedureName(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/getProcedureName_android'), defaultTime, onFailure)
	}
	@Keyword
	def getTxtOfProviderName(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/getProviderName_android'), defaultTime, onFailure)
	}
	@Keyword
	def getTxtOfStartDate() {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/getStartDate_android'), defaultTime)
	}
	@Keyword
	def getTxtOfAmount() {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/getAmount_android'), defaultTime)
	}
	@Keyword
	def getTxtOfAddress(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/getAddress_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnRevOneRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/ConfirmAppointmentPopup/revOneRadioBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnEditAddressOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/editAddressOption_android',['index':index]), defaultTime)
	}

	@Keyword
	def verifyEditApptAddressNotPresent(index = 1) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/editAddressOption_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyEditApptAddressPresent(index = 1) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/editAddressOption_android',['index':index]), defaultTime);
	}

	@Keyword
	def typeInEditAddress2Input(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/editAddress2Input_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/editAddress2Input_android'), text, defaultTime)
	}

	@Keyword
	def typeInArrivalInstructionsInput(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/arrivalInstructionsInput_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/arrivalInstructionsInput_android'), text, defaultTime)
	}
	
//	@Keyword
//	def tapOnSaveBtn() {
//		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/saveBtn_android'), defaultTime)
////		prov.tapOnCloseBtn(FailureHandling.OPTIONAL)
//	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/saveBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnUseSameAddressCheckBox(checkBox) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/useSameAddressCheckBox_android',['checkBox':checkBox]), defaultTime)
	}

	@Keyword
	def verifyRxShippingAddressText(index, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/rxShippingAddressText_android',['index':index]), text, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyRxInstructionNotExist(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/rxShippingAddressText_android',['index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyRxShippingAddressNotExist(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/rxShippingAddressText_android',['index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyRxShippingAddressInstructionNotExist() {
		verifyRxShippingAddressNotExist(1);
		verifyRxShippingAddressNotExist(2);
	}

	@Keyword
	def verifyRxShippingAddressInstruction(modifiedAddress, instruction) {
		verifyRxShippingAddressText(1,modifiedAddress);
		verifyRxShippingAddressText(2,instruction);
	}

	@Keyword
	def verifyConfirmAppoinmentAddressText(index = 1, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confimApptAddress_android',['index':index]), text, onFailure);
	}

	@Keyword
	def EditAndVerifyApptAddressUpdatedRxNotExist(index,address2,instruction,modifiedAddress) {
		tapOnEditAddressOption(index)
		typeInEditAddress2Input(address2)
		typeInArrivalInstructionsInput(instruction)
		tapOnSaveBtn()
		verifyConfirmAppoinmentAddressText(1, modifiedAddress)
		verifyConfirmAppoinmentAddressText(2, instruction);
		verifyRxShippingAddressNotExist(1);
		verifyRxShippingAddressNotExist(2);
	}

	@Keyword
	def EditAndVerifyApptAddressUpdatedRxNotExistCheckout(index,address2,instruction,modifiedAddress) {
		tapOnEditAddressOption(index)
		typeInEditAddress2Input(address2)
		typeInArrivalInstructionsInput(instruction)
		tapOnSaveBtn()
		Mobile.delay(10)
		check.verifyAddressAndInstruction(1, modifiedAddress)
		check.verifyAddressAndInstruction(2, instruction);
		verifyRxShippingAddressNotExist(1);
		verifyRxShippingAddressNotExist(2);
	}

	@Keyword
	def EditApptAddress(index,address2,instruction) {
		tapOnEditAddressOption(index)
		typeInEditAddress2Input(address2)
		typeInArrivalInstructionsInput(instruction)
		tapOnSaveBtn()
	}

	@Keyword
	def EditAndVerifyApptAddressUpdated(index,address2,instruction,modifiedAddress) {
		tapOnEditAddressOption(index)
		typeInEditAddress2Input(address2)
		typeInArrivalInstructionsInput(instruction)
		tapOnSaveBtn()
		Mobile.delay(10);
		verifyConfirmAppoinmentAddressText(1, modifiedAddress)
		verifyConfirmAppoinmentAddressText(2, instruction);
	}

	@Keyword
	def EditAndVerifyRxAddressUpdated(index,providerAddress2,rxAddress2,rxInstruction,modifiedRxAddress) {
		tapOnEditAddressOption(index)
		check.tapOnSearchAddress()
		select.setTxtInSearchLocationsField(providerAddress2);
		select.tapFirstSearchResult()
		typeInEditAddress2Input(rxAddress2)
		typeInArrivalInstructionsInput(rxInstruction)
		Mobile.delay(10);
		tapOnSaveBtn()	
		verifyRxShippingAddressInstruction(modifiedRxAddress,rxInstruction)
	}

	@Keyword
	def EditAndVerifyRxAddress(index,providerAddress2,rxAddress2,rxInstruction) {
		tapOnEditAddressOption(index)
		check.tapOnSearchAddress()
		select.setTxtInSearchLocationsField(providerAddress2);
		select.tapFirstSearchResult()
		typeInEditAddress2Input(rxAddress2)
		typeInArrivalInstructionsInput(rxInstruction)
		tapOnSaveBtn()
	}
	@Keyword
	def tapOnEditGreyBtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/editGreyIcon_android'), defaultTime);
	}

	@Keyword
	def typeInArrivalInstructionsInputForHomelabs(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/arrivalInstructionsInputForHomeLabs_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/arrivalInstructionsInputForHomeLabs_android'), text, defaultTime)
	}

	@Keyword
	def getPromoAppliedPrice(index = 2, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/getPromoAppliedPrice_android', ["index": index]), defaultTime, onFailure)
	}
	
	@Keyword
	def selectAddressRadioBtn(text) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/selectAddressRadioBtn_android', ["text": text]), defaultTime);
	}
}
