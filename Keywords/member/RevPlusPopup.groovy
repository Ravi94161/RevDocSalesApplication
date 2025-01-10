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

public class RevPlusPopup {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyRevPlusLogoExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/revPlusLogo_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteHeartIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/inviteHeartIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyInviteBtn(isEnabled = true , onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/inviteBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def tapOnInviteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/inviteBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySelectYourRevPlusProviderBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/selectYourRevPlusProviderBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSelectYourRevPlusProviderBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/selectYourRevPlusProviderBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRevPlusProviderSearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/revPlusProviderSearchField_android'), defaultTime, onFailure);
	}

	@Keyword
	def getProviderName() {
		return Mobile.getText(findTestObject('Object Repository/Member/RevPlus Popup/SelectAProvider/getProviderName_android'), defaultTime);
	}

	@Keyword
	def tapOnRequestInterviewBtnByProvider(providerName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/SelectAProvider/requestInterviewBtnByProvider_android', ['providerName': providerName]), defaultTime, onFailure);
	}

	@Keyword
	def typeInRevPlusProviderSearchField(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/RevPlus Popup/revPlusProviderSearchField_android'), text, defaultTime, onFailure)
	}

	@Keyword
	def verifyPendingLabelExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/pendingLabel_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelRequestsBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/cancelRequestBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCancelRequestsBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/cancelRequestBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyManageBtnExistsByProviderName(providerName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/manageBtnByProviderName_android', ['name': providerName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyRequestInterviewBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/requestInterviewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRequestInterviewBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/requestInterviewBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyrevDocPlusRectangleLogo(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/revDocPlusRectangleLogo_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCloseOutLine(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/closeOutLine_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseOutLine(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/closeOutLine_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMyFavoritesBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/myFavoritesBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMyFavoritesBtn(onFailure =  FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/myFavoritesBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMyFavoritesLogo(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/myFavoritesBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySpecificOption(contentDesc, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/specificContentDesc_android',["contentDesc":contentDesc]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSpecificOption(contentDesc, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/specificContentDesc_android',["contentDesc":contentDesc]), defaultTime, onFailure)
	}

	@Keyword
	def verifyPrescriptionIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/prescriptionBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyBookAppointmentIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/bookAppointmentBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyExclusiveSpecialsIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/exclusiveSpecialIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPromoIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/promoBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRebookIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/rebookBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyProgramIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/programIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyManageIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/manageBtnInRevPlus_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnManageIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.scrollToText("Manage", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBtnInRevPlus_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMessageIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/messageIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMessageBtnExist(isEnabled = false, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/messageBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def verifyManageBtnExist(isEnabled = false, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/manageBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def verifyRXGlassIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/rxGlassIcon'), defaultTime, onFailure)
	}

	@Keyword
	def verifyFaceToFaceIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/faceToFaceHouseIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyBookBtnExist(isEnabled = false, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/bookBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def verifySpecialityPharmacyMedsIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/faceToFaceHouseIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyOrderBtnExist(isEnabled = false, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/orderBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def verifyHandShakeIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/handShakeIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySearchBtnExist(isEnabled = false, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime)  {
		isEnabled = isEnabled ? 'true': 'false'
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/searchBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
		Mobile.verifyElementAttributeValue(obj, 'enabled', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def verifyAfiliatedManageLogoIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/manageAffiliatedLogoIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAfiliatedManageLogoIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/manageAffiliatedLogoIcon_android'), defaultTime, onFailure)
	}

	//--------------------------------------------Exclusive Benefits--------------------------------
	@Keyword
	def verifyExclusiveBenefitsBookBtnEnabled(isEnabled = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/exclisiveBenefitsBookbtn_android', ["isEnabled":isEnabled]), defaultTime, onFailure);
	}

	@Keyword
	def verifyGiftIconExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/giftIcon_android')
		return isExist == true ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure);
	}

	@Keyword
	def verifyExclusiveBenefitsTagExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/exclusiveBenfitsTag_android')
		return isExist == true ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure);
	}

	@Keyword
	def verifyExclusiveBenefitsBookBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/exclusiveBenfitsBookBtn_android')
		return isExist == true ? Mobile.verifyElementExist(obj, defaultTime, onFailure) : Mobile.verifyElementNotExist(obj, defaultTime, onFailure);
	}

	@Keyword
	def verifyAffiliateNameFromExclusiveBenefitsExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/getAffiliatedName_android'), defaultTime);
	}

	@Keyword
	def getAffiliateNameFromExclusiveBenefits() {
		return Mobile.getText(findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/getAffiliatedName_android'), defaultTime);
	}

	@Keyword
	def tapOnExclusiveBenefitsBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/exclusiveBenefits/exclisiveBenefitsBookbtn_android', ["isEnabled":true]), defaultTime);
	}
	//--------------------------------------------close-Exclusive Benefits--------------------------------
	//-----------------------------------------Membership--------------------------------------------------
	@Keyword
	def getMonthlyPriceText() {
		//check promo lable on Monthly btn
		def isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/Membership/promoOnMonthlyBtn_android'), defaultTime, FailureHandling.OPTIONAL)
		if(isExist) {
			return Mobile.getText(findTestObject('Object Repository/Member/RevPlus Popup/Membership/getMonthlyPriceWithoutPromo_android'), defaultTime);
		} else {
			return Mobile.getText(findTestObject('Object Repository/Member/RevPlus Popup/Membership/getMonthlyPriceText_android'), defaultTime);
		}
	}

	@Keyword
	def getYearlyPriceText() {
		return Mobile.getText(findTestObject('Object Repository/Member/RevPlus Popup/Membership/getYearlyPriceText_android'), defaultTime);
	}

	@Keyword
	def tapOnAffiliationPartnershipSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/affiliationPartnershipSearchBtn_android'), defaultTime)
	}

	//-----------------------------------------close - Membership--------------------------------------------------
	@Keyword
	def tapOnManagePrescriptionBtn(onFailure =  FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/RevPlus Popup/Membership/managnePrescriptionBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyManagePrescriptionBtnExist(onFailure =  FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevPlus Popup/Membership/managnePrescriptionBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyGetStartedBtnExist(onFailure =  FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/getStartedBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyContinueToSelectLocationBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/continueToSelectLocationBtn_android'), defaultTime, onFailure);
	}
}

