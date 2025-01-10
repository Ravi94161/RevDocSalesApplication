package providerRegistration

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

public class Procedures {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();

	@Keyword
	def verifyProceduresPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/proceduresPageTitle_android'), defaultTime);
	}

	@Keyword
	def tapOnProceduresOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/proceduresOption_android'), defaultTime)
	}

	@Keyword
	def verifyGeneralCareProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/generalCareProcedure_android'), defaultTime);
	}

	@Keyword
	def verifyScreenInfoOnProcedure() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Procedures/proceduresScreenInfoTxt_android'), "Select the procedures that you will perform");
	}

	@Keyword
	def verifyPimaryCareProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedure_android'), defaultTime);
	}

	@Keyword
	def verifyRevTogetherProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/revTogetherProcedure_android'), defaultTime);
	}

	@Keyword
	def verifyIvTherapyProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/revTogetherProcedure_android'), defaultTime);
	}

	@Keyword
	def verifyLungsProcedure(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsProcedure_android'), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsProcedureCheckbox_android'), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsDrpdwn_android'), defaultTime, onFailure);
	}

	@Keyword
	def clickOnLungsProcedureCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsProcedureCheckbox_android'), 30);
	}

	@Keyword
	def clickOnLungsProcedureDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsDrpdwn_android'), 30);
	}

	@Keyword
	def verifyBronchoscopyProcedure() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/bronchoscopyProcedure_android'), 30, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def clickOnSaveAndContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/saveAndContinueBtn_android'), 30);
	}

	@Keyword
	def verifyBankingTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/bankingTitle_android'), 30);
	}

	@Keyword
	def verifyBankingDescription() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/bankingDescription_android'), 30);
	}

	@Keyword
	def verifyAddBankOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BuildMyRevdocProfileBanking/addBankAccountLink_android'), 30);
	}

	@Keyword
	def clickOnRevTogetherCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/revTogetherProcedureCheckbox_android'), 30);
	}

	@Keyword
	def clickOnRevTogetherDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/revTogetherProcedureDrpDwn_android'), 30);
	}

	@Keyword
	def verifyShockWaveProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/shockWaveProcedure_android'), 30);
	}

	@Keyword
	def tapOnPrimaryCareCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureCheckbox_android'), 30);
	}

	@Keyword
	def verifyPrimaryCareProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedure_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureCheckbox_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureDrpDwn_android'), 30);
	}

	@Keyword
	def tapOnPrimaryCareProcedure() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedure_android'), 30);
	}

	@Keyword
	def tapOnCategoryByName(category) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Category/categoryOption_android',['category':category]), defaultTime);
	}

	@Keyword
	def verifyProcedureMoreInfoOpt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/procedureProfileBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureProfileBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureProfileBtn_android'), 30);
	}

	@Keyword
	def tapOnBronchoscopyProcedureProfileBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/bronchoscopyProcedureProfile_android'), 30);
	}

	@Keyword
	def verifyBronchoscopyTitleOnProcedureProfile() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/bronchoscopyProviderProfileTitle_android'), 30);
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/closeBtn_android'), 30);
	}


	@Keyword
	def verifyProcedureSteps() {
		Mobile.scrollToText("Procedure Steps")
		Mobile.verifyElementExist(findTestObject('Provider/Provider360/Procedures/procedureStepsInProfile_android'), 30);
	}

	@Keyword
	def verifyProcedureDetails() {
		Mobile.scrollToText("Procedure Cost and Other Details")
		Mobile.verifyElementExist(findTestObject('Provider/Provider360/Procedures/procedureDetailsInProfile_android'), 30);
	}

	@Keyword
	def verifyPostCareInstructions() {
		Mobile.scrollToText("Post Care Instructions")
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/postCareInstructionsInProfile_android'), 30);
	}

	@Keyword
	def verifyProcedureProfileTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureProfileTitle_android'), 30);
	}

	@Keyword
	def tapOnPrimaryCareProcedureDrpDwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureDrpDwn_android'), 30);
		//Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureProfileBtn_android'), defaultTime);
	}

	@Keyword
	def verifyChestTubeProcedure() {
		Mobile.scrollToText("Chest Tube Procedure", FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/chestTubeProcedure_android'), defaultTime);
	}

	@Keyword
	def clickOnChestTubeProcedureCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/chestTubeProcedureCheckbox_android'), defaultTime);
	}

	@Keyword
	def clickOnBronchoscopyProcedureCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/chestTubeProcedureCheckbox_android'), defaultTime);
	}

	@Keyword
	def checkTheProcedureCheckBox(procedure) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/checkTheProcedureCheckBox_andriod',["procedure": procedure]), defaultTime)
	}

	/// Custom toggle btn
	@Keyword
	def verifyCheckBoxIsChecked(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureCheckoxChecked_android',['procedure': procedure]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCustomRateToggleBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/customRateToggle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCustomRateToggleBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Procedures/customRateInput_andriod'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/customRateToggle_andriod'), defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnCustomRateToggleBtnByProcedureName(procedure, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/customRateInputByProcedure_android', ['procedure':procedure]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/customRateToggleByProcedure_android', ['procedure':procedure]), defaultTime, onFailure)
		}
	}

	@Keyword
	def verifyCustomRateToggleBtnByProcedureName(procedure, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/customRateToggleByProcedure_android', ['procedure':procedure]), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def enterTheCustomRateValue(value) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Procedures/customRateInput_andriod'), value, defaultTime)
		Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyTheCustomRateValue(value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Procedures/customRateInput_andriod'), value);
	}
	/// End

	@Keyword
	def tapOnSaveProceduresBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/saveProceduresBtn_android'), defaultTime)
	}

	@Keyword
	def selectProceduresInBuildMyProfile() {
		tapOnProceduresOption()
		verifyProceduresPageTitle()
		verifyAndExpandDeliveryMethod("House Call")
		Mobile.scrollToText("Primary Care", FailureHandling.OPTIONAL)
		verifyPrimaryCareProcedure()
		tapOnPrimaryCareCheckbox()
		tapOnPrimaryCareProcedure()
		Mobile.delay(5)
		tapOnPrimaryCareProcedureDrpDwn()
//		Mobile.scrollToText("Lungs", FailureHandling.OPTIONAL)
//		Mobile.delay(10)
//		verifyLungsProcedure()
//		clickOnLungsProcedureCheckbox()
//		Mobile.delay(5)
		tapOnSaveProceduresBtn()
	}

	@Keyword
	def verifyAndExpandDeliveryMethod(deliveryMethod) {
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Procedures/deliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/deliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime)
		}
	}

	@Keyword
	def verifyProcedureProviderType(type, status) {
		Mobile.scrollToText(type, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedureProviderTypeVerify_android',['type':type,'status':status]), defaultTime);
	}

	@Keyword
	def tapOnProcedureMoreInfoBtn(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedureMoreInfoBtn_android',['procedureName':procedureName]), defaultTime)
	}

	@Keyword
	def tapOnProcedureCostAndOtherDetailsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedureCostAndOtherDetailsBtn_android'), defaultTime)
	}

	@Keyword
	def verifycloseBtnExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/closeBtn_android'), 30);
	}
	@Keyword
	def tapOnHousCallOpt()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/HouseCallOption_android'), defaultTime)
	}

	@Keyword
	def verifyManualTestCategorycheckBxExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/manualTestCategorycheckBx_android'), 30);
	}
	@Keyword
	def tapOnManualTestCategorycheckBx()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/manualTestCategorycheckBx_android'), defaultTime)
	}
	@Keyword
	def verifyAutomationTestCategorycheckBxExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/automationTestCategorycheckBx_android'), defaultTime);
	}
	@Keyword
	def tapOnAutomationTestCategorycheckBx()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/automationTestCategorycheckBx_android'), defaultTime)
	}

	@Keyword
	def getProcedureCategoryTypeTxt(index) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/getProcedureCategory_android', ['index':index]),defaultTime);
	}

	@Keyword
	def getAutomationTestCategoryTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/automationTestCategoryTxt_android'),defaultTime);
	}
	@Keyword
	def verifyProcedureProfileTxtExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedureProfile_android'), 30);
	}
	@Keyword
	def verifyMoreInfoBtnExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/MoreInforBtn_android'), 30);
	}
	@Keyword
	def tapOnMoreInfoBtn()
	{
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/MoreInforBtn_android'), defaultTime)
	}
	@Keyword
	def verifyProcedureVideoExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedureVideo_android'), 30);
	}
	@Keyword
	def verifyReturnAndCancellationPolicyExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/ReturnAndCancellationPolicy_android'), 30);
	}
	@Keyword
	def verifyProcedureCostAndOtherDetailsExists()
	{
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/procedurCostAndOtherDetails_android'), 30);
	}
	@Keyword
	def tapOnFirstCategoryDrpDwn(deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/firstChevronRightArrow_android', ['deliveryMethod': deliveryMethod]), defaultTime)
	}

	@Keyword
	def closeDeliveryMethodDrpDwn(deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/closeDeliveryMethodDrpDwn_android', ['deliveryMethod': deliveryMethod]), defaultTime)
	}

	@Keyword
	def tapOnCloseBorderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/closeWithBordersIcon_android'), defaultTime)
	}

	@Keyword
	def verifyCloseBorderBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/closeWithBordersIcon_android'), defaultTime)
	}
}
