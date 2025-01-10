package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
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
import member360.ElectronicHealthRecord

public class MyPrograms {
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;
	Generic gen = new Generic();
	MobileActions ma  = new MobileActions()
	ElectronicHealthRecord ehr = new ElectronicHealthRecord()
	SettingsPage settings = new SettingsPage()

	@Keyword
	def tapOnMyProgramsIcon(defaultTime = defaultTime) {
		settings.tapOnAccountIcon();
		Mobile.scrollToText("Programs", FailureHandling.OPTIONAL)
		tapOnProgramsTabOnAccountPage()
		//		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/programIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnProgramsTabOnAccountPage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/programsTabOnAccountPage_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseIcon(onFailure = FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/closeIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBookApptBtnByApptName(apptname) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/bookApptBtnByApptName_android', ['apptname': apptname]), defaultTime)
	}

	@Keyword
	def verifyShareBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/shareBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAndTapOnShareBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/shareBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/shareBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProgramDuration() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/programDuration_android'), defaultTime)
	}

	@Keyword
	def tapOnMyProgramsInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/myProgramsIconInHomePage_android'), defaultTime)
	}

	@Keyword
	def scrollToCatogriesAndSelect(categoryName, iterations = 20, onFailure = onFailure, defaultTime = defaultTime) {
		//		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': 'All']), defaultTime)

		if(categoryName == "All") {
			TestObject scrollObjCategory = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBar_android')
			TestObject elementAll = findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': categoryName])
			boolean isPresent  = ma.scrollHorizontallyToSpecificElementFromLeftToRight(scrollObjCategory, elementAll, 3);
			isPresent ? null : ma.scrollHorizontallyToSpecificElementFromLeftToRight(scrollObjCategory, elementAll, 3);
			ma.verifyElementPresentByText(categoryName)
			Mobile.doubleTap(elementAll, defaultTime)
			Mobile.doubleTap(elementAll, defaultTime)
			Mobile.delay(5);
		}
		else {
			Mobile.delay(5);
			TestObject element = findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': categoryName])
			boolean isCategoryPresent = Mobile.verifyElementExist(element, 5, FailureHandling.OPTIONAL)

			if(isCategoryPresent == false) {
				TestObject scrollObj = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBar_android')
				ma.scrollHorizontallyToSpecificElementFromRightToLeft(scrollObj, element, iterations, defaultTime)
			}
			ma.verifyElementPresentByText(categoryName)

			Mobile.tap(element, defaultTime)
			Mobile.delay(5);
		}

	}

	@Keyword
	def scrollToCatogriesAndSelectInSearchPage(index = 1, categoryName, iterations = 20, onFailure = onFailure, defaultTime = defaultTime) {
		println(index)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBarOfSearchPg_andriod', ['name': 'All']), defaultTime)

		TestObject element = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBarOfSearchPg_andriod', ['name': categoryName])
		boolean isCategoryPresent = Mobile.verifyElementExist(element, 5, FailureHandling.OPTIONAL)

		if(isCategoryPresent == false) {
			TestObject scrollObj = findTestObject('Object Repository/Member/SearchForCare/horizontalScrollViewOpt_andriod', ["index": index])
			ma.scrollHorizontallyToSpecificElementFromRightToLeft(scrollObj, element, iterations, defaultTime)
		}
		ma.verifyElementPresentByText(categoryName)

		ma.tapOnElementByText(categoryName)
		Mobile.delay(5);
	}

	@Keyword
	def scrollToCatogriesAndVerifyCatogriesandProcedureNotPresent(categoryName, procedureName, iterations = 20, procedureNameIterrations = 20, onFailure = onFailure, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': 'All']), defaultTime)

		TestObject element = findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': categoryName])
		boolean isCategoryPresent = Mobile.verifyElementExist(element, 5, FailureHandling.OPTIONAL)

		if(isCategoryPresent == false) {
			TestObject scrollObj = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBar_android')
			ma.scrollHorizontallyToSpecificElementFromRightToLeft(scrollObj, element, iterations, defaultTime)
		}
		isCategoryPresent = Mobile.verifyElementExist(element, 5, FailureHandling.OPTIONAL)
		if(isCategoryPresent == true) {
			scrollAndVerifyProcedureNotInCategories(procedureName, procedureNameIterrations, onFailure)
			ma.verifyElementNotPresentByText(procedureName);
		}
		else {
			Mobile.verifyElementNotExist(element, defaultTime);
		}
	}

	@Keyword
	def scrollToCatogriesAndVerifyCatogriesandProgramsNotPresent(categoryName, procedureName, iterations = 20, procedureNameIterrations = 20, onFailure = onFailure, defaultTime = defaultTime) {
		scrollToCatogriesAndSelect(categoryName, iterations, onFailure, defaultTime)
		gen.waitForRevdocLoaderToDisappear();
		TestObject elementObj = findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure": procedureName])
		ma.scrollUntilElementIsVisible(elementObj, iterations, 2)
	}

	@Keyword
	def scrollToProcedureInCategories(programName, iterations = 90, onFailure = onFailure) {
		gen.waitForRevdocLoaderToDisappear();
		TestObject elementObj = findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure": programName])
		ma.scrollUntilElementIsVisible(elementObj, iterations, 2)
		ma.verifyElementPresentByText(programName)
	}

	@Keyword
	def scrollToCategoriesAndProcedures(categoryName, programName, categoryIterations = 30, programIterations = 90, onFailure = onFailure, defaultTime = defaultTime) {
		scrollToCatogriesAndSelect(categoryName, categoryIterations, onFailure, defaultTime)
		scrollToProcedureInCategories(programName, programIterations, onFailure)
	}

	@Keyword
	def verifyProgramExistsUnderCategory(categoryName, programName, programIterations = 20, onFailure = onFailure, defaultTime = defaultTime) {
		scrollToCatogriesAndSelect(categoryName, 2, onFailure, defaultTime)
		ma.scrollUntilTextIsVisible(programName, programIterations, onFailure, 5)
	}

	@Keyword
	def swipeDownLittleIfLabelOnProgramCardIsNotVisibleAndTap(progName, labelName, tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/promoLabelOnProgramCard_android',['progName': progName, 'labelName':labelName])
		if(Mobile.verifyElementNotExist(obj, 20, FailureHandling.OPTIONAL)) {
			gen.swipeDownLittle();
		}
		if(tap == true) {
			ma.tapOnElementByText(labelName)
		}
	}

	@Keyword
	def scrollAndVerifyProcedureNotInCategories(programName, iterations = 90, onFailure = onFailure) {
		gen.waitForRevdocLoaderToDisappear();
		TestObject elementObj = findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure": programName])
		ma.scrollUntilElementIsVisible(elementObj, iterations, 2)
	}

	// ---------------  Start Program Card ---------------------------
	@Keyword
	def tapOnAddToCartByProgramName(programName, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/AddToCartByProgram_android', ['programName': programName])
		if(Mobile.verifyElementNotExist(obj, 10, FailureHandling.OPTIONAL)) {
			gen.swipeUpLittle();
		}
		//ma.scrollUntilElementIsVisible(obj, iterations, 5);
		Mobile.tap(obj, defaultTime);
	}

	@Keyword
	def getRev1PriceByProgramName(programName, defaultTime = defaultTime) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/rev1Price_android', ['programName': programName])
		return Mobile.getText(obj, defaultTime)
	}

	@Keyword
	def getRevplusAndRevprivatePricesByProgramName(programName, defaultTime = defaultTime, onFailure = onFailure) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/revplusAndRevprivatePrice_android', ['programName': programName])
		Mobile.getText(obj, defaultTime, onFailure)
	}

	@Keyword
	def getPricesFromProgramCard(programName, defaultTime = defaultTime) {
		//		def revoneDollarPrice = getRev1PriceByProgramName(programName, defaultTime);
		//		def revplusDollarPrice = getRevplusAndRevprivatePricesByProgramName(programName, defaultTime);
		//		def revonePrice = revoneDollarPrice.replaceAll("[^\\d.]", "")
		//		def revplusPrice = revplusDollarPrice.replaceAll("[^\\d.]", "")
		//		return [revoneDollarPrice: revoneDollarPrice, revplusDollarPrice: revplusDollarPrice, revonePrice: revonePrice, revplusPrice: revplusPrice]
		def revplusDollarPrice = getProgramPriceOnCard(programName)
		def revplusPrice = revplusDollarPrice.replaceAll("[^\\d.]", "")
		return [revplusDollarPrice: revplusDollarPrice, revplusPrice: revplusPrice]
	}

	@Keyword
	def getProgramTitleFromProgramCard() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/programTitleInProgramCard_android')
		Mobile.getText(obj, defaultTime, onFailure)
	}

	@Keyword
	def getProgramTitleFromMoreDetailsPage(def index = 1) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/programTitleInMoreDetails_android', ['index': index])
		Mobile.getText(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyProgramTitleFromMoreDetailsPage(def index = 1) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/programTitleInMoreDetails_android', ['index': index])
		Mobile.getText(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseWithBorderBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/closeWithBorder_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnOptOutBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/My Programs/optOutBtn_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnYesOptOutBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/My Programs/yesOptOutBtn_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyCloseWithBorderBtnExist() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/closeWithBorder_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyRevDocLogoOnProgramCardExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/revDocLogo_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyVerifiedCheckLogoOnProgramCardExist() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/verifiedCheckLogo_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyMoreInfoBtnExist() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/moreInfoBtn_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnMoreInfoBtn() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/moreInfoBtn_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnMoreInfoBtnByProgramName(programName, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/moreInfoBtnByProgramName_android', ['programName': programName])
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyAddToCartBtnNotVisible() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCartBtnOnProgramPage_android'), defaultTime)
	}

	@Keyword
	def verifyAddToCartBtnExistInProgPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCart_android'), defaultTime)
	}

	@Keyword
	def tapOnAddToCartBtnOnProgPage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCartBtnOnProgramPage_android'), defaultTime)
	}

	@Keyword
	def verifyBuyNowBtnNotVisible() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/At Home Labs/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAddToCartBtnByProgNameNotVisible(programName) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/AddToCartByProgram_android', ['programName': programName]), defaultTime)
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnRightArrow() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/rightArrowBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAddToCartBtnOnProgPageExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCartBtnOnProgramPage_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyBuyNowBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/buyNowBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}


	// ---------------  End Program Card ----------------------------

	// ---------------  Start Payment bottom sheet ------------------

	@Keyword
	def verifyPaymentBottomSheetForRevOne() {
		verifyPaymentBottomSheetTitle();
		ehr.verifyBottomSheetClose();
		ma.verifyElementPresentByText("Payment Options");
		ma.verifyElementPresentByText("T&C apply");
		ma.verifyElementPresentByText("Monthly",FailureHandling.OPTIONAL);
		verifyRevPlusMonthlyPriceCkBxExist();
		verifyRevoneMonthlyOption();
		verifyRevonePriceTxtExist();
		verifyContinueBtnExist();
		ehr.verifyBottomSheetClose();
		ehr.tapOnBottomSheetClose();
	}

	@Keyword
	def verifyPaymentBottomSheetTitle(defaultTime = defaultTime, onFailure = onFailure) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/bottomSheetTitle_andoid')
		Mobile.waitForElementPresent(obj, defaultTime)
		Mobile.verifyElementText(obj, 'Payment', onFailure)
	}

	@Keyword
	def tapCloseIconFromPaymentBottomSheet() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/bottomSheetTitleClose_android'), defaultTime)
	}

	@Keyword
	def tapOnRevoneMonthlyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneMonthlyOption_android'), defaultTime)
	}

	@Keyword
	def getRevoneMonthlyPriceAndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneMontlyPrice_android')
		def revoneDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevoneMonthlyOption();
		}

		def revonePrice = revoneDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revoneDollarPrice, price: revonePrice]
	}


	@Keyword
	def tapOnRevplusMonthlyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revplusMonthlyOption_android'), defaultTime)
	}

	@Keyword
	def getRevplusMonthlyPriceAndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revplusMonthlyPrice_android')
		def revplusDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevplusMonthlyOption();
		}

		def revplusPrice = revplusDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revplusDollarPrice, price: revplusPrice]
	}

	@Keyword
	def tapOnRevPrivateMonthlyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revprivateMonthlyOption_android'), defaultTime)
	}

	@Keyword
	def getRevPrivateMonthlyPriceAndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revPrivateMonthlyPrice_android')
		def revprivateDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevPrivateMonthlyOption();
		}

		def revPrivatePrice = revprivateDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revprivateDollarPrice, price: revPrivatePrice]
	}

	@Keyword
	def getRevPrivateMonthlyPrice1AndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revPrivateMonthlyPrice1_android')
		def revprivateDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevPrivateMonthlyOption();
		}

		def revPrivatePrice = revprivateDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revprivateDollarPrice, price: revPrivatePrice]
	}

	@Keyword
	def tapOnRevoneOneTimeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneOneTimeOption_android'), defaultTime)
	}

	@Keyword
	def getRevoneOneTimePriceAndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneOneTimePrice_android')
		def revoneDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevoneOneTimeOption();
		}

		def revonePrice = revoneDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revoneDollarPrice, price: revonePrice]
	}


	@Keyword
	def tapOnRevplusOneTimeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revplusOneTimeOption_android'), defaultTime)
	}

	@Keyword
	def getRevplusOneTimePriceAndTap(tap = true, index = 1) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revplusOneTimePrice_android',['index':index])
		def revplusDollarPrice = Mobile.getText(obj, defaultTime, onFailure)
		println(revplusDollarPrice:revplusDollarPrice)

		if(tap) {
			tapOnRevplusOneTimeOption();
		}

		def revplusPrice = revplusDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revplusDollarPrice, price: revplusPrice]
	}

	@Keyword
	def tapOnRevPrivateOneTimeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revprivateOneTimeOption_android'), defaultTime)
	}

	@Keyword
	def getRevPrivateOneTimePriceAndTap(tap = true) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revPrivateOneTimePrice_android')
		def revprivateDollarPrice = Mobile.getText(obj, defaultTime, onFailure)

		if(tap) {
			tapOnRevPrivateOneTimeOption();
		}

		def revPrivatePrice = revprivateDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revprivateDollarPrice, price: revPrivatePrice]
	}

	@Keyword
	def getPaymentOptionPriceAndTap(user = 'revone', selectOption = 'revone', isMonthly = true, tap = true) {
		user = user.toLowerCase();
		selectOption = selectOption.toLowerCase();
		if(isMonthly) {
			if(user == 'revone' && selectOption == 'revone') {
				return getRevoneMonthlyPriceAndTap(tap)
			} else if (user == 'revplus' ||  selectOption == 'revplus') {
				return getRevplusMonthlyPriceAndTap(tap)
			} else if(user == 'revprivate' && selectOption == 'revprivate') {
				return getRevPrivateMonthlyPrice1AndTap(tap)
			}
		} else {
			if(user == 'revone' && selectOption == 'revone') {
				return getRevoneOneTimePriceAndTap(tap)
			} else if (user == 'revplus' ||  selectOption == 'revplus') {
				return getRevplusOneTimePriceAndTap(tap)
			} else if(user == 'revprivate' && selectOption == 'revprivate') {
				return getRevPrivateOneTimePriceAndTap(tap)
			}
		}
	}

	@Keyword
	def getRevonePriceAndTap(tap = true, index = 1) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revonePriceFor100percentProgram_android',['index': index])
		def revoneDollarPrice = Mobile.getText(obj, defaultTime, onFailure)
		println(revplusDollarPrice:revoneDollarPrice)

		if(tap) {
			Mobile.tap(obj, defaultTime)
		}

		def revonePrice = revoneDollarPrice.replaceAll("[^\\d.]", "")
		return [dollarPrice: revoneDollarPrice, price: revonePrice]
	}

	@Keyword
	def tapOnContinueBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/continueBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnContinueShoppingBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/AddToCart/continueShoppingBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCheckoutBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/AddToCart/checkoutBtn_android'), defaultTime)
	}

	@Keyword
	def getSavingsValueFromPaymentBottomSheet() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/savingsLabel_android'), defaultTime)
	}

	// ---------------  End Payment bottom sheet ------------------
	@Keyword
	def tapOnProgramsBenifitsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/programBenefitsBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAppoinmentTab() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/appoinmentTab_andriod'), defaultTime)
	}

	@Keyword
	def verifyCategoryTypeExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/category _android'), defaultTime)
	}

	@Keyword
	def verifyProgramDescriptionExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/My Programs/programDescription_android'), defaultTime)
	}

	@Keyword
	def verifyAddToCartBtnExist() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCart_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddToCartBtn(index = 1) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/addToCart_android', ['index':index])
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def tapOnProgramCard() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/programTitleInProgramCard_android')
		Mobile.tap(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyRevoneMonthlyOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneMonthlyOption_android'), defaultTime)
	}

	@Keyword
	def verifyRevonePriceTxtExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revoneMontlyPrice_android'), defaultTime)
	}
	@Keyword
	def verifyRevPlusMonthlyPriceCkBxExist() {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revplusMonthlyOption_android')
		Mobile.verifyElementExist(obj, defaultTime, onFailure)
	}

	@Keyword
	def verifyRevPrivateMonthlyPriceCheckBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revPrivateMonthlyPriceOption_android'), defaultTime)
	}

	@Keyword
	def verifyContinueBtnExist(defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/continueBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBookBtn(index = 1) {
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/bookBtn_android', ["index": index])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		Mobile.tap(testObject, defaultTime);
	}

	@Keyword
	def verifyBookBtnByIndex(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/bookBtn_android', ['index':index]), defaultTime)
	}

	@Keyword
	def verifyBookBtnNotExist(index = 1) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/bookBtn_android', ["index":index]), defaultTime);
	}

	//----------- Program Info details ---------------

	@Keyword
	def verifyBookBtnExistForAppointment(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/bookButtonByAppointment_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyBookBtnNotExistForAppointment(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/bookButtonByAppointment_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBookBtnByAppointmentName(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/bookButtonByAppointment_android', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyProgramePriceOnCard(pragramName, value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/programPriceOnCard_andriod',["pragramName": pragramName, "value":value]), defaultTime, onFailure)
	}

	@Keyword
	def getProgramPriceOnCard(pragramName, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/getPriceOnProgramCard_android', ["pragramName": pragramName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyToCompleteApptsList(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/compleApptListUnderAppt_android',['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAppointmentUnderProgramAppts(index = 1) {
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/expandOrCollapseAppts_android', ['index': index])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		Mobile.tap(testObject, defaultTime)
	}

	@Keyword
	def verifyApptCountInProgramAppt(deliveryMethod, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/apptcountByDeliveryMethod_android',["name": deliveryMethod])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		def actualText = Mobile.getText(testObject, defaultTime, onFailure)
		ma.verifyEqual(actualText, text, onFailure)
	}

	@Keyword
	def tapOnCheckAvailabilityBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/checkAvailability_android'), defaultTime)
	}

	@Keyword
	def verifyAddToCartBtnUnderProgramAvailable() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/addToCartBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAddToCartBtnUnderProgramAvailable() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/addToCartBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProgramNameExists(programName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/programName_android', ['programName': programName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyProgramCalendarFillExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/programCalenderFill_android'), defaultTime, onFailure)
	}

	@Keyword
	def getProgramDescription(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/getProgramDescription_android'), defaultTime)
	}

	@Keyword
	def getTotalPrice(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/getTotalPrice_android'), defaultTime)
	}

	@Keyword
	def getProgramAppointment(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/programAppointments_android',['index': index]), defaultTime)
	}

	@Keyword
	def tapOnChevronRightBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/chevronRightBtn_android', ['index': index]), defaultTime)
	}

	@Keyword
	def getProcedureOrDeliveryMethod(programAppointment, index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/getProcedureAndDeliveryMethod_android', ['index': index, 'programAppointment': programAppointment ]), defaultTime)
	}

	@Keyword
	def getCancellationPolicyTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/getCancellationPoliy_android'), defaultTime)
	}

	// ----------- End program info details

	@Keyword
	def verifyAddToCartByProgramNameNotExist(programName, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/AddToCartByProgram_android', ['programName': programName]),defaultTime)
	}

	@Keyword
	def verifyManageBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/My Programs/manageBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnManageBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/manageBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCancelProgramBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/cancelProgramBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnYesCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/yesCancelBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
		Mobile.delay(8);
	}

	@Keyword
	def navigateToProgramsTabInAccount() {
		tapOnProfileIcon()
		tapOnProgramsTabOnAccountPage();
	}

	@Keyword
	def navigateToProgramsAndVerifyProgramVisible(programCategory, programName) {
		tapOnProfileIcon()
		tapOnProgramsTabOnAccountPage();
		scrollToCategoriesAndProcedures(programCategory, programName)
		ma.verifyElementPresentByText(programName)
	}

	@Keyword
	def navigateToProgramsAndVerifyProgramNotVisible(programCategory, programName) {
		tapOnProfileIcon()
		tapOnProgramsTabOnAccountPage();
		scrollToCatogriesAndSelect(programCategory)
		ma.verifyElementNotPresentByText(programName)
	}

	@Keyword
	def tapOnRevOnePriceOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/revOnePriceOption_android'), defaultTime)
	}

	@Keyword
	def tapOnProcedureInfoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/procedureInfoBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnViewMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/viewMoreBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyViewMoreBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/My Programs/viewMoreBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyPercentageOffExist(valueWithSymbol) {
		//valueWithSymbol = ['50%']
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/discount_value', ['discountValueWithSymbol': valueWithSymbol]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnPromoAvailableBadge() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/promoAvailableBadge'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnManageProgrameBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/manageProgrameBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnCancelProgrameBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/cancelProgrameBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnYesCancelbtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/yesCancelBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyCheckAvailabilityBtn(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/checkAvailability_android'), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/checkAvailability_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifyBookBtnEnabled(index = 1, isEnabled = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/enabledBookBtn_android', ["index":index, "isEnabled":isEnabled]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTimeIcon(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/My Programs/timeIcon_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/My Programs/timeIcon_android'), defaultTime, onFailure);
		}

	}

	@Keyword
	def tapOnTimeIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/timeIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCategoryExistOnProcedureCard(procedureName, categoryName, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure profile/categoryOnProcedureCard_android',["procedureName": procedureName, "categoryName":categoryName]), defaultTime, onFailure)
	}
	@Keyword
	def verifyCategoryNotExistOnProcedureCard(procedureName, categoryName, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Procedure profile/categoryOnProcedureCard_android',["procedureName": procedureName, "categoryName":categoryName]), defaultTime, onFailure)
	}
	@Keyword
	def verifyProgramCardBox(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/My Programs/programCardBox_android', ["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyProgramsExistInProviderProfile(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(2)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/image_andriod', ["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyExclusiveProgramBottomSheetTitle(defaultTime = defaultTime, onFailure = onFailure) {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/MyPrograms/Payment/bottomSheetTitle_andoid')
		Mobile.waitForElementPresent(obj, defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementText(obj, 'Exclusive Program', onFailure)
	}

	@Keyword
	def verifyAndFillProgramCode(code, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/programCodeTxtBx_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/programCodeTxtBx_android'), defaultTime, onFailure);
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/MyPrograms/programCodeTxtBx_android'), code, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyViewBtnExists(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/viewBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnViewBtnExists(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/viewBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyBuyNowBtnUnderProgramAvailable(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/buyNowBtn_android');
		if(isExist) {
			Mobile.verifyElementExist(testObject, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(testObject, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnBuyNowBtnUnderProgramAvailable() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/buyNowBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCheckGreenExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/checkGreen_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/ProgramAvailable/checkGreen_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifyCalendarCheckExistForAppointment(isExist = true, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/calendarCheckByAppointment_android', ['index': index]), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/calendarCheckByAppointment_android', ['index': index]), defaultTime, onFailure)
		}
	}
	@Keyword
	def formatBookedAppointmentDateTime(dateTimeStr, timeZone = "CST") {
		// Step 1: Define input and output formats with specified time zone
		def inputFormat = new SimpleDateFormat("MMMM dd, yyyy, hh:mm a z")
		inputFormat.setTimeZone(TimeZone.getTimeZone(timeZone))

		def outputFormat = new SimpleDateFormat("EEEE, MM/dd/yyyy, h:mm a")
		outputFormat.setTimeZone(TimeZone.getTimeZone(timeZone))

		// Step 2: Parse the input string and format the date
		def date = inputFormat.parse(dateTimeStr)
		def formattedDate = outputFormat.format(date)

		return formattedDate
	}

	@Keyword
	def verifyProgramAppointmentDetails(apptTitle = "Appointment 1", procedureName, delivery = "Telemedicine Call") {
		Mobile.scrollToText(apptTitle, FailureHandling.OPTIONAL);
		ma.tapOnElementByText(apptTitle);
		gen.swipeUp();
		ma.verifyElementPresentByText(procedureName);
		ma.verifyElementPresentByText(delivery)
	}

	@Keyword
	def tapOnStructuredApptBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Programs/bookBtnForStructuredAppt_android'), defaultTime)
	}

	@Keyword
	def verifyUnStructuredAppointmentsSectionWithApptCount(deliveryMethod , count, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def index = 0
		if(deliveryMethod == "House Call") {
			index = 1
		}
		if(deliveryMethod == "Luxe Mobile Clinic") {
			index = 2
		}
		if(deliveryMethod == "Telemedicine Call") {
			index = 3
		}
		if(deliveryMethod == "Facility Visit") {
			index = 4
		}
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/appointmentCountByDelivery_android',["deliveryName": deliveryMethod, "index":index])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		def actualText = Mobile.getText(testObject, defaultTime, onFailure)
		ma.verifyEqual(actualText, count, onFailure)
	}
	@Keyword
	def tapOnSpecificDeliveryMethodBookBtn(deliveryMethod , onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def index = 0
		if(deliveryMethod == "House Call") {
			index = 1
		}
		if(deliveryMethod == "Luxe Mobile Clinic") {
			index = 2
		}
		if(deliveryMethod == "Telemedicine Call") {
			index = 3
		}
		if(deliveryMethod == "Facility Visit") {
			index = 4
		}
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/specificDeliveryMethodBookBtn_android',["deliveryMethod": deliveryMethod, "index":index, "boolean":"true"])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		Mobile.tap(testObject, defaultTime, onFailure);
	}

	@Keyword
	def verifySpecificDeliveryMethodBookBtnEnabled(deliveryMethod, enabled = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def index = 0
		if(deliveryMethod == "House Call") {
			index = 1
		}
		if(deliveryMethod == "Luxe Mobile Clinic") {
			index = 2
		}
		if(deliveryMethod == "Telemedicine Call") {
			index = 3
		}
		if(deliveryMethod == "Facility Visit") {
			index = 4
		}
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/specificDeliveryMethodBookBtn_android',["deliveryMethod": deliveryMethod, "index":index, "boolean":enabled])
		ma.scrollUntilElementIsVisible(testObject, 10, 5)
		Mobile.verifyElementExist(testObject, defaultTime, onFailure);
	}

	//-----------------------------------------program with code---------------------------------------------------
	@Keyword
	def verifyExclusiveProgramButtomSheetUI(programCode, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		ehr.verifyBottomSheetClose();
		verifyExclusiveProgramBottomSheetTitle();
		def testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/exclamationCircleFillLogo_android')
		Mobile.verifyElementExist(testObject, defaultTime, onFailure);
		ma.verifyElementPresentByText("You need a code to view this program");
		verifyAndFillProgramCode(programCode);
		verifyViewBtnExists();
		ehr.tapOnBottomSheetClose();
	}

	@Keyword
	def verifyAndTapOnExclusiveProgram(programCode, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		ehr.verifyBottomSheetClose();
		verifyExclusiveProgramBottomSheetTitle();
		def testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/exclamationCircleFillLogo_android')
		Mobile.verifyElementExist(testObject, defaultTime, onFailure);
		ma.verifyElementPresentByText("You need a code to view this program");
		verifyAndFillProgramCode(programCode);
		verifyViewBtnExists();
		tapOnViewBtnExists();
	}

	//-----------------------------------------End of program with code---------------------------------------------------

	@Keyword
	def verifyGreenCheckExistForCompletedAppointment(isExist = true, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def TestObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/greenCheckforCompletedAppt_android', ['index': index])
		if(isExist) {
			Mobile.verifyElementExist(TestObject, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(TestObject, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnBookBtnByApptName(appointmentName) {
		def testObject = findTestObject('Object Repository/Member/HomePage/My Programs/bookBtnByApptName_android', ['apptName':appointmentName])
		ma.scrollUntilElementIsVisible(testObject, 2, 5)
		Mobile.tap(testObject, defaultTime)
	}

}
