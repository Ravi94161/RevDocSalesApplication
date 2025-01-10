package providerRegistration

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import mobile.Generic

public class DeliveryMethods {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();

	@Keyword
	def tapOnBuildMyRevdocProfileBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/buildMyRevdocProfileBtn_android'), 30);
	}

	@Keyword
	def verifyBuildMyRevdocProfileBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/buildMyRevdocProfileBtn_android'), 30);
	}

	@Keyword
	def tapOnDeliveryMethodsOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/deliveryMethodsOption_android'), defaultTime);
	}
	@Keyword
	def WaitForEDeliveryMethodsOptionPresent() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/deliveryMethodsOption_android'), defaultTime);
	}
	@Keyword
	def verifyDeliveryMethodsPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deliveryMethodsTitle_android'), 30);
	}

	@Keyword
	def verifyScreenInfoText() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/deliveryMethodsScreenInfoTxt_android'), "Select the delivery methods that you will perform");
	}


	@Keyword
	def verifyHouseCallDeliveryMethod() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Provider Delivery Methods/houseCallDeliverymethod_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/houseCallCheckboxInDeliveryMethods_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/houseCallDrpDwnArrowInDeliveryMethods_android'), 30);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/houseCallDescription_android'), "Visiting a patient's home/work");
	}

	@Keyword
	def tapOnHouseCallOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Provider Delivery Methods/houseCallDeliverymethod_android'), defaultTime)
	}

	@Keyword
	def selectHouseCallDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/houseCallCheckboxInDeliveryMethods_android'), 30);
	}

	@Keyword
	def compressHouseCallDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/houseCallDrpDwnArrowInDeliveryMethods_android'), 30);
	}

	@Keyword
	def verifyFacilityDeliveryMethod() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Provider Delivery Methods/facilityDeliveryMethod_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/facilityCheckboxInDeliveryMethods_android'), 30);
		Mobile.verifyElementExist(findTestObject('Provider/Provider360/SetUpYourAvailability/facilityDrpdwnInDeliveryMethods_android'), 30);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/facilityDescription_android'), "Care from your clinic");
	}

	@Keyword
	def selectFacilityDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/facilityCheckboxInDeliveryMethods_android'), 30);
	}

	@Keyword
	def compressFacilityDeliveryMethod() {
		Mobile.tap(findTestObject('Provider/Provider360/SetUpYourAvailability/facilityDrpdwnInDeliveryMethods_android'), 30);
	}

	@Keyword
	def verifyTeleMedicineDeliveryMethod() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Provider Delivery Methods/telemedicineDeliverymethod_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/telemedicineCheckboxInDeliveryMethods_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/telemedicineDrpdwnInDeliveryMethods_android'), 30);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/TeleMedicineDeliveryMethod/telemedicineDescription_android'), "Care via phone or video");
	}

	@Keyword
	def selectTeleMedicineDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/telemedicineCheckboxInDeliveryMethods_android'), 30);
	}

	@Keyword
	def compressTeleMedicineDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/telemedicineDrpdwnInDeliveryMethods_android'), 30);
	}

	@Keyword
	def verifyVanCallDeliveryMethod() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Provider Delivery Methods/vanCallDeliveryMethod_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/vancallCheckboxInDeliveryMethods_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/vancallDrpDwnInDeliveryMethods_android'),30);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/VanCallDeliveryMethod/vancallDescription_android'), "Care from one of our vans");
	}

	@Keyword
	def selectVanCallDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/vancallCheckboxInDeliveryMethods_android'), 30);
	}

	@Keyword
	def compressVanCallDeliveryMethod() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/vancallDrpDwnInDeliveryMethods_android'),30);
	}

	@Keyword
	def tapOnSaveDeliveryMethodsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/saveDeliveryMethodsBtn_android'), 30);
	}


	@Keyword
	def verifyWhereWillYouPerformLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/whereWillYouPerformLabel_android'), 30);
	}

	@Keyword
	def verifySelectAnAddressField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/selectAnAddressField_android'), 30);
	}

	@Keyword
	def verifyAddAddressLink() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/addAddressLink_android'), 30);
	}

	@Keyword
	def enterAddressName(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/addressNameField_android'), name, 30);
	}

	@Keyword
	def enterAddress(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/address1Field_android'), address, 30);
	}

	@Keyword
	def enterCity(city) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/cityField_android'), city, 30);
	}

	@Keyword
	def tapOnStateField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/stateField_android'), 30);
	}

	@Keyword
	def tapOnFLstate() {
		Mobile.tap(findTestObject('Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/flState_android'), 30);
	}

	@Keyword
	def verifyFLstateInStateField() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/txtInStateField_android'), "FL");
	}

	@Keyword
	def enterZipCode(zip) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/zipCode_android'), zip, 30);
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/saveAddressBtn_android'), 30);
	}

	@Keyword
	def tapOnSelectAddressField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/selectAnAddressField_android'), 30);
	}

	@Keyword
	def verifySavedAddress(addressName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/savedNewAddress_android', ['addressName': addressName]), 30);
	}

	@Keyword
	def tapOnSavedAddress() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/savedNewAddress_android'), 30);
	}

	@Keyword
	def verifySelectedAddress(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/defaultSelectedAddress_android', ["value": name]), name);
	}

	@Keyword
	def verifySelfRateAmountLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/facilityRateAmountTitle_android'), 30);
	}

	@Keyword
	def verifyDistanceTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/distanceTitle_android'), 30);
	}

	@Keyword
	def verifyMilesLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/milesLabel_android'), 30);
	}

	@Keyword
	def verifyDistanceSlideBar() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/distanceSlideBar_android'), 30);
	}

	@Keyword
	def enterDistanceNumber() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/distanceNumber_android'), 30);
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/distanceNumber_android'), "8", 30);
	}

	@Keyword
	def verifyRateTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/rateTitle_android'), 30);
	}

	@Keyword
	def verifyRateDescription() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/rateDescription_android'), "Set your delivery rate for non-RevPrivate members. YOUR RevPrivate members will not be charged the delivery rate. Please see the terms and conditions for your RevPrivate practice.");
	}

	@Keyword
	def verifySelfRateDescription() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/facilitySelfRateDescription_android'), "Set your self pay rate for facility visits.");
	}

	@Keyword
	def verifyRateAmountLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/rateAmount_android'), 30);
	}

	@Keyword
	def enterRateNumber(String rate = 120) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/rateNumberField_android'), 30);
		Mobile.delay(5)
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/HouseCallDeliveryMethod/rateNumberField_android'), rate, 30);
	}

	@Keyword
	def enterRateNumberInTeleMedicine() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/TeleMedicineDeliveryMethod/teleMedicineRateNumber_android'), 30);
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/TeleMedicineDeliveryMethod/teleMedicineRateNumber_android'), "120", 30);
	}

	@Keyword
	def tapOnSaveAndContinueBtnOnDeliveryMethodsPage() {
		Mobile.tap(findTestObject('Provider/Provider360/DeliveryMethods/saveDeliveryMethodsBtn_android'), defaultTime);
	}

	@Keyword
	def verifyProceduresPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/proceduresPageTitle_android'), defaultTime);
	}

	@Keyword
	def verifyNeedHelpLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/VanCallDeliveryMethod/needHelpLabel_android'), defaultTime);
	}

	@Keyword
	def verifyRevDocCanHelpLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/VanCallDeliveryMethod/revDocCanHelpLabel_android'), defaultTime);
	}

	@Keyword
	def verifyContactUsLabel() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/VanCallDeliveryMethod/contactUsLabel_android'), defaultTime);
	}

	@Keyword
	def selectAllDeliveryMethods() {
		tapOnDeliveryMethodsOption()
		verifyDeliveryMethodsPageTitle()
		verifyHouseCallDeliveryMethod()
		selectHouseCallDeliveryMethod()
		verifySelectAnAddressField()
		compressHouseCallDeliveryMethod()
		verifyFacilityDeliveryMethod()
		selectFacilityDeliveryMethod()
		verifySelfRateAmountLabel()
		compressFacilityDeliveryMethod()
		verifyTeleMedicineDeliveryMethod()
		selectTeleMedicineDeliveryMethod()
		verifyRateTitle()
		compressTeleMedicineDeliveryMethod()
		gen.swipeUp();
		verifyVanCallDeliveryMethod()
		selectVanCallDeliveryMethod()
		verifyWhereWillYouPerformLabel()
		compressVanCallDeliveryMethod()
		tapOnSaveDeliveryMethodsBtn()
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/checkBox_android',), defaultTime)
	}

	@Keyword
	def verifyUnableToDeselectPopUp() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/UnableToDeselectPopup_android'), defaultTime);
	}

	@Keyword
	def verifyUnableToDeselectPopUpOkayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/unableToDeselectPopUpOkayBtn_android'), defaultTime);
	}
}