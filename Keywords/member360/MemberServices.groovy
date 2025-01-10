package member360

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
import mobile.Generic
import mobile.MobileActions
import member.MyPrograms

public class MemberServices {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	MobileActions mobile = new MobileActions();
	MyPrograms my = new MyPrograms();
	def onFailure=FailureHandling.STOP_ON_FAILURE;

	@Keyword
	def tapOnAtHomeLabsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/atHomeLabsOption_'+os), defaultTime);
	}

	@Keyword
	def typeInSearchLabs(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_android'), text,  defaultTime);
		mobile.scrollUntilElementIsVisible(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ));
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime);
	}

	@Keyword
	def typeInSearchLabsWithoutTappingHomelabs(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_android'), text,  defaultTime);
	}

	@Keyword
	def clearTextSearchLabs() {
		Mobile.clearText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchLabsOptionsElement(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchNameTextWithIndex(text,index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifySearchNameText_'+os, ['text': text, 'index': index] ), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchLabsOptionsElementNotExist(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCategorysOptionsElement(text) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime);
	}

	@Keyword
	def verifyCategorysOptionsElement(text,failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime, failure);
	}

	@Keyword
	def verifyCategoryOptionsElementNotExist(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), 5, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPriceText(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyPriceText_'+os, ['price': price] ), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPriceByUserType(userType, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labPriceByUserType_'+os, ['userType':userType, 'price': price] ), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPriceInLabKitDetails(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/More Info/verifyPriceInLabKitDetails_'+os, ['price': price] ), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPriceTextWithIndex(price, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyPriceTextWithIndex_'+os, ['price': price, 'index': index] ), defaultTime, onFailure);
	}

	@Keyword
	def tapOnMinusBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/minusBtn_'+os,['name': name]), defaultTime);
	}

	@Keyword
	def tapOnPlusBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/plusBtn_'+os,['name': name]), defaultTime);
	}

	@Keyword
	def verifyItemsCount(text, number) {
		Mobile.verifyElementExist(findTestObject('Member/HomePage/Member Services/At Home Labs/itemsCount_android', ['text': text, 'number': number]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnLearnMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/learnMoreBtn_android'), defaultTime);
	}

	@Keyword
	def verifyProcedureStepsElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/procedureSteps_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnProcedureSteps() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/procedureSteps_'+os), defaultTime);
	}

	@Keyword
	def verifyLabKitDetailsElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labKitDetails_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnLabKitDetails() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labKitDetails_'+os), defaultTime);
	}

	@Keyword
	def verifyPostCareInstructionsElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/postCareInstructions_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyWhatsNextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/whatsNext_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyManufacturersDocumentationElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/manufacturersDocumentation_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddToCartBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/addToCartBtn_android', ['index':index]), defaultTime);
	}

	@Keyword
	def tapOnLabCardByName(lab) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labNameCard_android', ['lab':lab]), defaultTime);
	}

	@Keyword
	def tapOnLabCardByIndex(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labNameCardByIndex_android', ['index':index]), defaultTime);
	}

	@Keyword
	def tapOnLabCardCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/labCardCloseBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyAddToCartTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/addToCartText_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyAddToCartBtnDisable() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/addToCartDisableBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyContinueShoppingTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/continueShoppingText_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyCheckoutTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutText_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/closeBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
		Mobile.delay(8);
	}


	@Keyword
	def swipeUp() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(10)
	}

	@Keyword
	def tapOnCartIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/cartIcon_android'), defaultTime)
	}

	@Keyword
	def verifyCardVisibleInCartPage() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/cardInCartPage_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyNoItemsInCartMsg() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/noItemsInCartMsg_android'), defaultTime)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnPlusBtnOne(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/plusBtnOne_'+os,['index':index]), defaultTime);
	}


	@Keyword
	def verifyRevOnePriceElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevOnePrice_'+os), text);
	}

	@Keyword
	def verifyRevPlusPrivatePriceElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevPlusPrivatePrice_'+os), text);
	}

	@Keyword
	def verifyUSDElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyUSD_'+os), text);
	}

	@Keyword
	def verifybaseCartItemTitleDetailElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifybaseCartItemTitleDetail_'+os), text);
	}

	@Keyword
	def tapOnPlaceOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/placeOrderBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyItemPriceLabelDisplayExpAmtElementText(index, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevOneItemPriceLabel_'+os, ['index': index]), text, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def trimTxtToGetOnlyPrice(text) {

		def matcher = (text =~ /(-?\$\d+(\.\d{2})?)/)

		if (matcher.find()) {
			String amount = matcher.group(1)
			println(amount) // Output: -$10
			return amount
		} else {
			println("No match found")
			return null
		}
	}

	@Keyword
	def verifyTotalPriceElementText(text, index = 1, type = "promo") {
		if(type == "prog") {
			def amt = Mobile.getText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevOneTotalPrice_'+os, ['index': index]), defaultTime)
			def trimmedAmt = trimTxtToGetOnlyPrice(amt)
			Mobile.verifyEqual(trimmedAmt, text, FailureHandling.CONTINUE_ON_FAILURE)
		}
		else {
			Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevOneTotalPrice_'+os, ['index': index]), text, FailureHandling.CONTINUE_ON_FAILURE);
		}
	}

	@Keyword
	def verifyRevPlusPrivatePriceCheckPOCElementText(index, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyRevPlusPrivateItemPriceLabel_'+os, ['index': index]), text, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPaymentSummaryElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyPaymentSummary_'+os), text, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnReceiptsOptionsRight() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/receiptsOptionsRight_'+os), defaultTime);
	}

	@Keyword
	def verifyReceiptsPriceElementText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyReceiptsPrice_'+os), text,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnViewDetailsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/viewDetailsBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyElementText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyText_'+os, ['text': text]), defaultTime,FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/verifyText_'+os, ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnRevPrivateCloseBtn(defaultTime = defaultTime) {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/revPrivateCloseBtn_android'), defaultTime);
		} catch(Exception e) {
			println("Element not found");
		}
	}

	@Keyword
	def tapOnPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/addPlusBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnContinueShoppingTxt() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/continueShoppingBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnCheckOutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/checkoutBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/yesOptnInConfirmPopUp_'+os), defaultTime);
	}

	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/noOptnInConfirmPopUp_'+os), defaultTime);
	}

	@Keyword
	def tapOnMoveToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/moveToCart_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveForLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/saveForLater_android'), defaultTime);
	}

	@Keyword
	def tapOnRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/removeBtnInCart_android'), defaultTime);
	}

	@Keyword
	def tapOnInsuranceOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/InsuranceOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnEditOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/EditOptn_'+os), defaultTime);
	}

	@Keyword
	def ClearSearchBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/clearSearchBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnSearchBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SearchInsuranceOptn_'+os), defaultTime);
	}

	@Keyword
	def EnterInsuranceInSearchBx(Insurance) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SearchInsuranceOptn_'+os), Insurance, defaultTime);
	}

	@Keyword
	def chooseInsuranceFromListedOptions() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SearchInsuranceOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAllergiesOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/AllergiesOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalAllergiesOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/AddAdditionalAllergy_'+os), defaultTime);
	}

	@Keyword
	def verifyAllergyTextBxPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalAllergyTxtBox_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SaveOptn_android'+os), defaultTime);
	}

	@Keyword
	def verifyReactionDropDownPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalReactionTxtBx_android'), defaultTime);
	}

	@Keyword
	def tapOnDeleteAllergyOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/DeleteIconForAdditionalAllergies_'+os), defaultTime);
	}

	@Keyword
	def tapOnMyAddresses() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MyAddresses_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalAddresses() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/addAdditionalAddresses_'+os), defaultTime);
	}

	@Keyword
	def scrollToAddAdditionalAddressesAndTap() {
		while(!(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/addAdditionalAddresses_'+os), defaultTime, FailureHandling.OPTIONAL))) {
			gen.swipeUp();
		}
		tapOnAddAdditionalAddresses();
	}
	@Keyword
	def verifyAddAdditionalAddressesExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/addAdditionalAddresses_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyMyAddressesHeaderTextPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MyAddressesHeaderText_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyEmptyCartMessagePresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Member Services/At Home Labs/emptyCartMsgText_'+os), defaultTime);
	}

	@Keyword
	def tapOnContinueToHealthRecords() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Member Services/At Home Labs/continueToHealthRecordsBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/backBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnPayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/payBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnLabResults() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResultsOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnUploadOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/UploadOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnViewMore() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/viewMoreOptn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddPlusBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/addPlusBtn_'+os,['index': index]), defaultTime);
	}

	@Keyword
	def tapOnProceedToCheckOutOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/proccedToCheckOut_'+os), defaultTime);
	}

	@Keyword
	def verifyProceedToCheckOutOptnPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/proccedToCheckOut_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyUploadOptnPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/UploadOptn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyProcedureNameElementExist(procedure) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/verifyProcedureName_'+os,['procedure':procedure]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def tapOnFirstLab(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/addPlusBtn_'+os,['index': index]), defaultTime);
	}

	// Add multiple labs to cart from promos

	@Keyword
	def addMultipleLabsToCartFromPromos(count) {
		tapOnLabCardByIndex(count-1);
		tapOnAddToCartBtn();
		my.tapOnContinueBtn();
		tapOnContinueShoppingTxt();
		tapOnLabCardCloseBtn();
		tapOnLabCardByIndex(count);
		tapOnAddToCartBtn();
		my.tapOnContinueBtn();
		tapOnCheckoutBtn();
	}
}
