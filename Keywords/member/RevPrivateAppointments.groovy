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
import mobile.MobileActions
import mobile.Generic

public class RevPrivateAppointments {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions ma = new MobileActions()
	HomePage home = new HomePage();
	Generic gen = new Generic()

	@Keyword
	def verifyPriceOnTitle(procedure, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyPriceOnTitle_'+os, ['procedure':procedure, 'price': price]), defaultTime);
	}
	@Keyword
	def tapOnProcedureProfileBtn(procedure, price) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/procedureProfileBtn_'+os, ['procedure':procedure, 'price': price]), defaultTime);
	}
	@Keyword
	def verifyPrice(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyPrice_'+os, ['price': price]), defaultTime);
	}
	@Keyword
	def verifyProcedureName(procedure) {
		Mobile.scrollToText(procedure, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/procedureName_'+os, ['procedure': procedure]), defaultTime);
	}
	@Keyword
	def tapOnBookAppointmentBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/bookAppointmentBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBookAppointmentBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/bookAppointmentBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/closeBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnProcedureCheckbox(procedure) {
		Mobile.scrollToText(procedure, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/procedureCheckbox_android', ['procedure':procedure]), defaultTime);
	}
	@Keyword
	def tapOnViewAvailabilitiesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/viewAvailabilitiesBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnSelectAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/selectAddress_'+os), defaultTime);
	}
	@Keyword
	def typeInRevPrivateAddress(address) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/RevPrivate/Address/addressInput_'+os),address, defaultTime);
	}
	@Keyword
	def tapOnFirstResultAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/Address/selectFirstAddress_android'), defaultTime);
	}
	@Keyword
	def tapOnViewAllBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/viewAllBtn_'+os, ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnProviderViewAllBtn(provider) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerViewAllBtn_'+os, ['provider':provider]), defaultTime);
	}
	@Keyword
	def verifySlotPrice(index, price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifySlotPrice_'+os, ['index':index]), price,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def tapOnRevPrivateCloseBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCloseBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyAndtapOnRevPrivateCloseBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = 15) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCloseBtn_'+os), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCloseBtn_'+os), defaultTime);
		}
	}

	@Keyword
	def tapOnRevPrivateBtn() {
		home.tapOnManageBenefitsBtn()
//		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/membershipBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyStrickoutPriceInCart(price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/strickoutPriceInCart_'+os), price);
	}
	@Keyword
	def verifyStrickoutPriceInCheckoutTitle(price) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/strickoutPriceInCheckoutTitle_'+os), price,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyStrickoutPriceInCheckoutPaymentSummary(price,procedure) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/strickoutPriceInCheckoutPaymentSummary_'+os, ['procedure':procedure]), price,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyRevdocPrivateSavings(price) {
		def revPrice = Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/revdocPrivateSavings_'+os), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.verifyEqual(revPrice, price)
	}
	@Keyword
	def verifyPriceInCart(procedure,price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyPriceInCart_'+os, ['procedure':procedure]), price);
	}
	@Keyword
	def verifySubTotalInCart(price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifySubTotalInCart_'+os), price);
	}
	@Keyword
	def verifyPriceInCheckout(price,index) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyPriceInCheckout_'+os, ['index':index]), price,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyPaymentSummaryPrice(price) {
		Mobile.scrollToText("Total", FailureHandling.OPTIONAL);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyPaymentSummaryPrice_'+os), price,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyTotalPriceInCheckout(price) {
		Mobile.scrollToText("Total", FailureHandling.CONTINUE_ON_FAILURE);
		def actualPrice = Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/verifyTotalPriceInCheckout_'+os), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		actualPrice = actualPrice.trim()
		ma.verifyEqual(actualPrice, price, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def verifyrevdocPrivateSavings1(price,index) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/revdocPrivateSavings1_'+os, ['index':index]), price);
	}
	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/RevMoney/cancelBtnInRevMoneyBtnSheet_android'), defaultTime);
	}
	@Keyword
	def tapOnBenefitsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/benefitsBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnRevprivateXBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCloseBtn_android'), defaultTime)
	}
	@Keyword
	def verifymanageBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/manageBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnManageButton() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/manageBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyYouPayLabel(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/youPayLabel_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRevPrivateDetails(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateDetails_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyViewMoreBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/viewMoreBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyDedicatedTo200RevPatientsTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/dedicatedTo200RevPatients_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyAge1To100YearTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/age1To100YearOldTxt_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyTypicalStaffAvailability(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/typicalStaffAvailability_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRevPrivateCategories(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCategories_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyWelcomeBackText(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/welcomeBackTxt_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCancelBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/cancelBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def getProviderName(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/ProviderName_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyProviderNameExist(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/verifyItemName_android', ['text': text]), defaultTime);
	}
	@Keyword
	def verifyProviderImageExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/VerifyItemImage_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnMyMedicalBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/MyMedicalBtn_android'), defaultTime)
	}
	@Keyword
	def verifyMsgRevPrivateProviderBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/MessageYourRevPrivateProviderBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAnyProvider(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/ProviderName_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnGradientCloseBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/gradientCloseBtn_android', ['index': index]), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnFindProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/findProviderBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnRevprivateCategory() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateCategory_android'), defaultTime);
	}
	@Keyword
	def verifyMessagePracticeBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/messagePractice_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyProviderName(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/ProviderName_android', ['index': index]), text, onFailure)
	}
	@Keyword
	def verifyProviderType(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerType_andriod', ['index': index]), text, onFailure)
	}
	@Keyword
	def verifyProviderLocation(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerLocation_andriod', ['index': index]), text, onFailure)
	}
	@Keyword
	def verifyProviderHsaCheck(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/hsaCheck_andriod', ['index': index]), text, onFailure)
	}
	@Keyword
	def verifyProviderCashCredit(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/cashCredit_andriod', ['index': index]), text, onFailure)
	}

	@Keyword
	def getProviderType(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerType_andriod', ['index': index]), defaultTime);
	}

	@Keyword
	def getProviderLocation(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerLocation_andriod', ['index': index]), defaultTime);
	}

	@Keyword
	def getProviderHsaCheck(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/hsaCheck_andriod', ['index': index]), defaultTime);
	}

	@Keyword
	def getProviderCashCredit(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/cashCredit_andriod', ['index': index]), defaultTime);
	}
	@Keyword
	def getProviderStars(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/reviewStars_andriod', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyProviderInsurance(text, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/providerInsurance_andriod', ['index': index]), text)
	}
	@Keyword
	def verifyProviderStars(text, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/RevPrivate/reviewStars_andriod', ['index': index]), text)
	}
	@Keyword
	def verifyMessageProviderBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/msgProvider_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyProviderNameTitleExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/ProviderName_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyProviderTypeElementExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerType_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnBookOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/Bookoptn_android'), defaultTime);
	}
	@Keyword
	def getProcedurePrice() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/RevPrivate/getProcedurePrice_andriod'), defaultTime)
	}
	@Keyword
	def tapOnPromoInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoInfoIcon_android'), defaultTime);
	}
	
	@Keyword
	def verifyPromosAvailableTagNotExist(procedure) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Promos/promosAvailableBtn_android', ['procedure':procedure]), defaultTime, FailureHandling.OPTIONAL);
	}
	
	@Keyword
	def scrollToPromosAvailableTagForProcedure(procedure) {
		int count = 0
		while(verifyPromosAvailableTagNotExist(procedure) && count <= 5) {
			gen.swipeUpLittle()
		}
	}
	
	@Keyword
	def tapOnPromoCodeDetailsBtn(promoName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/PromoCodeDetailsBtn_andriod', ["promoName": promoName]), defaultTime)
	}

	@Keyword
	def tapOnBookAppoinmentBtnByProcedure(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/bookAppoinmentBtnByProcedure_andriod',["procedureName": procedureName]), defaultTime)
	}

	@Keyword
	def tapOnPromoInfoIconByProcedureName(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/revPrivatePromoByProcedureName_android',["procedure": procedure]), defaultTime);
	}

	@Keyword
	def verifyPromoInfoIconByProcedureName(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/revPrivatePromoByProcedureName_android',["procedure": procedure]), defaultTime);
	}
}
