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
import org.openqa.selenium.WebElement

import internal.GlobalVariable
import mobile.Generic
import mobile.MobileActions
import providerRegistration.Supervision

public class HomePage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions mobile = new MobileActions();
	Generic gen = new Generic();
	Supervision sup = new Supervision();
	def programsIconName = "My Programs"
	def revPlusIconName = "My Provider"
	def promosIconName = "Promos"

	@Keyword
	def tapOnRevOneBtn(text = revPlusIconName) {
		scrollHorizontalToText(text, 2)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def tapOnManageBenefitsBtn(text = revPlusIconName) {
		scrollHorizontalToText(text, 2)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def verifyManageBenifitsBtn(text = revPlusIconName) {
		scrollHorizontalToText(text, 2)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def verifyMyProgramsBtn(text = programsIconName) {
		scrollHorizontalToText(text, 2)
		mobile.verifyElementPresentByText(text)
	}

	@Keyword
	def tapOnMyProgramsBtn(text = programsIconName) {
		scrollHorizontalToText(text, 2)
		mobile.tapOnElementByText(text)
	}

	@Keyword
	def tapOnMembershipOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/revPlusMembershipOption_android'), defaultTime)
	}

	@Keyword
	def scrollFiltersHorizontallyFromRightToLeft(index = 1) {
		TestObject vscroll = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android', ['index': index])
		def eHeight = Mobile.getElementHeight(vscroll, 10)
		def eWidth = Mobile.getElementWidth(vscroll, 10)
		def eLeftPos = Mobile.getElementLeftPosition(vscroll, 10)
		def eTopPos = Mobile.getElementTopPosition(vscroll, 10)

		def startx  = eWidth - 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eLeftPos + 300
		//		def endx = eLeftPos + 50
		def endy =  starty

		Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
	}

	@Keyword
	def scrollFiltersHorizontallyFromLeftToRight(index = 1) {
		TestObject vscroll = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android', ['index': index])
		def eHeight = Mobile.getElementHeight(vscroll, 10)
		def eWidth = Mobile.getElementWidth(vscroll, 10)
		def eLeftPos = Mobile.getElementLeftPosition(vscroll, 10)
		def eTopPos = Mobile.getElementTopPosition(vscroll, 10)

		def startx  = eLeftPos + 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eWidth - 300
		def endy =  starty

		Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
	}

	@Keyword
	def scrollHorizontalToText(text, index, iterations = 3) {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), 10, FailureHandling.OPTIONAL) && i < iterations) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft(index);
		}
		i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), 10, FailureHandling.OPTIONAL) && i < iterations) {
			i = i+1;
			scrollFiltersHorizontallyFromLeftToRight(index);
		}
	}

	@Keyword
	def verifyRevPlusPageTitle() {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Settings/bottomSheetPageTitle_android'), "REV+")
	}

	@Keyword
	def verifyUpgradeText(text) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/revPlusPopUpTitle_android',['text': text]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def addRevplusToCheckout() {
		tapOnRevOneBtn();
		tapOnBuyNowBtn()
	}

	@Keyword
	def verifyContent(text) {
		Mobile.scrollToText(text, FailureHandling.OPTIONAL)
		int i = 0
		while(Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/revPlusPopUpTitle_android',['text': text]), 3, FailureHandling.OPTIONAL) && i < 5) {
			i = i + 1;
			gen.swipeUpLittle()
		}
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/revPlusPopUpTitle_android',['text': text]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnLearnMoreBtn(title) {
		int i = 0
		while(Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/revplus/learnMoreBtn_android',['title': title]), 3, FailureHandling.OPTIONAL) && i < 5) {
			i = i + 1;
			gen.swipeUpShort()
		}
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/learnMoreBtn_android',['title': title]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyCloseBtnInPopup(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Member/Member360/SearchFunctionality/bottomSheetClose_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddToCartBtn(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/addToCartBtn_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddToCartBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/addToCartBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnMonthlyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/monthlyBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnYearlyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/yearlyBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBuyNowBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevOneMembership/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCompareToRev1Btn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/compareToRev1Btn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddToCartBtnInBottomBanner(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/revDocPlusAddToCartBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevdocPlusMemberShipName(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/revdocPlusMembershipName_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevdocPlusMemberShipPrice(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/revdocPlusMembershipPrice_android'), text, onFailure);
	}

	@Keyword
	def verifyRemoveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/removeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySaveForLaterBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/saveForLaterBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnProceedToCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/proceedToCheckoutBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnContinueToHealthRecordBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/continueToHealthRecordsBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnRemindMeLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/remaindMeLaterBtn_android'), defaultTime)
	}

	@Keyword
	def verifyRevPlusBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/revPLusBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevDocLogo(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revDocLogo_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnRevDocLogo(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revDocLogo_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnRevPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revPLusBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/profileIcon_android'), defaultTime);
	}
	@Keyword
	def verifyProfileIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.takeScreenshot();
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/profileIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def WaitForProfileIconPresent(onFailure =FailureHandling.OPTIONAL, defaultTime = 60) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/profileIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnHomePageIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyHomePageIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnEHRBtnInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/eHRBtnInHomePage_andriod'), defaultTime)
	}

	@Keyword
	def tapOnGeneralProcedureBtnInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/generalProcedureBtnInHomePage_andriod'), defaultTime)
	}

	@Keyword
	def tapOnGeneralCareBtnInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/generalCareBtnInHomePage_andriod'), defaultTime)
	}

	@Keyword
	def tapOnBackBtnInGnrlCarePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/General Care In Home Page/backBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/General Care In Home Page/backBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyElementPresent(Options) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/'+ Options), defaultTime);
	}

	@Keyword
	def scrollTheQuickLinks() {
		WebElement element = Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Quick Links/quickLinksHorizontalView_andriod'), 10)

		// Get the element's location
		int elementX = element.getLocation().getX();
		int elementY = element.getLocation().getY();

		// Get the device screen size
		int screenWidth = Mobile.getDeviceWidth();
		int screenHeight = Mobile.getDeviceHeight();

		// Determine the direction and distance needed to scroll
		int startX = screenWidth / 2 // Start from the middle of the screen
		int startY = elementY // Keep Y-coordinate unchanged for horizontal scrolling
		int endX = elementX // Scroll to the X-coordinate of the element
		int endY = elementY // Keep Y-coordinate unchanged for horizontal scrolling

		// Perform a swipe action to scroll horizontally to the element
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollQuicklinksHorizontallyFromRightToLeft(index = 1) {
		TestObject vscroll = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android', ['index': index])
		def eHeight = Mobile.getElementHeight(vscroll, 10)
		def eWidth = Mobile.getElementWidth(vscroll, 10)
		def eLeftPos = Mobile.getElementLeftPosition(vscroll, 10)
		def eTopPos = Mobile.getElementTopPosition(vscroll, 10)

		def startx  = eWidth - 150
		def starty = (eTopPos + (eHeight/2)).toInteger();
		//def endx = eLeftPos + 300
		def endx = eLeftPos + 250
		def endy =  starty

		Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnRevPrivatelabel() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnRevPrivateBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revPrivateButton_android'), defaultTime);
	}

	@Keyword
	def verifyRevprivateMembershipIconExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPrivate/revprivateMembershipIconBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnRevprivateMembershipIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/revprivateMembershipIconBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCancelRevPrivateRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/cancelRequestBtn_android'), defaultTime);
	}

	@Keyword
	def verifyMembershipIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/membershipIcon/membershipBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnArrowIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/arrowIcon_android'), defaultTime);
	}
	@Keyword
	def verifyArrowIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/arrowIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/closeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnXcloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/XcloseBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def VerifyXCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevOneMembership/XcloseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnExploreOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/exploreOptn_android'), defaultTime);
	}

	@Keyword
	def tapOnMemberShipBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/manageBtn_andriod'), defaultTime)
	}

	//	@Keyword
	//	def scrollToSpecificCardOnHomePage(text, index = 1, iterations = 8) {
	//		if(index>1) {
	//			gen.swipeUp();
	//		}
	//		Mobile.delay(3);
	//
	//		def eHeight = Mobile.getElementHeight(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
	//		def eWidth = Mobile.getElementWidth(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
	//		def eLeftPos = Mobile.getElementLeftPosition(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
	//		def eTopPos = Mobile.getElementTopPosition(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
	//
	//		// Define the start and end positions for swiping right to left
	//		def startx = eLeftPos + eWidth - 100
	//		def starty = (eTopPos + (eHeight / 2)).toInteger()
	//		def endx = eLeftPos + 100
	//		def endy = starty
	//		int i = 1
	//
	//		// Swipe from right to left until the element is found or the limit is reached
	//		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < iterations) {
	//			i = i + 1
	//			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
	//		}
	//
	//		if (i >= iterations) {
	//			return false
	//		}
	//
	//		return true
	//	}

	@Keyword
	def scrollToSpecificCardOnHomePage(text, index = 1, iterations = 10) {
		Mobile.delay(5)
		if(index > 1) {
			Mobile.delay(6)
			//			gen.swipeUp();
		}

		def eHeight = Mobile.getElementHeight(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
		def eWidth = Mobile.getElementWidth(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)
		def eTopPos = Mobile.getElementTopPosition(findTestObject('Object Repository/Member/HomePage/card_android', ["index":index]), defaultTime)

		// Adjust the scroll length to 70% by modifying the start and end positions
		def startx = eLeftPos + (eWidth * 0.7).toInteger()  // Start at 70% of the width
		def starty = (eTopPos + (eHeight / 2)).toInteger()
		def endx = eLeftPos + (eWidth * 0.3).toInteger()    // End at 30% of the width
		def endy = starty
		int i = 1

		// Swipe from right to left until the element is found or the limit is reached
		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < iterations) {
			i = i + 1
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
		}

		if (i >= iterations) {
			return false
		}

		return true
	}


	@Keyword
	def scrollToRevCashCardOnHomePageMembershipsAndTap(text = "RevCash Never Expires") {
		scrollToSpecificCardOnHomePageMemberships(text)
		tapOnSpecificCard(text)
	}

	@Keyword
	def scrollToRevPrivateCardOnHomePageMembershipsAndTap(text = "Rev Private") {
		scrollToSpecificCardOnHomePageMemberships(text)
		tapOnSpecificCard(text)
	}

	@Keyword
	def scrollToRevPlusCardOnHomePageMembershipsAndTap(text = "REV+ Saves You 40%") {
		scrollToSpecificCardOnHomePageMemberships(text)
		tapOnSpecificCard(text)
	}

	@Keyword
	def scrollToSpecificCardOnHomePageMemberships(text) {
		def title = "Fixed items"
		if(GlobalVariable.env == "uat") {
			title = "Memberships"
		}
		Mobile.scrollToText(title, FailureHandling.OPTIONAL);
		def index = 0;
		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), 10, FailureHandling.OPTIONAL)&& index<3) {
			gen.swipeUpShort();
			index = index + 1;
		}
		def eHeight = Mobile.getElementHeight(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eWidth = Mobile.getElementWidth(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eTopPos = Mobile.getElementTopPosition(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)

		def startx  = eWidth - 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eLeftPos + 400
		def endy =  starty
		int i= 1;

		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < 6) {
			i = i + 1;
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
		}
		startx = eLeftPos + 100
		starty = (eTopPos + (eHeight / 2)).toInteger()
		endx = eLeftPos + eWidth - 100
		endy = starty
		i = 1

		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < 6) {
			i = i + 1;
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
		}
		if(i>=4) {
			return false;
		}
	}

	@Keyword
	def scrollToSpecificCardOnCarouselView(text) {
		def title = "Promo Carousel"
		Mobile.scrollToText(title, FailureHandling.OPTIONAL);
		def index = 0;
		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), 10, FailureHandling.OPTIONAL)&& index<3) {
			gen.swipeUpShortLoop(2)
		}
		def eHeight = Mobile.getElementHeight(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eWidth = Mobile.getElementWidth(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)
		def eTopPos = Mobile.getElementTopPosition(findTestObject('Object Repository/Member/HomePage/Memberships/horizontalScrollBar_android',['title':title]), defaultTime)

		def startx  = eWidth - 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eLeftPos + 400
		def endy =  starty
		int i= 1;

		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < 6) {
			i = i + 1;
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
		}
		startx = eLeftPos + 100
		starty = (eTopPos + (eHeight / 2)).toInteger()
		endx = eLeftPos + eWidth - 100
		endy = starty
		i = 1

		while (!verifyElementExistOnCard(text, FailureHandling.OPTIONAL, 5) && i < 6) {
			i = i + 1;
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
		}
		if(i>=4) {
			return false;
		}
	}

	@Keyword
	def verifyElementExistOnCard(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/elementText_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSpecificCard(text, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/elementText_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnRevCashCardInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revCashCard_andriod'), defaultTime)
	}
	@Keyword
	def verifyAndTapOnMyEHRBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/myEHRBtn_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/myEHRBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyGIFPresent(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/gif_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyImagePresent(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/gif_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyLeftArrowIcon(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/leftArrowIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAndTapOnIgotItBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/iGotItBtn_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/iGotItBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def VerifyScreenTitle(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/screenTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifypageTitle(title) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Quick Links/General Care In Home Page/pageTitle_android', ['title': title]), defaultTime)
	}
	@Keyword
	def tapOnQuickLinkBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Quick Links/buttonInQuickLink_android', ['name':name]), defaultTime)
	}

	@Keyword
	def tapOnCategoriesViewAllBtn(title = "Book a Face-To-Face Appointment") { //Book a Face-To-Face Appointment
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android',['title':title]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.scrollToText(title, FailureHandling.OPTIONAL)
		}
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android',['title':title]), defaultTime)
	}

	@Keyword
	def selectCategoryAndScrollToProcedureInHome(categoryName, procedure,  title = "Book a Face-To-Face Appointment", iterations = 15) {
		selectCategoryInHome(categoryName, title)
		scrollToProcedureInCategories(procedure, iterations)
	}

	@Keyword
	def selectCategoryInHome(categoryName, title = "Book a Face-To-Face Appointment") {
		tapOnCategoriesViewAllBtn(title);
		scrollToSpecificCardOnHomePage(categoryName)
		mobile.tapOnElementByText(categoryName)
	}
	@Keyword
	def scrollToProcedureInCategories(procedure, iterations = 15) {
		def elementObj = findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/procedureMoreInfo/infobtnfollowedbyProcedure_android',["procedure":procedure])
		mobile.scrollUntilElementIsVisible(elementObj, iterations, 2)
	}

	@Keyword
	def scrollToProcedureWithAddToCartBtnInCategories(categoryName, procedure,  title = "Book a Face-To-Face Appointment", iterations = 30) {
		tapOnCategoriesViewAllBtn(title);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': 'All']), defaultTime)

		TestObject element = findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': categoryName])
		boolean isCategoryPresent = Mobile.verifyElementExist(element, 5, FailureHandling.OPTIONAL)

		if(isCategoryPresent == false) {
			TestObject scrollObj = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBar_android')
			mobile.scrollHorizontallyToSpecificElementFromRightToLeft(scrollObj, element, iterations, defaultTime)
		}
		mobile.verifyElementPresentByText(categoryName, onFailure)
		mobile.tapOnElementByText(categoryName)


		def elementObj = findTestObject('Object Repository/Member/HomePage/MemberServices/Categories/ProcedureCard/addToCartBtn_android',["procedureName":procedure])
		mobile.scrollUntilElementIsVisible(elementObj, 20, 2)
	}

	// --------------Start - At Home Labs Search labs Reusable methods ---------------------------------

	@Keyword
	def typeInSearchLabs(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabs_android'), text,  defaultTime);
	}

	@Keyword
	def tapOnSearchedLab(text) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/searchLabsOptions_'+os, ['text': text] ), defaultTime);
	}

	@Keyword
	def tapOnAddToCartBtnLabs() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevOneMembership/addToCartBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCheckOutBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/checkoutBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAtHomeLabsViewAllBtn(title = "At-Home Labs") {
		TestObject obj = findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android', ['title':title])
		Mobile.scrollToText(title, FailureHandling.OPTIONAL)
		mobile.scrollUntilElementIsVisible(obj, 5, 3)
		Mobile.tap(obj, defaultTime)
	}

	@Keyword
	def verifyViewAllBtnByTitleExists(title = "At-Home Labs") {
		Mobile.scrollToText(title, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android', ['title':title]), defaultTime)
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), defaultTime);
	}

	@Keyword
	def openAtHomeLabsSearchLab(labName) {
		tapOnAtHomeLabsViewAllBtn()
		typeInSearchLabs(labName)
	}

	@Keyword
	def openAtHomeLabsSearchLabTapOnLab(labName) {
		openAtHomeLabsSearchLab(labName)
		tapOnSearchedLab(labName)
	}

	@Keyword
	def openAtHomeLabsSearchLabAndAddToCart(labName) {
		openAtHomeLabsSearchLabTapOnLab(labName)
		tapOnAddToCartBtnLabs()

	}

	@Keyword
	def openAtHomeLabsSearchLabAndAddToCartCheckOut(labName) {
		openAtHomeLabsSearchLabAndAddToCart(labName);
		new AllAvailabilities().tapOnContinueBtn(FailureHandling.OPTIONAL);
		Mobile.delay(5);
		tapOnCheckOutBtn(FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnRevPlusCbxUnderPaymentOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/revPlusCBx_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)

	}
	// --------------------- End - At Home Labs Search labs Reusable methods ----------------------------------

	// ---------------- Start Invite icon -----------------
	@Keyword
	def tapOnInviteIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Invite/inviteIcon_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyInviteIconExists(defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Invite/inviteIcon_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	// ---------------- End Invite icon -----------------

	//--------------Promos Start-------------//
	@Keyword
	def tapOnPromosBtn(text = promosIconName) {
		scrollHorizontalToText(text, 2)
		mobile.tapOnElementByText(text)
	}

	@Keyword
	def verifyPromosBtnExist() {
		scrollHorizontalToText(promosIconName, 2)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/PromosBtn_andriod'), defaultTime)
	}
	//--------------Promos End-------------//

	//----------------------------My Programs Start--------------------//

	@Keyword
	def verifyMyProgramsExist(text = programsIconName) {
		scrollHorizontalToText(text, 2)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def tapOnMyProgramsTab(text = programsIconName) {
		scrollHorizontalToText(text, 2)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
	}

	@Keyword
	def tapOnAllTab() {
		TestObject scrollObjCategory = findTestObject('Object Repository/Member/HomePage/MyPrograms/horizonatalCategoryScrollBar_android')
		TestObject elementAll = findTestObject('Object Repository/Member/HomePage/MyPrograms/tabInHorizontalScrollBar_android', ['name': 'All'])
		mobile.scrollHorizontallyToSpecificElementFromLeftToRight(scrollObjCategory, elementAll, 3);
		mobile.verifyElementPresentByText('All')
		Mobile.tap(elementAll, defaultTime)
		Mobile.tap(elementAll, defaultTime)
	}

	//----------------------------My Programs End--------------------//

	@Keyword
	def getProcedureHomeScreenSubtitleText(procedure) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/procedureHomeScreenSubtitle_android',['procedure':procedure]), defaultTime)
	}

	@Keyword
	def tapOnProgramsViewAllBtn(title = "Available Programs") { //Book a Face-To-Face Appointment
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/categoriesViewAllBtn_android',['title':title]), defaultTime)
	}

	@Keyword
	def scrollToProgramInCategories(program) {
		def elementObj = findTestObject('Object Repository/Provider/Registration/elementText_android',["Text":program])
		mobile.scrollUntilElementIsVisible(elementObj, 15, 2)
	}

	@Keyword
	def tapOnAffiliationMembershipLogoIcon() {
		tapOnManageBenefitsBtn()
		//		Mobile.tap(findTestObject('Object Repository/Member/HomePage/membershipAffialiateLogoIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnExclusiveSpecials(text = "Exclusive Specials") {
		scrollHorizontalToText(text, 2)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBenefitsBtn_android',['text':text]), defaultTime)
		//		Mobile.tap(findTestObject('Object Repository/Member/HomePage/ExclusiveSpecials/exclusiveSpecials_android'), defaultTime)
	}

	@Keyword
	def verifyUnlimitedMessagingIconIsDisbledOrEnabled(isDisabled) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/UnlimitedMessaging/unlimitedMessagingIsDisabled_android',['isDisabled': isDisabled]), defaultTime)
	}

	@Keyword
	def verifyPrescriptionManagementIconIsDisbledOrEnabled(isDisabled) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/UnlimitedMessaging/prescriptionManagementIsDisabled_android', ['isDisabled': isDisabled]), defaultTime)
	}

	//----------------------------Select Your Provider Start--------------------//

	@Keyword
	def tapOnSelectYourPrivateProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/selectYourPrivateProvider_android'), defaultTime)
	}

	@Keyword
	def verifySelectYourPrivateProviderBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/selectYourPrivateProvider_android'), defaultTime)
	}

	@Keyword
	def searchRevPluseProvider(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/searchProvider_android'), text,  defaultTime);
	}

	@Keyword
	def tapOnRequestInterviewBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/requestInterview_android'), defaultTime)
	}

	@Keyword
	def verifyRequestInterviewBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/requestInterview_android'), defaultTime)
	}

	@Keyword
	def verifyPendingBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/SelectYourPrivateProvider/pending_android'), defaultTime)
	}
	//----------------------------Select Your Provider End--------------------//
	def tapOnWhatIsRevDocBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/whatisRevDoc_android'), defaultTime)
	}

	//----------------------------------Member Home Page Top Icons start-------------------------------//
	@Keyword
	def getHomePageIconsName(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/HomePage Top Icons/iconNameByIndex_android',['index':index]), defaultTime)
	}

	@Keyword
	def getHomePageIconsNameByScrollIndex(scrollIndex,index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/HomePage Top Icons/iconsHorizontalScrollByIndex_android',['scrollIndex':scrollIndex,'index':index]), defaultTime)
	}

	@Keyword
	def verifyImageByIconName(iconName) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/HomePage Top Icons/imageByIconName_android',['iconName':iconName]), defaultTime)
	}

	@Keyword
	def tapOnHomePageIconsName(name) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/HomePage Top Icons/iconNames_android',['name':name]), defaultTime)
	}

	@Keyword
	def tapOnMyProviderIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Provider/myProviderIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnRegisterIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/registerIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnMemberProfileDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/memberProfileDropDn_android'), defaultTime);
	}

	@Keyword
	def tapOnMemberProfileType(text) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberProfiles/profileType_android', ['text':text]), defaultTime);
	}
}
