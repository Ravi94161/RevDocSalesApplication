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
import api.Provider
import member.HomePage
import member.RevPrivateAppointments
import mobile.Generic

public class Memberships {

	String os = GlobalVariable.osName;
	def defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE
	Provider ProviderApi = new Provider();
	HomePage homepage = new HomePage();
	RevPrivateAppointments revprivateApt = new RevPrivateAppointments();
	Generic gen = new Generic()

	@Keyword
	def tapOnMembershipsTab() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships_android'), defaultTime);
	}

	@Keyword
	def VerifyMembershpsTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/membershipComparisonTitle_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/add_button_android'), defaultTime);
	}

	@Keyword
	def verifyElementExist(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementNotExist(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 10) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnMembershipsOption() {
		Mobile.scrollToText("Memberships", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/membershipsOpt_android'), defaultTime);
	}

	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/backBtn_android'), defaultTime,onFailure);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/backBtn_android'), defaultTime);
	}

	@Keyword
	def verifyMembershipComparisonTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/membershipCompTitle_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyRevDocMembershipsHeading() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/revDocMembershipsTxt_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyRevDocMembershipsDescription() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/membershipsDes_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyRevPrivateOption() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/revPrivateOpt_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnRevPrivateOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/revPrivateOpt_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyRevPlusOption() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/revPlusOption_android'), defaultTime,onFailure);
	}

	@Keyword
	def verifyElementRowExist(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			Mobile.scrollToText(txt);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime, onFailure);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/OrangeTick_android',["txt":txt]), defaultTime, onFailure);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/goldenTick_android',["txt":txt]), defaultTime, onFailure);
		}
		catch(Exception e) {}
	}
	@Keyword
	def verifyElementRowforWrongTicks(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			Mobile.scrollToText(txt);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/verifyElementTxt_android',["txt":txt]), defaultTime,onFailure);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/OrangeWrongTick_android',["txt":txt]), defaultTime,onFailure);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/goldenTick_android',["txt":txt]), defaultTime,onFailure);
		}
		catch(Exception e) {}
	}
	@Keyword
	def verifyUltimatedTxt(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/UltimatedTxt_android',["txt":txt]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyFreeTxt(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/freeTxt_android',["txt":txt]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyAddBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/addBtn_android'), defaultTime);
	}
	@Keyword
	def verifySearchField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/searchField_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSearchBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/searchField_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnXBtnInRevprivateSearch(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Search/xBtnInRevprivateSearch_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySearchBtnNotPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/Membership Comparison/searchField_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnLocationBox() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/locationBox_android'), defaultTime);
	}

	@Keyword
	def typeInSearchAddressInput(address) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/searchAddressInput_android'), address,defaultTime);
	}

	@Keyword
	def tapOnSelectSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/selectSearchResult_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchAdditionalProviderBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/searchAdditionalProviderBtn_andriod'), defaultTime)
		}
		catch(Exception e) {
		}
	}
	@Keyword
	def tapOnSearchedLocation(addressName, index=1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/savedLocations_android', ['addressName': addressName,"index":index]), defaultTime);
		Mobile.delay(5)
	}

	@Keyword
	def tapOnFirstSearchOption() {
		Mobile.delay(5)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/firstSearchOption_android'), defaultTime,FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/firstSearchOption_android'), defaultTime);
		Mobile.delay(5)
	}
	@Keyword
	def tapOnWonerName() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/wonerName_android'), defaultTime);
	}
	@Keyword
	def tapOnStaffBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/staffBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/staffBtn_android'), defaultTime);
	}
	@Keyword
	def verifyStaffBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/staffBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyBenifitsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/benifitsBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBenifitsBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/benifitsBtn_android'), defaultTime);
	}
	@Keyword
	def verifyPricingBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/pricingBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyExploreRevDocPrivateTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/exploreTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRequestToJoinBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/requestToJoinBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyProfilePicOfProvider() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/profilePicOfProvider_android'), defaultTime);
	}
	@Keyword
	def verifyAvatarPic() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/avatar_android'), defaultTime);
	}
	@Keyword
	def verifyProviderNameSpecialityLocation() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/providerName_android'), defaultTime);
		try {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/providerSpeciality_android'), defaultTime);
		}catch(Exception e) {}
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/providerLocation_android'), defaultTime);
	}
	@Keyword
	def tapOnProviderName() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/providerName_android'), defaultTime);
	}
	@Keyword
	def tapOnRequestToJoinBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/requestToJoinBtn_android'), defaultTime);
	}
	@Keyword
	def verifyGradientCheck() {
		try {
			Mobile.delay(10);
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/gradientCheck_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		}
		catch(Exception e) {
		}
	}
	@Keyword
	def verifyBackToHomeBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/backToHomeBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnBackToHomeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/backToHomeBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnGradientCloseBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/gradientCloseBtn_android'), defaultTime, onFailure);
		}
		catch(Exception e) {}
	}

	// -------------------------- Start Pending RevPrivate Requests ----------------------
	@Keyword
	def tapOnCancelRequestOpt() {
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/cancelRequestOpt_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/cancelRequestOpt_android'), defaultTime);
			Mobile.delay(5);
			tapOnSearchBtn();
			tapOnSearchAdditionalProviderBtn();
		}
	}

	@Keyword
	def tapOnInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/PendingRevPrivateRequests/infoIcon_android'), defaultTime)
	}
	// -------------------------- End Pending RevPrivate Requests ------------------

	@Keyword
	def getProviderNameFromProviderSearch(index = 1 ) {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/getProviderNameInProviderSearch_android', ['index': 1]), defaultTime);
	}


	@Keyword
	def tapProviderNameFromProviderSearch(index = 1 ) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/getProviderNameInProviderSearch_android', ['index': 1]), defaultTime);
	}

	@Keyword
	def sendTheTextToInputBx(location) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/searchLocationInputBx_andriod'), location, defaultTime)
	}
	@Keyword
	def tapOnsearchAdditionalProviderBtn() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/searchAdditionalProviderBtn_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/searchAdditionalProviderBtn_android'), defaultTime);
		}
	}
	@Keyword
	def verifyGradientCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/gradientCloseBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEditPencilIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/editPencil_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyClearBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/clearBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnClearBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/clearBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySearchBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/searchBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyBilledYearlyLable(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/billedYearly_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyBilledQuarterlyLable(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/billedQuarterly_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBilledQuarterlyLable(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/billedQuarterly_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifygradientCheckWithFollowingText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/gradientCheckWithFollowingText_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyViewMoreBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("View More", onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/viewMoreBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnViewMoreBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("View More", onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/viewMoreBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyDayAndTime(day, time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(day, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/dayAndTime_android',["day":day, "time":time]), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseButton(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/closeButton_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseButton() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/closeButton_android'), defaultTime)
	}
	@Keyword
	def tapOnRevPrivateProviderNameTxt(text) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/elementText_android',["text":text]), defaultTime);
	}

	@Keyword
	def tapOnProviderInfoIconInRevprivateSearch(providerName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/infoIconByProviderName_android',["providerName": providerName]), defaultTime);
	}
	//--------------------------------Send RevPrivate Request to Specific Provider Reusable method-----------------------------------------------------------
	@Keyword
	def sendRevPrivateRequestToSpecificProvider(providerEmail, providerPass) {
		//getting revprivate provider details
		def proSignRes = ProviderApi.postProviderSignIn(providerEmail, providerPass)
		def proDetailsRes = ProviderApi.getProviderDetails()
		def providerName = proDetailsRes.user.fullName
		def providerFirstName = proDetailsRes.user.firstName
		def employerAddress = proDetailsRes.user.workHistories?.first()?.employerAddress
		def providerAddress = "";
		if (employerAddress instanceof Map) {
			def addressLine1 = employerAddress?.addressLine1
			def city = employerAddress?.city
			def stateCode = employerAddress?.stateCode
			def postalCode = employerAddress?.postalCode
			println("Address Line 1: $addressLine1")
			println("City: $city")
			println("State Code: $stateCode")
			println("Postal Code: $postalCode")
			providerAddress = "${addressLine1}, ${city}, ${stateCode} ${postalCode}"
		} else {
			println("Employer address is not in the expected format.")
		}
		println(providerAddress);
		//Upgrade to revprivate membership
		def text = "";
		homepage.scrollToRevPrivateCardOnHomePageMembershipsAndTap(text = "Rev Private")
		revprivateApt.tapOnFindProviderBtn();
		tapOnSearchBtn();
		sendTheTextToInputBx(providerAddress);
		Mobile.delay(5)
		tapOnFirstSearchOption();
		tapOnSearchBtn();
		Mobile.scrollToText(providerFirstName, FailureHandling.OPTIONAL);
		tapOnRevPrivateProviderNameTxt(providerFirstName);
		tapOnRequestToJoinBtn();
		verifyElementExist("Your join request has been sent.");
		tapOnBackToHomeBtn();

	}
	//--------------------------------End of Send RevPrivate Request to Specific Provider Reusable method-----------------------------------------------------------
}
