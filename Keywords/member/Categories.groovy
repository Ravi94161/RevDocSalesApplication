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

public class Categories {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def clickOnCategory(text) {
		Mobile.scrollToText(text);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/category_android', ['text': text]), defaultTime);
	}

	@Keyword
	def verifyPriceOnProcedure(procedureName, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/priceForProcedure_android', ['procedureName': procedureName, 'price': price]), defaultTime)
	}

	@Keyword
	def clickOnProcedure(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureName_android', ['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def tapProcedureProfile(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureProfileBtn_android', ['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(text) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/bottomSheetTitle_android'), defaultTime)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/bottomSheetTitle_android'), text)
	}

	@Keyword
	def verifyScreenTitle(text) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/verifyTitleOfPage_android', ['text': text]), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/verifyTitleOfPage_android', ['text': text]), defaultTime)
	}

	@Keyword
	def tapCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/closeBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnProcedureMoreInfoBtn(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfoBtn_android', ['procedureName': procedureName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnProcedureInfoBtn(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureInfoBtn_android', ['procedureName': procedureName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyProcedureImageExist() {
		Mobile.delay(3)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureImage_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyTimeIconExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/timeIcon_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifySyringeIconExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/syringeIcon_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyCloseRedIcon( ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/closeRedIcon_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyGreenTickIcon( ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/greenTickAndroid_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyVideoPlayBtn( ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/videoPlayBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnRefundAndCancelationPolicy() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/refundAndCancellationPolicy_android'), defaultTime)
	}


	@Keyword
	def tapOnProcedureSteps() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureSteps_android'), defaultTime)
	}

	@Keyword
	def tapOnProcedureCostAndOtherDetails() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureCostAndOtherDetails_android'), defaultTime)
	}

	@Keyword
	def tapOnPostCareInstructions() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/postCareInstructions_android'), defaultTime)
	}

	@Keyword
	def tapOnManufacturesDocumentation() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/manufacturesDocumentation_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureStepsDesc(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureStepsDesc_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyPostCareInstructionsDesc(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/postCareInstructionsDesc_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def getProcedureStepsDesc() {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureStepsDesc_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyCostBreakDownPricesByItsType(priceType, cost, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/costBreakDownPrices_android', ['priceType': priceType, 'cost': cost]), defaultTime, onFailure)
	}

	@Keyword
	def verifyProcedureDeliveryMethodGreenCheckByDeliveryMethod(deliveryMethod) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/ProcedureDeliveryMethodsGreenCheckByDeliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyProcedureDeliveryMethodCrossRedByDeliveryMethod(deliveryMethod) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureDeliveryMethodsCrossRedIconByDeliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyDeliveryMethodPresentOrNot(adminDeliveryTypes, adminDeliveryType, appDeliveryType ) {
		if (adminDeliveryTypes.contains(adminDeliveryType)) {
			verifyProcedureDeliveryMethodGreenCheckByDeliveryMethod(appDeliveryType)
		} else {
			verifyProcedureDeliveryMethodCrossRedByDeliveryMethod(appDeliveryType)
		}
	}

	@Keyword
	def verifyProcedureProvidersGreenCheckByProviderType(providerType) {
		Mobile.scrollToText(providerType, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureProvidersGreenCheckByProviderType_android', ['providerType': providerType]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyProcedureProvidersCrossRedIconByProviderType(providerType) {
		Mobile.scrollToText(providerType, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/procedureProvidersCrossRedByProviderType_android', ['providerType': providerType]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOndownloadIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/downloadIcon_android'), defaultTime)
	}

	@Keyword
	def verifyPharmaMaterialProcedureSumAmount(amount) {
		//amount = $6.26
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ApproximatePrice/PharmaMaterialProcedureAmount', ['amount': amount]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyTextPresent(text) {
		//amount = $6.26
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ApproximatePrice/verifyText', ['anyText': text]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyProcedureAmount(procedureName, amount) {
		//amount = $6.26
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureAmount', ['procedureName': procedureName, 'amount': amount]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def tapOnInfoFollowedbyProcedureName(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure":procedure]), defaultTime);
	}

	@Keyword
	def verifyCloseXbtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/closeXbtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCloseXbtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/closeXbtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAddToCardBtnOnProcedureCard(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/addToCartBtn_android', ['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def tapOnSeeProviderAvailailityBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureDetails/seeProviderAvailabilityBtn_android'), defaultTime)
	}

	@Keyword
	def verifySeeProviderAvailailityBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureDetails/seeProviderAvailabilityBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnBuyNowBtnOnProcedureCard(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/buyNowBtn_android', ['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def verifyRevonePiceOnProcedureCard(procedureName, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revonePrice_android', ['procedureName': procedureName, 'price': price]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyRevplusPiceOnProcedureCard(procedureName, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revplusPrice_android', ['procedureName': procedureName, 'price': price]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnBuyNowBtnForProcedure() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureDetails/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAddToCartBtnForProcedure() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureDetails/addToCartBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnBookNowBtnForProcedure() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure profile/bookNowBtn_android'), defaultTime)
	}
	
	@Keyword
	def verifyAddToCardBtnOnProcedureCard(procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/addToCartBtn_android', ['procedureName': procedureName]), defaultTime, onFailure)
	}
	
	@Keyword
	def verifyBuyNowBtnOnProcedureCard(procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/buyNowBtn_android', ['procedureName': procedureName]), defaultTime, onFailure)
	}
	
	@Keyword
	def verifyRevTogetherTitleOnProcedureCardExist(isExist = true, procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/revTogetherTitle_android', ["procedureName":procedureName]), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/revTogetherTitle_android', ["procedureName":procedureName]), defaultTime, onFailure);
		}
	}
	
	@Keyword
	def verifyMinimumGuestsOnProcedureCardExist(isExist = true, procedureName, count, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/minimumGuests_android', ["procedureName":procedureName, "count":count]), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/minimumGuests_android', ["procedureName":procedureName, "count":count]), defaultTime, onFailure);
		}
	}
	@Keyword
	def verifyFreeForHostTitleOnProcedureCardExist(isExist = true, procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/freeForHostTitle_android', ["procedureName":procedureName]), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/revTogether/freeForHostTitle_android', ["procedureName":procedureName]), defaultTime, onFailure);
		}
	}
	
	@Keyword
	def verifyMoreInfoBtnOnProcedureCard(procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
	Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure": procedureName]), defaultTime, onFailure);
	}
}
