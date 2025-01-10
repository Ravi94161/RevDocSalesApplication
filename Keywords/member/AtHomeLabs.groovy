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
import  providerRegistration.ContactInformation;
import internal.GlobalVariable
import mobile.Generic
import member.SelectAddresses
import member360.Demographics
import provider360.HomeShippingAddress
import mobile.Utility

public class AtHomeLabs {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	ContactInformation cont =new ContactInformation();
	Generic gen=new Generic();
	HomeShippingAddress address=new HomeShippingAddress();
	SelectAddresses selectAdd = new SelectAddresses();
	Demographics demo = new Demographics();
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;
	Utility util = new Utility()

	@Keyword
	def tapOnAtHomeLabsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/atHomeLabsOption_android'), defaultTime);
	}
	@Keyword
	def tapOnOrderLabsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/orderLabs_android'), defaultTime);
	}

	@Keyword
	def verifyAtHomeLabsScreenTitle(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/atHomeLabsScreenTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/backBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def typeInSearchLabs(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_android'), text,  defaultTime);
		Mobile.hideKeyboard();
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime);
	}

	@Keyword
	def tapOnAddPlusBtnOfIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/addPlusBtn_android', ['index':index]), defaultTime);
	}

	@Keyword
	def tapOnAddToCartBtn(index = 1) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/At Home Labs/labImageView_android', ['index':index]), defaultTime, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/labImageView_android', ['index':index]), defaultTime);
		Mobile.delay(10);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/addToCartBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCheckOutBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutBtn_android'), defaultTime);
	}

	@Keyword
	def verifyElementExist(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddress(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnDeliveryAddressOption() {
		Mobile.scrollToText("Delivery Address", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/deliveryAddressOption_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/selectAddress_android'), defaultTime);
	}

	@Keyword
	def tapOnAddAnotherAddress() {
		Mobile.scrollToText("Add another address", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/addAnotherAddress_android'), defaultTime);
	}
	@Keyword
	def tapOnMakeDefaultDeliveryAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/makeDefaultDeliveryAdd_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/saveBtn_android'), defaultTime, onFailure);
		Mobile.delay(15);
	}
	@Keyword
	def fillDetailsInAddressScreen(address) {
		demo.tapOnAddressField();
		enterAddressINSearchField(address)
		Mobile.delay(5)
		selectAdd.tapFirstSearchResult();
		demo.typeInNameOfAddressInput("Work");
		def randomFiveDigitNumber = new Random().nextInt(100000).toString().padLeft(5, '0');
		setTextInArrivalInstrcuctionsTxtBox(randomFiveDigitNumber);
		Mobile.scrollToText("Make default", FailureHandling.OPTIONAL);
		tapOnMakeDefaultDeliveryAddress();
		tapOnSaveBtn();
		return randomFiveDigitNumber;
	}

	@Keyword
	def enterAddressINSearchField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/At Home Labs/searchAddressField_android'), txt, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnEditGrayOption() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/editGrayOption_android'), defaultTime);
	}
	@Keyword
	def tapOnEditGrayBtnForSpecificAddress(text) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/editGrayBtnForSpecificAddress_android', ["text":text]), defaultTime);
	}
	@Keyword
	def setTextInArrivalInstrcuctionsTxtBox(text) {
		Mobile.setText(findTestObject('Object Repository/Member/At Home Labs/arrivalInstructionsTxtBx_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def editDetailsInAddressScreen(address) {
		demo.tapOnAddressField();
		enterAddressINSearchField(address)
		Mobile.delay(5)
		selectAdd.tapFirstSearchResult();
		Mobile.delay(5)
		def add = getSelectedAddressText();
		tapOnSaveBtn();
		Mobile.delay(4)
		return add;
	}
	@Keyword
	def getSelectedAddressText() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/getSelectedAddressText_android'), defaultTime);
	}
	@Keyword
	def getTxtOfPriceOfCare(userType) {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/priceOfCare_android',['userType':userType]), defaultTime);
	}
	@Keyword
	def getTxtOfQuantity() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/getQuantity_android'), defaultTime);
	}
	@Keyword
	def getTxtOfSubTotal() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/getSubTotalText_android'), defaultTime);
	}
	@Keyword
	def tapOnContinueShoppingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/continueShoppingBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnContinueToPurchaseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/continueToPurchaseBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnAddToCartBtn2() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/addToCartBtn2_android'), defaultTime);
	}
	@Keyword
	def tapOnSettingsIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/settingsIcon_android'), defaultTime);
	}
	@Keyword
	def tapOnPasswordAndSecurityOption() {
		Mobile.scrollToText("Password and Security", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Settings/PasswordAndSecurityOption_android'), defaultTime);
	}
	@Keyword
	def tapOnUseBiometricToggle() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/useBiometricsToggle_android'), defaultTime);
	}
	@Keyword
	def verifyItemImage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/ItemImage_android'), defaultTime);
	}
	@Keyword
	def verifyItemName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/ItemName_android'), defaultTime);
	}
	@Keyword
	def verifyPriceOfRev1(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/OrderSummary/rev1Price_android', ['index':index]), defaultTime);
	}
	@Keyword
	def verifyPriceOfRevPlus(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/OrderSummary/revplusPrice_android', ['index':index]), defaultTime);
	}
	@Keyword
	def verifyRemoveOfBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/removeBtnInCart_android'), defaultTime);
	}
	@Keyword
	def verifySaveForLaterBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/saveForLaterBtn_android'), defaultTime);
	}

	@Keyword
	def searchLab(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/At Home Labs/searchLab'), txt, defaultTime)
	}

	@Keyword
	def verifyAddToCartBtn(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/addToCartBtn_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyPersonIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/personIcon_android'), defaultTime);
	}

	@Keyword
	def verifyProcedureDiscription(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/procedureDiscription_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyVideoIsVisible() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/At Home Labs/video_android'), 30);
	}

	@Keyword
	def verifySearchField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_android'), 30);
	}
	@Keyword
	def tapOnClose() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/searchClose_android'), defaultTime);
	}

	@Keyword
	def verifyProcedureNameElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/procedureName1_android'), defaultTime);
	}

	@Keyword
	def getProedureName1() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/procedureName1_android'), defaultTime);
	}

	@Keyword
	def getProedureNameByIndex(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/procedureName2_android',["index":index]), defaultTime);
	}
	@Keyword
	def getLabNameByIndex(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/getLabName_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyLabNameByIndex(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/getLabName_android',["index":index]), defaultTime);
	}

	// Promo Details

	@Keyword
	def verifyPromoTag() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoTag_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPromoAvailableBadge() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoAvailableBadge_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPromoAvailableBadgePresent(itemName, boolean stopOnfailure) {

		def failureMessage = "Promo badge is not shown for item = " + itemName
		if(stopOnfailure) {
			util.verifyElementPresent(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoBadge', ['itemName': itemName]), failureMessage)
		}
		else {
			util.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoBadge', ['itemName': itemName]), failureMessage)
			//Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoBadge', ['itemName': itemName]), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapPromoAvailableBadge(itemName) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoBadge', ['itemName': itemName]), defaultTime);
	}

	@Keyword
	def verifyPromoInfoIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoInfoIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnPromoInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoInfoIcon_android'), defaultTime);
	}

	@Keyword
	def verifyPromoTitle(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoTitle_android'), text, onFailure);
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPromoUsedPercentage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoUsedPercentage_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPromoExpireDate() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoExpireDate_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyDetailsBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/detailsBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/buyNowBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCloseWithBordersIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/closeWithBordersIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnLabsInAtHomeLabsByName(labsName) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/selectLabsInAtHomeLabs_android',["labsName":labsName]), defaultTime);
	}

	@Keyword
	def verifyRevPlusAndPrivatePrice() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/revPrivatePrice_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRevPlusPrice() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/revPlusPrice_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRevOnePrice() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/revOnePrice_android'), defaultTime, onFailure);
	}

}
