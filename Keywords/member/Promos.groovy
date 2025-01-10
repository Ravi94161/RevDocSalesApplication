package member
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import mobile.Generic
import mobile.MobileActions
import member360.Medications
import member360.MemberServices

public class Promos {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions mobile = new MobileActions();
	Generic gen = new Generic();
	Medications med = new Medications()
	MemberServices ms = new MemberServices()
	SettingsPage sp = new SettingsPage()

	@Keyword
	def tapOnPromoCodeDetailsBtn(promoName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/PromoCodeDetailsBtn_andriod', ["promoName": promoName]), defaultTime)
	}

	@Keyword
	def tapOnAddToCartBtnOfPromoCode(promoName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/addCartOfPromoCode_andriod', ["promoName": promoName]), defaultTime)
	}

	@Keyword
	def getPromoCodeDetails(name, index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/getDetailsOfPromoCode_andriod', ["name": name, "index": index]), defaultTime)
	}

	@Keyword
	def verifyPromosIconExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Promos", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/promosIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnPromosIcon() {
		sp.tapOnAccountIcon();
		Mobile.delay(5)
		Mobile.scrollToText("Promotions", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Account/promotionsOption_android'), defaultTime);
	}

	@Keyword
	def verifyMembersOnlyBadgeExists() {
		Mobile.scrollToText("Promos", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/membersOnlyBadge_android'), defaultTime);
	}

	@Keyword
	def verifyRevPlusOnlyBadgeExists(promoName, isExist = true) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/revPlusOnlyBadge_android', ["promoName": promoName]), defaultTime);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Promos/revPlusOnlyBadge_android', ["promoName": promoName]), defaultTime);
		}
	}

	@Keyword
	def verifyRevOneOnlyBadgeExists(promoName, isExist = true) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/revOneOnlyBadge_android', ["promoName": promoName]), defaultTime);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Promos/revOneOnlyBadge_android', ["promoName": promoName]), defaultTime);
		}
	}

	@Keyword
	def verifyCloseBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/closeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseButton(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyShareIconExists(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/shareIcon_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnShareIcon(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/shareIcon_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyBookAppointmentBtnExists(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/bookAppointmentBtn_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyDetailsBtnExists(promoName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android', ["promoName":promoName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddToCartBtnExists(promoName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/addToCart_android',["promoName":promoName]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddToCartBtnWithPromoName(promoName,  defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/addToCart_android',["promoName":promoName]), defaultTime);
	}

	@Keyword
	def swipeUpLittleIfElementIsNotVisible(TestObject element) {
		if(Mobile.verifyElementNotExist(element, 20, FailureHandling.OPTIONAL)) {
			gen.swipeUpLittle();
		}
	}

	@Keyword
	def tapOnDetailsBtnWithPromoName(promoName,  defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promoName]), defaultTime);
	}

	@Keyword
	def getPromoDetailsByType(type, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/getPromoDetailsByType_android',["type": type]), defaultTime)
	}

	@Keyword
	def getPromoPrice() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/PromoDetails/getPromoPrice_android'), defaultTime)
	}

	@Keyword
	def getPromoCodeName(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/getPromoCodeName_android', [ "index": index]), defaultTime)
	}

	@Keyword
	def getPromoCode() {
		gen.swipeUpLittle()
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/PromoDetails/getPromoCode_android'), defaultTime)
	}

	@Keyword
	def tapOnBookAppointmentBtnByName(promoName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/tapOnBookAppointmentByName_android',["promoName": promoName]), defaultTime);
	}

	@Keyword
	def getCurrentClaimOrRedemptionPercentage(TestObject element) {
		return Mobile.getText(element, defaultTime)
	}

	@Keyword
	def verifyBookAppointmentBtnByNameExists(promoName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/tapOnBookAppointmentByName_android',["promoName": promoName]), defaultTime);
	}

	@Keyword
	def verifyBookAppointmentBtnNotExists(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Promos/bookAppointmentBtn_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyBookAppointmentPromoName(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/bookAppointmentPromoName_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBookAppointmentBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/bookAppointmentBtn_android', ["index":index]), defaultTime);
	}

	@Keyword
	def tapOnFirstBookAppointmentDetailsBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/firstBookAppointmentDetailsBtn_android', ["index":index]), defaultTime);
	}

	@Keyword
	def tapOnViewBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/viewBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnDetailsBtn(promo) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',  ["promoName":promo]), defaultTime);
	}

	@Keyword
	def getPromoName() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Promos/nameOfThePromo_android'), defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodWithCheckMarkOnPromo(delivery) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/deliverymethodWithCheckMark_android', ['delivery': delivery]), defaultTime)
	}

	@Keyword
	def tapOnClosePromos() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/closeBtn_andriod'), defaultTime)
	}

	@Keyword
	def getPromoDetailsAndAddToCart(promotionName) {
		tapOnPromosIcon();
		def data = getPromoDetailsAndAddToCartInPromoScreen(promotionName)
		return [offAmount: data.offAmount, promoCode: data.promoCode]
	}

	@Keyword
	def getPromoDetailsAndAddToCartInPromoScreen(promotionName) {
		Mobile.scrollToText(promotionName, FailureHandling.OPTIONAL);
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		mobile.scrollUntilElementIsVisible(detailsTestObj);
		tapOnDetailsBtnWithPromoName(promotionName);
		def offAmount = getPromoPrice();
		def promoCode = getPromoCode();
		med.tapOnClose()
		tapOnAddToCartBtnWithPromoName(promotionName);
		return [offAmount: offAmount, promoCode: promoCode]
	}

	@Keyword
	def getPromoDetailsAndAddMultipleLabsInPromoScreen(promotionName, count = 2) {
		tapOnPromosIcon();
		Mobile.scrollToText(promotionName, FailureHandling.OPTIONAL);
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		mobile.scrollUntilElementIsVisible(detailsTestObj);
		tapOnDetailsBtnWithPromoName(promotionName);
		def offAmount = getPromoPrice();
		def promoCode = getPromoCode();
		med.tapOnClose()
		tapOnAddToCartBtnWithPromoName(promotionName);
		ms.addMultipleLabsToCartFromPromos(count);
		return [offAmount: offAmount, promoCode: promoCode]
	}

	@Keyword
	def getPromoDetailsAndTapOnBookAppt(promotionName, scrollCount = 18) {
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		def text = "RevDoc promo codes are an easy way to save! We automatically find and apply promos at checkout."
		def detailsTestObj2 = findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text])
		tapOnPromosIcon();
		mobile.scrollDownUntilElementIsVisible(detailsTestObj2, scrollCount, 5);
		mobile.scrollUntilElementIsVisible(detailsTestObj, 25, 5);
		tapOnDetailsBtnWithPromoName(promotionName);
		def offAmount = getPromoPrice();
		def promoCode = getPromoCode();
		med.tapOnClose()
		tapOnBookAppointmentBtnByName(promotionName);
		return [offAmount: offAmount, promoCode: promoCode]
	}

	@Keyword
	def verifyPromoAvailableForProcedure(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/promoAvailableForProcedure_android', ['procedureName': procedureName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnPromoAvailableForProcedure(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/promoAvailableForProcedure_android', ['procedureName': procedureName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyPromoDetailsValues(promoDetail, value) {
		Mobile.scrollToText(promoDetail, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/PromoDetails/promoTypeValueByPromoType_android', ['promoDetail': promoDetail, value: value]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyCopyBtnOnSharePopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/copyBtnOnSharePopup_android'), defaultTime)
	}

	@Keyword
	def verifyPromoNotVisibleAfterOnetimeUse(promoName) {
		boolean isPromoVisible = false
		for (int i = 0; i < 3; i++) {
			try {

				// Check if the promo code field is visible
				TestObject promoNameObject = new TestObject()
				promoNameObject.addProperty('xpath', ConditionType.EQUALS, "//*[contains(@text, '${promoName}')]")

				// Check if the promo name element is visible
				if (Mobile.verifyElementVisible(promoNameObject, 10, FailureHandling.OPTIONAL )) {
					isPromoVisible = true
					break
				}
				gen.swipeUp()
			} catch (Exception e) {
				// Continue if element is not found
				KeywordUtil.logInfo("Exception caught: " + e.getMessage())
				continue
			}
		}
		if (isPromoVisible) {
			KeywordUtil.markFailed('Promo code is still visible, which is not expected.')
		} else {
			KeywordUtil.markPassed('Promo code is no longer visible or applicable, as expected.')
		}
	}

	@Keyword
	def tapOnAddToCartLabByIndex(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/My Promos - Multiple Items/addToCartLabByIndex_android', ['index':index]), defaultTime)
	}

	@Keyword
	def openPromosAndVerifyPromoClaimPercentage(promoName, percentage) {
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promoName])
		tapOnPromosIcon();
		mobile.scrollUntilElementIsVisible(detailsTestObj);
		verifyClaimPercentage(promoName, percentage);
	}

	@Keyword
	def getRevprivatePromoName() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/revPrivatePromoName_android'), defaultTime, onFailure)
	}

	@Keyword
	def getRevPlusePromoName() {
		return Mobile.getText(findTestObject('Object Repository/Member/At Home Labs/revPlusePomoName_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevPrivateBadgeExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/revPrivateBadge_android'), defaultTime)
	}

	@Keyword
	def openPromosAndVerifyPromoClaimPercentageRedeemptionCount(promoName, percentage, count) {
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promoName])
		tapOnPromosIcon();
		mobile.scrollUntilElementIsVisible(detailsTestObj);
		verifyClaimPercentage(promoName, percentage);
		verifyRedeemptionCount(promoName, count);
	}

	@Keyword
	def verifyClaimPercentageGetPromoDetailsAndTapOnBookAppt(promotionName, percentage) {
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		tapOnPromosIcon();
		mobile.scrollUntilElementIsVisible(detailsTestObj, 15, 5);
		tapOnDetailsBtnWithPromoName(promotionName);
		def offAmount = getPromoPrice();
		def promoCode = getPromoCode();
		med.tapOnClose()
		verifyClaimPercentage(promotionName, percentage)
		tapOnBookAppointmentBtnByName(promotionName);
		return [offAmount: offAmount, promoCode: promoCode]
	}

	@Keyword
	def verifyClaimPercentageByPromoName(promotionName, percentage) {
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		tapOnPromosIcon();
		mobile.scrollUntilElementIsVisible(detailsTestObj, 15, 5);
		verifyClaimPercentage(promotionName, percentage)
	}

	@Keyword
	def verifyClaimPercentage(promoName, percentage) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/claimPercentage_android',["promoName":promoName,'text':percentage]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyRedeemptionCount(promoName, count) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/redeemptionCount_android',["promoName":promoName,'text':count]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyTextOnPromoCard(promoName, textToVerify) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Promos/textOnPromoCard',["promoName":promoName,'expectedText':textToVerify]), defaultTime);
	}

	@Keyword
	def verifyPromoExitsAndGetDetails(promotionName) {
		tapOnPromosIcon();
		Mobile.scrollToText(promotionName, FailureHandling.OPTIONAL);
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Promos/detailsBtn_android',["promoName":promotionName])
		mobile.scrollUntilElementIsVisible(detailsTestObj);
		tapOnDetailsBtnWithPromoName(promotionName);
		def offAmount = getPromoPrice();
		def promoCode = getPromoCode();
		med.tapOnClose()
		return [offAmount: offAmount, promoCode: promoCode]
	}

	@Keyword
	def taponViewProgramBtnWithPromoName(promoName,  defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Promos/viewProgramBtn_android',["promoName":promoName]), defaultTime);
	}

	@Keyword
	def tapOnCloseButtonInPromosScreen(pageTitle = 'Promos') {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/Chat/closeButtons',['sheetTitle': pageTitle]), defaultTime)
	}
	@Keyword
	def verifyPromoDiscountElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/promoDiscountElement_android'), defaultTime)
	}
	@Keyword
	def verifyStrikeOffPriceElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/Promo Details/strikeOffPriceElement_android'), defaultTime)
	}

	@Keyword
	def convertTermDateAndVerifyOnPromoCard(termDate, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		// Parse the input date string
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(termDate)

		// Format the date to 'Use by Wednesday, December 4, 2024'
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")
		String formattedDate = "Use by ${zonedDateTime.format(formatter)}"
		mobile.verifyElementPresentByText(formattedDate, onFailure)
		return formattedDate
	}
}
